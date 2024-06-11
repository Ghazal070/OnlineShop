package repository;

import entity.BaseEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BaseEntityRepository<T extends BaseEntity<ID>, ID> {
    T save(T entity,Class<ID> idType);
    T findByID(ID id);
    List<T> findAll();
    boolean deleteByID(ID id);
    boolean existByID(ID id);

}
