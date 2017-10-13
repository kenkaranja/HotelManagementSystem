package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Custom extends HttpServlet {
    public String get(HttpServletRequest req, String key) {
        return req.getParameter(key);
    }

}
