package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.DAO.impl.RepairDAO;
import com.hrudzinskyi.model.Repair;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class RepairService implements Service<Repair> {

    private final AbsDAO<Repair> dao = new RepairDAO();

    @Override
    public List<Repair> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Repair findById(Integer id) throws SQLException {
        return (Repair) dao.findById(id);
    }

    @Override
    public void create(Repair repair) throws SQLException {
        dao.create(repair);
    }

    @Override
    public void update(Repair repair) throws SQLException {
        dao.update(repair);
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