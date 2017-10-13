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
import java.io.PrintWriter;

public class UpdateRoom extends Custom {
    @EJB
    ReceptionistI receptionistI;
    @Inject
    Room room;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("UpdateRoom.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        room.setRoomType(get(req, "type"));
        room.setCost(Float.parseFloat(get(req, "cost")));
        room.setNoofpeople(Integer.parseInt(get(req, "people")));
        room.setDescription(get(req, "description"));


        if (receptionistI.update(room)) {
            out.println("Room is updated successfully!");
            resp.sendRedirect("viewRoom.jsp");

        } else {
            out.println("Sorry! Something went wrong, Repeat");
            RequestDispatcher rd = req.getRequestDispatcher("UpdateRoomForm.jsp");
            rd.forward(req, resp);
        }

    }
}
