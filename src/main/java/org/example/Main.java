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
//        Category c1 = new Category("klocki");
//        Category c2 = new Category("kwiaty");
//        Category c3 = new Category("zegarki");
//        Product p3 = new Product("ksiazka",15);
//        Product p4 = new Product("husteczki",31);
//        Supplier supplier  = new Supplier("FiremkaA","Kobaltowa","City");
//        supplier.addProduct(product);
//        supplier.addProduct(p1);
//        supplier.addProduct(p2);
//        session.save(supplier);
        Invoice i1  = new Invoice(5);
        Invoice i2  = new Invoice(5);
        Invoice i3  = new Invoice(5);
        product.addInvoice(i1);
        p1.addInvoice(i2);
        p1.addInvoice(i3);
        i1.addProduct(product);
        i2.addProduct(p1);
        i3.addProduct(p2);
//        c1.addProduct(product);
//        c2.addProduct(p1);
//        c3.addProduct(p2);
//        session.save(c1);
//        session.save(c2);
//        session.save(c3);
//        product.setSupplier(supplier);
//        p1.setSupplier(supplier);
//        p2.setSupplier(supplier);

//        p3.setSupplier(supplier);
//        p4.setSupplier(supplier);
        Transaction tx  = session.beginTransaction();
        session.save(i1);
        session.save(i2);
        session.save(i3);
        session.save(product);
        session.save(p1);
        session.save(p2);
//        session.save(p3);
//        session.save(p4);
        tx.commit();
//        Category category = session.get(Category.class, 143);
//        System.out.println(category.getProducts());
        try {
        } finally {
            session.close();
        }
    }
}