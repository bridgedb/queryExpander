package uk.ac.man.cs.openphacts.queryexpander.queryLoader;

import java.util.List;
import java.util.Map;
import org.junit.Ignore;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpander;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpanderImpl;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpansionException;
import uk.ac.man.cs.openphacts.queryexpander.mapper.BridgeDBMapper;
import uk.ac.man.cs.openphacts.queryexpander.QueryUtils;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class Ops1_1QueryTest  extends LoaderBase {
    
    @Test
    public void testAllNoMapping() throws Exception{
        Ops1_1QueryLoader loader = new Ops1_1QueryLoader();
        Set<String> queryKeys = loader.keySet();
 /*       DummyIMSMapper dummyMapper = new DummyIMSMapper();       
        dummyMapper.addMapping("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5", 
                "http://data.kasabi.com/dataset/chembl-rdf/target/t197");
        dummyMapper.addMapping("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5", 
                "http://data.kasabi.com/dataset/chembl-rdf/molecule/m276734");
        dummyMapper.addMapping("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5", 
                "http://www4.wiwiss.fu-berlin.de/drugbank/resource/targets/228");
        dummyMapper.addMapping("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5", 
                "http://www4.wiwiss.fu-berlin.de/drugbank/resource/drugs/DB00398");
        dummyMapper.addMapping("http://www.conceptwiki.org/concept/38932552-111f-4a4e-a46a-4ed1d7bdf9d5", 
                "http://rdf.chemspider.com/187440");
        
        HardCodedGraphResolver imsMapper = new HardCodedGraphResolver(dummyMapper);*/
        
        BridgeDBMapper imsMapper = TestBridgeDBFactory.getBridgeDBMapper();
        QueryExpanderImpl queryExpander = new QueryExpanderImpl(imsMapper);
        for (String queryKey:queryKeys){
            System.out.println("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery;
            targetQuery = loader.getTextReplaceQuery(queryKey);
            List<String> parameters = loader.getParameters(queryKey);
            String inputURI = loader.getInsertURI(queryKey);
            //ystem.out.println(originalQuery);
            String newQuery = queryExpander.expand(originalQuery, parameters, inputURI, false);
            //ystem.out.println(newQuery);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, false, loader.getQueryName(queryKey)));
        }
    }

    @Test
    public void testURISpacesInGraph() throws QueryExpansionException{
        BridgeDBMapper imsMapper = TestBridgeDBFactory.getBridgeDBMapper();
        Map<String, Set<String>> result = imsMapper.getURISpacesPerGraph();
        assertFalse(result.isEmpty());
        for (String graph:result.keySet()){
            Set<String> URISpaces = result.get(graph);
            assertFalse(URISpaces.isEmpty());        
        }
    }
}
