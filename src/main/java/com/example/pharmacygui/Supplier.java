package com.example.pharmacygui;

import java.util.ArrayList;

public class Supplier extends User {
    private String contactInfo;
    private ArrayList<Product> productSupplied;
    private static int n = 0;

    public Supplier() {}

    public Supplier(String name, String email, String contactInfo) {
        super(name, Role.SUPPLIER, email);
        id = generateId();
        this.contactInfo = contactInfo;
        productSupplied = new ArrayList<>();
    }

    public Supplier(String name, String id, String email, String contactInfo) {
        super(name, Role.SUPPLIER, email);
        this.id = id;
        n++;
        this.contactInfo = contactInfo;
        productSupplied = new ArrayList<>();
    }

    public Supplier(Supplier supplier) {
        id = supplier.id;
        n++;
        name = supplier.name;
        email = supplier.email;
        contactInfo = supplier.contactInfo;
        productSupplied = supplier.productSupplied;
    }

    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<Product> getProductSupplied() {
        return productSupplied;
    }
    public void setProductSupplied(ArrayList<Product> productSupplied) {
        this.productSupplied = productSupplied;
    }

    public void addProduct(Product product) {
        productSupplied.add(product);
    }

    public void removeProduct(Product product) {
        productSupplied.remove(product);
    }

    public int getProductCount() {
        return productSupplied.size();
    }

    public double getTotalPriceOfAllOrders() {
        double totalPrice = 0;
        for (Product order : productSupplied) {
            totalPrice += order.getPrice();
        }
        return totalPrice;
    }

    private String generateId() {
        String Id = "Supplier_" + n;
        n++;
        return Id;
    }

    public String fileSaver()
    {
        /*
    Suppliers.txt format:
    SupplierName,SupplierID,email,contactInfo,products....
         */
        StringBuffer result = new StringBuffer( this.name + "," + this.id + "," + this.email + "," + this.getContactInfo());
        for ( Product product : this.getProductSupplied())
        {
            result.append(",");
            result.append(product.getName());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "{ Supplier ID: " + id + ", Supplier Name: " + name + ", Constact Info: "
                + contactInfo + ", Number of Products Supplied: " + getProductCount() + " }";
    }
}
