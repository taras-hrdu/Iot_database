package com.hrudzinskyi.controller.impl;

import com.hrudzinskyi.controller.Controller;
import com.hrudzinskyi.model.TypeOfEquipment;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.TypeOfEquipmentService;

import java.sql.SQLException;
import java.util.List;

public class TypeOfEquipmentController implements Controller<TypeOfEquipment> {

    private final Service service = new TypeOfEquipmentService();

    @Override
    public List<TypeOfEquipment> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public TypeOfEquipment findById(Integer id) throws SQLException {
        return (TypeOfEquipment) service.findById(id);
    }

    @Override
    public void create(TypeOfEquipment typeOfEquipment) throws SQLException {
        service.create(typeOfEquipment);
    }

    @Override
    public void update(TypeOfEquipment typeOfEquipment) throws SQLException {
        service.update(typeOfEquipment);
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