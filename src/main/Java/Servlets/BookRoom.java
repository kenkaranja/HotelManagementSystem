package Servlets;

import Interfaces.CustomerI;
import Interfaces.DBI;
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

@WebServlet(urlPatterns = "BookRoom")
public class BookRoom extends HttpServlet {
    @EJB
    DBI dbi;
    @EJB
    CustomerI customerI;
    @Inject
    Room room;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String sessionName = String.valueOf(session.getAttribute("customer"));
        room.setUser(sessionName);
        if(customerI.bookRoom()){resp.sendRedirect("viewBookedRoomCustomer");

        }



    }

}
