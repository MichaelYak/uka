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

public class DeleteServlet extends HttpServlet {

    public DeleteServlet() {
    }

    private CouchDbClient dbClient;
    private DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        dbClient = DatabaseSetup.getDbCliend();

        dbController = new DatabaseController();

        try {
            int countBefore;
            int countAfter;
            try {
                countBefore = dbClient.view("_all_docs").query(DummyData.class).size();
            } catch (Exception e) {
                countBefore = 0;
            }
            Response resp = dbController.removeDocument(dbClient, id);

            try {
                countAfter = dbClient.view("_all_docs").query(DummyData.class).size();
            } catch (Exception e) {
                countAfter = 0;
            }

            String deletedId = resp.getId();
            request.setAttribute("countBefore", countBefore);
            request.setAttribute("countAfter", countAfter);
            request.setAttribute("deletedId", deletedId);
        } catch (Exception e) {}

        RequestDispatcher dispatcher = request.getRequestDispatcher("afterDeletedDocument.jsp");
        dispatcher.forward(request, response);
    }
}
