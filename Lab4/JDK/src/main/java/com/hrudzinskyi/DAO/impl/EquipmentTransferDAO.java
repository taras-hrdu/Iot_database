package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.EquipmentTransfer;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentTransferDAO implements DAO<EquipmentTransfer> {
    private static final String GET_ALL = "SELECT * FROM lab1db.equipment_transfer";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.equipment_transfer WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab1db.equipment_transfer " +
            "(time, start_data, end_data) VALUES (?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab1db.equipment_transfer " +
            "SET `time` = ?, `start_data` = ?, `end_data` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.equipment_transfer WHERE (`id` = ?);";

    @Override
    public List<EquipmentTransfer> findAll() throws SQLException {
        List<EquipmentTransfer> equipmentTransfers = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EquipmentTransfer equipmentTransfer = new EquipmentTransfer(
                        resultSet.getInt("id"),
                        resultSet.getString("time"),
                        resultSet.getString("start_data"),
                        resultSet.getString("end_data"));
                equipmentTransfers.add(equipmentTransfer);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return equipmentTransfers;
    }

    @Override
    public EquipmentTransfer findById(Integer id) throws SQLException {
        EquipmentTransfer equipmentTransfer = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                equipmentTransfer = new EquipmentTransfer(
                        resultSet.getInt("id"),
                        resultSet.getString("time"),
                        resultSet.getString("start_data"),
                        resultSet.getString("end_data"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return equipmentTransfer;
    }

    @Override
    public void create(EquipmentTransfer equipmentTransfer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, equipmentTransfer.getTime());
            statement.setString(2, equipmentTransfer.getStart_data());
            statement.setString(3, equipmentTransfer.getEnd_data());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, EquipmentTransfer equipmentTransfer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, equipmentTransfer.getTime());
            statement.setString(2, equipmentTransfer.getStart_data());
            statement.setString(3, equipmentTransfer.getEnd_data());
            statement.setInt(4, equipmentTransfer.getId());
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