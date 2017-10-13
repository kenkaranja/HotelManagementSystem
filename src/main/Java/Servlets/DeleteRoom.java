package Servlets;

import Interfaces.ReceptionistI;
import POJO.Room;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteRoom extends Custom {
    @EJB
    ReceptionistI receptionistI;
    @Inject
    Room room;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("deleteRoom.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        room.setRoomNo(Integer.parseInt(get(req, "id")));
        receptionistI.delete(room);
        resp.sendRedirect("ViewRoom");
    }
}
