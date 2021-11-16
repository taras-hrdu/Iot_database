package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.HibernateUtil;
import com.hrudzinskyi.model.Repair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairDAO implements AbsDAO<Repair> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Repair> findAll() throws SQLException {
        List<Repair> repairs = new ArrayList<Repair>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            repairs = session.createQuery("from Repair ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repairs;
    }

    @Override
    public Repair findById(Integer id) throws SQLException {
        Repair repair = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            repair = session.get(Repair.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repair;
    }

    @Override
    public void create(Repair repair) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(repair);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Repair repair) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(repair);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Repair repair = session.get(Repair.class, id);
            if (repair != null) {
                session.delete(repair);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}