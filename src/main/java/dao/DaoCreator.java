package dao;

import java.sql.Connection;

/**
 * Created by Andriana on 15.10.2016.
 */
public interface DaoCreator<Context> {
    public GenericDao create(Context context);
}


