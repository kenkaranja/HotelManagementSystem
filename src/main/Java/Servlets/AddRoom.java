package Servlets;

import Interfaces.ReceptionistI;
import POJO.Room;

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

@WebServlet(urlPatterns = "AddRoom")
public class AddRoom extends Custom {
    @EJB
    ReceptionistI receptionistI;
    @Inject
    Room room;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddRoom.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        room.setRoomNo(Integer.parseInt(get(req, "no")));
        room.setRoomType(get(req, "room"));
        room.setCost(Float.parseFloat(get(req, "price")));
        room.setNoofpeople(Integer.parseInt(get(req, "people")));
        room.setDescription(get(req, "descr"));
        room.setBookedStatus(get(req, "booking"));

        if (receptionistI.addRoom(room)) {
            out.println("<p>Room is added successfully!</p>");
            resp.sendRedirect("ReceptionistHomePage.jsp");

        } else {
            out.println("<p>Sorry! Something went wrong, Repeat</p>");
            RequestDispatcher rd = req.getRequestDispatcher("AddRoomForm.jsp");
            rd.forward(req, resp);
        }

    }
}
