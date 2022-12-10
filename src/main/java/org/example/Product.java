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
    private Supplier supplier;

    @ManyToOne
    private Category category;

    public Product(String productsName, int unitsOnStock) {
        ProductsName = productsName;
        UnitsOnStock = unitsOnStock;
    }

    public void setSupplier(Supplier suppliers) {
        this.supplier = suppliers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", ProductsName='" + ProductsName + '\'' +
                ", UnitsOnStock=" + UnitsOnStock +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
