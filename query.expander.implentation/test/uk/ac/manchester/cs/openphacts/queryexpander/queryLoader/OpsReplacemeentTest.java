package uk.ac.manchester.cs.openphacts.queryexpander.queryLoader;

import java.util.List;
import java.util.Set;
import org.bridgedb.uri.tools.GraphResolver;
import org.bridgedb.utils.Reporter;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.manchester.cs.openphacts.queryexpander.QueryUtils;
import uk.ac.manchester.cs.openphacts.queryexpander.api.QueryExpander;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public abstract class OpsReplacemeentTest {
    
    protected QueryExpander queryExpander;
   
    private final String NO_LENS = null;
            
    @Test
    public void testAllNoMapping() throws Exception{
        GraphResolver.addTestMappings();
        QueryCaseLoader loader = new OpsReplacementLoader();
        Set<String> queryKeys = loader.keySet();
        for (String queryKey:queryKeys){
            Reporter.println("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery = loader.getTextReplaceQuery(queryKey);
            List<String> parameters = loader.getParameters(queryKey);
            String inputURI = loader.getInsertURI(queryKey);
            //ystem.out.println(originalQuery);
            //ystem.out.println(parameters);
            String newQuery = queryExpander.expand(originalQuery, parameters, inputURI, NO_LENS, false);
            //System.out.println(newQuery);
            if (!QueryUtils.sameTupleExpr(targetQuery, newQuery, false, loader.getQueryName(queryKey))){
                assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)));
            }
        }
    }

}
