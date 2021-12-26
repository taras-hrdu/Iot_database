package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.TypeOfEquipment;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfEquipmentDAO implements DAO<TypeOfEquipment> {
    private static final String GET_ALL = "SELECT * FROM lab1db.type_of_equipment";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.type_of_equipment WHERE id=?";
    private static final String CREATE = "INSERT INTO lab1db.type_of_equipment (type) VALUES (?);";
    private static final String UPDATE = "UPDATE lab1db.type_of_equipment SET `type` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.type_of_equipment WHERE (`id` = ?);";

    @Override
    public List<TypeOfEquipment> findAll() throws SQLException {
        List<TypeOfEquipment> typeOfEquipments = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TypeOfEquipment typeOfEquipment = new TypeOfEquipment(
                        resultSet.getInt("id"),
                        resultSet.getString("type"));
                typeOfEquipments.add(typeOfEquipment);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return typeOfEquipments;
    }

    @Override
    public TypeOfEquipment findById(Integer id) throws SQLException {
        TypeOfEquipment typeOfEquipment = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                typeOfEquipment = new TypeOfEquipment(
                        resultSet.getInt("id"),
                        resultSet.getString("type"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return typeOfEquipment;
    }

    @Override
    public void create(TypeOfEquipment typeOfEquipment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, typeOfEquipment.getType());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, TypeOfEquipment typeOfEquipment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, typeOfEquipment.getType());
            statement.setInt(2, typeOfEquipment.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}