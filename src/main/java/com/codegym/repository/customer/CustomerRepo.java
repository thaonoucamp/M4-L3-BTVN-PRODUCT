package com.codegym.repository.customer;

import com.codegym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepo implements IRepoCustomer {
    @Qualifier("entityManager")
    @Autowired
    EntityManager manager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = manager.createQuery("select c from Customer as c", Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        manager.getTransaction().begin();
        if (customer.getId() != -1) {
            manager.merge(customer);
            manager.getTransaction().commit();
        } else {
            manager.getTransaction().rollback();
        }
    }

    @Override
    public void update(int id, Customer customer) {
        manager.getTransaction().begin();
        customer.setId(id);
        manager.merge(customer);
        manager.getTransaction().commit();
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        manager.getTransaction().begin();
        if (customer.getId() != -1) {
            manager.remove(customer);
            manager.getTransaction().commit();
        }
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = manager.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
