package top.shop.servlet;

import top.shop.entity.Cart;
import top.shop.entity.Fruit;
import top.shop.entity.FruitType;
import top.shop.entity.User;
import top.shop.service.impl.CartServerImpl;
import top.shop.service.impl.FruitTypeServiceImpl;
import top.shop.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProduServlet", urlPatterns = "/ProduServlet")
public class ProduServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        User user = (User) request.getSession().getAttribute("user");
        List<Fruit> fruits = null;
        List<FruitType> fruitTypes = null;
        List<Cart> cartList = null;
        try {
            fruits = FruitServiceImpl.getFrultService().showAllFruit(typeId);
            fruitTypes = FruitTypeServiceImpl.getFruitTypeService().showAllFruitType();
            if (user != null) {
                cartList = CartServerImpl.getCartServer().showAllCart(user.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("cartList", cartList);
        request.setAttribute("fruitList", fruits);
        request.setAttribute("fruitTypeList", fruitTypes);
        this.getServletContext().getRequestDispatcher("/produ.jsp").forward(request, response);
    }
}
