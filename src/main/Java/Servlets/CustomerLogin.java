package Servlets;

import Interfaces.CustomerI;
import POJO.Customer;

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

@WebServlet(urlPatterns = "CustomerLogin")
public class CustomerLogin extends Custom {
    @EJB
    CustomerI customerI;
    @Inject
    Customer customer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("CustomerLoginForm.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customer.setEmail(get(req, "email"));
        customer.setPassword(get(req, "password"));
        if (customerI.validate(customer)) {
            HttpSession session = req.getSession();
            session.setAttribute("customer", get(req, "email"));
            resp.sendRedirect("CustomerHomePage.jsp");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("CustomerLoginForm.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
