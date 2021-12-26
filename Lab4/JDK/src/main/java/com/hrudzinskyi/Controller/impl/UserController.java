package com.hrudzinskyi.Controller.impl;


import com.hrudzinskyi.Controller.Controller;
import com.hrudzinskyi.model.User;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController implements Controller<User> {
    private final Service<User> service = new UserService();

    @Override
    public List<User> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(User user) throws SQLException {
        service.create(user);
    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        service.update(id, user);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}