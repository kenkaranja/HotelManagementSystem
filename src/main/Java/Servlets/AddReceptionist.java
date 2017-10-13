package Servlets;

import Interfaces.ReceptionistI;
import POJO.Receptionist;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AddReceptionist")
public class AddReceptionist extends Custom {
    @EJB
    ReceptionistI receptionistI;
    @Inject
    Receptionist receptionist;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        receptionist.setName(get(req, "name"));
        receptionist.setEmail(get(req, "email"));
        receptionist.setPassword(get(req, "password"));
        if (receptionistI.register(receptionist)) {
            out.println("Receptionist is added successfully!");
            req.getRequestDispatcher("ReceptionistLoginForm.jsp").forward(req, resp);
        } else {
            out.println("Receptionist is not added successfully!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddReceptionist.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddReceptionist.jsp");
        rd.forward(req, resp);
    }
}
