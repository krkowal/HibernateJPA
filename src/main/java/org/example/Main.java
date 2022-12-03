package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Product product = new Product("Klocki lego",10);
        Product p1 = new Product("Bukiet kwiatkow",20);
        Product p2 = new Product("zegarek",5);
        Product p3 = new Product("ksiazka",15);
        Product p4 = new Product("husteczki",31);
        Supplier supplier  = new Supplier("FiremkaA","Kobaltowa","City");
        session.save(supplier);
//        supplier.addProducts(product);
        product.setSupplier(supplier);
        p1.setSupplier(supplier);
        p2.setSupplier(supplier);
        p3.setSupplier(supplier);
        p4.setSupplier(supplier);
        Transaction tx  = session.beginTransaction();
        session.save(product);
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        tx.commit();
        try {
        } finally {
            session.close();
        }
    }
}