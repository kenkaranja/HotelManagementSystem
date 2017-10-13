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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "deleteroomcustomer")
public class DeleteRoomByCustomer extends Custom {
    @EJB
    CustomerI customerI;
    @Inject
    Room room;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        room.setRoomNo(Integer.parseInt(get(req, "number")));
        customerI.deleteBookedRoom();
        resp.sendRedirect("viewBookedRoomCustomer");

    }
}
