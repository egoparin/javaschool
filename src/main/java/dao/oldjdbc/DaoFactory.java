package dao.oldjdbc;

/**
 * @author egor.oparin@x5.ru
 */
public interface DaoFactory<T> {
    Dao<T> getDao(String type);

}
