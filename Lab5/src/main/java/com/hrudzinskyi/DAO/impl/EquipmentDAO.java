package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.HibernateUtil;
import com.hrudzinskyi.model.Equipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO implements AbsDAO<Equipment> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Equipment> findAll() throws SQLException {
        List<Equipment> equipments = new ArrayList<Equipment>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            equipments = session.createQuery("from Equipment ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipments;
    }

    @Override
    public Equipment findById(Integer id) throws SQLException {
        Equipment equipment = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            equipment = session.get(Equipment.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipment;
    }

    @Override
    public void create(Equipment equipment) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(equipment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Equipment equipment) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(equipment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Equipment equipment = session.get(Equipment.class, id);
            if (equipment != null) {
                session.delete(equipment);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}