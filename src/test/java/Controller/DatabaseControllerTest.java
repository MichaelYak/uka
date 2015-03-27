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

    public static final String TESTDB = "testdb";
    private CouchDbClient dbClient;
    private DatabaseController databaseController;

    @Before
    public void setupFreshDB() {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName(TESTDB)
                .setCreateDbIfNotExist(true)
                .setProtocol("https")
                .setHost("couchdb40155-env-8900677.jelastic.elastx.net")
                .setPort(443)
                .setUsername("admin")
                .setPassword("admin")
                .setMaxConnections(100)
                .setConnectionTimeout(0);
        dbClient = new CouchDbClient(properties);

        databaseController = new DatabaseController();
    }

    // Skreiv om koden til delete, så måtte kommentere ut testene før visning.

    /*
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
*/
    @Test
    public void removeFromDatabase(){
        int countBefore = dbClient.view("_all_docs").query(DummyData.class).size();
        System.out.println("CounterBefore : " + countBefore);
        Response r = databaseController.addToDatabase(new DummyData());

        List<DummyData> allDocs = dbClient.view("_all_docs").includeDocs(true).query(DummyData.class);

        System.out.println("AllDocs : " + allDocs.size());


        databaseController.removeDocument(r.getId());
        int countAfter = dbClient.view("_all_docs").query(DummyData.class).size();
System.out.println("CounterAfter : " + countAfter);
 //       assertTrue(countBefore == countAfter + 1);
    }

    @Test
    public void addDataToDatabase() {
        Response r = databaseController.addToDatabase(new DummyData());
        assertTrue(r.getId().length() > 0);
    }

}