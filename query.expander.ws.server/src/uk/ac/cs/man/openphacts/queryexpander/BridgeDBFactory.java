/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cs.man.openphacts.queryexpander;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bridgedb.IDMapper;
import org.bridgedb.IDMapperException;
import org.bridgedb.file.IDMapperText;
import org.bridgedb.sql.SQLAccess;
import org.bridgedb.sql.SqlFactory;
import org.bridgedb.sql.URLMapperSQL;
import org.bridgedb.url.WrapperURLMapper;
import uk.ac.cs.man.openphacts.queryexpander.QueryExpansionException;
import uk.ac.cs.man.openphacts.queryexpander.mapper.BridgeDBMapper;
import uk.ac.cs.man.openphacts.queryexpander.mapper.HardCodedGraphResolver;

/**
 *
 * @author Christian
 */
public class BridgeDBFactory {
    
     public static BridgeDBMapper getBridgeDBMapper() throws QueryExpansionException{
        HardCodedGraphResolver resolver = new HardCodedGraphResolver();
        try {
            SQLAccess sqlAccess = SqlFactory.createSQLAccess();
            URLMapperSQL urlMapper = new URLMapperSQL(sqlAccess);
            return new BridgeDBMapper (resolver.getAllowedNamespaces(), urlMapper);
        } catch (Exception ex) {
            throw new QueryExpansionException("Error setting up File mapper ", ex);
        }
    }
     
    private static final File OFFLINE_TEST_FILE = new File ("D:/OpenPhacts/queryExpander/query.expander.implentation/test-data/offlineTest.txt");
	
    public static BridgeDBMapper getBridgeDBMapperLocal() throws QueryExpansionException{
        HardCodedGraphResolver resolver = new HardCodedGraphResolver();
        try {
            IDMapper idMapper = new IDMapperText(OFFLINE_TEST_FILE.toURL());
            WrapperURLMapper urlMapper = new WrapperURLMapper(idMapper);
            return new BridgeDBMapper (resolver.getAllowedNamespaces(), urlMapper);
        } catch (Exception ex) {
            throw new QueryExpansionException("Error setting up File mapper ", ex);
        }
    }
    	

}
