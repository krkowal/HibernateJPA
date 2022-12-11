package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("abc");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Invoice i1  = new Invoice(6);
        Invoice i2  = new Invoice(5);
        Invoice i3  = new Invoice(4);


        Category c1 = new Category("klocki");
        Category c2 = new Category("kwiaty");
        Category c3 = new Category("zegarki");

        Supplier s1  = new Supplier("FiremkaA","Kobaltowa","City");
        Supplier s2 = new Supplier("FiremkaB", "Miedziana", "Wok");

        Product product = new Product("Klocki lego",15,i1);
        Product p1 = new Product("Bukiet kwiatkow",25,i2);
        Product p2 = new Product("zegarek",5,i3);
        Product p3 = new Product("zestaw lego",5);
        Product p4 = new Product("magnolie",5);
        Product p5 = new Product("zegareczek zegarunio",5);

        Invoice i4  = new Invoice(3,p3);
        Invoice i5  = new Invoice(2,p4);
        Invoice i6  = new Invoice(1,p5);
//        product.addInvoice(i1);
//        p1.addInvoice(i2);
//        p2.addInvoice(i3);
//        i1.addProduct(product);
//        i2.addProduct(p1);
//        i3.addProduct(p2);

        manager.persist(product);
        manager.persist(p1);
        manager.persist(p2);
        manager.persist(i4);
        manager.persist(i5);
        manager.persist(i6);

//        manager.persist(i1);
//        manager.persist(i2);
//        manager.persist(i3);

        transaction.commit();
        manager.close();
    }
}
