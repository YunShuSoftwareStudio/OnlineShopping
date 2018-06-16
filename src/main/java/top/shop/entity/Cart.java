package top.shop.entity;

import top.shop.dao.FruitDao;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * 购物车
 */
public class Cart implements Serializable {
    /**
     * 水果ID
     */
    private String id;
    /**
     * 数量
     */
    private int num;
    /**
     * 水果
     */
    private Fruit fruit;
    /**
     * 所属用户
     */
    private String uid;

    public void initFruit() {
        try {
            this.fruit = FruitDao.getFruitDao().getOneFruit(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", num=" + num +
                ", fruit=" + fruit +
                ", uid='" + uid + '\'' +
                '}';
    }
}
