package mysql;

/**
 * Created by Andriana on 12.10.2016.
 */
import dao.DaoFactory;
import dao.UserDao;
import dao.SaladDao;
import dao.IngredientDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {

    private String user = "root";//Логин пользователя
    private String password = "123";//Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/daotalk";//URL адрес
    private String driver = "com.mysql.jdbc.Driver";//Имя драйвера

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public UserDao getUserDao(Connection connection) {
        return new MySqlUserDao(connection);
    }

    @Override
    public SaladDao getSaladDao(Connection connection) {
        return null;
    }

    @Override
    public IngredientDao getIngredientDao(Connection connection) {
        return null;
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

