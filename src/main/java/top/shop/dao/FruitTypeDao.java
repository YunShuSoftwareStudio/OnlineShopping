package top.shop.dao;

import top.shop.entity.FruitType;
import top.shop.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FruitTypeDao {
    private static final FruitTypeDao FRUIT_TYPE_DAO = new FruitTypeDao();

    private FruitTypeDao() {

    }

    public static FruitTypeDao getFruitTypeDao() {
        return FRUIT_TYPE_DAO;
    }

    /**
     * 获取所有水果类别集合
     *
     * @return 水果类别集合
     * @throws SQLException SQLException
     */
    public List<FruitType> getAllFruitList() throws SQLException {
        List<FruitType> list = new ArrayList<>();
        ResultSet res = DaoUtils.getDaoUtils().executeQuerySQL("select * from fruittype", null, DaoUtils.getConn());
        while (res.next()) {
            FruitType fruitType = new FruitType();
            String id = res.getString("id");
            String name = res.getString("name");
            fruitType.setId(id);
            fruitType.setName(name);
            list.add(fruitType);
        }
        return list;
    }

    public int addOneType(FruitType fruitType) {
        String[] s = {fruitType.getId(), fruitType.getName()};
        return DaoUtils.getDaoUtils().executeUpdateSQL("insert into fruittype values(?,?)", s, DaoUtils.getConn());
    }

    public int delOneType(String id) {
        String[] s = {id};
        return DaoUtils.getDaoUtils().executeUpdateSQL("delete from fruittype where id = ?", s, DaoUtils.getConn());
    }

    public int upOneType(FruitType fruitType) {
        String[] s = {fruitType.getName(), fruitType.getId()};
        return DaoUtils.getDaoUtils().executeUpdateSQL("update fruittype set name=? where id = ?", s, DaoUtils.getConn());
    }
}
