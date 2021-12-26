package com.hrudzinskyi.Controller.impl;


import com.hrudzinskyi.Controller.Controller;
import com.hrudzinskyi.model.Repair;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.RepairService;

import java.sql.SQLException;
import java.util.List;

public class RepairController implements Controller<Repair> {
    private final Service<Repair> service = new RepairService();

    @Override
    public List<Repair> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Repair findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Repair repair) throws SQLException {
        service.create(repair);
    }

    @Override
    public void update(Integer id, Repair repair) throws SQLException {
        service.update(id, repair);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}