package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.HibernateUtil;
import com.hrudzinskyi.model.RepairsWorker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairsWorkerDAO implements AbsDAO<RepairsWorker> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<RepairsWorker> findAll() throws SQLException {
        List<RepairsWorker> repairsWorkers = new ArrayList<RepairsWorker>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            repairsWorkers = session.createQuery("from RepairsWorker ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repairsWorkers;
    }

    @Override
    public RepairsWorker findById(Integer id) throws SQLException {
        RepairsWorker repairsWorker = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            repairsWorker = session.get(RepairsWorker.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repairsWorker;
    }

    @Override
    public void create(RepairsWorker repairsWorker) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(repairsWorker);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(RepairsWorker repairsWorker) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(repairsWorker);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            RepairsWorker repairsWorker = session.get(RepairsWorker.class, id);
            if (repairsWorker != null) {
                session.delete(repairsWorker);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}