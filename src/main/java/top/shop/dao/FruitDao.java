package top.shop.dao;

import org.omg.CORBA.PUBLIC_MEMBER;
import top.shop.entity.Fruit;
import top.shop.util.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FruitDao {
    private static final FruitDao FRUIT_DAO = new FruitDao();

    private FruitDao() {

    }

    public static FruitDao getFruitDao() {
        return FRUIT_DAO;
    }

    /**
     * 获取所有水果集合
     *
     * @return 水果集合
     * @throws SQLException SQLException
     */
    public List<Fruit> getAllFruitList(String typeId) throws SQLException {
        String sql = "select * from fruit where tid = ?";
        String[] s = {typeId};
        if (typeId == null) {
            sql = "select * from fruit";
            s = null;
        }
        List<Fruit> list = new ArrayList<>();
        ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL(sql, s, DaoUtils.getConn());
        while (res.next()) {
            Fruit fruit = new Fruit();
            String id = res.getString("id");
            String name = res.getString("name");
            double price = res.getDouble("price");
            String address = res.getString("address");
            String tid = res.getString("tid");
            fruit.setId(id);
            fruit.setName(name);
            fruit.setPrice(price);
            fruit.setAddress(address);
            fruit.setTypeId(tid);
            list.add(fruit);
        }
        return list;
    }

    public Fruit getOneFruit(String id) throws SQLException {
        String[] s = {id};
        ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL("select * from fruit where id = ?", s, DaoUtils.getConn());
        Fruit fruit = new Fruit();
        while (res.next()) {
            String ids = res.getString("id");
            String name = res.getString("name");
            double price = res.getDouble("price");
            String address = res.getString("address");
            String tid = res.getString("tid");
            fruit.setId(ids);
            fruit.setName(name);
            fruit.setPrice(price);
            fruit.setAddress(address);
            fruit.setTypeId(tid);
        }
        return fruit;
    }

    public int addOneFruit(Fruit fruit) throws SQLException {
        PreparedStatement pstmt = null;
        Connection conn = null;
        int num = 0;
        try {
            conn = DaoUtils.getConn();
            pstmt = conn.prepareStatement("insert into fruit values(?,?,?,?,?)");
            pstmt.setString(1, fruit.getId());
            pstmt.setString(2, fruit.getName());
            pstmt.setDouble(3, fruit.getPrice());
            pstmt.setString(4, fruit.getAddress());
            pstmt.setString(5, fruit.getTypeId());
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return num;
    }

    public int delFruit(String id){
        String[] s = {id};
        return DaoUtils.getDaoUtils().executeUpdateSQL("delete from fruit where id = ?", s, DaoUtils.getConn());
    }

    public int upFruit(Fruit fruit) throws SQLException {
        PreparedStatement pstmt = null;
        Connection conn = null;
        int num = 0;
        try {
            conn = DaoUtils.getConn();
            pstmt = conn.prepareStatement("update fruit set name=? , price =? , address =? ,tid =? where id =?");
            pstmt.setString(1, fruit.getName());
            pstmt.setDouble(2, fruit.getPrice());
            pstmt.setString(3, fruit.getAddress());
            pstmt.setString(4, fruit.getTypeId());
            pstmt.setString(5, fruit.getId());
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return num;
    }
}
