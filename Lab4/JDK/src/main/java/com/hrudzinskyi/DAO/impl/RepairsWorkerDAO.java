package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.RepairsWorker;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairsWorkerDAO implements DAO<RepairsWorker> {
    private static final String GET_ALL = "SELECT * FROM lab1db.repairs_worker";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.repairs_worker WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab1db.repairs_worker " +
            "(name, surname) VALUES (?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab1db.repairs_worker " +
            "SET `name` = ?, `surname` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.repairs_worker WHERE (`id` = ?);";

    @Override
    public List<RepairsWorker> findAll() throws SQLException {
        List<RepairsWorker> repairsWorkers = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RepairsWorker repairsWorker = new RepairsWorker(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"));
                repairsWorkers.add(repairsWorker);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return repairsWorkers;
    }

    @Override
    public RepairsWorker findById(Integer id) throws SQLException {
        RepairsWorker repairsWorker = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                repairsWorker = new RepairsWorker(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return repairsWorker;
    }

    @Override
    public void create(RepairsWorker repairsWorker) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, repairsWorker.getName());
            statement.setString(2, repairsWorker.getSurname());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, RepairsWorker repairsWorker) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, repairsWorker.getName());
            statement.setString(2, repairsWorker.getSurname());
            statement.setInt(3, repairsWorker.getId());
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