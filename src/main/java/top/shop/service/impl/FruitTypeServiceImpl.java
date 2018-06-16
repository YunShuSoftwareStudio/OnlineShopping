package top.shop.service.impl;

import top.shop.dao.FruitTypeDao;
import top.shop.entity.FruitType;
import top.shop.service.FruitTypeService;

import java.sql.SQLException;
import java.util.List;

public class FruitTypeServiceImpl implements FruitTypeService {
    private static final FruitTypeService FRUIT_TYPE_SERVICE = new FruitTypeServiceImpl();

    private FruitTypeServiceImpl() {

    }

    public static FruitTypeService getFruitTypeService() {
        return FRUIT_TYPE_SERVICE;
    }

    @Override
    public List<FruitType> showAllFruitType() throws SQLException {
        return FruitTypeDao.getFruitTypeDao().getAllFruitList();
    }

    @Override
    public boolean addFruitType(FruitType fruitType) {
        int i = FruitTypeDao.getFruitTypeDao().addOneType(fruitType);
        return i != 0;
    }

    @Override
    public boolean delFruitType(String id) throws SQLException {
        FruitServiceImpl.getFrultService().showAllFruit(id).forEach(fruit -> FruitServiceImpl.getFrultService().delFruit(fruit.getId()));
        int i = FruitTypeDao.getFruitTypeDao().delOneType(id);
        return i != 0;
    }

    @Override
    public boolean upFruitType(String id, String name) {
        FruitType fruitType = new FruitType();
        fruitType.setId(id);
        fruitType.setName(name);
        int i = FruitTypeDao.getFruitTypeDao().upOneType(fruitType);
        return i != 0;
    }

}
