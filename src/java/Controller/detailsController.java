package Controller;

import Model.Reservation;
import Model.Room;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class detailsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        if (ses.getAttribute("account") == null) {
            resp.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("access denied");
                return;
            }
        } else {
            if (req.getParameter("mod") != null && req.getParameter("mod").equals("1")) {
                Reservation rs = new Reservation();
                String rid = req.getParameter("rid");
                String checkIn = req.getParameter("checkIn");
                rs.remove(rid, checkIn);
            }
            User u = (User) ses.getAttribute("account");
            User infor = u.getInforByAccount(u.getAccount());
            String name = infor.getName();
            req.setAttribute("name", name);
            req.setAttribute("infor", infor);

            if (req.getParameter("type") != null) {
                String checkIn = req.getParameter("checkIn");
                String checkOut = req.getParameter("checkOut");
                String type = req.getParameter("type");
                Reservation rs = new Reservation();
                ArrayList<Room> roomData = rs.findRoomEmpty(type, checkIn, checkOut);
                req.setAttribute("checkIn", checkIn);
                req.setAttribute("checkOut", checkOut);
                req.setAttribute("type", type);
                req.setAttribute("data", roomData);
            } else {
                Room r = new Room();
                ArrayList<Room> data = new ArrayList<>();
                data = r.getListRoom();
                req.setAttribute("data", data);
            }
            req.setAttribute("acc", infor.getAccount());

            Reservation rs = new Reservation();
            ArrayList<Reservation> rdata = new ArrayList<>();
            rdata = rs.getListBookingByAccount(u.getAccount());
            req.setAttribute("rdata", rdata);

            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }

}
