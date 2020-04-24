package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Work lucyInTheSky=new Work("Lucy in the Sky");
        Artist nataliePortman=new Artist("Natalie Portman");
        lucyInTheSky.setMainArtist(nataliePortman);
        lucyInTheSky.setGenre("Drame");
        lucyInTheSky.setRelease(2020);
        lucyInTheSky.setSummary("Une jeune femme, engagée comme nounou de deux orphelins, est convaincue que le manoir dans lequel ils vivent est hanté. Adaptation de la nouvelle Le Tour d'écrou écrite par Henry James.");

        Work badBoysForLife=new Work("Bad boys for life");
        Artist willSmith=new Artist("Will Smith");
        badBoysForLife.setMainArtist(willSmith);
        badBoysForLife.setGenre("comédie");
        badBoysForLife.setRelease(2020);
        badBoysForLife.setSummary("Les Bad Boys Mike Lowrey et Marcus Burnett se retrouvent pour résoudre une ultime affaire.");

        Work theTurning=new Work("The turning");
        Artist mackenzieDavis=new Artist("Mackenzie Davis");
        theTurning.setMainArtist(mackenzieDavis);
        theTurning.setGenre("drame");
        theTurning.setRelease(2020);
        theTurning.setSummary("Une jeune femme, engagée comme nounou de deux orphelins, est convaincue que le manoir dans lequel ils vivent est hanté. Adaptation de la nouvelle Le Tour d'écrou écrite par Henry James.");

        Catalogue catalogue=new Catalogue();
        catalogue.listOfWorks.add(lucyInTheSky);
        catalogue.listOfWorks.add(badBoysForLife);
        catalogue.listOfWorks.add(theTurning);


        for (Work work:catalogue.listOfWorks) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print(" <head>");
            out.print("<title>Catalogue</title>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.print("</head>");
            out.print("<body>");
            out.print("<div><a href=\"work-details?id="+work.getId()+"\">"+work.getTitle() +" (" + work.getRelease() +")</a></div>");
            out.print("</body>");
            out.print("</html>");
        }


    }
}


