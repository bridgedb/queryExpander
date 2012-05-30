/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.cs.openphacts.queryexpander;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.query.Dataset;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.algebra.TupleExpr;
import org.openrdf.query.parser.ParsedQuery;
import org.openrdf.query.parser.sparql.SPARQLParser;
import uk.ac.man.cs.openphacts.queryexpander.mapper.IMSMapper;
import uk.ac.man.cs.openphacts.queryexpander.visitor.QueryReplaceAndWriteVisitor;

/**
 *
 * @author Christian
 */
public class QueryExpanderImpl implements QueryExpander{

    private static final SPARQLParser parser = new SPARQLParser();
    private static final List<String> ALL_ATTRIBUTES = null;
    
    IMSMapper imsMapper;
    
    public QueryExpanderImpl(IMSMapper imsMapper){
        this.imsMapper = imsMapper;
    }
    
    @Override
    public String expand(String originalQuery, List<String> placeholders, String replacementVariable) throws QueryExpansionException {
        return expand(originalQuery, placeholders, replacementVariable, false);
    }
    
    @Override
    public String expand(String originalQuery, List<String> placeholders, String replacementVariable, boolean verbose) 
            throws QueryExpansionException {
        if (verbose) System.out.println(originalQuery);
        ParsedQuery parsedQuery; 
        try {
            parsedQuery = parser.parseQuery(originalQuery, null);
        } catch (MalformedQueryException ex) {
            throw new QueryExpansionException("Unable to parse the query " + originalQuery, ex);
        }
        TupleExpr tupleExpr = parsedQuery.getTupleExpr();
        if (verbose) System.out.println(tupleExpr);
        Dataset dataset = parsedQuery.getDataset();
        URI replacementURI = null;
        if (replacementVariable != null){
            replacementURI = new URIImpl(replacementVariable);
        }
        return QueryReplaceAndWriteVisitor.convertToQueryString(tupleExpr, dataset, placeholders, replacementURI, imsMapper, ALL_ATTRIBUTES);
    }

    @Override
    public Map<String, Set<String>> getURISpacesPerGraph() throws QueryExpansionException {
        return imsMapper.getURISpacesPerGraph();
    }
    
}
