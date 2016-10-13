package dao;

/**
 * Created by Andriana on 12.10.2016.
 */

import java.sql.Connection;
import java.sql.SQLException;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {

    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws SQLException;

    /** Возвращает объект для управления персистентным состоянием объекта Group */
    public UserDao getUserDao(Connection connection);

    /** Возвращает объект для управления персистентным состоянием объекта Student */
    public SaladDao getSaladDao(Connection connection);

    public IngredientDao getIngredientDao(Connection connection);
}
