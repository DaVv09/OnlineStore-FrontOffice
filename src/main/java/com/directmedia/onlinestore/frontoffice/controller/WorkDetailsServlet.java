package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String sId= req.getParameter("id");

        Work oeuvre=null;
        for(Work newWork: Catalogue.listOfWorks){
           if(newWork.getId()==Long.parseLong(sId)){
             oeuvre=newWork;
           }
        }

        resp.setContentType("text/html;charset=UTF-8");
        out.print("<html>");
        out.print(" <head>");
        out.print("<title>Details de l'oeuvre</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("Titre : "+ oeuvre.getTitle()+"<BR/>");
        out.print("Année : "+ oeuvre.getRelease()+"<BR/>");
        out.print("Genre : "+ oeuvre.getGenre()+"<BR/>");
        out.print("Artiste: "+ oeuvre.getMainArtist().getName()+"<BR/>");
        out.print("Résumé : "+ oeuvre.getSummary()+"<BR/>");
        out.print("<form action=\"addToCart\" method=\"post\">\n" +
                "    <input type=\"hidden\" name=\"idSelectionAchat\" value="+oeuvre.getId()+"><br/>\n" +
                "    <input type=\"submit\" value=\"ajouter au panier\">\n" +
                "</form>");
        out.print("</body>");
        out.print("</html>");
    }
}


