package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import Entity.DummyData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.lightcouch.CouchDbClient;

import javax.servlet.RequestDispatcher;
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

        List<DummyData> allDocs = dbClient.view("_all_docs").includeDocs(true).query(DummyData.class);

        // Format Json output
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String listOutput = mapper.writeValueAsString(allDocs);

        request.setAttribute("listOutput", listOutput);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listDocuments.jsp");
        dispatcher.forward(request, response);
    }
}
