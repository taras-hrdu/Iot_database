package com.hrudzinskyi.DAO.impl;

import com.hrudzinskyi.DAO.AbsDAO;
import com.hrudzinskyi.HibernateUtil;
import com.hrudzinskyi.model.LaserCutter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaserCutterDAO implements AbsDAO<LaserCutter> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<LaserCutter> findAll() throws SQLException {
        List<LaserCutter> laserCutters = new ArrayList<LaserCutter>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            laserCutters = session.createQuery("from LaserCutter ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return laserCutters;
    }

    @Override
    public LaserCutter findById(Integer id) throws SQLException {
        LaserCutter laserCutter = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            laserCutter = session.get(LaserCutter.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return laserCutter;
    }

    @Override
    public void create(LaserCutter laserCutter) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(laserCutter);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LaserCutter laserCutter) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(laserCutter);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            LaserCutter laserCutter = session.get(LaserCutter.class, id);
            if (laserCutter != null) {
                session.delete(laserCutter);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}