package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import Entity.DummyData;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UploadServlet extends HttpServlet {

    public UploadServlet() {
    }

    private CouchDbClient dbClient;
    private DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbClient = DatabaseSetup.getDbCliend();
        dbController = new DatabaseController();
        int countBefore;
        try {
            countBefore = dbClient.view("_all_docs").query(DummyData.class).size();
        } catch (Exception e){
            countBefore = 0;
        }
        Response resp = dbController.addToDatabase(dbClient);

        int countAfter;
        try {
            countAfter = dbClient.view("_all_docs").query(DummyData.class).size();
        } catch (Exception e){
            countAfter = 0;
        }
        String docId = resp.getId();
        request.setAttribute("countBefore", countBefore);
        request.setAttribute("countAfter", countAfter);
        request.setAttribute("docId", docId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("afterAddedDocument.jsp");
        dispatcher.forward(request, response);
    }
}
