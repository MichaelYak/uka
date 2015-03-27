package Controller;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

/**
 * Created by kim.flaethe on 20.03.2015.
 */
public class DatabaseSetup {

    private CouchDbClient dbClient;
    private final String TESTDB = "uka";


    public CouchDbClient getDbClient() {

        CouchDbProperties properties = new CouchDbProperties()
                .setDbName(TESTDB)
                .setCreateDbIfNotExist(true)
                .setProtocol("https")
                .setHost("couchdb40212-uka2015.jelastic.elastx.net")
                .setPort(443)
                .setUsername("admin")
                .setPassword("FNHadm88693")
                .setMaxConnections(100)
                .setConnectionTimeout(0);
        return dbClient = new CouchDbClient(properties);
    }
}
