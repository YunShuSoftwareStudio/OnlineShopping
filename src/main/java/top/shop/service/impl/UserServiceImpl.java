package top.shop.service.impl;

import top.shop.dao.UserDao;
import top.shop.entity.User;
import top.shop.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    private UserServiceImpl() {

    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

    @Override
    public List<User> showAllUser() throws SQLException {
        return UserDao.getUserDao().findAllUser();
    }

    @Override
    public boolean delUser(String id) {
        if (CartServerImpl.getCartServer().delCartById(id)) {
            int i = UserDao.getUserDao().delUser(id);
            return i != 0;
        } else {
            return false;
        }
    }
}
