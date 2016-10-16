package dao;

import java.sql.SQLException;

/**
 * Created by Andriana on 14.10.2016.
 */
public class PersistException extends SQLException{
    public PersistException(String s) {
        super(s);
    }

    public PersistException(String s, Exception e) {
        super(s, e);
    }
    public PersistException(Exception e) {
        super(e);
    }
}
