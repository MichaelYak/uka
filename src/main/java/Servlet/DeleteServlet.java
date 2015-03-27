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

    private DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");


        dbController = new DatabaseController();

        try {
            int countBefore = dbController.countDatabase();
            Response resp = dbController.removeDocument(id);
            int countAfter = dbController.countDatabase();

            String deletedId = resp.getId();
            request.setAttribute("countBefore", countBefore);
            request.setAttribute("countAfter", countAfter);
            request.setAttribute("deletedId", deletedId);
        } catch (Exception e) {}

        RequestDispatcher dispatcher = request.getRequestDispatcher("afterDeletedDocument.jsp");
        dispatcher.forward(request, response);
    }

}
