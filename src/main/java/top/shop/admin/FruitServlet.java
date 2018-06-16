package top.shop.admin;

import top.shop.entity.Fruit;
import top.shop.entity.FruitType;
import top.shop.service.impl.FruitServiceImpl;
import top.shop.service.impl.FruitTypeServiceImpl;
import top.shop.util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "FruitServlet", urlPatterns = "/fruitServlet")
public class FruitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delid = req.getParameter("delid");
        if (delid != null) {
            FruitServiceImpl.getFrultService().delFruit(delid);
            resp.sendRedirect(this.getServletContext().getContextPath() + "/fruitServlet");
            return;
        }
        try {
            List<FruitType> fruitTypes = FruitTypeServiceImpl.getFruitTypeService().showAllFruitType();
            List<Fruit> fruitList = new ArrayList<>();
            fruitTypes.forEach(fruitType -> {
                try {
                    fruitList.addAll(FruitServiceImpl.getFrultService().showAllFruit(fruitType.getId()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            req.setAttribute("fruitList", fruitList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/fruit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = UUID.randomUUID().toString();
        Map<String, String> map = new FileUtils().setFileName(id).setOutPutDir("D:\\upload").startUpload(req);
        String id1 = map.get("id");
        String name = map.get("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        String price = map.get("price");
        String tid = map.get("tid");
        String fileName = map.get(FileUtils.OUT_PUT_FILE_NAME);
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setName(name);
        fruit.setPrice(Double.parseDouble(price));
        fruit.setAddress(fileName);
        fruit.setTypeId(tid);
        boolean addFruit = false;
        try {
            if (id1 != null) {
                fruit.setId(id1);
                Fruit oneFruit = FruitServiceImpl.getFrultService().getOneFruit(id1);
                fruit.setAddress(oneFruit.getAddress());
                addFruit = FruitServiceImpl.getFrultService().upFruit(fruit);
            } else {
                addFruit = FruitServiceImpl.getFrultService().addFruit(fruit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (addFruit) {
            resp.sendRedirect(this.getServletContext().getContextPath() + "/fruitServlet");
        } else {
            this.getServletContext().getRequestDispatcher("/addFruit.jsp").forward(req, resp);
        }
    }
}
