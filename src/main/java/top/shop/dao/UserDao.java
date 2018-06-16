package top.shop.dao;

import top.shop.entity.User;
import top.shop.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final UserDao USER_DAO = new UserDao();

    private UserDao() {

    }

    public static UserDao getUserDao() {
        return USER_DAO;
    }

    public User loadUserByPassWord(String username, String password) throws SQLException {
        String[] s = {username, password};
        ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL("select * from [user] where username=? and password= ?", s, DaoUtils.getConn());
        res.next();
        String id = res.getString("id");
        String username1 = res.getString("username");
        String password1 = res.getString("password");
        User user = new User();
        user.setId(id);
        user.setUsername(username1);
        user.setPassword(password1);
        return user;
    }

    public List<User> findAllUser() throws SQLException {
        ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL("select * from [user]", null, DaoUtils.getConn());
        List<User> list = new ArrayList<>();
        while (res.next()) {
            User user = new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            list.add(user);
        }
        return list;
    }
    public int delUser(String id){
        String[] s = {id};
        return DaoUtils.getDaoUtils().executeUpdateSQL("delete from [user] where id = ?", s, DaoUtils.getConn());
    }
}
