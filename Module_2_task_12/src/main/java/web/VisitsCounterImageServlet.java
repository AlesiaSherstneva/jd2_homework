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
import java.util.Scanner;

public class VisitsCounterImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int visitNumber;
    private boolean fileExists;
    String path = "C:" + File.separator + "Temp" + File.separator;

    public void init() {
        visitNumber = Integer.parseInt(getServletConfig().getInitParameter("visitNumber"));
        File file = new File(path + "count.txt");
        try {
            Scanner scanner = new Scanner(file);
            visitNumber += scanner.nextInt();
            fileExists = true;
        } catch (FileNotFoundException fileNotFoundException) {
            try {
                boolean mkdir = new File(path).mkdir();
                fileExists = file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        visitNumber++;
        BufferedImage image = new BufferedImage(1700, 850, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 80));
        graphics.setColor(Color.ORANGE);
        if (fileExists) {
            graphics.drawString("Welcome to my page!", 100, 200);
            graphics.drawString("Your visit number is " + visitNumber, 100, 400);
        } else {
            graphics.drawString("Sorry, I can't count your visits :-(", 100, 200);
            graphics.drawString("Try to visit my page from another device", 100, 400);
        }
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
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
