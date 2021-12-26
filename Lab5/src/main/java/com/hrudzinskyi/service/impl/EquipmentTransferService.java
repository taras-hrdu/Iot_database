package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.DAO.impl.EquipmentTransferDAO;
import com.hrudzinskyi.model.EquipmentTransfer;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class EquipmentTransferService implements Service<EquipmentTransfer> {

    private final AbsDAO<EquipmentTransfer> dao = new EquipmentTransferDAO();

    @Override
    public List<EquipmentTransfer> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public EquipmentTransfer findById(Integer id) throws SQLException {
        return (EquipmentTransfer) dao.findById(id);
    }

    @Override
    public void create(EquipmentTransfer equipmentTransfer) throws SQLException {
        dao.create(equipmentTransfer);
    }

    @Override
    public void update(EquipmentTransfer equipmentTransfer) throws SQLException {
        dao.update(equipmentTransfer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        Service.super.delete(firstId, secondId);
    }
}