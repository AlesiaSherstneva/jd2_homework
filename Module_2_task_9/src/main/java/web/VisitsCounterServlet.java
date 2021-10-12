package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class VisitsCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int visitNumber;

    public void init() {
        visitNumber = 0;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        visitNumber++;
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visits Counter Servlet</title><head>");
        out.println("<body><h1>Welcome to my page!</h1>");
        out.println("<p> Your visit number is ");
        out.println(visitNumber);
        out.println("</p></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        doGet(request, responce);
    }
}
