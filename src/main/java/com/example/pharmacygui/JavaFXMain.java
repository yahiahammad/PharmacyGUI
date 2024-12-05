package com.example.pharmacygui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


public class JavaFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.getIcons().add(new Image(new FileInputStream("src/main/java/com/example/pharmacygui/resources/Project_Icon.png")));
        Scene mainMenuScene, adminLoginScene , scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10;
        Admin admin = new Admin("Rina", "Rina123@gmail.com", "1234");

        //**************************************************
        Button mainMenu_adminButton = new Button("Admin");
        Button customer = new Button("Customer");
        Button cashier = new Button("Cashier");
        Button exit = new Button("Exit");

        VBox vbox1 = new VBox(new Label("Choose your role"), mainMenu_adminButton, customer, cashier, exit);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(10);
        mainMenuScene = new Scene(vbox1, 300, 250);
        primaryStage.setScene(mainMenuScene);

        exit.setOnAction(e -> primaryStage.close());

        //***********************************************************

        PasswordField adminPasswordTextField = new PasswordField();
        Label adminPasswordLabel = new Label("Password: ");
        Label adminWrongPasswordLabel = new Label("Wrong Password, try again");
        adminWrongPasswordLabel.setTextFill(Color.RED);
        adminWrongPasswordLabel.setVisible(false);
        Button adminPasswordBackButton = new Button("Back");

        HBox adminLoginHbox = new HBox(adminPasswordLabel, adminPasswordTextField, adminPasswordBackButton);
        adminLoginHbox.setAlignment(Pos.CENTER);
        adminLoginHbox.setSpacing(10);

        VBox adminLoginVbox = new VBox(adminLoginHbox, adminWrongPasswordLabel);
        adminLoginVbox.setAlignment(Pos.CENTER);
        adminLoginVbox.setSpacing(10);

        adminLoginScene = new Scene(adminLoginVbox, 400,400);

        adminPasswordBackButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        mainMenu_adminButton.setOnAction(e -> primaryStage.setScene(adminLoginScene));














        //************************************************************
        Button adminMenu_addProduct = new Button("Add New Product");
        Button adminMenu_editProduct = new Button("Edit Product");
        Button adminMenu_removeProduct = new Button("Remove Product");
        Button adminMenu_searchProduct = new Button("Search for a Product");
        Button adminMenu_productReport = new Button("View Reports About Products");
        Button adminMenu_addUser = new Button("Add User");
        Button adminMenu_editUser = new Button("Edit User");
        Button adminMenu_removeUser = new Button("Remove User");
        Button adminMenu_searchUser = new Button("Search for a User");
        Button adminMenu_userReport = new Button("View Report About Users");
        Button adminMenu_orderReport = new Button("View Report About Orders");
        Button adminMenu_logOut = new Button("Log Out");

        VBox vbox2 = new VBox(new Label("What would you like to do?"), adminMenu_addProduct, adminMenu_editProduct, adminMenu_removeProduct, adminMenu_searchProduct, adminMenu_addUser, adminMenu_editUser, adminMenu_removeUser, adminMenu_searchUser, adminMenu_userReport, adminMenu_orderReport, adminMenu_logOut);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);
        scene4 = new Scene(vbox2, 350, 450);
        adminPasswordTextField.setOnAction(e -> {
            if (adminPasswordTextField.getText().equals(admin.getPassword())) {
                adminPasswordTextField.setText("");
                primaryStage.setScene(scene4);
            }
            else
            {
                adminPasswordTextField.setText("");
                adminWrongPasswordLabel.setVisible(true);
            }
        });

        adminMenu_addProduct.setOnAction(e -> {
            FlowPane adminMenu_addProductFlowPane = new FlowPane();
            adminMenu_addProductFlowPane.setAlignment(Pos.CENTER);
            System.out.print("Enter Product Name: ");
            TextField adminMenu_addProduct_ProductName = new TextField();
            //if (addPname.equals("0")) {break;}
            System.out.print("Enter Product Price: ");
            TextField adminMenu_addProduct_ProductPrice = new TextField();
            System.out.print("Enter Product Quantity: ");
            TextField adminMenu_addProduct_ProductQuantity = new TextField();
            System.out.print("Enter Product Supplier ID: ");
            TextField adminMenu_addProduct_ProductSupplierID = new TextField();
            //if (addPsupplierName.equals("0")) {break;}
            System.out.print("Enter Product Expiration Date: ");
            TextField adminMenu_addProduct_ProductExpirationDate = new TextField();
            //admin.addNewProduct(addPname, addPprice, addPquantity, admin.searchSupplierByField("id", addPsupplierName), addPexpDate);
            //System.out.println("Product ID: " + admin.getProducts().getLast().getProductId());

        });

        VBox pane3 = new VBox();
        pane3.setAlignment(Pos.CENTER);

        Label label1 = new Label("Enter Product Name: ");
        TextField adminMenu_editProduct_ProductName = new TextField();
        adminMenu_editProduct_ProductName.getCharacters();
        //HBox h1 = new HBox(label1, adminMenu_editProduct_ProductName);

        Label label2 = new Label("Enter the field you want to edit: ");
        TextField adminMenu_editProduct_ProductField = new TextField();
        //HBox h2 = new HBox(label2, adminMenu_editProduct_ProductField);

        Label lb3 = new Label("Enter new value: ");
        TextField adminMenu_editProduct_ProductValue = new TextField();
        //HBox h3 = new HBox(lb3, adminMenu_editProduct_ProductValue);

        VBox v1 = new VBox(label1, label2, lb3);
        VBox v2 = new VBox(adminMenu_editProduct_ProductName, adminMenu_editProduct_ProductField, adminMenu_editProduct_ProductValue);
        HBox h4 = new HBox(v1, v2);
        h4.setAlignment(Pos.CENTER);
        h4.setPadding(new Insets(10, 10, 10, 10));

        Button bt1 = new Button("Cancel");
        Button bt2 = new Button("Confirm");
        //pane3.getChildren().addAll(h1, h2, h3);
        Scene sc = new Scene(h4, 350, 300);
        adminMenu_editProduct.setOnAction(e -> primaryStage.setScene(sc));


        /*System.out.print("Enter Product Name: ");
        editPid = CheckProductExistence(admin,in,false);
        if (editPid.equals("0")) {break;}
        editPid = admin.searchProductByField("name",editPid).getProductId();
        System.out.print("Enter the field you want to edit: ");
        editPfield = in.next();
        System.out.print("Enter new value: ");
        editPvalue = in.next();

        admin.editProduct(editPid, editPfield, editPvalue);
        TimeUnit.SECONDS.sleep(1);*/


        adminMenu_removeProduct.setOnAction(e -> System.out.println("Remove Product"));
        adminMenu_searchProduct.setOnAction(e -> System.out.println("Search for a Product"));
        adminMenu_productReport.setOnAction(e -> System.out.println("View Reports About Products"));
        adminMenu_userReport.setOnAction(e -> System.out.println("View Report About Users"));
        adminMenu_orderReport.setOnAction(e -> System.out.println("View Report About Orders"));
        adminMenu_logOut.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        //***********************************************************
        Label label6 = new Label("Click on your choice");
        Button addCashier = new Button("Add New Cashier");
        Button addCustomer = new Button("Add New Customer");
        Button addSupplier = new Button("Add New Supplier");
        Button back1 = new Button("Back");

        VBox vbox4 = new VBox(label6, addCashier, addCustomer, addSupplier, back1);
        vbox4.setAlignment(Pos.CENTER);
        vbox4.setSpacing(10);
        scene6 = new Scene(vbox4, 300, 250);
        adminMenu_addUser.setOnAction(e -> primaryStage.setScene(scene6));

        addCashier.setOnAction(e -> System.out.println("Add New Cashier"));
        addCustomer.setOnAction(e -> System.out.println("Add New Customer"));
        addSupplier.setOnAction(e -> System.out.println("Add New Supplier"));
        back1.setOnAction(e -> primaryStage.setScene(scene4));

        //***********************************************************
        Label label7 = new Label("Click on your choice");
        Button editCashier = new Button("Edit Cashier");
        Button editCustomer = new Button("Edit Customer");
        Button editSupplier = new Button("Edit Supplier");
        Button back2 = new Button("Back");

        VBox vbox5 = new VBox(label7, editCashier, editCustomer, editSupplier, back2);
        vbox5.setAlignment(Pos.CENTER);
        vbox5.setSpacing(10);
        scene7 = new Scene(vbox5, 300, 250);
        adminMenu_editUser.setOnAction(e -> primaryStage.setScene(scene7));

        editCashier.setOnAction(e -> System.out.println("Edit Cashier"));
        editCustomer.setOnAction(e -> System.out.println("Edit Customer"));
        editSupplier.setOnAction(e -> System.out.println("Edit Supplier"));
        back2.setOnAction(e -> primaryStage.setScene(scene4));

        //***********************************************************
        Label label8 = new Label("Click on you choice");
        Button removeCashier = new Button("Remove Cashier");
        Button removeCustomer = new Button("Remove Customer");
        Button removeSupplier = new Button("Remove Supplier");
        Button back3 = new Button("Back");

        VBox vbox6 = new VBox(label8, removeCashier, removeCustomer, removeSupplier, back3);
        vbox6.setAlignment(Pos.CENTER);
        vbox6.setSpacing(10);
        scene8 = new Scene(vbox6, 300, 250);
        adminMenu_removeUser.setOnAction(e -> primaryStage.setScene(scene8));

        removeCashier.setOnAction(e -> System.out.println("Remove Cashier"));
        removeCustomer.setOnAction(e -> System.out.println("Remove Customer"));
        removeSupplier.setOnAction(e -> System.out.println("Remove Supplier"));
        back3.setOnAction(e -> primaryStage.setScene(scene4));

        //***********************************************************
        Label label9 = new Label("Click on your choice");
        Button searchCashier = new Button("Search for a Cashier");
        Button searchCustomer = new Button("Search for a Customer");
        Button searchSupplier = new Button("Search for a Supplier");
        Button back4 = new Button("Back");

        VBox vbox7 = new VBox(label9, searchCashier, searchCustomer, searchSupplier, back4);
        vbox7.setAlignment(Pos.CENTER);
        vbox7.setSpacing(10);
        scene9 = new Scene(vbox7, 300, 250);
        adminMenu_searchUser.setOnAction(e -> primaryStage.setScene(scene9));

        searchCashier.setOnAction(e -> System.out.println("Search for a Cashier"));
        searchCustomer.setOnAction(e -> System.out.println("Search for a Customer"));
        searchSupplier.setOnAction(e -> System.out.println("Search for a Supplier"));
        back4.setOnAction(e -> primaryStage.setScene(scene4));

        //***********************************************************
        Label label10 = new Label("Click on your choice");
        Button cashierReport = new Button("View Report About Cashiers");
        Button customerReport = new Button("View Report About Customers");
        Button supplierReport = new Button("View Report About Suppliers");
        Button back5 = new Button("Back");

        VBox vbox8 = new VBox(cashierReport, customerReport, supplierReport, back5);
        vbox8.setAlignment(Pos.CENTER);
        vbox8.setSpacing(10);
        scene10 = new Scene(vbox8, 300, 250);
        adminMenu_userReport.setOnAction(e -> primaryStage.setScene(scene10));

        cashierReport.setOnAction(e -> System.out.println("View Report About Cashiers"));
        customerReport.setOnAction(e -> System.out.println("View Report About Customers"));
        supplierReport.setOnAction(e -> System.out.println("View Report About Suppliers"));
        back5.setOnAction(e -> primaryStage.setScene(scene4));

        //***********************************************************
        Label label3 = new Label("What would you like to do?");
        Button viewOrders = new Button("View Orders History");
        Button rateOrder = new Button("Rate Order");
        Button LogOut = new Button("Log Out");
        viewOrders.setOnAction(e -> System.out.println("View Orders History"));
        LogOut.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        VBox vbox = new VBox(label3, viewOrders, rateOrder, LogOut);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        scene2 = new Scene(vbox, 300, 250);
        customer.setOnAction(e -> primaryStage.setScene(scene2));

        //*****************************************************
        Label label4 = new Label("Rate:");
        TextField textField = new TextField();
        Button bt = new Button("Done");
        HBox hb = new HBox();
        hb.getChildren().addAll(label4, textField, bt);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        scene3 = new Scene(hb, 300, 50);
        rateOrder.setOnAction(e -> primaryStage.setScene(scene3));
        bt.setOnAction(e -> primaryStage.setScene(scene2));

        //**********************************************************
        Label label5 = new Label("What would you like to do?");
        Button createCart = new Button("Create Cart");
        Button addProToCart = new Button("Add Product to Cart");
        Button removeProFromCart = new Button("Remove Product from Cart");
        Button payment = new Button("Calculate Payment");
        Button cancelCart = new Button("Cancel Cart");
        Button lg = new Button("Log Out");

        VBox vbox3 = new VBox(label5, createCart, addProToCart, removeProFromCart, payment, cancelCart, lg);
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(10);
        scene5 = new Scene(vbox3, 300, 250);
        cashier.setOnAction(e -> primaryStage.setScene(scene5));

        createCart.setOnAction(e -> System.out.println("Create Cart"));
        addProToCart.setOnAction(e -> System.out.println("Add Product to Cart"));
        removeProFromCart.setOnAction(e -> System.out.println("Remove Product from Cart"));
        payment.setOnAction(e -> System.out.println("Calculate Payment"));
        cancelCart.setOnAction(e -> System.out.println("Cancel Cart"));
        lg.setOnAction(e -> primaryStage.setScene(mainMenuScene));


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
