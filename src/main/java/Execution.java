import dao.DaoFactory;
import dao.GenericDao;
import dao.PersistException;
import domain.User;
import mysql.MySqlDaoFactory;
import java.sql.Connection;
/**
 * Created by Andriana on 14.10.2016.
 */
public class Execution {
    public static void main(String[] args) {
        DaoFactory factory = new MySqlDaoFactory();
        Connection connection = null;
        try {
            connection = (Connection) factory.getContext();
        } catch (PersistException e) {
            e.printStackTrace();
        }
        try {
            GenericDao dao = factory.getDao(connection, User.class);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

}
