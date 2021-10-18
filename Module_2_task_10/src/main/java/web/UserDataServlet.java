package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class UserDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("fio");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        out.println("<html><head><title>User Data Servlet</title><head>");
        if (name.isEmpty()) {
            out.println("<body><h1>You didn't enter the name!</h1>");
            out.println("</body></html>");
        } else if (phone.isEmpty() && email.isEmpty()) {
            out.println("<body><h1>You didn't enter your phone number and email!</h1>");
            out.println("</body></html>");
        }
        else {
            out.println("<body><h1>Hello "+name+"</h1>");
            out.println("<p> Your phone number is "+phone+"</p>");
            out.println("<p> Your email is "+email+"</p>");
            out.println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        doGet(request, responce);
    }
}
