/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.manchester.cs.openphacts.queryexpander.mapper;

import org.bridgedb.uri.GraphResolver;
import java.util.HashMap;
import org.bridgedb.utils.BridgeDBException;
import org.bridgedb.utils.Reporter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class GraphResolverTest {
    
    public GraphResolverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllowedUriPatterns method, of class GraphResolver.
     */
    @Test
    public void testGetAllowedUriPatterns() throws BridgeDBException {
        Reporter.println("getAllowedUriPatterns");
        GraphResolver instance = GraphResolver.getInstance();
        HashMap result = instance.getAllowedUriPatterns();
        System.out.println(result);
        assertFalse(result.isEmpty());
    }
}
