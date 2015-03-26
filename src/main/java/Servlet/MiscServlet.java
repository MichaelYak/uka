package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import Entity.DummyData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by kim.flaethe on 26.03.2015.
 */
public class MiscServlet extends HttpServlet {

    private CouchDbClient dbClient;
    private DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbClient = DatabaseSetup.getDbCliend();
        dbController = new DatabaseController();

        PrintWriter out = response.getWriter();
        out.println("I MiscServlet");
        String getParam = request.getParameter("listdb");


        List<DummyData> allDocs = dbClient.view("_all_docs").includeDocs(true).query(DummyData.class);

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("items", new Gson().toJsonTree(allDocs).getAsJsonArray());

        out.println("JSONOBJECT ->");
        out.println(jsonObject);
    }
}
