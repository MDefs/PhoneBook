package com.mdefs.dao;

import com.mdefs.entity.Phone;
import com.mdefs.entity.User;

import java.util.List;

public interface UserDAO {

    void registerUser(User user);

    void updateUser(User user);

    User findByUsername(String username);

    void savePhone(Phone phone);

    void updatePhone(Phone phone);

    void deletePhone(Phone phone);

    Phone findPhoneById(int id);

    List<Phone> phoneList(String username);

}
