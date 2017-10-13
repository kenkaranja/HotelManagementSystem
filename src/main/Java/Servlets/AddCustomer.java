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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "AddCustomer")
public class AddCustomer extends Custom {
    @EJB
    CustomerI customerI;
    @Inject
    Customer customer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddCustomer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        customer.setAddress(get(req, "address"));
        customer.setPassword(get(req, "password"));
        customer.setEmail(get(req, "email"));
        customer.setName(get(req, "name"));
        customer.setArrival_date(get(req, "arrival"));
        customer.setDep_date(get(req, "dep"));
        customer.setContact(get(req, "contact"));


        if (customerI.register(customer)) {
            out.println("<html><p>Registered successfully!</p></html>");
            resp.sendRedirect("CustomerLogin");
        } else {
            out.println("<html><p>Registered not  successfully!<p></html>");
            resp.sendRedirect("AddCustomer");

        }

    }
}
