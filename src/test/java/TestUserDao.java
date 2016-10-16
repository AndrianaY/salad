

import dao.DaoFactory;
import dao.GenericDao;
import domain.User;
import mysql.MySqlDaoFactory;
import org.junit.Assert;
import org.junit.Test;


import java.sql.Connection;
import java.util.List;

/**
 * Created by Andriana on 12.10.2016.
 */

public class TestUserDao{
@Test
public void testGetAll() throws Exception {
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<User> list;
        try (Connection con = (Connection) daoFactory.getContext()) {
                GenericDao dao = daoFactory.getDao(con, User.class);
                list = dao.getAll();
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        }
}