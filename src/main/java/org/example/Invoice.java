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

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Product> products = new ArrayList<>();

    public Invoice(int quantity) {
        Quantity = quantity;
    }

    public Invoice() {
    }

    public void addProduct(Product product) throws Exception {
        products.add(product);
        product.reduceUnitsOnStock(Quantity);
    }


}

