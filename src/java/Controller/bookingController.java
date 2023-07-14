package Controller;

import Model.Reservation;
import Model.RoomType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bookingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rid = req.getParameter("name");
        String gid = req.getParameter("gid");
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        boolean check = true;
        String errors = "";
        if (req.getParameter("checkIn").isEmpty() || req.getParameter("checkOut").isEmpty()) {
            check = false;
            errors += "Bạn chưa nhập ngày Check In và Check Out";
        } else {
            Date date = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String cdate = sd.format(date);
            if (checkIn.compareTo(cdate) < 0) {
                check = false;
                errors += "Ngày Check In không hợp lệ !!";
            } else {
                if (checkIn.compareTo(checkOut) >= 0) {
                    check = false;
                    errors += "Ngày Check In phải trước ngày Check Out !!";
                } else {
                    Reservation rs = new Reservation();
                    if (!rs.checkRoomEmpty(checkIn, checkOut, rid)) {
                        check = false;
                        errors += "Xin lỗi quý khách, phòng không còn trống";
                    }
                }
            }
        }
        if (check == true) {
            Reservation res = new Reservation(gid, rid, checkIn, checkOut);
            res.add();

            resp.sendRedirect("checkBooking.jsp");
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("checkBookingFail.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String des = req.getParameter("des");
        req.setAttribute("des", des);
        String name = req.getParameter("name");
        req.setAttribute("name", name);
        String ntype = req.getParameter("type");
        RoomType rt = new RoomType();
        String type = rt.getNameById(ntype);
        req.setAttribute("type", type);
        String price = req.getParameter("price");
        req.setAttribute("price", price);
        if (req.getParameter("checkIn") != null && req.getParameter("checkOut") != null) {
            String checkIn = req.getParameter("checkIn");
            req.setAttribute("checkIn", checkIn);
            String checkOut = req.getParameter("checkOut");
            req.setAttribute("checkOut", checkOut);
        }

        String gid = req.getParameter("gid");
        req.setAttribute("gid", gid);
        String uname = req.getParameter("uname");
        req.setAttribute("uname", uname);
        req.getRequestDispatcher("booking.jsp").forward(req, resp);
    }

}
