package com.example.pharmacygui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cart implements java.io.Serializable{
    protected String id = "0";
    private Status status; //I feel like it's unnecessary but idk
    protected Customer customer;
    protected Cashier cashier;
    private ArrayList<Product> productList;
    private ArrayList<Integer> quantityList;
    private ArrayList<LocalDateTime> salesDate;
    protected double totalPrice;
    private LocalDate orderDate;
    private static int n = 0;

    public enum Status {
        PENDING,
        COMPLETED,
        CANCELLED
    }

    //no changes needed so far
    public Cart() {
        id = generateId();
        this.productList = new ArrayList<>();
        this.quantityList = new ArrayList<>();
        this.totalPrice = 0.0;
        this.orderDate = LocalDate.now();
        this.status = Status.PENDING;
    }

    public Cart(Customer customer, Cashier cashier) {
        id = generateId();
        this.customer = customer;
        this.cashier = cashier;
        this.productList = new ArrayList<>();
        this.quantityList = new ArrayList<>();
        this.totalPrice = 0.0;
        this.orderDate = LocalDate.now();
        this.status = Status.PENDING;
    }

    public Cart(String id, Status status, Customer customer, Cashier cashier, double totalPrice, LocalDate orderDate) {
        this.id = id;
        n++;
        this.status = status;
        this.customer = customer;
        this.cashier = cashier;
        this.productList = new ArrayList<>();
        this.quantityList = new ArrayList<>();
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Cart(Cart cart) {
        this.id = cart.getId();
        this.status = cart.getStatus();
        this.customer = cart.getCustomer();
        this.cashier = cart.getCashier();
        this.productList = cart.getProductList();
        this.quantityList = cart.getQuantityList();
        this.totalPrice = cart.getTotalPrice();
        this.orderDate = cart.getOrderDate();
    }

    public void cancelCart()
    {
        status = Status.CANCELLED;
    }

    public void addToProductList(Product product) {
        productList.add(product);
    }

    public void addToQuantityList(Integer quantity) {
        quantityList.add(quantity);
    }


    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    //comment this out
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void printProductList() {
        for(int i = 0 ; i < productList.size(); i++) {
            System.out.println("Product " + (i+1) + ": " + (productList.get(i)).getName() +
                    ", Quantity: " + quantityList.get(i));
        }
    }

    //comment this out
    public ArrayList<Integer> getQuantityList() {
        return quantityList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void addProduct(Product product, int quantity) {
        int index = productList.indexOf(product);

        if (productList.contains(product)) {
            quantityList.set(index, quantityList.get((productList.indexOf(product))) + quantity);
        }
        else {
            productList.add(product);
            quantityList.add(quantity);
        }
        calculateTotalPrice();
    }

    public void removeProduct(Product product) {
        boolean exists = productList.contains(product);
        if (exists) {
            quantityList.remove(productList.indexOf(product));
            productList.remove(product);
            calculateTotalPrice();
        } else {
            System.out.println("Product not found in cart");
        }
    }

    //need to check this
    //not in the uml
    public void removeProduct(Product product, int quantity) {
        int index = productList.indexOf(product);
        if (index != -1) {
            if (quantityList.get(index) - quantity > 0)
            {
                quantityList.set(index, quantityList.get((productList.indexOf(product))) - quantity);
            }
            else {
                productList.remove(index);
                quantityList.remove(index);
            }
            calculateTotalPrice();
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public double calculateTotalPrice() {
        totalPrice = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            totalPrice += productList.get(i).getPrice() * quantityList.get(i);
        }
        return totalPrice;
    }

    /*public Order checkout(Customer customer) {
        Order order = new Order(generateOrderId(), customer);
        for (int i = 0; i < productList.size(); i++) {
            order.addProduct(productList.get(i), quantityList.get(i));
        }
        productList.clear();
        quantityList.clear();
        totalPrice = 0.0;
        return order;
    }*/

    private String generateId() {
        String Id = "Order_" + n;
        n++;
        return Id;
    }

    public String fileSaver()
    {
        /*
    carts.txt format:
    CartID,Status,CustomerID,totalPrice,date,product,quantity,product,quantity...
         */
        StringBuffer result = new StringBuffer( this.id + "," + this.getStatus() + "," + this.getCashier().getId() +"," + this.getCustomer().getId() + "," + this.calculateTotalPrice() + "," + this.getOrderDate() );
        for ( int i = 0; i < productList.size(); i++ )
        {
            result.append(",");
            result.append(productList.get(i).getName());
            result.append(",");
            result.append(quantityList.get(i));
        }
        return result.toString();
    }

    //will check later
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("Order ID: " + id + ", Customer: " + customer.getName() + ", Total Price: " + totalPrice + ", Order Date: " + orderDate);
        for (Product product : productList) {
            result.append(", Product Name: ").append(product.getName());
            result.append(", Product Quantity: ").append(quantityList.get(productList.indexOf(product)));
        }
        return result.toString();
    }
}