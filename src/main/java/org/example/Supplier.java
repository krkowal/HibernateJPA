package org.example;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int SupplierID;

    private String CompanyName;
    private String Street;
    private String City;

//    @OneToMany
//    private Set<Product> products = new HashSet<>();

    public Supplier(String companyName, String street, String city) {
        CompanyName = companyName;
        Street = street;
        City = city;
    }

//    public void addProducts(Product product){
//        products.add(product);
//    }

    public Supplier() {
    }
}
