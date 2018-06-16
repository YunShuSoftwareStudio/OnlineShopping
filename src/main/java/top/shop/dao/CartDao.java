package top.shop.dao;

import top.shop.entity.Cart;
import top.shop.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private static final CartDao CART_DAO = new CartDao();

    private CartDao() {

    }

    public static CartDao getCartDao() {
        return CART_DAO;
    }

    /**
     * 获取所有水果集合
     *
     * @return 水果集合
     * @throws SQLException SQLException
     */
    public List<Cart> getAllFruitList(String uid) throws SQLException {
        List<Cart> list = new ArrayList<>();
        String[] s={uid};
        ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL("select * from cart where uid = ?", s, DaoUtils.getConn());
        while (res.next()) {
            Cart cart = new Cart();
            String id = res.getString("id");
            int num = res.getInt("num");
            cart.setId(id);
            cart.setNum(num);
            cart.initFruit();
            list.add(cart);
        }
        return list;
    }

    /**
     * 根据ID删除
     *
     * @param id 要删除的
     * @return 影响行数
     */
    public int delete(String id) {
        String[] s = {id};
        return DaoUtils.getDaoUtils().executeUpdateSQL("delete from cart where id = ?", s, DaoUtils.getConn());
    }

    public int add(Cart cart) {
        String[] s = {cart.getId(), String.valueOf(cart.getNum()), cart.getUid()};
        return DaoUtils.getDaoUtils().executeUpdateSQL("insert into cart values(?,?,?)", s, DaoUtils.getConn());
    }
}
