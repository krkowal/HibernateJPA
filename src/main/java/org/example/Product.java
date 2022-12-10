package org.example;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int productID;

    private String ProductsName;
    private int UnitsOnStock;

    public Product() {
    }

    @ManyToOne
//    @JoinColumn(name = "Product_FK")
    private Supplier supplier;
    public Product(String productsName, int unitsOnStock) {
        ProductsName = productsName;
        UnitsOnStock = unitsOnStock;
    }

    public void setSupplier(Supplier suppliers) {
        this.supplier = suppliers;
    }
}
