package com.example.pharmacygui;

import java.util.ArrayList;
import com.example.pharmacygui.Cart.Status;

public class Cashier extends User implements java.io.Serializable{
    private ArrayList<Cart> orderHandled;
    private static int n = 0;

    public Cashier() {}

    public Cashier(String name, String email) {
        super(name, Role.CASHIER, email);
        id = generateId();
        orderHandled = new ArrayList<>();
    }

    public Cashier(String name,String id, String email) {
        super(name, Role.CASHIER, email);
        this.id = id;
        n++;
        orderHandled = new ArrayList<>();
    }

    public Cashier(Cashier cashier) {
        id = cashier.id;
        n++;
        name = cashier.name;
        email = cashier.email;
        role = cashier.role;
        orderHandled = cashier.orderHandled;
    }

    public ArrayList<Cart> getOrdersHandled() {
        return orderHandled;
    }

    public boolean createOrder(Customer customer) {
        Cart newOrder = new Cart(customer, this);
        orderHandled.add(newOrder);
        customer.addOrder(newOrder);
        return true;
    }

    public void processPayment(Cart order) {
        System.out.println("Total is " + order.calculateTotalPrice());
        order.setStatus(Status.COMPLETED);
        //more code to get payment
        System.out.println("Payment processed successfully");
        int i = 0;
        for (Product product: order.getProductList())
        {
            product.addOrder((order.getQuantityList()).get(i));
            i++;
        }
    }

    public void viewOrderHistory() {
        if (orderHandled.isEmpty()) {
            System.out.println("No orders handled yet.");
            return;
        }
        for (Cart order : orderHandled) {
            System.out.println(order.toString());
        }
    }

    private String generateId() {
        String Id = "Cashier_" + n;
        n++;
        return Id;
    }

    //will check later
    public double getTotalPriceOfAllOrders() {
        double totalPrice = 0;
        for (Cart order : orderHandled) {
            totalPrice += order.calculateTotalPrice();
        }
        return totalPrice;
    }

    public String fileSaver()
    {
        /*
    cashier.txt format:
    CashierName,CashierID,email,carts...
         */
        StringBuffer result = new StringBuffer( this.name + "," + this.id + "," + this.email );
        for ( Cart order : this.getOrdersHandled())
        {
            result.append(",");
            result.append(order.getId());
        }
        return result.toString();
    }

    //need to make sure that the order is also removed for the Customer object
    public void addOrderHandled(Cart cart) {orderHandled.add(cart);}
    public void cancelCart (Cart cart) {
        orderHandled.remove(cart);
    }
    public boolean addProductToCart(Cart cart, Product product, int quantity) {
        cart.addProduct(product, quantity);
        return true;
    }
    public boolean removeProductFromCart(Cart cart, Product product) {
        cart.removeProduct(product);
        return true;
    }

    @Override
    public String toString() {
        return "{ Cashier ID: " + id + ", Cashier Name: " + name + " }";
    }
}