package com.hrudzinskyi.service.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.DAO.impl.TypeOfEquipmentDAO;
import com.hrudzinskyi.model.TypeOfEquipment;
import com.hrudzinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class TypeOfEquipmentService implements Service<TypeOfEquipment> {

    private final AbsDAO<TypeOfEquipment> dao = new TypeOfEquipmentDAO();

    @Override
    public List<TypeOfEquipment> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public TypeOfEquipment findById(Integer id) throws SQLException {
        return (TypeOfEquipment) dao.findById(id);
    }

    @Override
    public void create(TypeOfEquipment typeOfEquipment) throws SQLException {
        dao.create(typeOfEquipment);
    }

    @Override
    public void update(TypeOfEquipment typeOfEquipment) throws SQLException {
        dao.update(typeOfEquipment);
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