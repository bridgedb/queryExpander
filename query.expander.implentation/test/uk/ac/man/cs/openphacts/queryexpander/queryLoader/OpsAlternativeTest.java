package uk.ac.man.cs.openphacts.queryexpander.queryLoader;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import org.junit.Ignore;

import org.junit.Test;

import uk.ac.man.cs.openphacts.queryexpander.QueryExpanderImpl;
import uk.ac.man.cs.openphacts.queryexpander.QueryUtils;
import uk.ac.man.cs.openphacts.queryexpander.mapper.ContextDummyIMSMapper;
import uk.ac.man.cs.openphacts.queryexpander.mapper.ContextDummyIMSMapper1;
import uk.ac.man.cs.openphacts.queryexpander.mapper.ContextDummyIMSMapper2;
import uk.ac.man.cs.openphacts.queryexpander.mapper.DummyIMSMapper;

/*
 * See also
 * http://code.google.com/p/fbench/wiki/Queries#Life_Science_%28LS%29
 */

/**
 *
 * @author Christian
 */
public class OpsAlternativeTest {
    
    @Test
    public void testAll() throws Exception{
        OpsAlternativeLoader loader = new OpsAlternativeLoader();
        Set<String> queryKeys = loader.keySet();
        ContextDummyIMSMapper imsMapper = new ContextDummyIMSMapper();
        QueryExpanderImpl queryExpander = new QueryExpanderImpl(imsMapper);
        for (String queryKey:queryKeys){
            System.out.println("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery = loader.getTextReplaceQuery(queryKey);
            //ystem.out.println(originalQuery);
            String newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_GRAPH");
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey) + " FILTER_GRAPH"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "");
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey) + " FILTER_GRAPH"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_STATEMENT");
            targetQuery = loader.getFilterStatement(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " FILTER_STATEMENT"));

            //newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_ALL");
            //targetQuery = loader.getFilterAll(queryKey);
            //assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " FILTER_ALL"));

            //newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_ALL");
            //targetQuery = loader.getUnionAll(queryKey);
            //assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_ALL"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_STATEMENT");
            targetQuery = loader.getUnionStatement(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_STATEMENT"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_GRAPH");
            //ystem.out.println(newQuery);
            targetQuery = loader.getUnionGraph(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_Graph"));

            System.out.println("All ok");
        }
    }
    
    @Test
    public void testAll1() throws Exception{
        OpsAlternativeLoader1 loader = new OpsAlternativeLoader1();
        Set<String> queryKeys = loader.keySet();
        ContextDummyIMSMapper1 imsMapper = new ContextDummyIMSMapper1();
        imsMapper.addMapping("http://www.foo.com/subj1", "http://www.bar.com/1");
        imsMapper.addMapping("http://www.foo.com/subj2", "http://www.bar.com/2");
        QueryExpanderImpl queryExpander = new QueryExpanderImpl(imsMapper);
        for (String queryKey:queryKeys){
            System.out.println("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery = loader.getTextReplaceQuery(queryKey);
            //ystem.out.println(originalQuery);
            String newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_GRAPH");
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey) + " FILTER_GRAPH"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "");
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey) + " FILTER_GRAPH"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_STATEMENT");
            targetQuery = loader.getFilterStatement(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " FILTER_STATEMENT"));

            //newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_ALL");
            //targetQuery = loader.getFilterAll(queryKey);
            //assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " FILTER_ALL"));

            //newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_ALL");
            //targetQuery = loader.getUnionAll(queryKey);
            //assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_ALL"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_STATEMENT");
            targetQuery = loader.getUnionStatement(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_STATEMENT"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_GRAPH");
            //ystem.out.println(newQuery);
            targetQuery = loader.getUnionGraph(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_Graph"));

            System.out.println("All ok");
        }
    }

    @Test
    public void testAll2() throws Exception{
        OpsAlternativeLoader2 loader = new OpsAlternativeLoader2();
        Set<String> queryKeys = loader.keySet();
        ContextDummyIMSMapper2 imsMapper = new ContextDummyIMSMapper2();
        imsMapper.addMapping("http://www.foo.com/subj1", "http://www.bar.com/1");
        imsMapper.addMapping("http://www.foo.com/subj2", "http://www.bar.com/2");
        QueryExpanderImpl queryExpander = new QueryExpanderImpl(imsMapper);
        for (String queryKey:queryKeys){
            System.out.println("Testing " + loader.getQueryName(queryKey));
            String originalQuery = loader.getOriginalQuery(queryKey);
            String targetQuery = loader.getTextReplaceQuery(queryKey);
            //ystem.out.println(originalQuery);
            String newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_GRAPH");
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey) + " FILTER_GRAPH"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "");
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey) + " FILTER_GRAPH"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_STATEMENT");
            targetQuery = loader.getFilterStatement(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " FILTER_STATEMENT"));

            //newQuery = queryExpander.expandWithStrategy(originalQuery, "FILTER_ALL");
            //targetQuery = loader.getFilterAll(queryKey);
            //assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " FILTER_ALL"));

            //newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_ALL");
            //targetQuery = loader.getUnionAll(queryKey);
            //assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_ALL"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_STATEMENT");
            targetQuery = loader.getUnionStatement(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_STATEMENT"));

            newQuery = queryExpander.expandWithStrategy(originalQuery, "UNION_GRAPH");
            //ystem.out.println(newQuery);
            targetQuery = loader.getUnionGraph(queryKey);
            assertTrue(QueryUtils.sameTupleExpr(targetQuery, newQuery, true, loader.getQueryName(queryKey)+ " UNION_Graph"));

            System.out.println("All ok");
        }
    }
}
