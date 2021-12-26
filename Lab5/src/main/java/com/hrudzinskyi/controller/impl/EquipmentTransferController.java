package com.hrudzinskyi.controller.impl;

import com.hrudzinskyi.controller.Controller;
import com.hrudzinskyi.model.EquipmentTransfer;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.EquipmentTransferService;

import java.sql.SQLException;
import java.util.List;

public class EquipmentTransferController implements Controller<EquipmentTransfer> {

    private final Service service = new EquipmentTransferService();

    @Override
    public List<EquipmentTransfer> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public EquipmentTransfer findById(Integer id) throws SQLException {
        return (EquipmentTransfer) service.findById(id);
    }

    @Override
    public void create(EquipmentTransfer equipmentTransfer) throws SQLException {
        service.create(equipmentTransfer);
    }

    @Override
    public void update(EquipmentTransfer equipmentTransfer) throws SQLException {
        service.update(equipmentTransfer);
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