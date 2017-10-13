package Servlets;

import Interfaces.ReceptionistI;
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

@WebServlet(urlPatterns = "ViewbookedRooms")
public class ViewBookedRoomReceptionist extends HttpServlet {
    @EJB
    ReceptionistI receptionistI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> bookedrooms = receptionistI.viewBookedRooms();
        req.setAttribute("bookedrooms", bookedrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("BookedRooms.jsp");
        requestDispatcher.forward(req, resp);
    }
}
