package com.hrudzinskyi.Controller.impl;


import com.hrudzinskyi.Controller.Controller;
import com.hrudzinskyi.model.Equipment;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.EquipmentService;

import java.sql.SQLException;
import java.util.List;

public class EquipmentController implements Controller<Equipment> {
    private final Service<Equipment> service = new EquipmentService();

    @Override
    public List<Equipment> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Equipment findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Equipment equipment) throws SQLException {
        service.create(equipment);
    }

    @Override
    public void update(Integer id, Equipment equipment) throws SQLException {
        service.update(id, equipment);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}