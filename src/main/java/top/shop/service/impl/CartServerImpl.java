package top.shop.service.impl;

import top.shop.dao.CartDao;
import top.shop.entity.Cart;
import top.shop.service.CartServer;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CartServerImpl implements CartServer {
    private static final CartServer CART_SERVER = new CartServerImpl();

    private CartServerImpl() {

    }

    public static CartServer getCartServer() {
        return CART_SERVER;
    }

    @Override
    public List<Cart> showAllCart(String uid) throws SQLException {
        return CartDao.getCartDao().getAllFruitList(uid);
    }

    @Override
    public boolean delCartById(String id) {
        int delete = CartDao.getCartDao().delete(id);
        return delete != 0;
    }

    @Override
    public boolean addCart(String id, String num, String uid) throws SQLException {
        Cart cart = new Cart();
        cart.setId(id);
        cart.setNum(Integer.parseInt(num));
        cart.setUid(uid);
        List<Cart> fruitList = CartDao.getCartDao().getAllFruitList(uid);
        AtomicBoolean have = new AtomicBoolean(false);
        fruitList.forEach(cart1 -> {
            if (cart1.getId().equals(id)) {
                have.set(true);
            }
        });
        if (!have.get()) {
            int add = CartDao.getCartDao().add(cart);
            return add != 0;
        } else {
            return true;
        }
    }
}
