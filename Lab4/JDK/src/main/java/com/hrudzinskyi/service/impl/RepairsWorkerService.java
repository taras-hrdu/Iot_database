package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.DAO.impl.RepairsWorkerDAO;
import com.hrudzinskyi.model.RepairsWorker;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class RepairsWorkerService implements Service<RepairsWorker> {

    private final DAO<RepairsWorker> dao = new RepairsWorkerDAO();

    @Override
    public List<RepairsWorker> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public RepairsWorker findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(RepairsWorker repairsWorker) throws SQLException {
        dao.create(repairsWorker);
    }

    @Override
    public void update(Integer id, RepairsWorker repairsWorker) throws SQLException {
        dao.update(id, repairsWorker);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}