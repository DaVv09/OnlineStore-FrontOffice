package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Long idSelectionAchat=Long.parseLong(req.getParameter("idSelectionAchat")); //recupération de l'id de louvre selection a mettre dans le caddie
        ShoppingCart cart=(ShoppingCart)req.getSession().getAttribute("cart");

        if(cart==null) {
            cart = new ShoppingCart();
            req.getSession().setAttribute("cart", cart); // mise en session du caddie
        }
        for (Work work: Catalogue.listOfWorks){
            if(work.getId()==idSelectionAchat){
                cart.getItems().add(work);
            }
        }

        resp.setContentType("text/html;charset=UTF-8");
        out.print("<html>");
        out.print(" <head>");
        out.print("<title>Panier</title>");
        out.print("</head>");
        out.print("<body>");
        out.print(" oeuvre ajoutée au caddie ("+cart.getItems().size()+")<br/>");
        out.print("<a href=\"catalogue\">retour au catalogue</a>");
        out.print("</body>");
        out.print("</html>");
    }
}


