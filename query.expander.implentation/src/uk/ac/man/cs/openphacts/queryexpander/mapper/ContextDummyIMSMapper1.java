package uk.ac.man.cs.openphacts.queryexpander.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * A simple implmentation of the IMSMapper that only returns URIs specifically loaded after construction.
 * 
 * Mainly used for testing.
 * 
 * Ignores the graph, and does the implements getMatchesForURIs by just returning all the Maps it has ignoring the Set.
 * 
 * @author Christian
 */
public class ContextDummyIMSMapper1 implements IMSMapper{

    Map<URI, List<URI>> uriMappings = new HashMap<URI, List<URI>>();
    ValueFactory valueFactory = ValueFactoryImpl.getInstance();
    
    /**
     * Allows test methods to load the Mappings they expect.
     * 
     * @param fromString
     * @param toString 
     */
    public void addMapping(String fromString, String toString){
       URI fromURI = valueFactory.createURI(fromString);
       URI toURI = valueFactory.createURI(toString);
       List<URI> uriList = uriMappings.get(fromURI);
       if (uriList == null){
           uriList = new ArrayList<URI>();
       }
       if (!uriList.contains(toURI)){
           uriList.add(toURI);
       }
       uriMappings.put(fromURI, uriList);
    }
    
    @Override
    public List<URI> getMatchesForURI(URI uri) {
        List<URI> mapped = uriMappings.get(uri);
        if (mapped == null){
            mapped = new ArrayList<URI>();
        }
        if (!mapped.contains(uri)){
            mapped.add(uri);
        }
        return mapped;
    }

    @Override
    public List<URI> getSpecificMatchesForURI(URI uri, String graph) {
        List<URI> results = new ArrayList<URI>();
        if (graph.equals("http://www.example.org/graph1")){
            results.add(uri);
        } else if (graph.equals("http://www.example.org/graph2")){
            if (uri.stringValue().equals("http://www.foo.com/subj1")){
                results.add(valueFactory.createURI("http://www.bar.com/1"));
                results.add(valueFactory.createURI("http://www.bar.com/1a"));
            } else {
                results.add(valueFactory.createURI("http://www.bar.com/2"));
                results.add(valueFactory.createURI("http://www.bar.com/1a"));
            }             
        } else {
            results = getMatchesForURI(uri);
        }
        return results;
    }

    @Override
    public Map<String, Set<String>> getURISpacesPerGraph() {
        HashMap<String, Set<String>> URISpacesPerGraph = new HashMap<String, Set<String>>();
        return URISpacesPerGraph;
    }
    
}
