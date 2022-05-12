package com.mes.dao;

import com.mes.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaDAO<E> {
    protected EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    public E create(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public E update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public E find(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        E entity = entityManager.find(type, id);
        entityManager.close();
        if (entity == null) {
            return null;
        } else {
            return entity;
        }
    }

    public List<Object[]> findAllCreateQuery(String sql) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery(sql);
        List<Object[]> resultList = query.getResultList();

        entityManager.close();
        return resultList;
    }

    public boolean delete(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            Object references = entityManager.getReference(type, id);
            //Object entity = entityManager.find(type,id);
            entityTransaction.begin();
            entityManager.remove(references);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);

        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();

        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    public List<E> findWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }


    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        List<E> result = query.getResultList();
        entityManager.close();
        ;
        return result;
    }

    public long countWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        return (long) query.getSingleResult();
    }

    public List<E> searchWithQuery(String tableName, Map<Object, Object> map) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sql = "SELECT tn from " + tableName + " tn where 1 = 1 ";

        Set<Map.Entry<Object, Object>> set = map.entrySet();

        for (Map.Entry<Object, Object> entry : set) {
            if (entry.getValue() != null) {
                sql += " AND " + entry.getKey() + " LIKE '%" + entry.getValue() + "%'";
            }
        }
        Query query = entityManager.createQuery(sql);
        System.out.println(sql);
        return query.getResultList();
    }

    public boolean findWithQuery(String tableName, Map<Object, Object> map) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sql = "SELECT tn from " + tableName + " tn where 1 = 1 ";

        Set<Map.Entry<Object, Object>> set = map.entrySet();

        for (Map.Entry<Object, Object> entry : set) {
            if (entry.getValue() != null) {
                sql += " AND " + entry.getKey() + " = '" + entry.getValue() + "'";
            }
        }
        System.out.println(sql + " =======");
        Query query = entityManager.createQuery(sql);
        return query.getResultList().size() > 0 ? false : true;
    }


}
