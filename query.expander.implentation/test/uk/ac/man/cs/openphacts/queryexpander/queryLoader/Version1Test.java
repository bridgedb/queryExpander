package uk.ac.man.cs.openphacts.queryexpander.queryLoader;

import org.junit.Ignore;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpanderImpl;
import uk.ac.man.cs.openphacts.queryexpander.QueryUtils;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpander;
import java.util.Set;
import org.junit.Test;
import uk.ac.man.cs.openphacts.queryexpander.mapper.DummyIMSMapper;
import uk.ac.man.cs.openphacts.queryexpander.mapper.IMSMapper;
import static org.junit.Assert.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
@Ignore
public class Version1Test {
    
    @Test
    public void testAllNoMapping() throws Exception{
        Version1Loader loader = new Version1Loader();
        Set<String> queryKeys = loader.keySet();
        IMSMapper imsMapper = new DummyIMSMapper();
        QueryExpander queryExpander = new QueryExpanderImpl(imsMapper);
        for (String queryKey:queryKeys){
            System.out.println("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery = loader.getNoReplaceQuery(queryKey);
            System.out.println(originalQuery);
            String newQuery = queryExpander.expand(originalQuery, false);
            //ystem.out.println(newQuery);
 //           assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true));
        }
    }

}
