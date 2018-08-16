package com.mdefs.service;

import com.mdefs.entity.Phone;
import com.mdefs.entity.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    User findByUsername(String username);

    void updateUser(User user);

    void savePhone(Phone phone);

    Phone findPhoneById(int id);

    void updatePhone(Phone phone);

    void deletePhone(Phone phone);

    List<Phone> phoneList(String username);

}
