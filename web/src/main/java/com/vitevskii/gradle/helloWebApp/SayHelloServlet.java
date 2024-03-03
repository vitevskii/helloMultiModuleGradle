package com.vitevskii.gradle.helloWebApp;
import com.vitevskii.gradle.DataRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class SayHelloServlet extends HttpServlet {

  private final DataRepository repository = new DataRepository();
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String greeting = repository.getGreeting(request.getParameter("name"));
    request.setAttribute("greeting", greeting);
    request.getRequestDispatcher("hello.jsp").forward(request, response);
  }
}
