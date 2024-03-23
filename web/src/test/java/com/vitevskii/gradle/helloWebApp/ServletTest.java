package com.vitevskii.gradle.helloWebApp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ServletTest {

    private AutoCloseable closeable;
    @Mock private HttpServletResponse response;
    @Mock private HttpServletRequest request;
    @Mock private RequestDispatcher requestDispatcher;

    @Before
    public void openMocks() throws Exception {
        closeable = MockitoAnnotations.openMocks(this);
    }
    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void getCoupon() throws ServletException, IOException {
        StringWriter stringWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));
        new CouponServlet().doGet(request, response);
        assertEquals("COUPON", stringWriter.toString());
    }

    @Test
    public void doPost() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("Bill");
        when(request.getRequestDispatcher("hello.jsp")).thenReturn(requestDispatcher);
        new SayHelloServlet().doPost(request, response);
        verify(request).setAttribute("greeting", "Hello, Bill!");
        verify(requestDispatcher).forward(request, response);
    }
}