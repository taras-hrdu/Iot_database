package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.HibernateUtil;
import com.hrudzinskyi.model.EquipmentTransfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentTransferDAO implements AbsDAO<EquipmentTransfer> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<EquipmentTransfer> findAll() throws SQLException {
        List<EquipmentTransfer> equipmentTransfers = new ArrayList<EquipmentTransfer>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            equipmentTransfers = session.createQuery("from EquipmentTransfer ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipmentTransfers;
    }

    @Override
    public EquipmentTransfer findById(Integer id) throws SQLException {
        EquipmentTransfer equipmentTransfer = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            equipmentTransfer = session.get(EquipmentTransfer.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipmentTransfer;
    }

    @Override
    public void create(EquipmentTransfer equipmentTransfer) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(equipmentTransfer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EquipmentTransfer equipmentTransfer) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(equipmentTransfer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            EquipmentTransfer equipmentTransfer = session.get(EquipmentTransfer.class, id);
            if (equipmentTransfer != null) {
                session.delete(equipmentTransfer);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}