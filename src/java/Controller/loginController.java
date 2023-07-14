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
import java.util.ArrayList;

public class loginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin
        String account = req.getParameter("acc");
        String password = req.getParameter("pass");

        //Xu ly thong tin
        User u = new User(account, password);
        boolean check = u.checkUser();

        //Tra ket qua ve
        if (check) {
            // Luu lai thong tin login vao session
            HttpSession session = req.getSession();
            session.setAttribute("account", u);

            User infor = u.getInforByAccount(account);
            String name = infor.getName();
            req.setAttribute("name", name);
            req.setAttribute("infor", infor);

            Room r = new Room();
            ArrayList<Room> data = new ArrayList<>();
            data = r.getListRoom();
            req.setAttribute("data", data);
            req.setAttribute("acc", account);
            
            Reservation rs = new Reservation();
            ArrayList<Reservation> rdata = new ArrayList<>();
            rdata = rs.getListBookingByAccount(u.getAccount());
            req.setAttribute("rdata", rdata);

            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("checkLoginFail.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
