package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CategoryID;

    private String Name;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        Name = name;
    }

    public Category() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
//        product.setCategory(this);
    }

    @Override
    public String toString() {
        return "Category{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
