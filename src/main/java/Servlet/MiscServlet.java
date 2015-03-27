package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import Entity.DummyData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.lightcouch.CouchDbClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kim.flaethe on 26.03.2015.
 */
public class MiscServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseController databaseController = new DatabaseController();
        List <DummyData> allDocs = databaseController.getAllDocuments();

        // Format Json output
        String listOutput = formatJsonString(allDocs);

        request.setAttribute("listOutput", listOutput);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listDocuments.jsp");
        dispatcher.forward(request, response);
    }

    private String formatJsonString(List<DummyData> allDocs) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper.writeValueAsString(allDocs);
    }
}
