package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int productID;

    private String ProductsName;
    private int UnitsOnStock;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<Invoice> invoices = new ArrayList<>();


    public Product() {
    }

//    @ManyToOne
//    private Supplier supplier;
//
//    @ManyToOne
//    private Category category;

    public Product(String productsName, int unitsOnStock) {
        ProductsName = productsName;
        UnitsOnStock = unitsOnStock;
    }

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void reduceUnitsOnStock(int quatity) throws Exception {
        if (UnitsOnStock - quatity >= 0 ) UnitsOnStock -= quatity;
        else throw new Exception("quantity below 0");
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", ProductsName='" + ProductsName + '\'' +
                ", UnitsOnStock=" + UnitsOnStock +
                "}";
    }
    //    public void setSupplier(Supplier suppliers) {
//        this.supplier = suppliers;
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productID=" + productID +
//                ", ProductsName='" + ProductsName + '\'' +
//                ", UnitsOnStock=" + UnitsOnStock +
//                ", supplier=" + supplier +
//                ", category=" + category +
//                '}';
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
}
