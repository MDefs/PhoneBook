
package com.mdefs.service;

import com.mdefs.dao.UserDAO;
import com.mdefs.entity.Phone;
import com.mdefs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerUser(User user) {
        user.setEncodePassword(passwordEncoder.encode(user.getPassword()));
        userDAO.registerUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void savePhone(Phone phone) {
        userDAO.savePhone(phone);
    }

    @Override
    public Phone findPhoneById(int id) {
        return userDAO.findPhoneById(id);
    }

    @Override
    public void updatePhone(Phone phone) {
        userDAO.updatePhone(phone);
    }

    @Override
    public void deletePhone(Phone phone) {
        userDAO.deletePhone(phone);
    }

    @Override
    public List<Phone> phoneList(String username) {
        return userDAO.phoneList(username);
    }
}
