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

public class UploadServlet extends HttpServlet {

    public UploadServlet() {
        super();
    }

    DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbController = new DatabaseController();

        int countBefore = dbController.countDatabase();
        Response resp = dbController.addToDatabase(new DummyData());
        int countAfter = dbController.countDatabase();

        String docId = resp.getId();
        request.setAttribute("countBefore", countBefore);
        request.setAttribute("countAfter", countAfter);
        request.setAttribute("docId", docId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("afterAddedDocument.jsp");
        dispatcher.forward(request, response);
    }


}
