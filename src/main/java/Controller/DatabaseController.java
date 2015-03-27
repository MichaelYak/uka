package Controller;

import Entity.DummyData;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.Random;

/**
 * Created by kim.flaethe on 20.03.2015.
 */
public class DatabaseController {

    private int number;
    private DummyData dummyData;

    public Response addToDatabase(CouchDbClient dbClient) {
        Random rand = new Random();
        number = rand.nextInt((1000) + 1);
        dummyData = new DummyData();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Some data", dummyData.getData());
        jsonObject.addProperty("A name", dummyData.getName());
        return dbClient.save(jsonObject);
    }

    public Response removeDocument(CouchDbClient dbClient, String id) {

        dummyData = new DummyData();
        dummyData = dbClient.find(DummyData.class, id);

        return dbClient.remove(dummyData);
    }
}
