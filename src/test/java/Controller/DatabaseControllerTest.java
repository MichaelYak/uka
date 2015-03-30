package Controller;

import Entity.DummyData;
import org.junit.Before;
import org.junit.Test;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.Response;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DatabaseControllerTest {
/*
    public static final String TESTDB = "uka";
    private CouchDbClient dbClient;
    private DatabaseController databaseController;

    @Before
    public void setUp() {
        dbClient = getDbClient();
        databaseController = new DatabaseController();
    }

    // Skreiv om koden til delete, så måtte kommentere ut testene før visning.


    @Test
    public void connectionSmokeTest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_id", "123");
        jsonObject.addProperty("appname", "simple-app");
        jsonObject.add("array", new JsonArray());
        dbClient.save(jsonObject);

        jsonObject = dbClient.find(JsonObject.class, "123");
        assertNotNull(jsonObject);
        assertNotNull(jsonObject.get("_id"));
        assertNotNull(jsonObject.get("appname"));
        assertEquals(jsonObject.get("appname").getAsString(), "simple-app");
        dbClient.remove(jsonObject);
    }

    @Test
    public void removeFromDatabase(){
        Response r = databaseController.addToDatabase(new DummyData());
        int countBefore = dbClient.view("_all_docs").query(DummyData.class).size();

        databaseController.removeDocument(r.getId());
        int countAfter = dbClient.view("_all_docs").query(DummyData.class).size();

        assertTrue(countBefore == countAfter + 1);
    }

    @Test
    public void addDataToDatabase() {
        Response r = databaseController.addToDatabase(new DummyData());
        System.out.println("Added id: " + r.getId());
        assertTrue(r.getId().length() > 0);
    }

    private CouchDbClient getDbClient() {
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
    */
}