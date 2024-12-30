package com.example.pharmacygui;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product implements java.io.Serializable {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private Supplier supplier;
    //
    private String supplierName;
    //
    private LocalDate expirationDate;
    private int numberOfOrders;
    private int quantitySold;
    private static int n = 0;

    public Product() {}
    public static void setN(int n) {
        Product.n = n;
    }
    public Product(String name, double price, int quantity, Supplier supplier, LocalDate expirationDate) {
        productId = generateId();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.supplierName = supplier.getName();
        this.expirationDate = expirationDate;
    }
    public Product(Product p) {
        productId = p.getProductId();
        n++;
        name = p.getName();
        price = p.getPrice();
        quantity = p.getQuantity();
        supplier = p.supplier;
        supplierName = p.supplierName;
        expirationDate = p.expirationDate;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Supplier getSuppliers() {
        return supplier;
    }
    public void setSuppliers(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }
    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void addOrder(int quantity)
    {
        this.numberOfOrders+= quantity;
    }

    //we probably don't need this cuz we already have a method for this in Admin
    /*public void addProduct(int productId, int quantity, String name) {
        this.productId += productId;
        this.quantity += quantity;
        this.name = name;
    }*/

    //might remove if not needed
    public void increaseStock(int quantity) {
        this.quantity += quantity;
    }

    //might remove if not needed
    public void reduceStock(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough stock to be reduced");
        }
    }

    public boolean isInStock() {
        return this.quantity != 0;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    private String generateId() {
        String Id = "Product_" + n;
        n++;
        return Id;
    }

    public String fileSaver()
    {
        /*
        Products.txt format:
        ProductName,ProductID,ProductPrice,ProductQuantity,SupplierName
         */
        return ( this.name + "," + this.productId + "," + this.price + "," + this.quantity + "," + this.supplierName + "," + this.expirationDate );

    }

    @Override
    public String toString() {
        return " Product ID: " + productId + ", Product Name: " + name + ", Product Price: " + price
                + ", Product Quantity: " + quantity + ", Product Supplier: " + supplier.getName() + ", Product Expiration Date: "
                + expirationDate + "\n";
    }

}