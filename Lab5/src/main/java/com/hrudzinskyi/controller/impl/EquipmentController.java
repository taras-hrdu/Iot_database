package com.hrudzinskyi.controller.impl;

import com.hrudzinskyi.controller.Controller;
import com.hrudzinskyi.model.Equipment;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.EquipmentService;

import java.sql.SQLException;
import java.util.List;

public class EquipmentController implements Controller<Equipment> {

    private final Service service = new EquipmentService();

    @Override
    public List<Equipment> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Equipment findById(Integer id) throws SQLException {
        return (Equipment) service.findById(id);
    }

    @Override
    public void create(Equipment equipment) throws SQLException {
        service.create(equipment);
    }

    @Override
    public void update(Equipment equipment) throws SQLException {
        service.update(equipment);
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