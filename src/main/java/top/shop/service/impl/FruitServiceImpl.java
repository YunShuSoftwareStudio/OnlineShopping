package top.shop.service.impl;

import top.shop.dao.FruitDao;
import top.shop.entity.Fruit;
import top.shop.service.FruitService;

import java.sql.SQLException;
import java.util.List;

/**
 * 水果服务实现
 *
 * @author
 */
public class FruitServiceImpl implements FruitService {
    private static final FruitService FRULT_SERVICE = new FruitServiceImpl();

    private FruitServiceImpl() {

    }

    public static FruitService getFrultService() {
        return FRULT_SERVICE;
    }

    @Override
    public List<Fruit> showAllFruit(String typeId) throws SQLException {
        return FruitDao.getFruitDao().getAllFruitList(typeId);
    }

    @Override
    public Fruit getOneFruit(String id) throws SQLException {
        return FruitDao.getFruitDao().getOneFruit(id);
    }

    @Override
    public boolean addFruit(Fruit fruit) throws SQLException {
        int i = FruitDao.getFruitDao().addOneFruit(fruit);
        return i != 0;
    }

    @Override
    public boolean delFruit(String id) {
        int i = FruitDao.getFruitDao().delFruit(id);
        return i != 0;
    }

    @Override
    public boolean upFruit(Fruit fruit) throws SQLException {
        int i = FruitDao.getFruitDao().upFruit(fruit);
        return i != 0;
    }
}
