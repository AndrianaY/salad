import dao.DaoFactory;
import dao.PersistException;
import domain.Salad;
import domain.User;
import mysql.MySqlDaoFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Created by Andriana on 16.10.2016.
 */
public class GenericTest {
    private static final DaoFactory<Connection> factory = new MySqlDaoFactory();
    private Connection connection;

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
    }
    @After
    public void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }

    @Test
    public void testCreate() throws PersistException {
        Salad salad = (Salad) factory.getDao(connection, Salad.class).create();
        salad.setName("some salad");
        Assert.assertNull("User is not null.", salad.getUser());

        User user = new User();
        salad.setUser(user);
        Assert.assertNotNull("User is null.", salad.getUser());
    }

    @Test
    public void testPersist() throws PersistException {
        Salad salad = new Salad();
        User user = (User) factory.getDao(connection, User.class).create();
        salad.setUser(user);
        user.setFirstName("andriana");
        salad = (Salad) factory.getDao(connection, Salad.class).persist(salad);
        Assert.assertNotNull("User is null.", salad.getUser());
        Assert.assertEquals("Wrong user firstname.", "andriana", salad.getUser().getFirstName());
    }

    @Test
    public void testPersistAll() throws PersistException {
        Salad salad = new Salad();
        salad.setUser(new User());
        salad = (Salad) factory.getDao(connection, Salad.class).persist(salad);
        Assert.assertNotNull("Group is null.", salad.getUser());
        Assert.assertNotNull("Group.id is null.", salad.getUser().getId());
    }

    @Test
    public void testUpdate() throws PersistException {
        Salad salad = (Salad) factory.getDao(connection, Salad.class).create();
        salad.setUser(new User());
        factory.getDao(connection, Salad.class).update(salad);
        Assert.assertNotNull("USer is null.", salad.getUser());
        Assert.assertNotNull("User.id is null.", salad.getUser().getId());
    }

    @Test
    public void testUpdateAll() throws PersistException {
        Salad salad = (Salad) factory.getDao(connection, Salad.class).create();
        User user = (User) factory.getDao(connection, User.class).create();
        user.setFirstName("andriana");
        salad.setUser(user);
        factory.getDao(connection, Salad.class).update(salad);
        Assert.assertNotNull("User is null.", salad.getUser());
        Assert.assertEquals("Wrong user firstname.", "andriana", salad.getUser().getFirstName());
    }

    @Test
    public void testRead() throws PersistException {
        Salad salad = (Salad) factory.getDao(connection, Salad.class).create();
        salad.setUser(new User());
        factory.getDao(connection, Salad.class).update(salad);

        salad = (Salad) factory.getDao(connection, Salad.class).getByPK(salad.getId());
        Assert.assertNotNull("Salad is null.", salad);
        Assert.assertNotNull("User is null.", salad.getUser());
    }

    @Test
    public void testDelete() throws PersistException {
        Salad salad = (Salad) factory.getDao(connection, Salad.class).create();
        salad.setUser(new User());
        factory.getDao(connection, Salad.class).update(salad);

        User user = salad.getUser();

        factory.getDao(connection, Salad.class).delete(salad);
        user = (User) factory.getDao(connection, User.class).getByPK(user.getId());
        Assert.assertNotNull("User not found.", user);
    }
}
