package com.hrudzinskyi.Controller.impl;


import com.hrudzinskyi.Controller.Controller;
import com.hrudzinskyi.model.LaserCutter;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.LaserCutterService;

import java.sql.SQLException;
import java.util.List;

public class LaserCutterController implements Controller<LaserCutter> {
    private final Service<LaserCutter> service = new LaserCutterService();

    @Override
    public List<LaserCutter> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public LaserCutter findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(LaserCutter laserCutter) throws SQLException {
        service.create(laserCutter);
    }

    @Override
    public void update(Integer id, LaserCutter laserCutter) throws SQLException {
        service.update(id, laserCutter);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}