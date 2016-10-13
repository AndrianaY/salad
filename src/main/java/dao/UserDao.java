package dao;
import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andriana on 12.10.2016.
 */
public interface UserDao {

    /** Создает новую запись и соответствующий ей объект */
    public User create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public User read(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    public void update(User user);

    /** Удаляет запись об объекте из базы данных */
    public void delete(User user);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<User> getAll() throws SQLException;
}
