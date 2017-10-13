package Servlets;

import Interfaces.ReceptionistI;
import POJO.Customer;
import POJO.Room;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "ViewCustomer")
public class ViewCustomer extends HttpServlet {
    @EJB
    ReceptionistI receptionistI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = receptionistI.viewCustomer();
        req.setAttribute("customerList", customerList);
        RequestDispatcher rd = req.getRequestDispatcher("ViewCustomer.jsp");
        rd.forward(req, resp);
    }
}
