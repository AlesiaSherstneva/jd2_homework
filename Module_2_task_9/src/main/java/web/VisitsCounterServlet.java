package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Scanner;

@SuppressWarnings("RedundantThrows")
public class VisitsCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int visitNumber;
    private boolean fileExists;
    String path = "C:" + File.separator + "Temp"+ File.separator;

    public void init() {
        visitNumber = Integer.parseInt(getServletConfig().getInitParameter("visitNumber"));
        File file = new File(path + "count.txt");
        try {
            Scanner scanner = new Scanner(file);
            visitNumber += scanner.nextInt();
            fileExists = true;
        } catch (FileNotFoundException fileNotFoundException) {
            try {
                @SuppressWarnings("unused")
                boolean mkdir = new File(path).mkdir();
                fileExists = file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visits Counter Servlet</title><head>");
        out.println("<body><h1>Welcome to my page!</h1>");
        if(fileExists) {
            visitNumber++;
            out.println("<p> Your visit number is ");
            out.println(visitNumber);
            out.println("</p></body></html>");
        } else {
            out.println("<p> Sorry, I can't count your visits :-( </p>");
            out.println("<p> Try to visit my page from another device </p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        doGet(request, responce);
    }

    public void destroy() {
        File file = new File(path + "count.txt");
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(visitNumber);
            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
