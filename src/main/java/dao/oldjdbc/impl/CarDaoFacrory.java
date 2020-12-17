package dao.oldjdbc.impl;

import dao.oldjdbc.Dao;
import dao.oldjdbc.DaoFactory;
import domain.oldjdbc.Car;

/**
 * @author egor.oparin@x5.ru
 */
public class CarDaoFacrory implements DaoFactory<Car> {

    @Override
    public Dao<Car> getDao(String type) {
        Dao<Car> dao = null;
        switch (type){
            case "db": dao = new DbCarDao();
            break;
            case "json": dao = new JsonCarDao();
            break;
            default: throw new UnsupportedOperationException("Don't find dao");
        }
        return dao;
    }
}
