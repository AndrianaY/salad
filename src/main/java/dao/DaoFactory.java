package dao;

/**
 * Created by Andriana on 12.10.2016.
 */


/** Фабрика объектов для работы с базой данных */
public interface DaoFactory<Context> {
    public interface DaoCreator<Context> {
        public GenericDao create(Context context);
    }
      /** Возвращает подключение к базе данных */
    public Context getContext() throws PersistException;

    /** Возвращает объект для управления персистентным состоянием объекта */
    public GenericDao getDao(Context context, Class dtoClass) throws PersistException;
}
