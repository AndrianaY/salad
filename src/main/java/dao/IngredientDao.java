package dao;

/**
 * Created by Andriana on 12.10.2016.
 */
import domain.Salad;

import java.util.List;

/** Объект для управления персистентным состоянием объекта Student */
public interface IngredientDao {

    /** Создает новую запись и соответствующий ей объект */
    public Salad create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Salad read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Salad salad);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Salad salad);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Salad> getAll();
}

