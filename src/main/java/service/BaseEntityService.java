package service;

import entity.BaseEntity;

import java.util.List;

public interface BaseEntityService<T extends BaseEntity<ID>,ID> {
    T save(T entity,Class<ID> idType);
    T findByID(ID id);
    List<T> findAll();
    boolean deleteByID(ID id);
    boolean existByID(ID id);
}
