package top.shop.admin;

import top.shop.entity.User;
import top.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delid = req.getParameter("delid");
        if (delid != null) {
            UserServiceImpl.getUserService().delUser(delid);
            resp.sendRedirect(this.getServletContext().getContextPath() + "/userServlet");
            return;
        }
        List<User> userList = null;
        try {
            userList = UserServiceImpl.getUserService().showAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("userList", userList);
        this.getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
