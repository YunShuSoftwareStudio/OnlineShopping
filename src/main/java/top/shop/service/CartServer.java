package top.shop.service;

import top.shop.entity.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartServer {
    List<Cart> showAllCart(String uid) throws SQLException;

    boolean delCartById(String id);

    boolean addCart(String id, String num,String uid) throws SQLException;
}
