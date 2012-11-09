package uk.ac.man.cs.openphacts.queryexpander.queryLoader;

import org.junit.Ignore;
import uk.ac.man.cs.openphacts.queryexpander.mapper.BridgeDBMapper;
import java.util.List;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpanderImpl;
import uk.ac.man.cs.openphacts.queryexpander.QueryUtils;
import java.util.Set;
import org.junit.Test;
import uk.ac.man.cs.openphacts.queryexpander.visitor.ExpansionStategy;
import static org.junit.Assert.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public class OpsReplacemeentTest  extends LoaderBase {
    
    @Test
    public void testAllNoMapping() throws Exception{
        QueryCaseLoader loader = new OpsReplacementLoader();
        Set<String> queryKeys = loader.keySet();
        BridgeDBMapper imsMapper = TestBridgeDBFactory.getBridgeDBMapper();
        QueryExpanderImpl queryExpander = new QueryExpanderImpl(imsMapper);
        for (String queryKey:queryKeys){
            report("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery = loader.getTextReplaceQuery(queryKey);
            List<String> parameters = loader.getParameters(queryKey);
            String inputURI = loader.getInsertURI(queryKey);
            //ystem.out.println(originalQuery);
            //ystem.out.println(parameters);
            String newQuery = queryExpander.expand(originalQuery, parameters, inputURI, false,
                    ExpansionStategy.FILTER_GRAPH);
            //System.out.println(newQuery);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)));
        }
    }

}
