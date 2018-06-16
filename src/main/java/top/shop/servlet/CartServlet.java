package top.shop.servlet;

import top.shop.entity.Cart;
import top.shop.entity.User;
import top.shop.service.impl.CartServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
@WebServlet(name = "CartServlet", urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String delid = req.getParameter("delid");
        String id = req.getParameter("id");
        String num = req.getParameter("num");
        if (delid != null) {
            //删除
            if (CartServerImpl.getCartServer().delCartById(delid)) {
                resp.sendRedirect(this.getServletContext().getContextPath() + "/ProduServlet");
            }

        } else if (id != null) {
            //添加
            try {
                if (CartServerImpl.getCartServer().addCart(id, num, user.getId())) {
                    resp.sendRedirect(this.getServletContext().getContextPath() + "/ProduServlet");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<Cart> cartList = CartServerImpl.getCartServer().showAllCart(user.getId());
                req.setAttribute("cartList", cartList);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
