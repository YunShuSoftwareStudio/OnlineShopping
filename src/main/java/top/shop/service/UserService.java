package top.shop.service;

import top.shop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> showAllUser() throws SQLException;
    boolean delUser(String id);
}
