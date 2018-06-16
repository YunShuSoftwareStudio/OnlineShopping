package top.shop.service;

import top.shop.entity.Fruit;

import java.sql.SQLException;
import java.util.List;

/**
 * 水果服务
 *
 * @author
 */
public interface FruitService {
    List<Fruit> showAllFruit(String typeId) throws SQLException;

    Fruit getOneFruit(String id) throws SQLException;

    boolean addFruit(Fruit fruit) throws SQLException;

    boolean delFruit(String id);

    boolean upFruit(Fruit fruit) throws SQLException;
}
