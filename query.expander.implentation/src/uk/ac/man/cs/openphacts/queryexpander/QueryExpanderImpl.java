/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.cs.openphacts.queryexpander;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.query.Dataset;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.algebra.TupleExpr;
import org.openrdf.query.parser.ParsedQuery;
import org.openrdf.query.parser.sparql.SPARQLParser;
import uk.ac.man.cs.openphacts.queryexpander.mapper.IMSMapper;
import uk.ac.man.cs.openphacts.queryexpander.visitor.QueryExpandAndWriteVisitor;
import uk.ac.man.cs.openphacts.queryexpander.visitor.QueryReplaceAndWriteVisitor;

/**
 *
 * @author Christian
 */
public class QueryExpanderImpl implements QueryExpander{

    static final Logger logger = Logger.getLogger(QueryExpanderImpl.class);

    private static final SPARQLParser parser = new SPARQLParser();
    private static final List<String> ALL_ATTRIBUTES = null;
    
    IMSMapper imsMapper;
    
    public QueryExpanderImpl(IMSMapper imsMapper){
        this.imsMapper = imsMapper;
    }
    
    @Override
    public String expand(String originalQuery, List<String> parameters, String inputURI) throws QueryExpansionException {
        return expand(originalQuery, parameters, inputURI, false);
    }
        
    @Override
    public String expand(String originalQuery) throws QueryExpansionException {
        return expand(originalQuery, new ArrayList<String>(), null, false);
    }

    public String expand(String originalQuery, List<String> parameters, String inputURI, boolean verbose) 
            throws QueryExpansionException {
        inputURI = checkURI(inputURI);
        if (verbose) logger.info(originalQuery);
        ParsedQuery parsedQuery; 
        try {
            parsedQuery = parser.parseQuery(originalQuery, null);
        } catch (MalformedQueryException ex) {
            throw new QueryExpansionException("Unable to parse the query " + originalQuery, ex);
        }
        TupleExpr tupleExpr = parsedQuery.getTupleExpr();
        if (verbose) logger.info(tupleExpr);
        Dataset dataset = parsedQuery.getDataset();
        URI InputAsURI = null;
        if (inputURI != null && !inputURI.isEmpty()){
            InputAsURI = new URIImpl(inputURI);
        }
        String newQuery;
        if (parameters.isEmpty()){
            newQuery = QueryExpandAndWriteVisitor.convertToQueryString(tupleExpr, dataset, imsMapper, ALL_ATTRIBUTES);
        } else {
            newQuery = QueryReplaceAndWriteVisitor.convertToQueryString(tupleExpr, dataset, parameters, InputAsURI,
                    imsMapper, ALL_ATTRIBUTES);
        }
        try {
            parsedQuery = parser.parseQuery(newQuery, null);
        } catch (MalformedQueryException ex) {
            throw new QueryExpansionException("OOPS! Unable to parse the result query \n" + newQuery, ex);
        }
        return newQuery;
    }

    @Override
    public Map<String, Set<String>> getURISpacesPerGraph() throws QueryExpansionException {
        return imsMapper.getURISpacesPerGraph();
    }

    @Override
    public List<String> mapURI(String inputURI, String graph) throws QueryExpansionException {
        URI uri = new URIImpl(inputURI);
        List<URI> mappings;
        if (graph != null && !graph.isEmpty()){
            mappings =  imsMapper.getSpecificMatchesForURI(uri, graph);
        } else {
           mappings =  imsMapper.getMatchesForURI(uri);
        }
        ArrayList<String> results = new ArrayList<String>();
        for (URI mapping: mappings){
            results.add(mapping.stringValue());
        }
        return results;
    }

    private String checkURI(String inputURI) {
        if (inputURI == null || inputURI.isEmpty()) return inputURI;
        String checked = inputURI.trim();
        URI test = new URIImpl(inputURI);
        return inputURI;
    }
    
}
