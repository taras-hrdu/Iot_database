package com.hrudzinskyi.Controller.impl;


import com.hrudzinskyi.Controller.Controller;
import com.hrudzinskyi.model.EquipmentTransfer;
import com.hrudzinskyi.service.Service;
import com.hrudzinskyi.service.impl.EquipmentTransferService;

import java.sql.SQLException;
import java.util.List;

public class EquipmentTransferController implements Controller<EquipmentTransfer> {
    private final Service<EquipmentTransfer> service = new EquipmentTransferService();

    @Override
    public List<EquipmentTransfer> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public EquipmentTransfer findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(EquipmentTransfer equipmentTransfer) throws SQLException {
        service.create(equipmentTransfer);
    }

    @Override
    public void update(Integer id, EquipmentTransfer equipmentTransfer) throws SQLException {
        service.update(id, equipmentTransfer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}