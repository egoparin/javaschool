package dao.oldjdbc;


import dao.oldjdbc.exceptions.DaoException;

/**
 * @author egor.oparin@x5.ru
 */
public interface Dao<T> {
    void insert(T item) throws DaoException;
    void delete(T item);
    T getById(int id);
}
