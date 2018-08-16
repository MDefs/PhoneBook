package com.mdefs.dao;

import com.mdefs.entity.Phone;
import com.mdefs.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void registerUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.update(user);
    }


    @Override
    @Transactional
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = null;

        try {
            Query query = session.createQuery("from User where username =: username");
            query.setParameter("username", username);
            user = (User) query.getSingleResult();
        } catch (NoResultException e){

        }

        return user;
    }


    @Override
    @Transactional
    public void savePhone(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.save(phone);
    }

    @Override
    @Transactional
    public Phone findPhoneById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Phone phone = session.get(Phone.class, id);

        return phone;
    }

    @Override
    @Transactional
    public void updatePhone(Phone phone) {
        Session session = sessionFactory.getCurrentSession();

        session.update(phone);
    }

    @Override
    @Transactional
    public void deletePhone(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(phone);
    }

    @Override
    @Transactional
    public List<Phone> phoneList(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<Phone> phoneList = new ArrayList<>();
        try {
            Query query = session.createQuery("from Phone where username =: username order by id");
            query.setParameter("username", username);
            phoneList = query.getResultList();
        } catch (NoResultException e){

        }

        return phoneList;
    }
}
