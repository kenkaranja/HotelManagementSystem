package Servlets;

import Interfaces.CustomerI;
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

@WebServlet(urlPatterns = "ViewRoomByCustomer")
public class ViewRoomCustomer extends HttpServlet {
    @EJB
    CustomerI customerI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> roomList = customerI.viewRoom();
        req.setAttribute("roomslist", roomList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewRoomCustomer.jsp");
        requestDispatcher.forward(req,resp);
    }
}
