package com.directmedia.onlinestore.frontoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Long idSelectionAchat=Long.parseLong(req.getParameter("idSelectionAchat"));
        HttpSession session=req.getSession();
        req.getSession().getAttribute("idSelectionAchat",);

        //if{ //1ere session achat }
        // else{
        // charger shop^ping cart avec session }
        resp.setContentType("text/html;charset=UTF-8");
        out.print("<html>");
        out.print(" <head>");
        out.print("<title>AddToCartServlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<div>OnlineStore, votre boutique multimédia en ligne</div>");
        out.print("</body>");
        out.print("</html>");
    }
}


