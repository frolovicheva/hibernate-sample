package ru.geekbrains.hibernate;

import org.hibernate.Session;

import java.util.List;

public class ProductDao {
    private SessionFactoryApp factory;
    private Product product;

    public ProductDao(SessionFactoryApp factory) {
        this.factory = factory;
    }

    public Product findByID (Long id){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
            return product;
        }
    }


    public List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            System.out.println(products + "\n");
            session.getTransaction().commit();
            return products;
        }
    }

    public Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            System.out.println(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public void deleteByID(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.delete (product);
            session.getTransaction().commit();
        }
    }
}
