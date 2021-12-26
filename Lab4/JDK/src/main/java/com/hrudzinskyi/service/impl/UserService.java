package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.DAO.impl.UserDAO;
import com.hrudzinskyi.model.User;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class UserService implements Service<User> {

    private final DAO<User> dao = new UserDAO();

    @Override
    public List<User> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(User user) throws SQLException {
        dao.create(user);
    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        dao.update(id, user);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}