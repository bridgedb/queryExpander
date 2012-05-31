package uk.ac.man.cs.openphacts.queryexpander.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.query.Dataset;
import org.openrdf.query.algebra.Compare;
import org.openrdf.query.algebra.Compare.CompareOp;
import org.openrdf.query.algebra.TupleExpr;
import org.openrdf.query.algebra.ValueConstant;
import org.openrdf.query.algebra.ValueExpr;
import org.openrdf.query.algebra.Var;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpansionException;
import uk.ac.man.cs.openphacts.queryexpander.mapper.IMSMapper;

/**
 * Extends the QueryWriterModelVisitor to insert replacement URI received from an IMSMapper.
 * 
 * @author Christian
 */
public class QueryReplaceAndWriteVisitor extends QueryWriterModelVisitor{
    
    //FULL_EXPAND currently untested with the Option nesting.
    //private static final boolean DO_FULL_EXPAND = false;
       
    //Maps the Values used for a URI with the list of URIs that this value could represent.
    private Map<String,List<URI>> mappings = new  HashMap<String,List<URI>>(); 
    
    //Service that provides the URI mappings.
    private IMSMapper mapper;
    
    //Counter to ensure that all the temporary variables have unique names.
    private int variableCounter =  0;
    
    private List<String> placeholders;
    private URI replacementVariable;
    
    /**
     * Sets up the visitor for writing the query.
     * 
     * @param dataSet dataSets listed in the original Queries FROM clause.
     * @param mapper The service that will offers replacement URIs for each (none predicate) URI found in the query.
     * @param contexts List of Contexts retrieved using the ContextListerVisitor.
     */
    QueryReplaceAndWriteVisitor (Dataset dataset, List<String> placeholders, URI replacementVariable, IMSMapper mapper){
        super(dataset);
        this.mapper = mapper;  
        this.placeholders = placeholders;
        this.replacementVariable = replacementVariable;
    }
    
    @Override
    public QueryWriterModelVisitor clone(){
        return new QueryReplaceAndWriteVisitor(originalDataSet, placeholders, replacementVariable, mapper);
    }
    
    /**
     * Retreives the mappings from this URI is any from the service.
     * <p>
     * Where applicable this function will attempt to retreive context specific mappings.
     * Where there is no context for example the Statement is not inside a Graph claus,
     * or the context is a variable all mapped URIs are retreived.
     * 
     * @param uri The URI for which replacements are to be found.
     * @return A List of replacement URIs or NULL is not replacement are returned by the mapper.
     * @throws QueryExpansionException Some expection thrown by the mapping service.
     */
    private List<URI> getMappings(URI uri) throws QueryExpansionException{
        if (context == null){
            return mapper.getMatchesForURI(uri);            
        } else {
            if (context.hasValue()){
                List<URI> results = mapper.getSpecificMatchesForURI(uri, context.getValue().stringValue());
                return results;
            } else {
                return mapper.getMatchesForURI(uri);   
            }
        }
    }
    
    private List<URI> getMappings(ValueExpr uriArg) throws QueryExpansionException {
        Value value;
        if (uriArg instanceof ValueConstant){
            ValueConstant vc = (ValueConstant)uriArg;
            value = vc.getValue();
        } else if (uriArg instanceof Var){
            Var var = (Var)uriArg;
            if (var.hasValue()){
               value = var.getValue();
            } else {
                throw new QueryExpansionException ("Expected a URI but found : " + uriArg);        
            }
        } else {
            throw new QueryExpansionException ("Expected a URI but found : " + uriArg);
        }
        if (value instanceof URI){
            return getMappings((URI)value);
        } else {
            throw new QueryExpansionException ("Expected a URI but found : " + uriArg);            
        }
    }

    @Override                 
     /**
     * Close the context (GRAPH clause) and any optional clauses opened inside the graph anding a filter if required.
     * <p>
     * This method has three steps.
     * <ol>
     * <li> Close any optionals opened inside the Graph Clause. </li>
     * <li> Add any required URI filters </li>
     * <li> Close the context. </li>
     * </ol>    
     * <p>
     * Subclasses with overwrite this method to add behavior such as adding URi replacement filters.
     */
    void closeContext (){
        //Close any optionals opened inside the Graph Clause.
        //optionsInGraph will never be > 0 outside of a context.
        //optionsIngraph is only used if there are more statements in the context than in the optional
        //   So closing the optional first is cleaner.
        while (optionInGraph > 0){
            newLine();
            queryString.append(" } "); 
            if (SHOW_DEBUG_IN_QUERY) queryString.append("#OPTION from close context");
            //reduce the count so it is not closed again.
            optionInGraph--;
        }
        //Add any required URI filters
        //if there are non no filters need to be added.
        if (!(mappings.isEmpty())){
            for (String variableName:mappings.keySet()){
                List<URI> uriList = mappings.get(variableName);
                newLine();
                queryString.append("FILTER (");
                queryString.append(variableName);
                queryString.append(" = <");
                queryString.append(uriList.get(0));
                queryString.append(">");
                for (int i = 1; i < uriList.size(); i++){
                    queryString.append(" || ");
                    queryString.append(variableName);
                    queryString.append(" = <");
                    queryString.append(uriList.get(i));
                    queryString.append(">");            
                }
                queryString.append(")");
            }
            //Clear the mappings so they are no closed again.
            mappings = new  HashMap<String,List<URI>>(); 
        }
        //Call super class to do the actual closing.
        super.closeContext();
    }

    private void mapParameter(String variableName) throws QueryExpansionException{
        //If the name is not in the parameter list nothing needs to be done
        if (!(placeholders.contains(variableName))) return;
        //if there is already a paramter mapping nothing needs to be done
        if (mappings.containsKey(variableName)) return;
        List<URI> list = getMappings(replacementVariable);
        if (list.isEmpty()){
            list.add(replacementVariable);
        }
       //Store the list for adding the filter.
        mappings.put(variableName, list);
   }

    @Override
    /**
     * Write the var, or for a URI the replacement.
     * <p>
     * Called by meet(StatementPattern sp) for the subject and the object.
     * <p> 
     * Checks to see if the var is a URI.
     * If it is a URI getURIVariable is used to find a possible replacement.
     * If it is not a URI the normal write method is used.
     * 
     * @param var Var to be written.
     * @throws QueryExpansionException 
     */
    void writeStatementPart(Var var) throws QueryExpansionException{
        meet(var);         
        System.out.println(var.getSignature());
        System.out.println(var.isAnonymous());
        if (!var.isAnonymous()){
            String name = "?" + var.getName();
            System.out.println(name);
            System.out.println(placeholders);
            if (placeholders.contains(name)){
                mapParameter(name);
            }
       }
    }

    /**
     * Writes a compare where one of the values is known to be a URI which may need replacing.
     * <p>
     * <ol>
     * <li> Write the non URI arguement. </li>
     * <li> Writes the operator. </li>
     * <li> Gets the List of replacement URIs (if any) </li>
     * <ol>
     * <li> If the List is null or empty: Just writes the list </li>
     * <li> If the list has one URI: Just write that URI inclduing the &lt; and &gt; </li>
     * <li> If the list has more than one URI: Expands the filter to include each of the mapped URIs
     *     Seperated by AND or OR as appropriate. </li>
     * </ol></ol>
     * @param compareOp The comparison operator. Note: Only Equals and  Not equals make sence.
     * @param normalArg The none URI arguement.
     * @param uriArg The URI arguement
     * @throws QueryExpansionException If uriArg is not a URI, compareOp is not "=" or "!=" or a mapping exception.
     */
    private void writeCompareWithURI(CompareOp compareOp, ValueExpr normalArg, ValueExpr uriArg) throws QueryExpansionException {
        queryString.append("(");
        normalArg.visit(this);
        queryString.append(" ");
        queryString.append(compareOp.getSymbol());
        List<URI> uriList = this.getMappings(uriArg);
        if (uriList == null || uriList.isEmpty()){
            uriArg.visit(this);
        } else {
            queryString.append(" <");
            queryString.append(uriList.get(0));
            queryString.append(">");
            for (int i = 1; i< uriList.size(); i++){
                switch (compareOp){
                    case EQ: 
                        queryString.append(" || ");        
                        break;                    
                    case NE: 
                        queryString.append(" && ");        
                        break;
                    default:  //LT, LE, GE, GT do not make sense applied to a URI: 
                        throw new QueryExpansionException ("Did not expect " + compareOp + " in a Compare with URIs");
                }
                normalArg.visit(this);
                queryString.append(" ");
                queryString.append(compareOp.getSymbol());
                queryString.append(" <");
                queryString.append(uriList.get(i));
                queryString.append(">");
            }
        }
        queryString.append(")");
   }

    /**
     * Write a compare that does not include a URi by writing the three parts. 
     */
    private void writeCompareWithoutURI (CompareOp operator, ValueExpr leftArg,  ValueExpr rightArg) 
            throws QueryExpansionException{
        queryString.append("(");
        leftArg.visit(this);    
        queryString.append(" ");
        queryString.append(operator.getSymbol());
        queryString.append(" ");
        rightArg.visit(this);
        queryString.append(")");
    }
    
    /**
     * Determines if a ValueExpr contains a URI.
     * @param valueExpr Any non null ValueExpr
     * @return True if and only if the expresssion holds a URI
     */
    private boolean isURI(ValueExpr valueExpr){
        //ystem.out.println(valueExpr);
        if (valueExpr instanceof ValueConstant){
            ValueConstant vc = (ValueConstant)valueExpr;
            Value value = vc.getValue();
            return value instanceof URI;
        } else if (valueExpr instanceof Var){
            Var var = (Var)valueExpr;
            if (var.hasValue()){
                Value value = var.getValue();
                return value instanceof URI;
            //} else {
                //ystem.out.println(" no value");
            }
        //} else {
            //ystem.out.println (" not a Var or ValueConstant");
        }
        return false;
    }
    
    @Override
    /**
     * Checks if the compare incluses a URi and calls the appropriate method writeCompareWithURI or writeCompareWithoutURI.
     * @param cmpr 
     * @throws QueryExpansionException 
     */
    public void meet(Compare cmpr) throws QueryExpansionException {
        //ystem.out.println(cmpr);
        if (isURI(cmpr.getRightArg())){
            if (isURI(cmpr.getLeftArg())) {
                throw new QueryExpansionException ("Unexpected compare with two URIs; " + cmpr);
            } else {
                writeCompareWithURI(cmpr.getOperator(), cmpr.getLeftArg(), cmpr.getRightArg());
            }
        } else {
            if (isURI(cmpr.getLeftArg())) {
                writeCompareWithURI( cmpr.getOperator(), cmpr.getRightArg(), cmpr.getLeftArg());
            } else {
                writeCompareWithoutURI(cmpr.getOperator(), cmpr.getLeftArg(), cmpr.getRightArg());
            } 
        }
    }

    @Override
    /**
     * Checks if the Variable is a URI and if so writes the mapped list otherwise just writes the variable
     * @param decribeVariable Variable which may be a URI
     * @throws QueryExpansionException 
     */
    void writeDescribeVariable(ValueExpr decribeVariable) throws QueryExpansionException{
        if (isURI(decribeVariable)){
            //See if there are any mapped URIs
            List<URI> mappedURIs = getMappings(decribeVariable);
            if (mappedURIs == null){
                //OK no mapped URIs so just fall back to the normal behavior.
                queryString.append(extractName(decribeVariable));
            } else {
                //Write the mapped URIs
                for (URI uri:mappedURIs){
                    queryString.append(getUriString(uri));
                }
            }
        } else {
            //OK not a URI so just fall back to the normal bahaviour
            queryString.append(extractName(decribeVariable));
        }
    }

    /**
     * Returns the query as a string.
     * <p>
     * Works if and only if the model was visited exactly once.
     * @return query as a String
     * @throws QueryExpansionException Declared as thrown to allow calling methods to catch it specifically.
     */
    private String getQuery() throws QueryExpansionException {
        return queryString.toString();
    }

    @Override
    protected String writeSubQuery(TupleExpr tupleExpr) throws QueryExpansionException{
        QueryReplaceAndWriteVisitor writer = 
                new QueryReplaceAndWriteVisitor(originalDataSet, placeholders, replacementVariable, mapper);
        tupleExpr.visit(writer);
        return writer.getQuery();
    }
    
    public static String convertToQueryString(TupleExpr tupleExpr, Dataset dataSet, List<String> placeholders, 
            URI replacementVariable, IMSMapper mapper, 
            List<String> requiredAttributes) throws QueryExpansionException{
        QueryReplaceAndWriteVisitor writer = new QueryReplaceAndWriteVisitor(dataSet, placeholders,  replacementVariable, mapper);
        tupleExpr.visit(writer);
        return writer.getQuery();
    }
}
