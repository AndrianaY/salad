package mysql;

/**
 * Created by Andriana on 12.10.2016.
 */
import dao.UserDao;
import domain.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDao {
    private final Connection connection;

    @Override
    public User create() {
        return null;
    }

    @Override
    public User read(int key) throws SQLException {
        String sql = "SELECT * FROM daotalk.user WHERE id = ?;";// todo: setup DB server
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, key);

        ResultSet rs = stm.executeQuery();
        rs.next();
        User g = new User();
        g.setId(rs.getInt("id"));
        g.setFirstName(rs.getString("first_name"));
        g.setLastName(rs.getString("last_name"));
        return g;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM daotalk.user;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<User> list = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            list.add(user);
        }
        return list;
    }

    public MySqlUserDao(Connection connection) {
        this.connection = connection;
    }
}