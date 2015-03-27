package Controller;

import Entity.DummyData;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Random;

/**
 * Created by kim.flaethe on 20.03.2015.
 */
public class DatabaseController {

    private int number;
    private CouchDbClient dbClient;

    public DatabaseController () {
        dbClient = new DatabaseSetup().getDbClient();
    }

    public Response addToDatabase(DummyData dummyData) {
        Random rand = new Random();
        number = rand.nextInt((1000) + 1);
        dummyData = new DummyData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Data", dummyData.getData());
        jsonObject.addProperty("Name", dummyData.getName());
        return dbClient.save(jsonObject);
    }

    public Response removeDocument(String id) {
        DummyData dummyData = dbClient.find(DummyData.class, id);
        return dbClient.remove(dummyData);
    }

    public List<DummyData> getAllDocuments(){
        return dbClient.view("_all_docs").includeDocs(true).query(DummyData.class);
    }

    public int countDatabase() {
        int countBefore;
        try {
            countBefore = dbClient.view("_all_docs").query(DummyData.class).size();
        } catch (Exception e) {
            countBefore = 0;
        }
        return countBefore;
    }
}
