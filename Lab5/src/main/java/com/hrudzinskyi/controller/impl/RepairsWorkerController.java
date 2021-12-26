package com.hrudzinskyi.controller.impl;

import com.hrudzinskyi.controller.Controller;
import com.hrudzinskyi.model.RepairsWorker;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.RepairsWorkerService;

import java.sql.SQLException;
import java.util.List;

public class RepairsWorkerController implements Controller<RepairsWorker> {

    private final Service service = new RepairsWorkerService();

    @Override
    public List<RepairsWorker> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public RepairsWorker findById(Integer id) throws SQLException {
        return (RepairsWorker) service.findById(id);
    }

    @Override
    public void create(RepairsWorker repairsWorker) throws SQLException {
        service.create(repairsWorker);
    }

    @Override
    public void update(RepairsWorker repairsWorker) throws SQLException {
        service.update(repairsWorker);
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