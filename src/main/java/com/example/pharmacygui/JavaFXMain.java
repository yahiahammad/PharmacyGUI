package com.example.pharmacygui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;


public class JavaFXMain extends Application {

    Admin admin = new Admin("Rina", "Rina123@gmail.com", "1234");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.getIcons().add(new Image(new FileInputStream("src/main/java/com/example/pharmacygui/resources/Project_Icon.png")));
        Scene mainMenuScene, adminLoginScene , scene2, scene3, adminMenuScene, scene5, adminMenu_addUserScene, scene7, scene8, scene9, scene10;

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
        adminMenuScene = new Scene(vbox2, 350, 450);
        adminPasswordTextField.setOnAction(e -> {
            if (adminPasswordTextField.getText().equals(admin.getPassword())) {
                adminPasswordTextField.setText("");
                primaryStage.setScene(adminMenuScene);
            }
            else
            {
                adminPasswordTextField.setText("");
                adminWrongPasswordLabel.setVisible(true);
            }
        });

        //****************************************************************************
        adminMenu_addProduct.setOnAction(e -> {
            GridPane adminMenu_addProductGridPane = new GridPane();
            adminMenu_addProductGridPane.setAlignment(Pos.CENTER);

            Label productName= new Label("Enter Product Name: ");
            Label adminMenu_addProduct_ProductNameWarning = new Label("Product Already Exists!");
            adminMenu_addProduct_ProductNameWarning.setTextFill(Color.RED);
            adminMenu_addProduct_ProductNameWarning.setVisible(false);
            TextField adminMenu_addProduct_ProductName = new TextField();

            Label productPrice = new Label("Enter Product Price: ");
            TextField adminMenu_addProduct_ProductPrice = new TextField();

            Label productQuantity =  new Label("Enter Product Quantity: ");
            TextField adminMenu_addProduct_ProductQuantity = new TextField();

            Label productSupplier = new Label("Enter Product Supplier ID: ");
            Label adminMenu_addProduct_SupplierIDWarning= new Label("Supplier Doesn't Exist!");
            adminMenu_addProduct_SupplierIDWarning.setTextFill(Color.RED);
            adminMenu_addProduct_SupplierIDWarning.setVisible(false);
            TextField adminMenu_addProduct_ProductSupplierID = new TextField();

            Label productExpirationDate = new Label("Enter Product Expiration Date: ");
            TextField adminMenu_addProduct_ProductExpirationDate = new TextField("yyyy-MM-dd");

            Button adminMenu_addProductButton = new Button("Add Product");
            Button adminMenu_addProductCancelButton= new Button("Cancel");
            adminMenu_addProductButton.setAlignment(Pos.CENTER);

            adminMenu_addProductGridPane.add(productName, 0, 0);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductName, 1, 0);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductNameWarning, 2, 0);
            adminMenu_addProductGridPane.add(productPrice, 0, 1);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductPrice, 1, 1);
            adminMenu_addProductGridPane.add(productQuantity, 0, 2);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductQuantity, 1, 2);
            adminMenu_addProductGridPane.add(productSupplier, 0, 3);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductSupplierID, 1, 3);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_SupplierIDWarning,2,3);
            adminMenu_addProductGridPane.add(productExpirationDate, 0, 4);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductExpirationDate, 1, 4);
            adminMenu_addProductGridPane.add(adminMenu_addProductButton, 1, 5);
            adminMenu_addProductGridPane.add(adminMenu_addProductCancelButton, 1, 6);

            adminMenu_addProductGridPane.setHgap(10);
            adminMenu_addProductGridPane.setVgap(10);

            Scene scene = new Scene(adminMenu_addProductGridPane,500,500);
           primaryStage.setScene(scene);

            //************************************************************
            adminMenu_addProductButton.setOnAction(e1 ->{
               if (CheckProductExistence(admin,adminMenu_addProduct_ProductName.getText()) || !CheckSupplierExistence(admin, adminMenu_addProduct_ProductSupplierID.getText()))
               {
                   if (CheckProductExistence(admin,adminMenu_addProduct_ProductName.getText()))
                   {
                       adminMenu_addProduct_ProductNameWarning.setVisible(true);
                       adminMenu_addProduct_ProductName.setText("");
                   }
                   else
                   {
                       adminMenu_addProduct_ProductNameWarning.setVisible(false);
                   }
                   if (!CheckSupplierExistence(admin, adminMenu_addProduct_ProductSupplierID.getText()))
                   {
                       adminMenu_addProduct_SupplierIDWarning.setVisible(true);
                       adminMenu_addProduct_ProductSupplierID.setText("");
                   }
                   else
                   {
                       adminMenu_addProduct_SupplierIDWarning.setVisible(false);
                   }
               }
               else
               {
                   adminMenu_addProduct_ProductNameWarning.setVisible(false);
                   adminMenu_addProduct_SupplierIDWarning.setVisible(false);
                   if (admin.addNewProduct(adminMenu_addProduct_ProductName.getText(),Double.parseDouble(adminMenu_addProduct_ProductPrice.getText()),Integer.parseInt(adminMenu_addProduct_ProductQuantity.getText()), admin.searchSupplierByField("id",adminMenu_addProduct_ProductSupplierID.getText()), LocalDate.parse(adminMenu_addProduct_ProductExpirationDate.getText())))
                   {
                       Alert adminMenu_addProduct_ProductAddedAlert = new Alert(Alert.AlertType.INFORMATION);
                       adminMenu_addProduct_ProductAddedAlert.setTitle("Add Product");
                       try {
                           admin.saveData();
                       } catch (IOException ex) {
                           Alert adminMenu_addProduct_ProductAddingFailed = new Alert(Alert.AlertType.ERROR);
                           adminMenu_addProduct_ProductAddingFailed.setTitle("PRODUCT ADDITION FAILED");
                           adminMenu_addProduct_ProductAddingFailed.setHeaderText("Failed to add product to the database");
                           adminMenu_addProduct_ProductAddingFailed.showAndWait();
                           primaryStage.setScene(adminMenuScene);
                       }
                       adminMenu_addProduct_ProductAddedAlert.setHeaderText("Product successfully added!");
                       adminMenu_addProduct_ProductAddedAlert.setContentText("Press OK to continue");
                       adminMenu_addProduct_ProductAddedAlert.showAndWait();
                       primaryStage.setScene(adminMenuScene);
                   }
               }
           });
            adminMenu_addProductCancelButton.setOnAction(e1 ->{
                primaryStage.setScene(adminMenuScene);
            });
        });
        //********************************************************************
        adminMenu_editProduct.setOnAction(e -> {
            GridPane adminMenu_editProductGridPane = new GridPane();
            adminMenu_editProductGridPane.setAlignment(Pos.CENTER);

            Label productName2 = new Label("Enter Product Name: ");
            Label adminMenu_editProduct_ProductNameWarning = new Label("Product Does Not Exist!");
            adminMenu_editProduct_ProductNameWarning.setTextFill(Color.RED);
            adminMenu_editProduct_ProductNameWarning.setVisible(false);
            TextField adminMenu_editProduct_ProductName = new TextField();

            Label productField = new Label("Enter The Field You Want To Edit: ");
            Label adminMenu_editProduct_ProductFieldWarning = new Label("Only Name, Price, and Quantity can be edited!");
            adminMenu_editProduct_ProductFieldWarning.setTextFill(Color.RED);
            adminMenu_editProduct_ProductFieldWarning.setVisible(false);
            TextField adminMenu_editProduct_ProductField = new TextField();

            Label productValue = new Label("Enter New Value: ");
            TextField adminMenu_editProduct_ProductValue = new TextField();

            Button adminMenu_editProductButton = new Button("Edit Product");
            adminMenu_editProductButton.setAlignment(Pos.CENTER);

            adminMenu_editProductGridPane.add(productName2, 0, 0);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductName, 1, 0);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductNameWarning, 2, 0);
            adminMenu_editProductGridPane.add(productField, 0, 1);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductField, 1, 1);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductFieldWarning, 2, 1);
            adminMenu_editProductGridPane.add(productValue, 0, 2);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductValue, 1, 2);
            adminMenu_editProductGridPane.add(adminMenu_editProductButton, 1, 3);

            adminMenu_editProductGridPane.setHgap(10);
            adminMenu_editProductGridPane.setVgap(10);

            Scene editProduct_scene = new Scene(adminMenu_editProductGridPane, 600, 400);
            primaryStage.setScene(editProduct_scene);

            adminMenu_editProductButton.setOnAction(e1 -> {
                if (!CheckProductExistence(admin, adminMenu_editProduct_ProductName.getText())) {
                    adminMenu_editProduct_ProductNameWarning.setVisible(true);
                    adminMenu_editProduct_ProductName.setText("");
                }
                else {
                    adminMenu_editProduct_ProductNameWarning.setVisible(false);
                }
                if (adminMenu_editProduct_ProductField.getText().equalsIgnoreCase("name") || adminMenu_editProduct_ProductField.getText().equalsIgnoreCase("price") || adminMenu_editProduct_ProductField.getText().equalsIgnoreCase("quantity")) {
                    adminMenu_editProduct_ProductFieldWarning.setVisible(false);
                }
                else {
                    adminMenu_editProduct_ProductFieldWarning.setVisible(true);
                    adminMenu_editProduct_ProductField.setText("");

                }
                if (admin.editProduct(adminMenu_editProduct_ProductName.getText(), adminMenu_editProduct_ProductField.getText(),adminMenu_editProduct_ProductValue.getText())) {
                    Alert adminMenu_editProduct_ProductEditedAlert = new Alert(Alert.AlertType.INFORMATION);
                    adminMenu_editProduct_ProductEditedAlert.setTitle("Edit Product");
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_editProduct_ProductEditingFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_editProduct_ProductEditingFailed.setHeaderText("PRODUCT EDITING FAILED");
                        adminMenu_editProduct_ProductEditingFailed.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                    adminMenu_editProduct_ProductEditedAlert.setHeaderText("Product successfully edited!");
                    adminMenu_editProduct_ProductEditedAlert.setContentText("Press OK to continue");
                    adminMenu_editProduct_ProductEditedAlert.showAndWait();
                    primaryStage.setScene(adminMenuScene);
                }


            });

        });
        //**********************************************************************
        adminMenu_removeProduct.setOnAction(e -> {
            GridPane adminMenu_removeProductGridPane = new GridPane();
            adminMenu_removeProductGridPane.setAlignment(Pos.CENTER);

            Label removeProductName = new Label("Enter Name of Product to be removed: ");
            Label adminMenu_removeProductNameWarning = new Label("Product Does Not Exist!");
            adminMenu_removeProductNameWarning.setTextFill(Color.RED);
            adminMenu_removeProductNameWarning.setVisible(false);
            TextField adminMenu_removeProductName = new TextField();

            Button adminMenu_removeProductButton = new Button("Remove Product");
            adminMenu_removeProductButton.setAlignment(Pos.CENTER);

            adminMenu_removeProductGridPane.add(removeProductName, 0, 0);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductName, 1, 0);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductNameWarning, 2, 0);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductButton, 1, 1);

            adminMenu_removeProductGridPane.setHgap(10);
            adminMenu_removeProductGridPane.setVgap(10);

            Scene removeProduct_scene = new Scene(adminMenu_removeProductGridPane, 600, 300);
            primaryStage.setScene(removeProduct_scene);

            adminMenu_removeProductButton.setOnAction(e1 -> {
                if (!CheckProductExistence(admin, adminMenu_removeProductName.getText())) {
                    adminMenu_removeProductNameWarning.setVisible(true);
                    adminMenu_removeProductName.setText("");
                }
                else {
                    adminMenu_removeProductNameWarning.setVisible(false);
                }
                if (admin.removeProduct(adminMenu_removeProductName.getText())) {
                    Alert adminMenu_removeProduct_ProductRemovedAlert = new Alert(Alert.AlertType.INFORMATION);
                    adminMenu_removeProduct_ProductRemovedAlert.setTitle("Remove Product");
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_removeProduct_ProductRemoveFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_removeProduct_ProductRemoveFailed.setTitle("PRODUCT REMOVE FAILED");
                        adminMenu_removeProduct_ProductRemoveFailed.setHeaderText("Failed to remove product from the database");
                        adminMenu_removeProduct_ProductRemoveFailed.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                    adminMenu_removeProduct_ProductRemovedAlert.setHeaderText("Product successfully removed!");
                    adminMenu_removeProduct_ProductRemovedAlert.setContentText("Press OK to continue");
                    adminMenu_removeProduct_ProductRemovedAlert.showAndWait();
                    primaryStage.setScene(adminMenuScene);
                }
            });
        });

        //**********************************************************************************
        adminMenu_searchProduct.setOnAction(e -> {
            GridPane adminMenu_searchProductGridPane = new GridPane();
            adminMenu_searchProductGridPane.setAlignment(Pos.CENTER);

            Label searchProductField = new Label("Enter Search Field: ");
            Label adminMenu_searchProduct_ProductFieldWarning = new Label("Only Name or ID can be used!");
            adminMenu_searchProduct_ProductFieldWarning.setTextFill(Color.RED);
            adminMenu_searchProduct_ProductFieldWarning.setVisible(false);
            TextField adminMenu_searchProduct_ProductField = new TextField();

            Label searchProductValue = new Label("Enter Value to Search with: ");
            TextField adminMenu_searchProduct_ProductValue = new TextField();

            Button adminMenu_searchProductButton = new Button("Search Product");
            adminMenu_searchProductButton.setAlignment(Pos.CENTER);

            adminMenu_searchProductGridPane.add(searchProductField, 0, 0);
            adminMenu_searchProductGridPane.add(adminMenu_searchProduct_ProductField, 1, 0);
            adminMenu_searchProductGridPane.add(adminMenu_searchProduct_ProductFieldWarning, 2, 0);
            adminMenu_searchProductGridPane.add(searchProductValue, 0, 1);
            adminMenu_searchProductGridPane.add(adminMenu_searchProduct_ProductValue, 1, 1);
            adminMenu_searchProductGridPane.add(adminMenu_searchProductButton, 0, 3);

            adminMenu_searchProductGridPane.setHgap(10);
            adminMenu_searchProductGridPane.setVgap(10);

            Scene searchProduct_scene = new Scene(adminMenu_searchProductGridPane, 600, 600);
            primaryStage.setScene(searchProduct_scene);

            adminMenu_searchProductButton.setOnAction(e1 -> {
                if (adminMenu_searchProduct_ProductField.getText().equalsIgnoreCase("name") || adminMenu_searchProduct_ProductField.getText().equalsIgnoreCase("id")) {
                    adminMenu_searchProduct_ProductFieldWarning.setVisible(false);
                    if (admin.searchProductByField(adminMenu_searchProduct_ProductField.getText(), adminMenu_searchProduct_ProductValue.getText()) == null) {
                        Alert adminMenu_searchProduct_ProductSearchAlert = new Alert(Alert.AlertType.ERROR);
                        adminMenu_searchProduct_ProductSearchAlert.setHeaderText("PRODUCT NOT FOUND!");
                        adminMenu_searchProduct_ProductSearchAlert.showAndWait();
                        adminMenu_searchProduct_ProductValue.setText("");
                        adminMenu_searchProduct_ProductField.setText("");
                        primaryStage.setScene(searchProduct_scene);
                    }
                    else {
                        Product p = new Product(admin.searchProductByField(adminMenu_searchProduct_ProductField.getText(), adminMenu_searchProduct_ProductValue.getText()));
                        Alert adminMenu_searchProduct_ProductSearchAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_searchProduct_ProductSearchAlert.setTitle("Search Product");
                        adminMenu_searchProduct_ProductSearchAlert.setHeaderText("Product found:\n" + p.toString());
                        adminMenu_searchProduct_ProductSearchAlert.setContentText("Press OK to continue");
                        adminMenu_searchProduct_ProductSearchAlert.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                }
                else {
                    adminMenu_searchProduct_ProductFieldWarning.setVisible(true);
                    adminMenu_searchProduct_ProductField.setText("");
                }
            });
        });



        adminMenu_productReport.setOnAction(e -> System.out.println("View Reports About Products"));
        adminMenu_userReport.setOnAction(e -> System.out.println("View Report About Users"));
        adminMenu_orderReport.setOnAction(e -> System.out.println("View Report About Orders"));
        adminMenu_logOut.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        //***********************************************************
        Label adminMenu_addUser_ChoiceLabel = new Label("Click on your choice");
        Button adminMenu_addUser_addCashier = new Button("Add New Cashier");
        Button adminMenu_addUser_addCustomer = new Button("Add New Customer");
        Button adminMenu_addUser_addSupplier = new Button("Add New Supplier");
        Button adminMenu_addUser_back = new Button("Back");

        VBox adminMenu_addUser_Vbox = new VBox(adminMenu_addUser_ChoiceLabel, adminMenu_addUser_addCashier, adminMenu_addUser_addCustomer, adminMenu_addUser_addSupplier, adminMenu_addUser_back);
        adminMenu_addUser_Vbox.setAlignment(Pos.CENTER);
        adminMenu_addUser_Vbox.setSpacing(10);
        adminMenu_addUserScene = new Scene(adminMenu_addUser_Vbox, 300, 250);
        adminMenu_addUser.setOnAction(e -> primaryStage.setScene(adminMenu_addUserScene));

        adminMenu_addUser_addCashier.setOnAction(e -> {

            Label adminMenu_addUser_addCashierNameLabel = new Label("Enter Name: ");
            Label adminMenu_addUser_addCashierInvalidNameLabel = new Label("Invalid Name!");
            adminMenu_addUser_addCashierInvalidNameLabel.setTextFill(Color.RED);
            adminMenu_addUser_addCashierInvalidNameLabel.setVisible(false);
            TextField adminMenu_addUser_addCashierNameTF = new TextField();

            Label adminMenu_addUser_addCashierEmailLabel = new Label("Enter Email: ");
            Label adminMenu_addUser_addCashierInvalidEmailLabel = new Label("Invalid Email!");
            adminMenu_addUser_addCashierInvalidEmailLabel.setTextFill(Color.RED);
            adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(false);
            TextField adminMenu_addUser_addCashierEmailTF = new TextField();

            Button adminMenu_addUser_addCashierButton = new Button("Add New Cashier");
            Button adminMenu_addUser_addCashierCancelButton = new Button("Cancel");

            GridPane adminMenu_addUser_addCashier_GridPane = new GridPane();
            adminMenu_addUser_addCashier_GridPane.setHgap(10);
            adminMenu_addUser_addCashier_GridPane.setVgap(10);
            adminMenu_addUser_addCashier_GridPane.setAlignment(Pos.CENTER);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierNameLabel,0,0);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierNameTF,1,0);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierInvalidNameLabel,2,0);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierEmailLabel,0,1);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierEmailTF,1,1);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierInvalidEmailLabel,2,1);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierButton,1,2);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierCancelButton,1,3);

            Scene scene = new Scene(adminMenu_addUser_addCashier_GridPane, 300, 250);
            primaryStage.setScene(scene);
            adminMenu_addUser_addCashierButton.setOnAction(e1 -> {

                if (adminMenu_addUser_addCashierNameTF.getText().equalsIgnoreCase("")) {
                    adminMenu_addUser_addCashierInvalidNameLabel.setVisible(true);
                }
                else {
                    adminMenu_addUser_addCashierInvalidNameLabel.setVisible(false);
                }
                if (adminMenu_addUser_addCashierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCashierEmailTF.getText())) {
                    adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(true);
                }
                else {
                    adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(false);
                }
                if (adminMenu_addUser_addCashierNameTF.getText().equalsIgnoreCase("") || adminMenu_addUser_addCashierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCashierEmailTF.getText()))
                {
                    if (adminMenu_addUser_addCashierNameTF.getText().equalsIgnoreCase("")) {
                        adminMenu_addUser_addCashierInvalidNameLabel.setVisible(true);
                    }
                    else {
                        adminMenu_addUser_addCashierInvalidNameLabel.setVisible(false);
                    }
                    if (adminMenu_addUser_addCashierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCashierEmailTF.getText())) {
                        adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(true);
                    }
                    else {
                        adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(false);
                    }
                }
                else
                {
                    admin.addNewCashier(adminMenu_addUser_addCashierNameTF.getText(),adminMenu_addUser_addCashierEmailTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_addUser_addCashier_CashierAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_addUser_addCashier_CashierAdditionFailed.setTitle("CASHIER ADDITION FAILED");
                        adminMenu_addUser_addCashier_CashierAdditionFailed.setHeaderText("Failed to add cashier to the database");
                        adminMenu_addUser_addCashier_CashierAdditionFailed.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Cashier");
                    alert.setHeaderText("Cashier added Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(adminMenuScene);
                }
            });
        });

        adminMenu_addUser_addCustomer.setOnAction(e -> {

        });
        adminMenu_addUser_addSupplier.setOnAction(e -> System.out.println("Add New Supplier"));
        adminMenu_addUser_back.setOnAction(e -> primaryStage.setScene(adminMenuScene));

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
        back2.setOnAction(e -> primaryStage.setScene(adminMenuScene));

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
        back3.setOnAction(e -> primaryStage.setScene(adminMenuScene));

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
        back4.setOnAction(e -> primaryStage.setScene(adminMenuScene));

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
        back5.setOnAction(e -> primaryStage.setScene(adminMenuScene));

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



    public static boolean CheckSupplierExistence(Admin admin, String supplierId) {
        return admin.searchSupplierByField("id", supplierId) != null;
    }

    public static boolean CheckProductExistence(Admin admin, String name) {
        return admin.searchProductByField("name", name) != null;
    }

    public static boolean CheckCustomerExistence(Admin admin, String customerId) {
       return (admin.searchCustomerByField("id", customerId) != null);
    }
    public static boolean CheckCashierExistence(Admin admin, String cashierId) {
        return (admin.searchCashierByField("id", cashierId) != null);
    }
    public static boolean CheckCartExistence(Admin admin, String cartId) {
        return (admin.searchCartByField("id", cartId) != null);
    }
    public boolean isValidEmailAddress(String email) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m;
        m = p.matcher(email);
        return m.matches();
    }










}
