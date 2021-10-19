package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class VisitsCounterImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int visitNumber;

    public void init() {
        visitNumber = Integer.parseInt(getServletConfig().getInitParameter("visitNumber"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        visitNumber++;
        BufferedImage image = new BufferedImage(2000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 80));
        graphics.setColor(Color.ORANGE);
        graphics.drawString("Welcome to my page!Your visit number is " + visitNumber, 100, 100);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        doGet(request, responce);
    }
}
