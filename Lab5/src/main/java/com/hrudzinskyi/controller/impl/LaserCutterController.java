package com.hrudzinskyi.controller.impl;

import com.hrudzinskyi.controller.Controller;
import com.hrudzinskyi.model.LaserCutter;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.LaserCutterService;

import java.sql.SQLException;
import java.util.List;

public class LaserCutterController implements Controller<LaserCutter> {

    private final Service service = new LaserCutterService();

    @Override
    public List<LaserCutter> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public LaserCutter findById(Integer id) throws SQLException {
        return (LaserCutter) service.findById(id);
    }

    @Override
    public void create(LaserCutter laserCutter) throws SQLException {
        service.create(laserCutter);
    }

    @Override
    public void update(LaserCutter laserCutter) throws SQLException {
        service.update(laserCutter);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        Controller.super.delete(firstId, secondId);
    }
}