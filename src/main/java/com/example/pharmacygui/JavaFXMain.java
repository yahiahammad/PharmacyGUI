package com.example.pharmacygui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class JavaFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pharmacy Management System");
        Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10;

        //**************************************************
        Button admin = new Button("Admin");
        Button customer = new Button("Customer");
        Button cashier = new Button("Cashier");
        Button exit = new Button("Exit");

        VBox vbox1 = new VBox(new Label("Choose your role"), admin, customer, cashier, exit);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(10);
        scene1 = new Scene(vbox1, 300, 250);
        primaryStage.setScene(scene1);

        exit.setOnAction(e -> primaryStage.close());

        //***********************************************************
        Button addProduct = new Button("Add New Product");
        Button editProduct = new Button("Edit Product");
        Button removeProduct = new Button("Remove Product");
        Button searchProduct = new Button("Search for a Product");
        Button productReport = new Button("View Reports About Products");
        Button addUser = new Button("Add User");
        Button editUser = new Button("Edit User");
        Button removeUser = new Button("Remove User");
        Button searchUser = new Button("Search for a User");
        Button userReport = new Button("View Report About Users");
        Button orderReport = new Button("View Report About Orders");
        Button logOut = new Button("Log Out");

        VBox vbox2 = new VBox(new Label("What would you like to do?"), addProduct, editProduct, removeProduct, searchProduct, addUser, editUser, removeUser, searchUser, userReport, orderReport, logOut);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);
        scene4 = new Scene(vbox2, 350, 450);
        admin.setOnAction(e -> primaryStage.setScene(scene4));

        addProduct.setOnAction(e -> System.out.println("Add New Product"));
        editProduct.setOnAction(e -> System.out.println("Edit Product"));
        removeProduct.setOnAction(e -> System.out.println("Remove Product"));
        searchProduct.setOnAction(e -> System.out.println("Search for a Product"));
        productReport.setOnAction(e -> System.out.println("View Reports About Products"));
        userReport.setOnAction(e -> System.out.println("View Report About Users"));
        orderReport.setOnAction(e -> System.out.println("View Report About Orders"));
        logOut.setOnAction(e -> primaryStage.setScene(scene1));

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
        addUser.setOnAction(e -> primaryStage.setScene(scene6));

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
        editUser.setOnAction(e -> primaryStage.setScene(scene7));

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
        removeUser.setOnAction(e -> primaryStage.setScene(scene8));

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
        searchUser.setOnAction(e -> primaryStage.setScene(scene9));

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
        userReport.setOnAction(e -> primaryStage.setScene(scene10));

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
        LogOut.setOnAction(e -> primaryStage.setScene(scene1));

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
        lg.setOnAction(e -> primaryStage.setScene(scene1));


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
