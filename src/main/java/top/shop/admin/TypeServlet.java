package top.shop.admin;

import top.shop.entity.FruitType;
import top.shop.service.impl.FruitTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "typeServlet", urlPatterns = "/typeServlet")
public class TypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delid = req.getParameter("delid");
        String upid = req.getParameter("upid");
        if (delid != null) {
            try {
                FruitTypeServiceImpl.getFruitTypeService().delFruitType(delid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect(this.getServletContext().getContextPath() + "/typeServlet");
        } else if (upid != null) {
            System.out.println("upId-->" + upid);
            resp.sendRedirect(this.getServletContext().getContextPath() + "/typeServlet");
        } else {
            List<FruitType> fruitTypes = null;
            try {
                fruitTypes = FruitTypeServiceImpl.getFruitTypeService().showAllFruitType();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("fruitType", fruitTypes);
            this.getServletContext().getRequestDispatcher("/type.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = UUID.randomUUID().toString();
        String name = req.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        FruitType fruitType = new FruitType();
        fruitType.setId(id);
        fruitType.setName(name);
        String id1 = req.getParameter("id");
        boolean addFruitType;
        if (id1 != null) {
            fruitType.setId(id1);
            addFruitType = FruitTypeServiceImpl.getFruitTypeService().upFruitType(id1, name);
        } else {
            addFruitType = FruitTypeServiceImpl.getFruitTypeService().addFruitType(fruitType);
        }
        if (addFruitType) {
            resp.sendRedirect(this.getServletContext().getContextPath() + "/typeServlet");
        } else {
            this.getServletContext().getRequestDispatcher("/addType.jsp").forward(req, resp);
        }

    }
}
