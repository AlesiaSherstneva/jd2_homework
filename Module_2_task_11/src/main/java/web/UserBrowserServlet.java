package web;

import eu.bitwalker.useragentutils.UserAgent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/")
public class UserBrowserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String browserName;

    /* Оказалось, что Google использует user-agent в своих целях, замедляет свои сервисы, если пользователь заходит
    с браузера, отличного от Chrome.
    А Microsoft Edge и Opera с этим борются, маскируясь под Chrome в своих user-agent.
    А я-то час билась, не могла понять, почему у меня все браузеры определяются, как Chrome :-)
    Firefox и Internet Explorer определяются корректно без дополнительных проверок.
    Других браузеров у меня на ПК нет, поэтому их не проверяла */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getHeader("User-Agent");
        if (info.toLowerCase().contains("edg")) {
            browserName = "Microsoft Edge";
        } else if (info.toLowerCase().contains("opr")) {
            browserName = "Opera";
        } else {
            UserAgent userAgent = UserAgent.parseUserAgentString(info);
            browserName = userAgent.getBrowser().getGroup().getName();
        }
        request.setAttribute("browserName", browserName);
        request.getRequestDispatcher("title.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        doGet(request, responce);
    }
}
