package com.mes.dao;

import com.mes.entity.User;
import com.mes.util.HashGenerator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends JpaDAO<User> {

    public User find(Object id) {
        return super.find(User.class, id);
    }

    @Override
    public User create(User entity) {
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        return super.create(entity);
    }

    @Override
    public User update(User entity) {
        entity.setPassword(HashGenerator.generateMD5(entity.getPassword()));
        entity.setUpdatedAt(new Date());
        return super.update(entity);
    }

    public void delete(Object id) {
        super.delete(User.class, id);
    }

    public List<User> findAll() {
        return super.findWithNamedQuery("User.findAll");
    }

    public long count() {
        return super.countWithNamedQuery("User.count");
    }

    public boolean checkLogin(String userId, String password) {
        String encryptedPassword = HashGenerator.generateMD5(password);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("password", encryptedPassword);

        List<User> listUsers = super.findWithNamedQuery("User.checkLogin", parameters);

        return listUsers.size() == 1 ? true : false;
    }

    public boolean checkByUserId(String userId) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId", userId);
        return super.findWithQuery("User", map);
    }

}
