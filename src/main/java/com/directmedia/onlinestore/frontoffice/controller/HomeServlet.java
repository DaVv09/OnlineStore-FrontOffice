package com.directmedia.onlinestore.frontoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        out.print("<html>");
        out.print(" <head>");
        out.print("<title>Front-Office HomeServlet</title>");
        out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.print("</head>");
        out.print("<body>");
        out.print("<div>OnlineStore, votre boutique multimédia en ligne</div></p>");
        out.print("<a href=\"catalogue\">Accès au catalogue des oeuvres</a>");
        out.print("</body>");
        out.print("</html>");

    }
}


