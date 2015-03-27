package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import com.sun.corba.se.impl.orb.DataCollectorBase;
import org.junit.Before;
import org.junit.Test;
import org.lightcouch.CouchDbClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import static org.mockito.Mockito.*;

public class UploadServletTest {


    private HttpServletResponse responseMock;
    private HttpServletRequest requestMock;
    private DatabaseController databaseController;
    private CouchDbClient dbClient;

    private UploadServlet uploadServlet;

    @Before
    public void setUp(){
        uploadServlet = new UploadServlet();
        responseMock = mock(HttpServletResponse.class);
        requestMock = mock(HttpServletRequest.class);
        databaseController = mock(DatabaseController.class);
        dbClient = mock(CouchDbClient.class);

        uploadServlet.dbController = databaseController;
    }


}
