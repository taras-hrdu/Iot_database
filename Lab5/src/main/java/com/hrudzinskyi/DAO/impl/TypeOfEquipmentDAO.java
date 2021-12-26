package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.HibernateUtil;
import com.hrudzinskyi.model.TypeOfEquipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfEquipmentDAO implements AbsDAO<TypeOfEquipment> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<TypeOfEquipment> findAll() throws SQLException {
        List<TypeOfEquipment> typeOfEquipments = new ArrayList<TypeOfEquipment>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            typeOfEquipments = session.createQuery("from TypeOfEquipment ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return typeOfEquipments;
    }

    @Override
    public TypeOfEquipment findById(Integer id) throws SQLException {
        TypeOfEquipment typeOfEquipment = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            typeOfEquipment = session.get(TypeOfEquipment.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return typeOfEquipment;
    }

    @Override
    public void create(TypeOfEquipment typeOfEquipment) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(typeOfEquipment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TypeOfEquipment typeOfEquipment) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(typeOfEquipment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            TypeOfEquipment typeOfEquipment = session.get(TypeOfEquipment.class, id);
            if (typeOfEquipment != null) {
                session.delete(typeOfEquipment);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}