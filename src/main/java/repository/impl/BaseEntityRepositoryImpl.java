package repository.impl;

import entity.BaseEntity;
import repository.BaseEntityRepository;
import util.QueryUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID> implements BaseEntityRepository<T, ID> {
    protected final Connection connection;

    public BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

//    @Override
//    public T save(T entity) {
//        try (PreparedStatement preparedStatement =
//                     connection.prepareStatement(String.format(QueryUtil.INSERT_INTO_QUERY_TEMPLATE, getTableName(),
//                             String.join(",", getColumnNames()), getQuestionMarks(getColumnNames().size()-1),
//                             PreparedStatement.RETURN_GENERATED_KEYS))) {
//            for (int i = 0; i < getColumnNames().size(); i++) {
//                if (entity!=null){
//                Field field = entity.getClass().getDeclaredField(getColumnNames().get(i));
//                field.setAccessible(true);
//                preparedStatement.setObject(i + 1, field.get(entity));
//                }
//            }
//            int rowAffected = preparedStatement.executeUpdate();
//            if (rowAffected > 0) {
//                try (ResultSet resultSet = preparedStatement.executeQuery("SELECT LAST_INSERT_ID()")) {
//                    if (resultSet.next()) {
//                        entity.setId(idType.cast(resultSet.getObject(1)));
//                    }
//                }
//            }
//            return entity;
//        } catch (Throwable e) {
//            throw new RuntimeException("Error In save entity! ");
//        }
//    }

    @Override
    public T findByID(ID id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.FIND_BY_ID_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;
        } catch (Throwable e) {
            throw new RuntimeException("Error In find by id! ");
        }
    }

    @Override
    public List<T> findAll() {
        List<T> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.FIND_BY_ID_QUERY_TEMPLATE, getTableName()))) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet!=null){
                while (resultSet.next()){
                    entityList.add(mapResultSetToBaseEntity(resultSet));
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("Error In find all entity! ");
        }
        return entityList;
    }

    @Override
    public boolean deleteByID(ID id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.DELETE_BY_ID_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setObject(1, id);
            int rowAffect = preparedStatement.executeUpdate();
            return rowAffect > 0;

        } catch (Throwable e) {
            throw new RuntimeException("Error In find by id! ");
        }
    }

    @Override
    public boolean existByID(ID id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.EXISTS_BY_ID_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (Throwable e) {
            throw new RuntimeException("Error In exist by id! ");
        }
    }

    protected abstract String getTableName();

    protected abstract List<String> getColumnNames();

    protected abstract String getQuestionMarks(int length);

    protected abstract T mapResultSetToBaseEntity(ResultSet resultSet);
}

