package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String repass = req.getParameter("repass");
        String name = req.getParameter("name");
        String number = req.getParameter("num");
        String id = req.getParameter("id");
        String add = req.getParameter("add");
        String error = "";
        
        boolean check = true;
        if (req.getParameter("acc").isEmpty()) {
            error += "Account is empty <br>";
            check = false;
        } else {
            User u = new User();
            u.setAccount(account);
            if (u.checkDuplicateAccount()) {
                error += "Tên đăng nhập đã tồn tại!! <br>";
                check = false;
            }
        }
        if (req.getParameter("pass").isEmpty()) {
            error += "password is empty <br>";
            check = false;
        }
        if (req.getParameter("repass").isEmpty()) {
            error += "re-password is empty <br>";
            check = false;
        } else {
            if (!repass.equals(pass)) {
                error += "Mật khẩu không trùng khớp <br>";
                check = false;
            }
        }
        if (number.length()!=10) {
            error += "Số điện thoại không hợp lệ <br>";
            check = false;
        }
        if (id.length()!=12) {
            error += "Số CCCD không hợp lệ <br>";
            check = false;
        }
        if (check == false) {
            req.setAttribute("error", error);
            req.getRequestDispatcher("checkRegisterFail.jsp").forward(req, resp);
        } else {
            User u = new User(account, pass, name, number, id, add);
            u.add();
            resp.sendRedirect("checkRegister.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
