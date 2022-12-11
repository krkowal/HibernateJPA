package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceID;

    private int Quantity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    public List<Product> products = new ArrayList<>();

    public Invoice(int quantity) {
        Quantity = quantity;
    }

    public Invoice() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) throws Exception {
        products.add(product);
        product.reduceUnitsOnStock(Quantity);
    }

    public Invoice(int quantity, Product product) {
        Quantity = quantity;
        ArrayList <Product> p = new ArrayList<>();
        p.add(product);
        this.products = p;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "InvoiceID=" + InvoiceID +
                ", Quantity=" + Quantity +
                '}';
    }

}

