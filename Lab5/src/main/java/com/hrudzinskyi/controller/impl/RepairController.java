package com.hrudzinskyi.controller.impl;

import com.hrudzinskyi.controller.Controller;
import com.hrudzinskyi.model.Repair;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.RepairService;

import java.sql.SQLException;
import java.util.List;

public class RepairController implements Controller<Repair> {

    private final Service service = new RepairService();

    @Override
    public List<Repair> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Repair findById(Integer id) throws SQLException {
        return (Repair) service.findById(id);
    }

    @Override
    public void create(Repair repair) throws SQLException {
        service.create(repair);
    }

    @Override
    public void update(Repair repair) throws SQLException {
        service.update(repair);
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