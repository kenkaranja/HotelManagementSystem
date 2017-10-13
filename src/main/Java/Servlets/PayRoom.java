package Servlets;

import Interfaces.CustomerI;
import POJO.Room;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "payRoom")
public class PayRoom extends HttpServlet {
    @EJB
    CustomerI customerI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerI.payForRoom();
        resp.sendRedirect("ViewBookedRoomCustomer.jsp");
    }
}
