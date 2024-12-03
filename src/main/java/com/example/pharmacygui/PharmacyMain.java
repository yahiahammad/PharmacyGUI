package com.example.pharmacygui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class PharmacyMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {



        Admin admin = new Admin("Rina", "Rina123@gmail.com", "1234");
        Cashier cashier = null;
        int choice;
        String password;
        Scanner in = new Scanner(System.in);
        Cart cart = null;
        Customer customer = null;





        FlowPane mainMenuflowPane = new FlowPane();
        mainMenuflowPane.setAlignment(Pos.CENTER);
        mainMenuflowPane.setPadding(new Insets(10, 10, 10, 10));
        mainMenuflowPane.setHgap(5);
        mainMenuflowPane.setVgap(5);

        Label mainMenuLabel = new Label("Choose your role: ");
        Button adminButton= new Button("Admin");
        Button cashierButton = new Button("Cashier");
        Button customerButton = new Button("Customer");

        mainMenuflowPane.getChildren().addAll(mainMenuLabel,adminButton,cashierButton,customerButton);

        Scene scene = new Scene(mainMenuflowPane, 400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.show();

        adminButton.setOnAction(e -> {
            FlowPane adminLoginflowPane = new FlowPane();
            adminLoginflowPane.setAlignment(Pos.CENTER);
            adminLoginflowPane.setPadding(new Insets(10, 10, 10, 10));
            adminLoginflowPane.setHgap(5);
            adminLoginflowPane.setVgap(5);

            PasswordField adminPasswordTextField = new PasswordField();
            Label adminPasswordLabel = new Label("Password: ");
            Label adminWrongPasswordLabel = new Label("Wrong Password, try again");
            adminWrongPasswordLabel.setTextFill(Color.RED);
            adminWrongPasswordLabel.setVisible(false);


            adminLoginflowPane.getChildren().addAll(adminPasswordLabel,adminPasswordTextField, adminWrongPasswordLabel);

            Scene adminLoginScene = new Scene(adminLoginflowPane, 400,400);

            primaryStage.setScene(adminLoginScene);
            primaryStage.setTitle("Pharmacy Management System");
            primaryStage.show();


            adminPasswordTextField.setOnAction(e1 -> {
                if (adminPasswordTextField.getText().equals(admin.getPassword())) {
                    Label adminMenuLabel = new Label("Menu to Pharmacy Management System, Admin!");

                    FlowPane adminMenuFlowPane = new FlowPane();
                    adminMenuFlowPane.setAlignment(Pos.TOP_CENTER);
                    adminMenuFlowPane.setPadding(new Insets(10, 10, 10, 10));
                    adminMenuFlowPane.setHgap(5);
                    adminMenuFlowPane.setVgap(5);

                    Button adminMenu_addNewProduct = new Button("Add New Product");
                    Button adminMenu_editProduct = new Button("Edit Product");
                    Button adminMenu_removeProduct = new Button("Remove Product");
                    Button adminMenu_searchForProduct = new Button("Search for a Product");
                    Button adminMenu_viewReportsAboutProducts = new Button("View Reports About Products");
                    Button adminMenu_addNewUser = new Button("Add New User");
                    Button adminMenu_editUser = new Button("Edit User");
                    Button adminMenu_removeUser = new Button("Remove User");
                    Button adminMenu_searchForUser = new Button("Search for a User");
                    Button adminMenu_viewReportsAboutUsers = new Button("View Reports About Users");
                    Button adminMenu_viewReportsAboutOrders = new Button("View Reports About Orders");
                    Button adminMenu_logOut = new Button("LogOut");

                    double buttonWidth = 200;
                    double buttonHeight = 40;

                    adminMenu_addNewProduct.setPrefWidth(buttonWidth);
                    adminMenu_addNewProduct.setPrefHeight(buttonHeight);
                    adminMenu_editProduct.setPrefWidth(buttonWidth);
                    adminMenu_editProduct.setPrefHeight(buttonHeight);
                    adminMenu_removeProduct.setPrefWidth(buttonWidth);
                    adminMenu_removeProduct.setPrefHeight(buttonHeight);
                    adminMenu_searchForProduct.setPrefWidth(buttonWidth);
                    adminMenu_searchForProduct.setPrefHeight(buttonHeight);
                    adminMenu_viewReportsAboutProducts.setPrefWidth(buttonWidth);
                    adminMenu_viewReportsAboutProducts.setPrefHeight(buttonHeight);
                    adminMenu_addNewUser.setPrefWidth(buttonWidth);
                    adminMenu_addNewUser.setPrefHeight(buttonHeight);
                    adminMenu_editUser.setPrefWidth(buttonWidth);
                    adminMenu_editUser.setPrefHeight(buttonHeight);
                    adminMenu_removeUser.setPrefWidth(buttonWidth);
                    adminMenu_removeUser.setPrefHeight(buttonHeight);
                    adminMenu_searchForUser.setPrefWidth(buttonWidth);
                    adminMenu_searchForUser.setPrefHeight(buttonHeight);
                    adminMenu_viewReportsAboutUsers.setPrefWidth(buttonWidth);
                    adminMenu_viewReportsAboutUsers.setPrefHeight(buttonHeight);
                    adminMenu_viewReportsAboutOrders.setPrefWidth(buttonWidth);
                    adminMenu_viewReportsAboutOrders.setPrefHeight(buttonHeight);
                    adminMenu_logOut.setPrefWidth(buttonWidth);
                    adminMenu_logOut.setPrefHeight(buttonHeight);

                    VBox adminMenu_vbox = new VBox(10);
                    adminMenu_vbox.getChildren().addAll(
                            adminMenuLabel,
                            adminMenu_addNewProduct,
                            adminMenu_editProduct,
                            adminMenu_removeProduct,
                            adminMenu_searchForProduct,
                            adminMenu_viewReportsAboutProducts,
                            adminMenu_addNewUser,
                            adminMenu_editUser,
                            adminMenu_removeUser,
                            adminMenu_searchForUser,
                            adminMenu_viewReportsAboutUsers,
                            adminMenu_viewReportsAboutOrders,
                            adminMenu_logOut
                    );


                    adminMenu_vbox.setAlignment(Pos.CENTER);
                    adminMenuFlowPane.getChildren().addAll(adminMenu_vbox);

                    Scene adminMenuScene = new Scene(adminMenuFlowPane, 400,800);
                    primaryStage.setScene(adminMenuScene);
                    primaryStage.show();











                }
                else
                {
                    adminWrongPasswordLabel.setVisible(true);
                }



            });





        });

/*
        do {
            int innerChoice;
            System.out.println("Choose your role:");
            System.out.println("------------------------------------");
            System.out.println("| 1. Admin                         |");
            System.out.println("| 2. Customer                      |");
            System.out.println("| 3. Cashier                       |");
            System.out.println("| 4. Exit                          |");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter password: ");
                    password = in.next();
                    if (!admin.getPassword().equals(password)) {
                        System.out.println("Incorrect password");
                        System.out.println();
                        break;
                    }
                    else {
                        do {
                            System.out.println("Admin Menu:");
                            System.out.println("------------------------------------");
                            System.out.println("| 1. Add New Product               |");
                            System.out.println("| 2. Edit Product                  |");
                            System.out.println("| 3. Remove Product                |");
                            System.out.println("| 4. Search for a Product          |");
                            System.out.println("| 5. View Reports About Products   |");
                            System.out.println("| 6. Add New User                  |");
                            System.out.println("| 7. Edit User                     |");
                            System.out.println("| 8. Remove User                   |");
                            System.out.println("| 9. Search for a User             |");
                            System.out.println("| 10. View Reports About Users     |");
                            System.out.println("| 11. View Reports About Orders    |");
                            System.out.println("| 12. LogOut                       |");
                            System.out.println("------------------------------------");
                            System.out.print("Enter your choice: ");
                            innerChoice = in.nextInt();

                            switch (innerChoice) {
                                case 1:
                                    String addPname;
                                    double addPprice;
                                    int addPquantity;
                                    String addPsupplierName;
                                    LocalDate addPexpDate;
                                    System.out.print("Enter Product Name: ");
                                    addPname = CheckProductExistence(admin,in,true);
                                    if (addPname.equals("0")) {break;}
                                    System.out.print("Enter Product Price: ");
                                    addPprice = in.nextDouble();
                                    System.out.print("Enter Product Quantity: ");
                                    addPquantity = in.nextInt();
                                    System.out.print("Enter Product Supplier ID: ");
                                    addPsupplierName = CheckSupplierExistence(admin,in,false);
                                    if (addPsupplierName.equals("0")) {break;}
                                    System.out.print("Enter Product Expiration Date: ");
                                    addPexpDate = LocalDate.parse(in.next());
                                    admin.addNewProduct(addPname, addPprice, addPquantity, admin.searchSupplierByField("id", addPsupplierName), addPexpDate);
                                    System.out.println("Product ID: " + admin.getProducts().getLast().getProductId());
                                    TimeUnit.SECONDS.sleep(1);
                                    break;
                                case 2:
                                    String editPid, editPfield, editPvalue;

                                    System.out.print("Enter Product Name: ");
                                    editPid = CheckProductExistence(admin,in,false);
                                    if (editPid.equals("0")) {break;}
                                    editPid = admin.searchProductByField("name",editPid).getProductId();
                                    System.out.print("Enter the field you want to edit: ");
                                    editPfield = in.next();
                                    System.out.print("Enter new value: ");
                                    editPvalue = in.next();

                                    admin.editProduct(editPid, editPfield, editPvalue);
                                    TimeUnit.SECONDS.sleep(1);
                                    break;
                                case 3:
                                    String removePname;
                                    System.out.print("Enter name of Product to be removed: ");
                                    removePname = CheckProductExistence(admin,in,false);
                                    if (removePname.equals("0")) {break;}
                                    admin.removeProduct(admin.searchProductByField("name", removePname).getProductId());
                                    TimeUnit.SECONDS.sleep(1);
                                    break;
                                case 4:
                                    String searchPfield, searchPvalue;
                                    System.out.print("Enter Search Field: ");
                                    searchPfield = in.next();
                                    System.out.print("Enter value to search with: ");
                                    searchPvalue = in.next();
                                    if(admin.searchProductByField(searchPfield, searchPvalue) == null) {
                                        System.out.println("Product not found");
                                        break;
                                    }
                                    System.out.println("Product you searched for: "
                                            + admin.searchProductByField(searchPfield, searchPvalue));
                                    System.out.println();
                                    TimeUnit.SECONDS.sleep(1);
                                    break;
                                case 5:
                                    admin.viewProductReport();
                                    System.out.println();
                                    TimeUnit.SECONDS.sleep(3);
                                    break;
                                case 6:
                                    System.out.println("------------------------");
                                    System.out.println("| 1. Add New Cashier   |");
                                    System.out.println("| 2. Add New Customer  |");
                                    System.out.println("| 3. Add New Supplier  |");
                                    System.out.println("------------------------");
                                    System.out.print("Enter your choice: ");
                                    innerChoice = in.nextInt();
                                    switch (innerChoice) {
                                        case 1:
                                            String addCAname, addCAemail;
                                            System.out.print("Enter Cashier Name: ");
                                            addCAname = in.next();
                                            System.out.print("Enter Cashier Email: ");
                                            addCAemail = isValidEmailAddress(in);
                                            if (addCAemail.equals("0")) {break;}
                                            admin.addNewCashier(addCAname, addCAemail);
                                            System.out.println("Cashier ID: " + admin.getCashiers().getLast().getId());
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        case 2:
                                            String addCUname, addCUemail;
                                            System.out.print("Enter Customer Name: ");
                                            addCUname = in.next();
                                            System.out.print("Enter Customer Email: ");
                                            addCUemail = isValidEmailAddress(in);
                                            if (addCUemail.equals("0")) {break;}
                                            admin.addNewCustomer(addCUname, addCUemail);
                                            System.out.println("Customer ID: " + admin.getCustomers().getLast().getId());
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        case 3:
                                            String addSname, addSemail, addContact;
                                            System.out.print("Enter Supplier Name: ");
                                            addSname = CheckSupplierExistence(admin,in,true);
                                            if (addSname.equals("0")) {break;}
                                            System.out.print("Enter Supplier Email: ");
                                            addSemail = isValidEmailAddress(in);
                                            if (addSemail.equals("0")) {break;}
                                            System.out.print("Enter Supplier Contact Info: ");
                                            addContact = in.next();
                                            admin.addNewSupplier(addSname, addSemail, addContact);
                                            System.out.println("Supplier ID: " + admin.getSuppliers().getLast().getId());
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        default:
                                            System.out.println("Invalid choice");

                                    }
                                    System.out.println();
                                    break;
                                case 7:
                                    System.out.println("------------------------");
                                    System.out.println("| 1. Edit Cashier       |");
                                    System.out.println("| 2. Edit Customer      |");
                                    System.out.println("| 3. Edit Supplier      |");
                                    System.out.println("------------------------");
                                    System.out.print("Enter your choice: ");
                                    innerChoice = in.nextInt();
                                    switch (innerChoice) {
                                        case 1:
                                            String editCAid, editCAfield, editCAvalue;

                                            System.out.print("Enter Cashier ID: ");
                                            editCAid = CheckCashierExistence(admin,in,false);
                                            if (editCAid.equals("0")) {break;}
                                            System.out.print("Enter the field you want to edit: ");
                                            editCAfield = in.next();
                                            System.out.print("Enter new value: ");
                                            editCAvalue = in.next();

                                            admin.editCashier(editCAid, editCAfield, editCAvalue);
                                            System.out.println();
                                            break;
                                        case 2:
                                            String editCUid, editCUfield, editCUvalue;

                                            System.out.print("Enter Customer ID: ");
                                            editCUid = CheckCustomerExistence(admin,in,false);
                                            if (editCUid.equals("0")) {break;}
                                            System.out.print("Enter the field you want to edit: ");
                                            editCUfield = in.next();
                                            System.out.print("Enter new value: ");
                                            editCUvalue = in.next();

                                            admin.editCustomer(editCUid, editCUfield, editCUvalue);
                                            System.out.println();
                                            break;
                                        case 3:
                                            String editSid, editSfield, editSvalue;

                                            System.out.print("Enter Supplier ID: ");
                                            editSid = CheckSupplierExistence(admin,in,false);
                                            if (editSid.equals("0")) {break;}
                                            System.out.print("Enter the field you want to edit: ");
                                            editSfield = in.next();
                                            System.out.print("Enter new value: ");
                                            editSvalue = in.next();

                                            admin.editSupplier(editSid, editSfield, editSvalue);
                                            System.out.println();
                                            break;
                                        default:
                                            System.out.println("Invalid choice");

                                    }
                                    System.out.println();
                                    break;
                                case 8:
                                    System.out.println("------------------------");
                                    System.out.println("| 1. Remove Cashier    |");
                                    System.out.println("| 2. Remove Customer   |");
                                    System.out.println("| 3. Remove Supplier   |");
                                    System.out.println("------------------------");
                                    System.out.print("Enter your choice: ");
                                    innerChoice = in.nextInt();
                                    switch (innerChoice) {
                                        case 1:
                                            String removeCAid;
                                            System.out.print("Enter ID of Cashier to be removed: ");
                                            removeCAid = CheckCashierExistence(admin,in,false);
                                            if (removeCAid.equals("0")) {break;}
                                            admin.removeCashier(admin.searchCashierByField("id", removeCAid).getId());
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        case 2:
                                            String removeCUid;
                                            System.out.print("Enter ID of Customer to be removed: ");
                                            removeCUid = CheckCustomerExistence(admin,in,false);
                                            if (removeCUid.equals("0")) {break;}
                                            admin.removeCustomer(admin.searchCustomerByField("id", removeCUid).getId());
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        case 3:
                                            String removeSid;
                                            System.out.print("Enter ID of Supplier to be removed: ");
                                            removeSid = CheckSupplierExistence(admin,in,false);
                                            if (removeSid.equals("0")) {break;}
                                            admin.removeSupplier(admin.searchSupplierByField("id", removeSid).getId());
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        default:
                                            System.out.println("Invalid choice");

                                    }
                                    System.out.println();
                                    break;
                                case 9:
                                    System.out.println("----------------------------");
                                    System.out.println("| 1. Search dor a Cashier  |");
                                    System.out.println("| 2. Search for a Customer |");
                                    System.out.println("| 3. Search for a Supplier |");
                                    System.out.println("----------------------------");
                                    System.out.print("Enter your choice: ");
                                    innerChoice = in.nextInt();
                                    switch (innerChoice) {
                                        case 1:
                                            String searchCAfield, searchCAvalue;
                                            System.out.print("Enter Search Field: ");
                                            searchCAfield = in.next();
                                            System.out.print("Enter value to search with: ");
                                            searchCAvalue = in.next();
                                            if(admin.searchCashierByField(searchCAfield, searchCAvalue) == null) {
                                                System.out.println("Cashier not found");
                                                break;
                                            }
                                            System.out.println("Cashier you searched for: " + admin.searchCashierByField(searchCAfield, searchCAvalue));
                                            System.out.println();
                                            break;
                                        case 2:
                                            String searchCUfield, searchCUvalue;
                                            System.out.print("Enter Search Field: ");
                                            searchCUfield = in.next();
                                            System.out.print("Enter value to search with: ");
                                            searchCUvalue = in.next();
                                            if(admin.searchCustomerByField(searchCUfield, searchCUvalue) == null) {
                                                System.out.println("Customer not found");
                                                break;
                                            }
                                            System.out.println("Customer you searched for: "
                                                    + admin.searchCustomerByField(searchCUfield, searchCUvalue));
                                            System.out.println();
                                            break;
                                        case 3:
                                            String searchSfield, searchSvalue;
                                            System.out.print("Enter Search Field: ");
                                            searchSfield = in.next();
                                            System.out.print("Enter value to search with: ");
                                            searchSvalue = in.next();
                                            if(admin.searchSupplierByField(searchSfield, searchSvalue) == null) {
                                                System.out.println("Supplier not found");
                                                break;
                                            }
                                            System.out.println("Supplier you searched for: "
                                                    + admin.searchSupplierByField(searchSfield, searchSvalue));
                                            System.out.println();
                                            break;
                                        default:
                                            System.out.println("Invalid choice");

                                    }
                                    System.out.println();
                                    break;
                                case 10:
                                    System.out.println("-----------------------------------");
                                    System.out.println("| 1. View Reports About Cashiers  |");
                                    System.out.println("| 2. View Reports About Customers |");
                                    System.out.println("| 3. View Reports About Suppliers |");
                                    System.out.println("-----------------------------------");
                                    System.out.print("Enter your choice: ");
                                    innerChoice = in.nextInt();
                                    switch (innerChoice) {
                                        case 1:
                                            admin.viewCashierReport();
                                            System.out.println();
                                            break;
                                        case 2:
                                            admin.viewCustomerReport();
                                            System.out.println();
                                            break;
                                        case 3:
                                            admin.viewSupplierReport();
                                            System.out.println();
                                            break;
                                        default:
                                            System.out.println("Invalid choice");

                                    }
                                    System.out.println();
                                    break;
                                case 11:
                                    admin.viewOrdersReport();
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("You are now logged out");
                                    System.out.println();
                                    break;
                            }
                        } while (innerChoice != 12);
                    }
                    break;
                case 2:
                    System.out.println("New Customer? (enter 1 for yes and 0 for no)");
                    int CUanswer = in.nextInt();
                    String CUid, CUname, CUemail;
                    if (CUanswer == 1) {
                        System.out.print("Enter you name: ");
                        CUname = in.next();
                        System.out.print("Enter your email: ");
                        CUemail = isValidEmailAddress(in);
                        if (CUemail.equals("0")) {break;}
                        customer = new Customer(CUname, CUemail);
                    }
                    else if (CUanswer == 0) {
                        System.out.print("Enter your ID: ");
                        CUid = in.next();
                        customer = admin.searchCustomerByField("id", CUid);
                    }
                    else System.out.println("Invalid choice");

                    do {
                        System.out.println("Customer Menu:");
                        System.out.println("------------------------------------");
                        System.out.println("| 1. View Orders History           |");
                        System.out.println("| 2. Rate Order                    |");
                        System.out.println("| 3. LogOut                        |");
                        System.out.println("------------------------------------");
                        System.out.print("Enter your choice: ");
                        innerChoice = in.nextInt();

                        switch (innerChoice) {
                            case 1:
                                if (customer != null) {
                                    customer.displayOrderHistory();
                                }
                                System.out.println();
                                System.out.println();
                                break;
                            case 2:
                                String orderID;
                                int rating;
                                System.out.print("Enter ID of Order: ");
                                orderID = in.next();
                                admin.searchCartByField("id", orderID);
                                System.out.println("Enter you rating out of 10: ");
                                rating = in.nextInt();
                                if (customer != null) {
                                    customer.rateOrder(admin.searchCartByField("id", orderID), rating);
                                }
                                System.out.println();
                                break;
                            default:
                                System.out.println("You are now logged out");
                                System.out.println();
                                break;
                        }
                    } while(innerChoice != 3);
                    break;
                case 3:
                    System.out.println("New Cashier? Contact admin to add new cashier");
                    String CAid;

                    System.out.print("Enter your ID: ");
                    CAid = in.next();
                    cashier = admin.searchCashierByField("id", CAid);
                    System.out.println("Invalid choice");

                    do {
                        System.out.println("Cashier Menu:");
                        System.out.println("------------------------------------");
                        System.out.println("| 1. Create Cart                   |");
                        System.out.println("| 2. Add Product to Cart           |");
                        System.out.println("| 3. Remove Product from Cart      |");
                        System.out.println("| 4. Calculate Payment             |");
                        System.out.println("| 5. Cancel Cart                   |");
                        System.out.println("| 6. LogOut                        |");
                        System.out.println("------------------------------------");
                        System.out.print("Enter your choice: ");
                        innerChoice = in.nextInt();

                        switch (innerChoice) {
                            case 1:
                                System.out.println("Create Cart");
                                System.out.print("Enter Customer ID: ");
                                String name = CheckCustomerExistence(admin, in, false);
                                if (name.equals("0")) {break;}
                                customer = admin.searchCustomerByField("id", name);
                                cart = new Cart(customer, cashier);
                                System.out.println("Cart created successfully!");
                                admin.getOrders().add(cart);
                                TimeUnit.SECONDS.sleep(1);
                                break;
                            case 2:
                                String repeater = "1";
                                String cartID = null;
                                do {


                                    System.out.println("Add Product to Cart");

                                    if (cart != null) {
                                        System.out.println("Current cart: " + cart);
                                        //

                                    } else {
                                        System.out.println("Enter Cart ID: ");
                                        cartID = CheckCartExistence(admin, in, false);
                                        if (cartID.equals("0")) {
                                            break;
                                        }
                                        cart = admin.searchCartByField("id", cartID);
                                        System.out.println("Current cart: " + cart);
                                    }

                                    System.out.print("Enter Product name: ");
                                    name = CheckProductExistence(admin, in, false);
                                    if (name.equals("0")) {
                                        break;
                                    }

                                    System.out.print("Enter Product Quantity: ");
                                    int quantity = in.nextInt();

                                    cart.addProduct(admin.searchProductByField("name", name), quantity);

                                    System.out.println("Enter 1 if you would like to add another product or anything else to exit:");
                                    repeater = in.next();
                                    TimeUnit.SECONDS.sleep(1);
                                }while (repeater.equals("1"));
                                break;
                            case 3:
                                System.out.println("Remove Product from Cart");

                                if (cart != null) {
                                    System.out.println("Current cart: " + cart);
                                    //

                                } else {
                                    System.out.println("Enter Cart ID: ");
                                    cartID = CheckCartExistence(admin, in, false);
                                    if (cartID.equals("0")) {
                                        break;
                                    }
                                    cart = admin.searchCartByField("id", cartID);
                                    System.out.println("Current cart: " + cart);
                                }
                                System.out.print("Enter Product name: ");
                                name = CheckProductExistence(admin, in, false);
                                if (name.equals("0")) {break;}

                                cart.removeProduct(admin.searchProductByField("name", name));
                                System.out.println("Product removed successfully!");
                                TimeUnit.SECONDS.sleep(1);
                                break;
                            case 4:
                                System.out.println("Calculate Payment");
                                if (cart != null) {
                                    System.out.println("Current cart: " + cart);
                                    //

                                } else {
                                    System.out.println("Enter Cart ID: ");
                                    cartID = CheckCartExistence(admin, in, false);
                                    if (cartID.equals("0")) {
                                        break;
                                    }
                                    cart = admin.searchCartByField("id", cartID);
                                    System.out.println("Current cart: " + cart);
                                }

                                boolean answer = false;
                                System.out.println("Are you sure you want to checkout?");
                                answer = in.nextBoolean();
                                if (answer) {
                                    cart.setStatus(Cart.Status.COMPLETED);
                                    System.out.println("Checkout successful!");
                                    TimeUnit.SECONDS.sleep(1);
                                    break;
                                }
                                else
                                    System.out.println("Checkout failed!");
                                TimeUnit.SECONDS.sleep(1);
                                System.out.println();
                                break;
                            case 5:

                                if (cart != null) {
                                    System.out.println("Current cart: " + cart);
                                    //

                                } else {
                                    System.out.println("Enter Cart ID: ");
                                    cartID = CheckCartExistence(admin, in, false);
                                    if (cartID.equals("0")) {
                                        break;
                                    }
                                    cart = admin.searchCartByField("id", cartID);
                                    System.out.println("Current cart: " + cart);
                                }

                                answer = false;
                                System.out.println("Are you sure you want to cancel the cart?");
                                answer = in.nextBoolean();
                                if (answer)
                                {
                                    cart.cancelCart();
                                    admin.getOrders().remove(cart);
                                    System.out.println("Cart cancelled successfully!");
                                    TimeUnit.SECONDS.sleep(1);
                                    break;
                                }
                                else
                                    System.out.println("Cart cancellation failed!");
                                TimeUnit.SECONDS.sleep(1);
                                System.out.println();
                                break;
                            default:
                                System.out.println("You are now logged out");
                                System.out.println();
                        }
                    } while(innerChoice != 6);
                    break;
                default:
                    System.out.println("Exiting Program");
            }
        } while(choice != 4);




        admin.saveData();

 */
    }// end of main

    public static String CheckSupplierExistence(Admin admin, Scanner in, Boolean exists) {
        String supplierId;

        if (exists) {
            do {
                supplierId = in.next();
                if (supplierId.equals("0")) {break;}
                else if (admin.searchSupplierByField("id", supplierId) != null) {
                    System.out.println("Supplier already exists! \nTry again");
                    System.out.print("Enter Supplier ID or 0 to cancel: ");
                }
            }while (admin.searchSupplierByField("id", supplierId) != null);
        }

        else
        {
            do {
                supplierId = in.next();
                if (supplierId.equals("0")) {break;}
                else if (admin.searchSupplierByField("id", supplierId) == null) {
                    System.out.println("Supplier doesn't exist! \nTry again");
                    System.out.print("Enter Supplier ID or 0 to cancel: ");
                }
            }while (admin.searchSupplierByField("id", supplierId) == null);
        }

        return supplierId;
    }

    public static String CheckProductExistence(Admin admin, Scanner in, Boolean exists) {
        String name;
        if (exists) {
            do {
                name = in.next();
                if (name.equals("0")) {break;}
                else if (admin.searchProductByField("name", name) != null) {
                    System.out.println("Product already exists! \nTry again");
                    System.out.print("Enter Product Name or 0 to cancel: ");
                }
            }while (admin.searchProductByField("name", name) != null);
        }
        else
        {
            do {
                name = in.next();
                if (name.equals("0")) {break;}
                else if (admin.searchProductByField("name", name) == null) {
                    System.out.println("Product doesn't exist! \nTry again");
                    System.out.print("Enter Product Name or 0 to cancel: ");
                }
            }while (admin.searchProductByField("name", name) == null);
        }
        return name;
    }

    public static String CheckCustomerExistence(Admin admin, Scanner in, Boolean exists) {
        String customerId = in.next();

        if (exists) {
            while (admin.searchCustomerByField("id", customerId) != null)
            {
                customerId = in.next();
                if (customerId.equals("0")) {break;}
                else if (admin.searchCustomerByField("id", customerId) != null) {
                    System.out.println("Customer already exists! \nTry again");
                    System.out.print("Enter Customer ID or 0 to cancel: ");
                }
            }
        }
        else
        {
            while (admin.searchCustomerByField("id", customerId) == null) {
                customerId = in.next();
                if (customerId.equals("0")) {break;}
                else if (admin.searchCustomerByField("id", customerId) == null) {
                    System.out.println("Customer doesn't exist! \nTry again");
                    System.out.print("Enter Customer ID or 0 to cancel: ");
                }
            }
        }
        return customerId;
    }
    public static String CheckCashierExistence(Admin admin, Scanner in, Boolean exists) {
        String cashierId;
        if (exists) {
            do {
                cashierId = in.next();
                if (cashierId.equals("0")) {break;}
                else if (admin.searchCashierByField("id", cashierId) != null) {
                    System.out.println("Cashier already exists! \nTry again");
                    System.out.print("Enter Cashier ID or 0 to cancel: ");
                }
            }while (admin.searchCashierByField("id", cashierId) != null);
        }
        else
        {
            do {
                cashierId = in.next();
                if (cashierId.equals("0")) {break;}
                else if (admin.searchCashierByField("id", cashierId) == null) {
                    System.out.println("Cashier doesn't exist! \nTry again");
                    System.out.println("Enter Cashier ID or 0 to cancel: ");
                }
            }while (admin.searchCashierByField("id", cashierId) == null);
        }
        return cashierId;
    }
    public static String CheckCartExistence(Admin admin, Scanner in, Boolean exists) {
        String cartId;
        if (exists) {
            do {
                cartId = in.next();
                if (cartId.equals("0")) {break;}
                else if (admin.searchCartByField("id", cartId) != null) {
                    System.out.println("Cart already exists! \nTry again");
                    System.out.print("Enter Cart ID or 0 to cancel: ");
                }
            }while (admin.searchCartByField("id", cartId) != null);
        }
        else
        {
            do {

                cartId = in.next();
                if (cartId.equals("0")) {break;}
                else if (admin.searchCartByField("id", cartId) == null) {
                    System.out.println("Cart doesn't exist! \nTry again");
                    System.out.print("Enter Cart ID or 0 to cancel: ");
                }
            }while (admin.searchCartByField("id", cartId) == null);
        }
        return cartId;
    }

    public static String isValidEmailAddress(Scanner in) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m;
        String email;
        do {
            email = in.next();
            m = p.matcher(email);
            if (!m.matches()) {
                System.out.println("Invalid Email Address \nTry again or enter 0 to cancel:");
            }
        } while (!m.matches() || email.equals("0"));
        return email;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        launch(args);
    }

}// end of class
