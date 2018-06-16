package top.shop.service;

import top.shop.entity.FruitType;

import java.sql.SQLException;
import java.util.List;

public interface FruitTypeService {
    List<FruitType> showAllFruitType() throws SQLException;

    boolean addFruitType(FruitType fruitType);

    boolean delFruitType(String id) throws SQLException;

    boolean upFruitType(String id,String name);
}
