package Controller;

import Model.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class adminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mod") != null && req.getParameter("mod").equals("1")) {
            Reservation rs = new Reservation();
            String rid = req.getParameter("rid");
            String checkIn = req.getParameter("checkIn");
            rs.remove(rid, checkIn);
        }
        ArrayList<Reservation> data = new ArrayList<>();
        Reservation rs = new Reservation();
        data = rs.getListReservation();
        req.setAttribute("data", data);
        req.getRequestDispatcher("listReservation.jsp").forward(req, resp);
    }

}
