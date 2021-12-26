package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.DAO.impl.LaserCutterDAO;
import com.hrudzinskyi.model.LaserCutter;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class LaserCutterService implements Service<LaserCutter> {

    private final AbsDAO<LaserCutter> dao = new LaserCutterDAO();

    @Override
    public List<LaserCutter> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public LaserCutter findById(Integer id) throws SQLException {
        return (LaserCutter) dao.findById(id);
    }

    @Override
    public void create(LaserCutter laserCutter) throws SQLException {
        dao.create(laserCutter);
    }

    @Override
    public void update(LaserCutter laserCutter) throws SQLException {
        dao.update(laserCutter);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        Service.super.delete(firstId, secondId);
    }
}