package com.mes.dao;

import com.mes.entity.Account;
import com.mes.entity.Material;

import java.util.Date;
import java.util.List;

public class MaterialDAO extends JpaDAO<Material> {

    public Material find(Object id) {
        return super.find(Material.class, id);
    }

    @Override
    public Material create(Material entity) {
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        return super.create(entity);
    }

    @Override
    public Material update(Material entity) {
        entity.setUpdatedAt(new Date());
        return super.update(entity);
    }

    public void delete(Object id) {
        super.delete(Material.class, id);
    }

    public List<Object[]> findAll() {
//        String sql = "SELECT m, a FROM Account a INNER JOIN Material m ON a.id = m.account.id ORDER BY m.id DESC";
        String sql = "SELECT m, a FROM Material m LEFT JOIN Account a ON a.id = m.account.id ORDER BY m.id DESC";
        return super.findAllCreateQuery(sql);
    }

    public long countAll() {
        return super.countWithNamedQuery("Material.countAll");
    }
}
