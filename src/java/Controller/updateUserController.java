package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String num = req.getParameter("num");
        String id = req.getParameter("id");
        String add = req.getParameter("add");
        String errors = "";
        boolean check = true;
        if (num.length() != 10) {
            errors += "Số điện thoại không hợp lệ <br>";
            check = false;
        }
        if (id.length() != 12) {
            errors += "Số CCCD không hợp lệ <br>";
            check = false;
        }
        if (check == false) {
            req.setAttribute("errors", errors);
            req.setAttribute("acc", acc);
            req.getRequestDispatcher("checkUpdateFail.jsp").forward(req, resp);
        } else {
            User u = new User(acc, "", "", num, id, add);
            u.update();
            resp.sendRedirect("checkUpdate.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        req.setAttribute("acc", acc);
        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }

}
