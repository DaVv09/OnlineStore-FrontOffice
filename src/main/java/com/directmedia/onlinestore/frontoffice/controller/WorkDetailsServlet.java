package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.RequestDispatcher;
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
        String sId = req.getParameter("id");

        Work selectedWork = null;
        for (Work work : Catalogue.listOfWorks) {
            if (work.getId() == Long.parseLong(sId)) {
                selectedWork = work;
                req.setAttribute("selectedWork", selectedWork);
                RequestDispatcher disp = req.getRequestDispatcher("/work-details.jsp");
                disp.forward(req, resp);
            }
        }
    }
}


