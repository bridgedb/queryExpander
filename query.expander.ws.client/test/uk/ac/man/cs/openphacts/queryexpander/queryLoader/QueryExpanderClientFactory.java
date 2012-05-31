/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.man.cs.openphacts.queryexpander.queryLoader;

import java.util.ArrayList;
import org.bridgedb.IDMapperException;
import uk.ac.man.cs.openphacts.queryexpander.QueryExpanderWSClient;

/**
 *
 * @author Christian
 */
public class QueryExpanderClientFactory {
    
    public static QueryExpanderWSClient createTestQueryExpanderWSClient() throws IDMapperException{
        System.out.println("Trying to set up a QueryExpanderWSClient");
        QueryExpanderWSClient webService = new QueryExpanderWSClient("http://localhost:8080/QueryExpander");
        System.out.println("Set up a QueryExpanderWSClient");
        try { 
            webService.expand("select * { ?s ?o ?p}", new ArrayList<String>(), null);
            System.out.println("QueryExpanderWSClient test successfull");
        } catch (Exception ex) {
            System.err.println(ex);
            System.out.println ("***** SKIPPING QueryExpanderWSClient Test ******");
            System.out.println ("Please make sure the server is running");
            org.junit.Assume.assumeTrue(false);        
        }
        return webService;
    }
   
    public static QueryExpanderWSClient createOpenPhactsQueryExpanderWSClient() throws IDMapperException{
        System.out.println("Trying to set up a QueryExpanderWSClient");
        QueryExpanderWSClient webService = new QueryExpanderWSClient("http://openphacts.cs.man.ac.uk:9090/QueryExpander");
        System.out.println("Set up a QueryExpanderWSClient");
        try { 
            webService.expand("select * { ?s ?o ?p}", new ArrayList<String>(), null);
            System.out.println("QueryExpanderWSClient test successfull");
        } catch (Exception ex) {
            System.err.println(ex);
            System.out.println ("***** SKIPPING QueryExpanderWSClient Test ******");
            System.out.println ("Please make sure the server is running");
            org.junit.Assume.assumeTrue(false);        
        }
        return webService;
    }
}
