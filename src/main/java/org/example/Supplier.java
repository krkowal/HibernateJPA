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

    @OneToMany
//    @JoinColumn(name = "Supplier_FK")
    private Set<Product> products = new HashSet<>();

    public Supplier(String companyName, String street, String city) {
        CompanyName = companyName;
        Street = street;
        City = city;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Supplier() {
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "CompanyName='" + CompanyName + '\'' +
                ", Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
