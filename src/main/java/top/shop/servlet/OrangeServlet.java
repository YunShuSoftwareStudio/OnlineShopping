package top.shop.servlet;

import top.shop.entity.Fruit;
import top.shop.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrangeServlet", urlPatterns = "/OrangeServlet")
public class OrangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Fruit fruit = FruitServiceImpl.getFrultService().getOneFruit(id);
            request.setAttribute("fruit", fruit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/orange.jsp").forward(request, response);
    }
}
