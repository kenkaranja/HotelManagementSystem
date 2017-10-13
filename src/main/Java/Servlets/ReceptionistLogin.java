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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "ReceptionistLogin")
public class ReceptionistLogin extends Custom {
    @EJB
    ReceptionistI receptionistI;
    @Inject
    Receptionist receptionist;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        receptionist.setEmail(get(req, "email"));
        receptionist.setPassword(get(req, "password"));

        if (receptionistI.validate(receptionist)) {
            HttpSession session = req.getSession();
            session.setAttribute("receptionist", get(req, "email"));
            resp.sendRedirect("ReceptionistHomePage.jsp");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("ReceptionistLoginForm.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("ReceptionistLoginForm.jsp");
        rd.forward(req, resp);
    }

}
