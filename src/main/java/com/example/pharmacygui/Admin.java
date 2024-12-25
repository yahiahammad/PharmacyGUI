package com.example.pharmacygui;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class
Admin extends User{

    private ArrayList<Product> products;
    private ArrayList<Cashier> cashiers;
    private ArrayList<Customer> customers;
    private ArrayList<Supplier> suppliers;
    private ArrayList<Cart> orders;
    private String password;
    private static int n = 0;

    public Admin() {}
    public Admin(String name, String email, String password) {
        super(name, Role.ADMIN, email);
        id = generateId();
        this.password = password;
        products = new ArrayList<>();
        cashiers = new ArrayList<>();
        customers = new ArrayList<>();
        suppliers = new ArrayList<>();
        orders = new ArrayList<>();
        initializeAdmin();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }
    public void setCashiers(ArrayList<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Cart> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Cart> orders) {
        this.orders = orders;
    }

    //Product methods********************************************************************************************

    //should check if the product already exists and if it does then change the quantity only if it's greater
    //add new product
    public boolean addNewProduct(String pName, double pPrice, int pQuantity, Supplier pSupplier, LocalDate pExpirationDate) {
        if (!JavaFXMain.CheckProductExistence(this,pName))
        {
            Product product = new Product(pName, pPrice, pQuantity, pSupplier, pExpirationDate);
            products.add(product);
            //System.out.println("Product added successfully to the pharmacy");
            return true;
        }
        return false;
    }

    //edit product
    public boolean editProduct(String name, String field, String value) {
        if (JavaFXMain.CheckProductExistence(this, name)) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    if (field.equalsIgnoreCase("name")) {
                        product.setName(value);
                        //System.out.println("Product Edited Successfully!\n");
                        return true;
                    } else if (field.equalsIgnoreCase("price")) {
                        product.setPrice(Double.parseDouble(value));
                        //System.out.println("Product Edited Successfully!\n");
                        return true;
                    } else if (field.equalsIgnoreCase("quantity")) {
                        product.setQuantity(Integer.parseInt(value));
                        //System.out.println("Product Edited Successfully!\n");
                        return true;
                    } else {
                        //System.out.println("Only Name, Price, and Quantity can be edited");
                        return false;
                    }
                }

            }
        }
        return false;
    }

    //remove product
    public boolean removeProduct(String name) {
        if(JavaFXMain.CheckProductExistence(this, name)) {
            products.removeIf(product -> product.getName().equals(name));
            //System.out.println("Product removed successfully");
            return true;
        }
        return false;
    }

    //search for a product
    public Product searchProductByField(String field, String value) {
        for (Product product : products) {
            if (field.equalsIgnoreCase("name") && product.getName().equalsIgnoreCase(value)) {
                return product;
            }
            else if (field.equalsIgnoreCase("id") && product.getProductId().equals(value)) {
                return product;
            }
        }
        return null;
    }

    //get most sold product
    public String getMostSoldProduct(LocalDate start, LocalDate end) {
        int maxQuantity = 0;
        ArrayList<Product> productOccurences = new ArrayList<>();
        HashSet<Product> bestSellerProducts = new HashSet<>();

        for (Cart order : orders)
        {
            if (order.getOrderDate().isAfter(start) && order.getOrderDate().isBefore(end) && order.getStatus() == Cart.Status.COMPLETED) {
                for (int i = 0 ; i < order.getProductList().size(); i++)
                {
                    for (int j = 0 ; j < order.getQuantityList().get(i); j++)
                        productOccurences.add(order.getProductList().get(i));
                }
            }
        }

        for (Product product : productOccurences) {
            if (Collections.frequency(productOccurences, product) > maxQuantity) {
                maxQuantity = Collections.frequency(productOccurences, product);
            }
        }

        if (maxQuantity == 0) {
            return "";
        }

        for (Product product : productOccurences) {
            if (Collections.frequency(productOccurences, product) == maxQuantity) {
                bestSellerProducts.add(product);
            }
        }

        //String mostRevenue;
        for (Product product : bestSellerProducts) {
            return ("Most Sold Product is of ID: " + product.getProductId() + " and it was ordered " + maxQuantity + " time(s)");
        }

        return "";
    }

    //get most revenue product
    public String getMostRevenueProduct(LocalDate start, LocalDate end) {
        int maxQuantity = 0;
        ArrayList<Product> productOccurences = new ArrayList<>();
        HashSet<Product> bestSellerProducts = new HashSet<>();
        Product bestRevenueProduct = null;
        for (Cart order : orders)
        {
            if (order.getOrderDate().isAfter(start) && order.getOrderDate().isBefore(end) && order.getStatus() == Cart.Status.COMPLETED) {
                for (int i = 0 ; i < order.getProductList().size(); i++)
                {
                    for (int j = 0 ; j < order.getQuantityList().get(i); j++)
                        productOccurences.add(order.getProductList().get(i));
                }
            }
        }

        for (Product product : productOccurences) {
            if (Collections.frequency(productOccurences, product) > maxQuantity) {
                maxQuantity = Collections.frequency(productOccurences, product);
            }

        }


        if (maxQuantity == 0) {
            //System.out.println("Product not found");
            //return;
            return "";
        }

        for (Product product : productOccurences) {
            if (Collections.frequency(productOccurences, product) == maxQuantity) {
                bestSellerProducts.add(product);
            }
        }

        double maxPrice = 0;

        for (Product product : bestSellerProducts) {

            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
                bestRevenueProduct = product;
            }

        }
        assert bestRevenueProduct != null;
        return ("Most Revenue Product is of Name: " + bestRevenueProduct.getName() +
                " and it  made revenue of: " + bestRevenueProduct.getPrice() * maxQuantity + " EGP");

    }

    //20/11
    public void viewProductReport() {
        System.out.println("---- Products Report ----");

        //List of Suppliers
        System.out.println("List of Suppliers:");//because the suppliers is already an array list
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }
        System.out.println();

        //List of Prices
        System.out.println("List of Prices:"); //loop over each product to print the price
        for(Product product:products) {
            System.out.println(product.getName() + " has a price of " + product.getPrice());
        }
        System.out.println();

        //Bestseller Product over a specific period of time
        System.out.println("Bestseller Product over a specific period of time:");
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate start = LocalDate.of(2024,1,1), end = LocalDate.of(2025,1,1);
        //check when you parse the string into a date(because no entry of it directly) if an exception may occur unintentionally by user
        try {
            System.out.println("Enter the start date and time in this form please (yyyy-MM-dd): ");
            String startFromUser = scanner.nextLine();
            start = LocalDate.parse(startFromUser, myFormat);
            System.out.println("Enter the end date and time in this form please (yyyy-MM-dd): ");
            String endFromUser = scanner.nextLine();
            end = LocalDate.parse(endFromUser, myFormat);
            //check that the input is valid and that the end is after the start
            if (start.isAfter(end)) {
                System.out.println("This is an invalid set of dates");
                return;
            }
        } catch (DateTimeParseException e) {
            // Handle invalid input format
            System.out.println("Invalid date and time format. Please use (yyyy-MM-dd)");
        }
        System.out.println("Bestseller Product over a specific period of time:");
        getMostSoldProduct(start, end);

        //Most revenue Product over a specific period of time
        System.out.println("Most revenue Product over a specific period of time:");
        getMostRevenueProduct(start, end);
    }

    //javafx version
    public void viewProductReportJavaFX() {
        TextArea t = new TextArea();
        t.appendText("---- Products Report ----\n");

        //List of Suppliers
        t.appendText("List of Suppliers:\n");//because the suppliers is already an array list
        for (Supplier supplier : suppliers) {
            t.appendText(supplier.toString() + "\n");
        }
        t.appendText("\n");

        //List of Prices
        t.appendText("List of Prices:\n"); //loop over each product to print the price
        for(Product product:products) {
            t.appendText(product.getName() + " has a price of " + product.getPrice() + "\n");
        }
        t.appendText("\n");
    }

    //Cashier methods********************************************************************************************
    //20/11
    public void addNewCashier(String cName, String cEmail) {
        boolean exists = false;
        //if cashier exists, change quantity
        for(Cashier cashier : cashiers) {
            if(cashier.getName().equals(cName)) {
                exists = true;
                System.out.println("Cashier already exists");
                return;
            }
        }
        if(!exists) {
            Cashier cashier = new Cashier(cName, cEmail);
            cashiers.add(cashier);
            System.out.println("Cashier added successfully to the pharmacy");
        }
    }

    //20/11
    public void editCashier(String cashierId, String field, String value) {
        for (Cashier cashier : cashiers) {
            if (cashier.getId().equals(cashierId)){
                if (field.equalsIgnoreCase("name")) {
                    cashier.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("email")) {
                    cashier.setEmail(value);
                }
                else {
                    System.out.println("Only Name and Email can be edited");
                    return;
                }
            }
        }
    }

    //20/11
    public boolean removeCashier(String cashierId) {
        cashiers.removeIf(cashier -> cashier.getId().equals(cashierId));
        System.out.println("Cashier removed successfully");
        return true;
    }

    //20/11
    public Cashier searchCashierByField(String field, String value) {
        for (Cashier cashier : cashiers) {
            if (field.equalsIgnoreCase("name") && cashier.getName().equalsIgnoreCase(value)) {
                return cashier;
            }
            else if (field.equalsIgnoreCase("id") && cashier.getId().equals(value)) {
                return cashier;
            }
            else if (field.equalsIgnoreCase("email") && cashier.getEmail().equals(value)) {
                return cashier;
            }
        }
        return null;
    }

    public void viewCashierReport() {
        //Number of Orders per each Cashier and their details
        System.out.println("Number of Orders per each Cashier and their details:");
        for (Cashier cashier : cashiers) {
            System.out.println("Number of Orders for " + cashier.getId() + ": " + cashier.getOrdersHandled().size());
            System.out.println("Orders Details:");
            for (Cart order : cashier.getOrdersHandled()) {
                System.out.println(order);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");


        //Cashier with the maximum number of Orders
        System.out.println("Cashier with the maximum number of Orders:");
        int maxOrders_cashier = 0;
        Cashier maxOrderCashier = null;
        for (Cashier cashier : cashiers) {
            if (cashier.getOrdersHandled().size() > maxOrders_cashier) {
                maxOrders_cashier = cashier.getOrdersHandled().size();
                maxOrderCashier = cashier;
            }
        }
        if (maxOrderCashier != null) {
            System.out.println("Cashier: " + maxOrderCashier);
            System.out.println("Number of Orders: " + maxOrders_cashier);
        } else {
            System.out.println("No cashiers to determine the maximum no. of Orders");
        }
        System.out.println("-------------------------------------------------------");


        //Cashier with the maximum number of revenue
        System.out.println("Cashier with the maximum number of revenue:");
        double maxRev = 0.0;
        Cashier maxRevCashier = null;
        for (Cashier cashier : cashiers) {

            if (cashier.getTotalPriceOfAllOrders() > maxRev) {
                maxRev = cashier.getTotalPriceOfAllOrders();
                maxRevCashier = cashier;
            }
        }
        if (maxRevCashier != null) {
            System.out.println("Cashier: " + maxRevCashier);
            System.out.println("Revenue: " + maxRev);
        } else {
            System.out.println("No cashiers to determine the maximum revenue");
        }
        System.out.println("-------------------------------------------------------");
    }

    //Customer methods********************************************************************************************
    //20/11
    public void addNewCustomer(String cName, String cEmail) {
        boolean exists = false;
        //if CUSTOMER exists do nothing and don't add it again
        for(Customer customer : customers) {
            if (customer.getName().equals(cName)) {
                exists = true;
                System.out.println("Customer already exists");
                return;
            }
        }
        if(!exists) {
            Customer customer = new Customer(cName, cEmail);
            customers.add(customer);
            System.out.println("Customer added successfully to the pharmacy");
        }
    }

    //20/11
    public void editCustomer(String customerId, String field, String value) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)){
                if (field.equalsIgnoreCase("name")) {
                    customer.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("email")) {
                    customer.setEmail(value);
                }
                else {
                    System.out.println("Only Name and Email can be edited");
                    return;
                }
            }
        }
    }

    //20/11
    public boolean removeCustomer(String customerId) {
        cashiers.removeIf(customer -> customer.getId().equals(customerId));
        System.out.println("Customer removed");
        return true;
    }

    //20/11
    public Customer searchCustomerByField(String field, String value) {
        for (Customer customer : customers) {
            if (field.equalsIgnoreCase("name") && customer.getName().equalsIgnoreCase(value)) {
                return customer;
            }
            else if (field.equalsIgnoreCase("id") && customer.getId().equals(value)) {
                return customer;
            }
            else if (field.equalsIgnoreCase("email") && customer.getEmail().equals(value)) {
                return customer;
            }
        }
        return null;
    }

    public void viewCustomerReport() {
        //Number of Orders per each Customer and their details
        System.out.println("Number of Orders per each Customer and their details:");
        for (Customer customer : customers) {
            System.out.println("Number of Orders for " + customer.getId() + ": " + customer.getOrderHistory().size());
            System.out.println("Orders History:");
            for(Cart order : customer.getOrderHistory()) {
                System.out.println(order);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");


        //Customer with the maximum number of Orders
        System.out.println("Customer with the maximum number of Orders:");
        Customer maxOrderCustomer = null;
        double maxOrders_customer = 0;
        for (Customer customer : customers) {
            if (customer.getOrderHistory().size() > maxOrders_customer) {
                maxOrders_customer = customer.getOrderHistory().size() ;
                maxOrderCustomer = customer;
            }
        }
        if (maxOrderCustomer != null) {
            System.out.println("Customer: " + maxOrderCustomer);
            System.out.println("Number of Orders: " + maxOrders_customer);
        } else {
            System.out.println("No customers to determine the maximum no. of Orders");
        }
        System.out.println("-------------------------------------------------------");


        //Customer with the maximum number of revenue
        System.out.println("Customer with the maximum number of revenue:");
        Customer maxRevCustomer = null;
        double maxRevCustomerRev=0;
        for (Customer customer : customers) {
            if (customer.getTotalPriceOfAllOrders() > maxRevCustomerRev) {
                maxRevCustomerRev = customer.getTotalPriceOfAllOrders();
                maxRevCustomer = customer;
            }
        }
        if (maxRevCustomer != null) {
            System.out.println("Customer: " + maxRevCustomer);
            System.out.println("Revenue: " + maxRevCustomerRev);
        } else {
            System.out.println("No customers to determine the maximum revenue");
        }
        System.out.println("-------------------------------------------------------");
    }

    //Supplier methods*******************************************************************************************
    //20/11
    public void addNewSupplier(String sName, String sEmail, String sContactInfo) {
        boolean exists = false;
        //if supplier exists do nothing and don't add it again
        for(Supplier supplier : suppliers) {
            if (supplier.getName().equals(sName)) {
                exists = true;
                System.out.println("Supplier already exists");
                return;
            }
        }
        if(!exists) {
            Supplier supplier = new Supplier(sName, sEmail, sContactInfo);
            suppliers.add(supplier);
        }
    }

    //20/11
    public void editSupplier(String supplierId, String field, String value) {
        for (Supplier supplier : suppliers) {
            if (supplier.getId().equals(supplierId)){
                if (field.equalsIgnoreCase("name")) {
                    supplier.setName(value);
                    return;
                }
                else if (field.equalsIgnoreCase("email")) {
                    supplier.setEmail(value);
                }
                else {
                    System.out.println("Only Name and Email can be edited");
                    return;
                }
            }
        }
    }

    //20/11
    public boolean removeSupplier(String supplierId) {
        suppliers.removeIf(supplier -> supplier.getId().equals(supplierId));
        System.out.println("Supplier removed");
        return true;
    }

    //20/11
    public Supplier searchSupplierByField(String field, String value) {
        for (Supplier supplier : suppliers) {
            if (field.equalsIgnoreCase("name") && supplier.getName().equalsIgnoreCase(value)) {
                return supplier;
            }
            else if (field.equalsIgnoreCase("id") && supplier.getId().equals(value)) {
                return supplier;
            }
            else if (field.equalsIgnoreCase("email") && supplier.getEmail().equals(value)) {
                return supplier;
            }
        }
        return null;
    }

    public void viewSupplierReport() {
        //Number of Orders per each Supplier and their details
        System.out.println("Number of Orders per each Supplier and their details:");
        for (Supplier supplier : suppliers) {
            System.out.println("Number of Orders for " + supplier.getName() + ": " + supplier.getProductCount());
            System.out.println("Orders Details:");
            for(Product order : supplier.getProductSupplied()) {
                System.out.println(order);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");


        //Supplier with maximum number of Orders
        System.out.println("Supplier with maximum number of Orders:");
        int maxOrders_sup = 0;
        Supplier maxOrderSupplier = null;
        for (Supplier supplier : suppliers) {
            if(supplier.getProductCount() > maxOrders_sup)
            {

                maxOrders_sup = supplier.getProductCount();
                maxOrderSupplier = supplier;
            }
        }
        if (maxOrderSupplier != null) {
            System.out.println("Supplier: " + maxOrderSupplier);
            System.out.println("Number of Orders: " + maxOrders_sup);
        } else {
            System.out.println("No suppliers to determine the maximum no. of Orders");
        }
        System.out.println("-------------------------------------------------------");


        //Supplier with maximum number of revenue
        System.out.println("Supplier with maximum number of revenue:");
        Supplier maxRevSupplier = null;
        double maxRevSupplierRev = 0.0;
        for (Supplier supplier : suppliers) {
            if (supplier.getTotalPriceOfAllOrders() > maxRevSupplierRev) {
                maxRevSupplierRev = supplier.getTotalPriceOfAllOrders();
                maxRevSupplier = supplier;
            }
        }
        if (maxRevSupplier != null) {
            System.out.println("Supplier: " + maxRevSupplier);
            System.out.println("Revenue: " + maxRevSupplierRev);
        } else {
            System.out.println("No suppliers to determine the maximum revenue");
        }
        System.out.println("-------------------------------------------------------");
    }

    public Cart searchCartByField(String field, String value) {
        for (Cart cart : orders) {
            if (field.equalsIgnoreCase("id") && cart.getId().equals(value)) {
                return cart;
            }
        }
        return null;
    }

    //View Orders Report Method
    public void viewOrdersReport() {
        System.out.println("---- Orders Report ----");
        System.out.println("Orders details:");
        for (Cart order : orders) {
            System.out.println(order);
        }
        System.out.println("--------------------------------------------");
        //still not done
        System.out.println("Total Revenue and Average Revenue per order over a specific period of time:");
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate start = LocalDate.of(2024,1,1), end = LocalDate.of(2025,1,1);
        //check when you parse the string into a date(because no entry of it directly) if an exception may occur unintentionally by user
        try {
            System.out.println("Enter the start date and time in this form please (yyyy-MM-dd): ");
            String startFromUser = scanner.nextLine();
            start = LocalDate.parse(startFromUser, myFormat);
            System.out.println("Enter the end date and time in this form please (yyyy-MM-dd): ");
            String endFromUser = scanner.nextLine();
            end = LocalDate.parse(endFromUser, myFormat);
            //check that the input is valid and that the end is after the start
            if (start.isAfter(end)) {
                System.out.println("This is an invalid set of dates");
                return;
            }
        } catch (DateTimeParseException e) {
            // Handle invalid input format
            System.out.println("Invalid date and time format. Please use (yyyy-MM-dd)");
        }
        double totalRevenue = 0;
        int cartCount = 0;
        for (Cart order : orders)
        {
            if (order.getOrderDate().isAfter(start) && order.getOrderDate().isBefore(end) && order.getStatus() == Cart.Status.COMPLETED) {

                totalRevenue += order.getTotalPrice();
                cartCount++;
            }
        }
        if (cartCount == 0)
        {
            System.out.println("No orders were made in the specified time:");
        }
        else
        {
            System.out.println("Average revenue per order From:" + start + " To: " + end + " Is: " + totalRevenue/cartCount);
            System.out.println("Total revenue From:" + start + " To: " + end + " Is: " + totalRevenue);

        }


    }

    private String generateId() {
        String Id = "Admin_" + n;
        n++;
        return Id;
    }

    private void initializeAdmin()
    {
        File supplierFile =   new File(      "src/main/java/com/example/pharmacygui/Suppliers.dat");
        File productFile =    new File(      "src/main/java/com/example/pharmacygui/Products.dat");
        File cartFile =       new File(      "src/main/java/com/example/pharmacygui/Cart.dat");
        File cashierFile =    new File(      "src/main/java/com/example/pharmacygui/Cashier.dat");
        File customerFile =   new File(      "src/main/java/com/example/pharmacygui/Customer.dat");

        try (ObjectInputStream supplierInputStream = new ObjectInputStream(new FileInputStream(supplierFile))) {
            // Read the entire list
            suppliers = (ArrayList<Supplier>) supplierInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading supplier file: " + e.getMessage());
        }

        try (ObjectInputStream productInputStream = new ObjectInputStream(new FileInputStream(productFile))) {
            // Read the entire list
            products = (ArrayList<Product>) productInputStream.readObject();
            // Restore relationships after deserialization
            for (Product product : products) {
                product.getSupplier().addProduct(product);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading product file: " + e.getMessage());
        }

        try (ObjectInputStream customerInputStream = new ObjectInputStream(new FileInputStream(customerFile))) {
            // Read the entire list
            customers = (ArrayList<Customer>) customerInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading customer file: " + e.getMessage());
        }

        try (ObjectInputStream cashierInputStream = new ObjectInputStream(new FileInputStream(cashierFile))) {
            // Read the entire list
            cashiers = (ArrayList<Cashier>) cashierInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading cashier file: " + e.getMessage());
        }

        try (ObjectInputStream cartInputStream = new ObjectInputStream(new FileInputStream(cartFile))) {
            // Read the entire list
            orders = (ArrayList<Cart>) cartInputStream.readObject();
            // Restore relationships after deserialization
            for (Cart cart : orders) {
                cart.getCustomer().addOrder(cart);
                cart.getCashier().addOrderHandled(cart);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading cart file: " + e.getMessage());
        }
    }

    public void saveData() throws IOException {
        File supplierFile =   new File(      "src/main/java/com/example/pharmacygui/Suppliers.dat");
        File productFile =    new File(      "src/main/java/com/example/pharmacygui/Products.dat");
        File cartFile =       new File(      "src/main/java/com/example/pharmacygui/Cart.dat");
        File cashierFile =    new File(      "src/main/java/com/example/pharmacygui/Cashier.dat");
        File customerFile =   new File(      "src/main/java/com/example/pharmacygui/Customer.dat");

        try {
            // Save suppliers
            ObjectOutputStream supplierStream = new ObjectOutputStream(new FileOutputStream(supplierFile));
            supplierStream.writeObject(suppliers);
            supplierStream.close();

            // Save products
            ObjectOutputStream productStream = new ObjectOutputStream(new FileOutputStream(productFile));
            productStream.writeObject(products);
            productStream.close();

            // Save cashiers
            ObjectOutputStream cashierStream = new ObjectOutputStream(new FileOutputStream(cashierFile));
            cashierStream.writeObject(cashiers);
            cashierStream.close();

            // Save customers
            ObjectOutputStream customerStream = new ObjectOutputStream(new FileOutputStream(customerFile));
            customerStream.writeObject(customers);
            customerStream.close();

            // Save carts/orders
            ObjectOutputStream cartStream = new ObjectOutputStream(new FileOutputStream(cartFile));
            cartStream.writeObject(orders);
            cartStream.close();

        } catch (IOException e) {
            System.out.println("FILE SAVING ERROR: " + e.getMessage());
        }
    }

    /*
    each file is to be saved in the same format, each attribute
    mentioned seperated with a comma "," and each object separated with a new line

    carts.txt format:
    CartID,Status,CashierID,CustomerID,totalPrice,date,product,quantity,product,quantity...

    cashier.txt format:
    CashierName,CashierID,email,carts...

    customer.txt format:
    CustomerName,CustomerID,email,carts...

    Suppliers.txt format:
    SupplierName,SupplierID,email,contactInfo,products....

    Products.txt format:
    ProductName,ProductID,ProductPrice,ProductQuantity,SupplierName
     */
}