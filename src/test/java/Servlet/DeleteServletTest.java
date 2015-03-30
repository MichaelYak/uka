package Servlet;

import Controller.DatabaseController;
import org.junit.Before;
import org.junit.Test;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

/**
 * Created by kim.flaethe on 23.03.2015.
 */
public class DeleteServletTest {

    private CouchDbClient dbClientMock;
    private DatabaseController dbControllerMock;
    private HttpServletResponse responseMock;
    private HttpServletRequest requestMock;
    private Response responseLightCouchMock;

    @Before
    public void setUp(){
        dbClientMock = mock(CouchDbClient.class);
        dbControllerMock = mock(DatabaseController.class);
        responseMock = mock(HttpServletResponse.class);
        requestMock = mock(HttpServletRequest.class);
        responseLightCouchMock = mock(Response.class);
    }


    @Test
    public void doGetTest(){
        when(requestMock.getParameter(anyString())).thenReturn(anyString());
  //      when(dbControllerMock.countDatabase()).thenReturn(anyInt());
  //      when(dbControllerMock.removeDocument(anyString())).thenReturn(responseLightCouchMock);

    }
}
