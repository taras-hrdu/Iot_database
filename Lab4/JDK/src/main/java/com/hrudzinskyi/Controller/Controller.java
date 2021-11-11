package com.hrudzinskyi.Controller;

import java.sql.SQLException;
import java.util.List;

public interface Controller<T> {
    List<T> findAll() throws SQLException;

    default T findById(Integer id) throws SQLException {
        return null;
    }

    default void create(T entity) throws SQLException {
    }

    default void update(Integer id, T entity) throws SQLException {
    }

    default void delete(Integer id) throws SQLException {
    }

    default T findByType(String type) throws SQLException {
        return null;
    }

    default void update(String type, T entity) throws SQLException {
    }

    default void delete(String type) throws SQLException {
    }

}