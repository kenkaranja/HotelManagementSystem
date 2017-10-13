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

@WebServlet(urlPatterns = "ViewRoom")
public class ViewRoomReceptionist extends HttpServlet {
    @EJB
    ReceptionistI receptionistI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> roomList = receptionistI.viewRooms();
        req.setAttribute("roomslist", roomList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewRoom.jsp");
        requestDispatcher.forward(req, resp);
    }
}
