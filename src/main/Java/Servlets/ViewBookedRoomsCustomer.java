package Servlets;

import Interfaces.CustomerI;
import POJO.Room;

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
import java.util.List;

@WebServlet(urlPatterns = "viewBookedRoomCustomer")
public class ViewBookedRoomsCustomer extends HttpServlet {
    @EJB
    CustomerI customerI;
    @Inject
    Room room;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String sessionName = String.valueOf(session.getAttribute("customer"));
        List<Room> bookedrooms = customerI.viewBookedRooms(sessionName);
        req.setAttribute("bookedrooms", bookedrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewBookedRoomCustomer.jsp");
        requestDispatcher.forward(req, resp);
    }
}
