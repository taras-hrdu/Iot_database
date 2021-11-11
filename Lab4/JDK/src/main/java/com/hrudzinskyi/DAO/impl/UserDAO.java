package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.DAO;
import com.hrudzinskyi.model.User;
import com.hrudzinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    private static final String GET_ALL = "SELECT * FROM lab1db.user";
    private static final String GET_BY_ID = "SELECT * FROM lab1db.user WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab1db.user " +
            "(surname, name, student_number, zip) VALUES (?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab1db.user " +
            "SET `surname` = ?, `name` = ?, `student_number` = ?, `zip` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab1db.user WHERE (`id` = ?);";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("student_number"),
                        resultSet.getInt("zip"));
                users.add(user);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("student_number"),
                        resultSet.getInt("zip"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getName());
            statement.setString(3, user.getStudent_number());
            statement.setInt(4, user.getZip());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getName());
            statement.setString(3, user.getStudent_number());
            statement.setInt(4, user.getZip());
            statement.setInt(5, user.getId());
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