package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.DAO.impl.EquipmentDAO;
import com.hrudzinskyi.model.Equipment;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class EquipmentService implements Service<Equipment> {

    private final DAO<Equipment> dao = new EquipmentDAO();

    @Override
    public List<Equipment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Equipment findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Equipment equipment) throws SQLException {
        dao.create(equipment);
    }

    @Override
    public void update(Integer id, Equipment equipment) throws SQLException {
        dao.update(id, equipment);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}