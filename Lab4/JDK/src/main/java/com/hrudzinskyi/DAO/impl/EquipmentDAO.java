package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.Equipment;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO implements DAO<Equipment> {
    private static final String GET_ALL = "SELECT * FROM lab1db.equipment";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.equipment WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab1db.equipment " +
            "(inventory_numbers, color, body_material, condition_of_equipment) VALUES (?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab1db.equipment " +
            "SET `inventory_numbers` = ?, `color` = ?, `body_material` = ?, `condition_of_equipment` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.equipment WHERE (`id` = ?);";

    @Override
    public List<Equipment> findAll() throws SQLException {
        List<Equipment> equipments = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Equipment equipment = new Equipment(
                        resultSet.getInt("id"),
                        resultSet.getInt("inventory_numbers"),
                        resultSet.getString("color"),
                        resultSet.getString("body_material"),
                        resultSet.getString("condition_of_equipment"));
                equipments.add(equipment);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return equipments;
    }

    @Override
    public Equipment findById(Integer id) throws SQLException {
        Equipment equipment = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                equipment = new Equipment(
                        resultSet.getInt("id"),
                        resultSet.getInt("inventory_numbers"),
                        resultSet.getString("color"),
                        resultSet.getString("body_material"),
                        resultSet.getString("condition_of_equipment"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return equipment;
    }

    @Override
    public void create(Equipment equipment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, equipment.getInventory_numbers());
            statement.setString(2, equipment.getColor());
            statement.setString(3, equipment.getBody_material());
            statement.setString(4, equipment.getCondition_of_equipment());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Equipment equipment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, equipment.getInventory_numbers());
            statement.setString(2, equipment.getColor());
            statement.setString(3, equipment.getBody_material());
            statement.setString(4, equipment.getCondition_of_equipment());
            statement.setInt(5, equipment.getId());
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