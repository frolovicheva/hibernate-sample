package ru.geekbrains.hibernate;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryApp factory  = new SessionFactoryApp ();
        ProductDao productDao = new ProductDao (factory);

        try {
            factory.init();
            factory.prepareData();
            productDao.findByID (1L);
            productDao.saveOrUpdate (new Product ("cup", 15));
            productDao.deleteByID (1L);
            productDao.findAll ();

        } finally {
            factory.shutdown();
        }
    }

}
