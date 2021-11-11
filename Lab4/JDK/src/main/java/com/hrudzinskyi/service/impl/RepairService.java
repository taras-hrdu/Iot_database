package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.DAO.impl.RepairDAO;
import com.hrudzinskyi.model.Repair;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class RepairService implements Service<Repair> {

    private final DAO<Repair> dao = new RepairDAO();

    @Override
    public List<Repair> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Repair findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Repair repair) throws SQLException {
        dao.create(repair);
    }

    @Override
    public void update(Integer id, Repair repair) throws SQLException {
        dao.update(id, repair);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}