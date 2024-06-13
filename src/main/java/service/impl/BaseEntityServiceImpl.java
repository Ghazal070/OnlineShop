package service.impl;

import entity.BaseEntity;
import repository.BaseEntityRepository;
import service.BaseEntityService;

import java.util.List;

public class BaseEntityServiceImpl <T extends BaseEntity<ID>,ID,R extends BaseEntityRepository<T,ID>> implements BaseEntityService<T,ID> {
   protected final R baseEntityRepository;

    public BaseEntityServiceImpl(R baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

//    @Override
//    public T save(T entity, Class<ID> idType) {
//        return baseEntityRepository.save(entity,idType);
//    }

    @Override
    public T findByID(ID id) {
        return baseEntityRepository.findByID(id);
    }

    @Override
    public List<T> findAll() {
        return baseEntityRepository.findAll();
    }

    @Override
    public boolean deleteByID(ID id) {
        return baseEntityRepository.deleteByID(id);
    }

    @Override
    public boolean existByID(ID id) {
        return baseEntityRepository.existByID(id);
    }

}
