package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.LaserCutter;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaserCutterDAO implements DAO<LaserCutter> {
    private static final String GET_ALL = "SELECT * FROM lab1db.laser_cutter";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.laser_cutter WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab1db.laser_cutter " +
            "(time_using, start_data, end_data, equipment_id) VALUES (?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab1db.laser_cutter " +
            "SET `time_using` = ?, `start_data` = ?, `end_data` = ?, `equipment_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.laser_cutter WHERE (`id` = ?);";

    @Override
    public List<LaserCutter> findAll() throws SQLException {
        List<LaserCutter> laserCutters = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LaserCutter laserCutter = new LaserCutter(
                        resultSet.getInt("id"),
                        resultSet.getString("time_using"),
                        resultSet.getString("start_data"),
                        resultSet.getString("end_data"),
                        resultSet.getInt("equipment_id"));
                laserCutters.add(laserCutter);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return laserCutters;
    }

    @Override
    public LaserCutter findById(Integer id) throws SQLException {
        LaserCutter laserCutter = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laserCutter = new LaserCutter(
                        resultSet.getInt("id"),
                        resultSet.getString("time_using"),
                        resultSet.getString("start_data"),
                        resultSet.getString("end_data"),
                        resultSet.getInt("equipment_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return laserCutter;
    }

    @Override
    public void create(LaserCutter laserCutter) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, laserCutter.getTime_using());
            statement.setString(2, laserCutter.getStart_data());
            statement.setString(3, laserCutter.getEnd_data());
            statement.setInt(4, laserCutter.getEquipment_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, LaserCutter laserCutter) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, laserCutter.getTime_using());
            statement.setString(2, laserCutter.getStart_data());
            statement.setString(3, laserCutter.getEnd_data());
            statement.setInt(4, laserCutter.getEquipment_id());
            statement.setInt(5, laserCutter.getId());
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