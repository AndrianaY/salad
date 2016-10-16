package mysql;

/**
 * Created by Andriana on 14.10.2016.
 */
import dao.DaoFactory;
import domain.Salad;
import dao.AbstractJDBCDao;
import dao.PersistException;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySQLSaladDao extends AbstractJDBCDao<Salad, Integer>{
    private class PersistSalad extends Salad {
        public void setId(int id) {
            super.setId(id);
        }
    }
    public MySQLSaladDao(DaoFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
        addRelation(Salad.class, "user");
    }
    @Override
    public String getSelectQuery() {
        return "SELECT id, name, user_id FROM daotalk.salad ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO daotalk.salad (name, user_id) \n" +
                "VALUES (?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE daotalk.salad \n" +
                "SET name = ?, user_id = ? \n" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM daotalk.salad WHERE id= ?;";
    }

    @Override
    public Salad create() throws PersistException {
        Salad s = new Salad();
        return persist(s);
    }


    @Override
    protected List<Salad> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Salad> result = new LinkedList<Salad>();
        try {
            while (rs.next()) {

                PersistSalad salad = new PersistSalad();
                salad.setId(rs.getInt("id"));
                salad.setName(rs.getString("name"));

                salad.setUser((User) getDependence(User.class, rs.getInt("user_id")));

//                salad.setUserId(rs.getInt("user_id"));
                result.add(salad);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override //todo: find out signature of  insert
    protected void prepareStatementForInsert(PreparedStatement statement, Salad object) throws PersistException {
        try {
            int userId = (object.getUser() == null || object.getUser().getId() == null) ? -1
                    : object.getUser().getId();
            statement.setString(1, object.getName());
            statement.setInt(2, userId);
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Salad object) throws PersistException {
        try {
            int userId = (object.getUser() == null || object.getUser().getId() == null) ? -1
                    : object.getUser().getId();
            statement.setString(1, object.getName());
            statement.setInt(2, userId);
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
