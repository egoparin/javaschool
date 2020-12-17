package dao.oldjdbc.exceptions;

/**
 * @author egor.oparin@x5.ru
 */
public class DaoException extends Exception {

    public DaoException(String message, Throwable e){
        super(message, e);
    }

}
