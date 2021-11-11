package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.Repair;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairDAO implements DAO<Repair> {
    private static final String GET_ALL = "SELECT * FROM lab1db.repair";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.repair WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab1db.repair " +
            "(time, start_data, end_data, repairs_worker_id, equipment_id, repairs_worker_id1) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab1db.repair " +
            "SET `time` = ?, `start_data` = ?, `end_data` = ?, `repairs_worker_id` = ?, `equipment_id` = ?, `repairs_worker_id1` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.repair WHERE (`id` = ?);";

    @Override
    public List<Repair> findAll() throws SQLException {
        List<Repair> repairs = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Repair repair = new Repair(
                        resultSet.getInt("id"),
                        resultSet.getString("time"),
                        resultSet.getString("start_data"),
                        resultSet.getString("end_data"),
                        resultSet.getInt("repairs_worker_id"),
                        resultSet.getInt("equipment_id"),
                        resultSet.getInt("repairs_worker_id1"));
                repairs.add(repair);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return repairs;
    }

    @Override
    public Repair findById(Integer id) throws SQLException {
        Repair repair = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                repair = new Repair(
                        resultSet.getInt("id"),
                        resultSet.getString("time"),
                        resultSet.getString("start_data"),
                        resultSet.getString("end_data"),
                        resultSet.getInt("repairs_worker_id"),
                        resultSet.getInt("equipment_id"),
                        resultSet.getInt("repairs_worker_id1"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return repair;
    }

    @Override
    public void create(Repair repair) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, repair.getTime());
            statement.setString(2, repair.getStart_data());
            statement.setString(3, repair.getEnd_data());
            statement.setInt(4, repair.getRepairs_worker_id());
            statement.setInt(5, repair.getEquipment_id());
            statement.setInt(6, repair.getRepairs_worker_id1());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Repair repair) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, repair.getTime());
            statement.setString(2, repair.getStart_data());
            statement.setString(3, repair.getEnd_data());
            statement.setInt(4, repair.getRepairs_worker_id());
            statement.setInt(5, repair.getEquipment_id());
            statement.setInt(6, repair.getRepairs_worker_id1());
            statement.setInt(7, repair.getId());
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