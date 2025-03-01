package com.example.pharmacygui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.*;


public class JavaFXMain extends Application {

    int scene_height = 800, scene_width = 800;
    Admin admin = new Admin("Rina", "Rina123@gmail.com", "1234");
    Customer currentCustomer = null;
    Cashier currentCashier = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Pharmacy Management System
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.getIcons().add(new Image(new FileInputStream("src/main/java/com/example/pharmacygui/resources/Project_Icon.png")));
        Scene mainMenuScene, adminLoginScene, adminMenuScene, adminMenu_addUserScene, scene7, scene8, scene9;

        //**************************************************
        //Main Menu
        Button mainMenu_adminButton = new Button("Admin");
        Button mainMenu_customerButton = new Button("Customer");
        Button mainMenu_cashierButton = new Button("Cashier");
        Button mainMenu_exitButton = new Button("Exit");


        styleButton(mainMenu_adminButton);
        styleButton(mainMenu_customerButton);
        styleButton(mainMenu_cashierButton);
        styleButton(mainMenu_exitButton);

        mainMenu_adminButton.setPrefSize(200, 30);
        mainMenu_customerButton.setPrefSize(200, 30);
        mainMenu_cashierButton.setPrefSize(200, 30);
        mainMenu_exitButton.setPrefSize(200, 30);

        Label mainMenu_welcomeLabel = new Label("Welcome to Pharmacy Management System!");
        styleLabel(mainMenu_welcomeLabel);
        VBox vbox1 = new VBox(mainMenu_welcomeLabel, mainMenu_adminButton, mainMenu_customerButton, mainMenu_cashierButton, mainMenu_exitButton);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(10);
        mainMenuScene = new Scene(vbox1, scene_width, scene_height);
        primaryStage.setScene(mainMenuScene);

        mainMenu_exitButton.setOnAction(e -> primaryStage.close());

        //***********************************************************
        //Admin Login
        PasswordField adminPasswordTextField = new PasswordField();
        styleTextField(adminPasswordTextField);
        Label adminPasswordLabel = new Label("Password: ");
        styleLabel(adminPasswordLabel);
        Label adminWrongPasswordLabel = new Label("Wrong Password, try again");
        adminWrongPasswordLabel.setTextFill(Color.RED);
        adminWrongPasswordLabel.setVisible(false);
        Button adminPasswordBackButton = new Button("Back");
        styleButton(adminPasswordBackButton);

        HBox adminLoginHbox = new HBox(adminPasswordLabel, adminPasswordTextField, adminPasswordBackButton);
        adminLoginHbox.setAlignment(Pos.CENTER);
        adminLoginHbox.setSpacing(10);

        VBox adminLoginVbox = new VBox(adminLoginHbox, adminWrongPasswordLabel);
        adminLoginVbox.setAlignment(Pos.CENTER);
        adminLoginVbox.setSpacing(10);

        adminLoginScene = new Scene(adminLoginVbox, scene_width, scene_height);

        adminPasswordBackButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));
        mainMenu_adminButton.setOnAction(e -> primaryStage.setScene(adminLoginScene));

        //************************************************************
        //Admin Menu
        Button adminMenu_addProduct = new Button("Add New Product");
        Button adminMenu_editProduct = new Button("Edit Product");
        Button adminMenu_removeProduct = new Button("Remove Product");
        Button adminMenu_searchProduct = new Button("Search for a Product");
        Button adminMenu_productReport = new Button("View Reports About Products");
        Button adminMenu_BestsellerAndMostRevenueProduct = new Button("View Best Seller and Most Revenue Products");
        Button adminMenu_addUser = new Button("Add User");
        Button adminMenu_editUser = new Button("Edit User");
        Button adminMenu_removeUser = new Button("Remove User");
        Button adminMenu_searchUser = new Button("Search for a User");
        Button adminMenu_userReport = new Button("View Reports About Users");
        Button adminMenu_orderReport = new Button("View Report About Orders");
        Button adminMenu_AvgRevenueAndTotalRevenueForOrders = new Button("View Average Revenue and Total Revenue for Orders");
        Button adminMenu_logOut = new Button("Log Out");

        int buttonWidth = 400;
        int buttonHeight = 30;

        styleButton(adminMenu_addProduct);
        styleButton(adminMenu_editProduct);
        styleButton(adminMenu_removeProduct);
        styleButton(adminMenu_searchProduct);
        styleButton(adminMenu_productReport);
        styleButton(adminMenu_BestsellerAndMostRevenueProduct);
        styleButton(adminMenu_addUser);
        styleButton(adminMenu_editUser);
        styleButton(adminMenu_removeUser);
        styleButton(adminMenu_searchUser);
        styleButton(adminMenu_userReport);
        styleButton(adminMenu_orderReport);
        styleButton(adminMenu_AvgRevenueAndTotalRevenueForOrders);
        styleButton(adminMenu_logOut);

        adminMenu_addProduct.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_editProduct.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_removeProduct.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_searchProduct.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_productReport.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_BestsellerAndMostRevenueProduct.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_addUser.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_editUser.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_removeUser.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_searchUser.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_userReport.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_orderReport.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_AvgRevenueAndTotalRevenueForOrders.setPrefSize(buttonWidth,buttonHeight);
        adminMenu_logOut.setPrefSize(buttonWidth,buttonHeight);

        Label adminMenu_welcomeLabel = new Label("What would you like to do?");
        styleLabel(adminMenu_welcomeLabel);
        VBox vbox2 = new VBox(adminMenu_welcomeLabel, adminMenu_addProduct, adminMenu_editProduct,
                adminMenu_removeProduct, adminMenu_searchProduct,
                adminMenu_productReport, adminMenu_BestsellerAndMostRevenueProduct,
                adminMenu_addUser, adminMenu_editUser, adminMenu_removeUser,
                adminMenu_searchUser, adminMenu_userReport, adminMenu_orderReport,
                adminMenu_AvgRevenueAndTotalRevenueForOrders, adminMenu_logOut);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);
        adminMenuScene = new Scene(vbox2, scene_width,scene_height);
        adminPasswordTextField.setOnAction(e -> {
            if (adminPasswordTextField.getText().equals(admin.getPassword())) {
                adminPasswordTextField.setText("");
                primaryStage.setScene(adminMenuScene);
            } else {
                adminPasswordTextField.setText("");
                adminWrongPasswordLabel.setVisible(true);
            }
        });

        adminMenu_logOut.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        //****************************************************************************
        //Admin Menu -> Add Product Button
        adminMenu_addProduct.setOnAction(e -> {
            GridPane adminMenu_addProductGridPane = new GridPane();
            adminMenu_addProductGridPane.setAlignment(Pos.CENTER);

            Label productName = new Label("Enter Product Name: ");
            styleLabel(productName);
            Label adminMenu_addProduct_ProductNameWarning = new Label("Product Already Exists!");
            adminMenu_addProduct_ProductNameWarning.setTextFill(Color.RED);
            adminMenu_addProduct_ProductNameWarning.setVisible(false);
            TextField adminMenu_addProduct_ProductName = new TextField();
            styleTextField(adminMenu_addProduct_ProductName);

            Label productPrice = new Label("Enter Product Price: ");
            styleLabel(productPrice);
            Label adminMenu_addProduct_ProductPriceWarning = new Label("Price Must be Double or Integer!");
            adminMenu_addProduct_ProductPriceWarning.setTextFill(Color.RED);
            adminMenu_addProduct_ProductPriceWarning.setVisible(false);
            TextField adminMenu_addProduct_ProductPrice = new TextField();
            styleTextField(adminMenu_addProduct_ProductPrice);

            Label productQuantity = new Label("Enter Product Quantity: ");
            styleLabel(productQuantity);
            Label adminMenu_addProduct_ProductQuantityWarning = new Label("Quantity Must be Integer!");
            adminMenu_addProduct_ProductQuantityWarning.setTextFill(Color.RED);
            adminMenu_addProduct_ProductQuantityWarning.setVisible(false);

            TextField adminMenu_addProduct_ProductQuantity = new TextField();
            styleTextField(adminMenu_addProduct_ProductQuantity);


            Label productSupplier = new Label("Enter Product Supplier ID: ");
            styleLabel(productSupplier);
            Label adminMenu_addProduct_SupplierIDWarning = new Label("Supplier Doesn't Exist!");
            adminMenu_addProduct_SupplierIDWarning.setTextFill(Color.RED);
            adminMenu_addProduct_SupplierIDWarning.setVisible(false);
            TextField adminMenu_addProduct_ProductSupplierID = new TextField();
            styleTextField(adminMenu_addProduct_ProductSupplierID);

            Label productExpirationDate = new Label("Enter Product Expiration Date: ");
            styleLabel(productExpirationDate);
            Label adminMenu_addProduct_ProductExpirationDateWarning = new Label("Expiration Date Must be Date!");
            adminMenu_addProduct_ProductExpirationDateWarning.setTextFill(Color.RED);
            adminMenu_addProduct_ProductExpirationDateWarning.setVisible(false);
            TextField adminMenu_addProduct_ProductExpirationDate = new TextField("yyyy-MM-dd");
            styleTextField(adminMenu_addProduct_ProductExpirationDate);

            Button adminMenu_addProductButton = new Button("Add Product");
            Button adminMenu_addProductCancelButton = new Button("Cancel");
            adminMenu_addProductButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_addProductButton);
            styleButton(adminMenu_addProductCancelButton);

            adminMenu_addProductButton.setPrefSize(200, 30);
            adminMenu_addProductCancelButton.setPrefSize(200, 30);

            adminMenu_addProductGridPane.add(productName, 0, 0);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductName, 1, 0);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductNameWarning, 2, 0);
            adminMenu_addProductGridPane.add(productPrice, 0, 1);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductPrice, 1, 1);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductPriceWarning, 2, 1);
            adminMenu_addProductGridPane.add(productQuantity, 0, 2);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductQuantity, 1, 2);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductQuantityWarning, 2, 2);
            adminMenu_addProductGridPane.add(productSupplier, 0, 3);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductSupplierID, 1, 3);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_SupplierIDWarning, 2, 3);
            adminMenu_addProductGridPane.add(productExpirationDate, 0, 4);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductExpirationDate, 1, 4);
            adminMenu_addProductGridPane.add(adminMenu_addProduct_ProductExpirationDateWarning, 2, 4);
            adminMenu_addProductGridPane.add(adminMenu_addProductButton, 1, 5);
            adminMenu_addProductGridPane.add(adminMenu_addProductCancelButton, 1, 6);

            adminMenu_addProductGridPane.setHgap(10);
            adminMenu_addProductGridPane.setVgap(10);

            Scene adminMenu_addProductScene = new Scene(adminMenu_addProductGridPane, scene_width, scene_height);
            primaryStage.setScene(adminMenu_addProductScene);

            adminMenu_addProductButton.setOnAction(e1 -> {
                if (CheckProductExistence(admin, adminMenu_addProduct_ProductName.getText()) || !CheckSupplierExistence(admin, adminMenu_addProduct_ProductSupplierID.getText())) {
                    if (CheckProductExistence(admin, adminMenu_addProduct_ProductName.getText())) {
                        adminMenu_addProduct_ProductNameWarning.setVisible(true);
                        adminMenu_addProduct_ProductName.setText("");
                    } else {
                        adminMenu_addProduct_ProductNameWarning.setVisible(false);
                    }
                    if (!CheckSupplierExistence(admin, adminMenu_addProduct_ProductSupplierID.getText())) {
                        adminMenu_addProduct_SupplierIDWarning.setVisible(true);
                        adminMenu_addProduct_ProductSupplierID.setText("");
                    } else {
                        adminMenu_addProduct_SupplierIDWarning.setVisible(false);
                    }
                } else {
                    adminMenu_addProduct_ProductNameWarning.setVisible(false);
                    adminMenu_addProduct_SupplierIDWarning.setVisible(false);

                    double parseAdminMenu_addProduct_ProductPrice = 0;
                    int parseAdminMenu_addProduct_ProductQuantity = 0;
                    LocalDate parseAdminMenu_addProduct_ProductExpirationDate = null;

                    try {
                        try {
                            parseAdminMenu_addProduct_ProductPrice = Double.parseDouble(adminMenu_addProduct_ProductPrice.getText());
                            adminMenu_addProduct_ProductPriceWarning.setVisible(false);
                        } catch (NumberFormatException ex) {
                            adminMenu_addProduct_ProductPriceWarning.setVisible(true);
                            throw ex;
                        }

                        try {
                            parseAdminMenu_addProduct_ProductQuantity = Integer.parseInt(adminMenu_addProduct_ProductQuantity.getText());
                            adminMenu_addProduct_ProductQuantityWarning.setVisible(false);
                        } catch (NumberFormatException ex) {
                            adminMenu_addProduct_ProductQuantityWarning.setVisible(true);
                            throw ex;
                        }

                        try {
                            parseAdminMenu_addProduct_ProductExpirationDate = LocalDate.parse(adminMenu_addProduct_ProductExpirationDate.getText());
                            adminMenu_addProduct_ProductExpirationDateWarning.setVisible(false);
                        } catch (DateTimeParseException ex) {
                            adminMenu_addProduct_ProductExpirationDateWarning.setVisible(true);
                            throw ex;
                        }

                        if (admin.addNewProduct(adminMenu_addProduct_ProductName.getText(), parseAdminMenu_addProduct_ProductPrice, parseAdminMenu_addProduct_ProductQuantity, admin.searchSupplierByField("id", adminMenu_addProduct_ProductSupplierID.getText()), parseAdminMenu_addProduct_ProductExpirationDate)) {
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
                    } catch (NumberFormatException | DateTimeParseException ex) {
                        primaryStage.setScene(adminMenu_addProductScene);
                    }
                }
            });
            adminMenu_addProductCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(adminMenuScene);
            });
        });
        //********************************************************************
        //Admin Menu -> Edit Product Button
        adminMenu_editProduct.setOnAction(e -> {
            GridPane adminMenu_editProductGridPane = new GridPane();
            adminMenu_editProductGridPane.setAlignment(Pos.CENTER);

            Label productName2 = new Label("Enter Product Name: ");
            styleLabel(productName2);
            Label adminMenu_editProduct_ProductNameWarning = new Label("Product Does Not Exist!");
            adminMenu_editProduct_ProductNameWarning.setTextFill(Color.RED);
            adminMenu_editProduct_ProductNameWarning.setVisible(false);
            TextField adminMenu_editProduct_ProductName = new TextField();
            styleTextField(adminMenu_editProduct_ProductName);

            Label productField = new Label("Enter The Field You Want To Edit: ");
            styleLabel(productField);
            Label adminMenu_editProduct_ProductFieldWarning = new Label("Only Name, Price, and Quantity can be edited!");
            adminMenu_editProduct_ProductFieldWarning.setTextFill(Color.RED);
            adminMenu_editProduct_ProductFieldWarning.setVisible(false);
            TextField adminMenu_editProduct_ProductField = new TextField();
            styleTextField(adminMenu_editProduct_ProductField);

            Label productValue = new Label("Enter New Value: ");
            styleLabel(productValue);
            Label adminMenu_editProduct_ProductValueWarning = new Label("Type Mismatch!");
            adminMenu_editProduct_ProductValueWarning.setTextFill(Color.RED);
            adminMenu_editProduct_ProductValueWarning.setVisible(false);
            TextField adminMenu_editProduct_ProductValue = new TextField();
            styleTextField(adminMenu_editProduct_ProductValue);

            Button adminMenu_editProductButton = new Button("Edit Product");
            Button adminMenu_editProductCancelButton = new Button("Cancel");
            adminMenu_editProductButton.setAlignment(Pos.CENTER);
            adminMenu_editProductCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_editProductButton);
            styleButton(adminMenu_editProductCancelButton);

            adminMenu_editProductButton.setPrefSize(200, 30);
            adminMenu_editProductCancelButton.setPrefSize(200, 30);

            adminMenu_editProductGridPane.add(productName2, 0, 0);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductName, 1, 0);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductNameWarning, 2, 0);
            adminMenu_editProductGridPane.add(productField, 0, 1);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductField, 1, 1);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductFieldWarning, 2, 1);
            adminMenu_editProductGridPane.add(productValue, 0, 2);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductValue, 1, 2);
            adminMenu_editProductGridPane.add(adminMenu_editProduct_ProductValueWarning, 2, 2);
            adminMenu_editProductGridPane.add(adminMenu_editProductButton, 1, 3);
            adminMenu_editProductGridPane.add(adminMenu_editProductCancelButton, 1, 4);

            adminMenu_editProductGridPane.setHgap(10);
            adminMenu_editProductGridPane.setVgap(10);

            Scene editProduct_scene = new Scene(adminMenu_editProductGridPane, scene_width, scene_height);
            primaryStage.setScene(editProduct_scene);

            adminMenu_editProductButton.setOnAction(e1 -> {
                if (!CheckProductExistence(admin, adminMenu_editProduct_ProductName.getText())) {
                    adminMenu_editProduct_ProductNameWarning.setVisible(true);
                    adminMenu_editProduct_ProductName.setText("");
                } else {
                    adminMenu_editProduct_ProductNameWarning.setVisible(false);
                }
                if (adminMenu_editProduct_ProductField.getText().equalsIgnoreCase("name") || adminMenu_editProduct_ProductField.getText().equalsIgnoreCase("price") || adminMenu_editProduct_ProductField.getText().equalsIgnoreCase("quantity")) {
                    adminMenu_editProduct_ProductFieldWarning.setVisible(false);
                } else {
                    adminMenu_editProduct_ProductFieldWarning.setVisible(true);
                    adminMenu_editProduct_ProductField.setText("");

                }
                try {
                    if (admin.editProduct(adminMenu_editProduct_ProductName.getText(), adminMenu_editProduct_ProductField.getText(), adminMenu_editProduct_ProductValue.getText())) {
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
                } catch (NumberFormatException | DateTimeParseException ex) {
                    adminMenu_editProduct_ProductValueWarning.setVisible(true);
                    primaryStage.setScene(editProduct_scene);
                    adminMenu_editProduct_ProductValue.setText("");
                }
            });
            adminMenu_editProductCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(adminMenuScene);
            });

        });

        //**********************************************************************
        //Admin Menu -> Remove Product Button
        adminMenu_removeProduct.setOnAction(e -> {
            GridPane adminMenu_removeProductGridPane = new GridPane();
            adminMenu_removeProductGridPane.setAlignment(Pos.CENTER);

            Label removeProductName = new Label("Enter Name of Product to be removed: ");
            styleLabel(removeProductName);
            Label adminMenu_removeProductNameWarning = new Label("Product Does Not Exist!");
            adminMenu_removeProductNameWarning.setTextFill(Color.RED);
            adminMenu_removeProductNameWarning.setVisible(false);
            TextField adminMenu_removeProductName = new TextField();
            styleTextField(adminMenu_removeProductName);

            Button adminMenu_removeProductButton = new Button("Remove Product");
            Button adminMenu_removeProductCancelButton = new Button("Cancel");
            adminMenu_removeProductButton.setAlignment(Pos.CENTER);
            adminMenu_removeProductCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_removeProductButton);
            styleButton(adminMenu_removeProductCancelButton);

            adminMenu_removeProductButton.setPrefSize(200, 30);
            adminMenu_removeProductCancelButton.setPrefSize(200, 30);

            adminMenu_removeProductGridPane.add(removeProductName, 0, 0);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductName, 1, 0);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductNameWarning, 2, 0);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductButton, 1, 1);
            adminMenu_removeProductGridPane.add(adminMenu_removeProductCancelButton, 1, 2);

            adminMenu_removeProductGridPane.setHgap(10);
            adminMenu_removeProductGridPane.setVgap(10);

            Scene removeProduct_scene = new Scene(adminMenu_removeProductGridPane, scene_width, scene_height);
            primaryStage.setScene(removeProduct_scene);

            adminMenu_removeProductButton.setOnAction(e1 -> {
                if (!CheckProductExistence(admin, adminMenu_removeProductName.getText())) {
                    adminMenu_removeProductNameWarning.setVisible(true);
                    adminMenu_removeProductName.setText("");
                } else {
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

            adminMenu_removeProductCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(adminMenuScene);
            });
        });

        //**********************************************************************************
        //Admin Menu -> Search Product Button
        adminMenu_searchProduct.setOnAction(e -> {
            GridPane adminMenu_searchProductGridPane = new GridPane();
            adminMenu_searchProductGridPane.setAlignment(Pos.CENTER);

            Label searchProductField = new Label("Enter Search Field: ");
            styleLabel(searchProductField);
            Label adminMenu_searchProduct_ProductFieldWarning = new Label("Only Name or ID can be used!");
            adminMenu_searchProduct_ProductFieldWarning.setTextFill(Color.RED);
            adminMenu_searchProduct_ProductFieldWarning.setVisible(false);
            TextField adminMenu_searchProduct_ProductField = new TextField();
            styleTextField(adminMenu_searchProduct_ProductField);

            Label searchProductValue = new Label("Enter Value to Search with: ");
            styleLabel(searchProductValue);
            TextField adminMenu_searchProduct_ProductValue = new TextField();
            styleTextField(adminMenu_searchProduct_ProductValue);

            Button adminMenu_searchProductButton = new Button("Search Product");
            Button adminMenu_searchProductCancelButton = new Button("Cancel");
            adminMenu_searchProductButton.setAlignment(Pos.CENTER);
            adminMenu_searchProductCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_searchProductButton);
            styleButton(adminMenu_searchProductCancelButton);

            adminMenu_searchProductButton.setPrefSize(200, 30);
            adminMenu_searchProductCancelButton.setPrefSize(200, 30);

            adminMenu_searchProductGridPane.add(searchProductField, 0, 0);
            adminMenu_searchProductGridPane.add(adminMenu_searchProduct_ProductField, 1, 0);
            adminMenu_searchProductGridPane.add(adminMenu_searchProduct_ProductFieldWarning, 2, 0);
            adminMenu_searchProductGridPane.add(searchProductValue, 0, 1);
            adminMenu_searchProductGridPane.add(adminMenu_searchProduct_ProductValue, 1, 1);
            adminMenu_searchProductGridPane.add(adminMenu_searchProductButton, 0, 3);
            adminMenu_searchProductGridPane.add(adminMenu_searchProductCancelButton, 0, 4);

            adminMenu_searchProductGridPane.setHgap(10);
            adminMenu_searchProductGridPane.setVgap(10);

            Scene searchProduct_scene = new Scene(adminMenu_searchProductGridPane, scene_width, scene_height);
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
                    } else {
                        Product p = new Product(admin.searchProductByField(adminMenu_searchProduct_ProductField.getText(), adminMenu_searchProduct_ProductValue.getText()));
                        Alert adminMenu_searchProduct_ProductSearchAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_searchProduct_ProductSearchAlert.setTitle("Search Product");
                        adminMenu_searchProduct_ProductSearchAlert.setHeaderText("Product found:\n" + p.toString());
                        adminMenu_searchProduct_ProductSearchAlert.setContentText("Press OK to continue");
                        adminMenu_searchProduct_ProductSearchAlert.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                } else {
                    adminMenu_searchProduct_ProductFieldWarning.setVisible(true);
                    adminMenu_searchProduct_ProductField.setText("");
                }
            });

            adminMenu_searchProductCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(adminMenuScene);
            });
        });


        //*********************************************************************************************
        //Admin Menu -> View Reports About Products Button
        adminMenu_productReport.setOnAction(e -> {
            Label titleLabel = new Label("Products Details: ");
            titleLabel.setFont(Font.font("System", FontWeight.BOLD, 25));
            titleLabel.setUnderline(true);

            // Create a GridPane to display the product details
            GridPane productReportGridPane = new GridPane();
            productReportGridPane.setAlignment(Pos.CENTER);
            productReportGridPane.setHgap(15);
            productReportGridPane.setVgap(15);
            productReportGridPane.add(titleLabel, 0, 0);

            int rowIndex = 1;

            // Fetch the products from the Admin class
            for (Product product : admin.getProducts()) {
                // Display product information
                Label productNameLabel = new Label("Product: " + product.getName());
                productNameLabel.setFont(Font.font("System", FontWeight.BOLD, 15));

                Label supplierLabel = new Label("Supplier: " + product.getSupplier().getName());
                Label productPriceLabel = new Label("Price: $" + product.getPrice());
                Label productQuantityLabel = new Label("Quantity: " + product.getQuantity());
                Label expirationDateLabel = new Label("Expiration Date: " + product.getExpirationDate());

                productReportGridPane.add(productNameLabel, 0, rowIndex++);
                productReportGridPane.add(supplierLabel, 0, rowIndex++);
                productReportGridPane.add(productPriceLabel, 0, rowIndex++);
                productReportGridPane.add(productQuantityLabel, 0, rowIndex++);
                productReportGridPane.add(expirationDateLabel, 0, rowIndex++);
                rowIndex++;
            }

            // Back Button to return to the Admin Menu
            Button backButton = new Button("Back");
            styleButton(backButton);
            backButton.setPrefSize(100, 30);
            productReportGridPane.add(backButton, 0, rowIndex);
            backButton.setOnAction(e1 -> primaryStage.setScene(adminMenuScene));


            ScrollPane scrollPane = new ScrollPane(productReportGridPane);
            scrollPane.setFitToWidth(true);

            Scene productReportScene = new Scene(scrollPane, scene_width, scene_height);
            primaryStage.setScene(productReportScene);
        });

        //*********************************************************************************************
        //Admin Menu -> Bestseller and Most Revenue Products Button
        adminMenu_BestsellerAndMostRevenueProduct.setOnAction(e ->  {
            GridPane adminMenu_BestsellerAndMostRevenueProductGridPane = new GridPane();
            adminMenu_BestsellerAndMostRevenueProductGridPane.setAlignment(Pos.CENTER);

            Label startDate = new Label("Enter Start Date: ");
            styleLabel(startDate);
            Label startDateWarning = new Label("Invalid input!");
            startDateWarning.setTextFill(Color.RED);
            startDateWarning.setVisible(false);
            TextField startDateField = new TextField();
            styleTextField(startDateField);

            Label endDate = new Label("Enter End Date: ");
            styleLabel(endDate);
            Label endDateWarning = new Label("Invalid input!");
            endDateWarning.setTextFill(Color.RED);
            endDateWarning.setVisible(false);
            TextField endDateField = new TextField();
            styleTextField(endDateField);

            Button getBestsellerButton = new Button("Best seller Product");
            Button getMostRevenueButton = new Button("Most Revenue Product");
            Button bestSellerAndMostRevenueCancelButton = new Button("Cancel");
            getBestsellerButton.setAlignment(Pos.CENTER);
            getMostRevenueButton.setAlignment(Pos.CENTER);

            styleButton(getBestsellerButton);
            styleButton(getMostRevenueButton);
            styleButton(bestSellerAndMostRevenueCancelButton);

            getBestsellerButton.setPrefSize(200, 30);
            getMostRevenueButton.setPrefSize(200, 30);
            bestSellerAndMostRevenueCancelButton.setPrefSize(200, 30);

            adminMenu_BestsellerAndMostRevenueProductGridPane.add(startDate, 0, 0);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(startDateField, 1, 0);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(startDateWarning, 2, 0);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(endDate, 0, 1);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(endDateField, 1, 1);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(endDateWarning, 2, 1);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(getBestsellerButton, 0, 2);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(getMostRevenueButton, 1, 2);
            adminMenu_BestsellerAndMostRevenueProductGridPane.add(bestSellerAndMostRevenueCancelButton, 0, 3);

            adminMenu_BestsellerAndMostRevenueProductGridPane.setHgap(10);
            adminMenu_BestsellerAndMostRevenueProductGridPane.setVgap(10);

            Scene adminMenu_BestsellerAndMostRevenueScene = new Scene(adminMenu_BestsellerAndMostRevenueProductGridPane, scene_width, scene_height);
            primaryStage.setScene(adminMenu_BestsellerAndMostRevenueScene);

            getBestsellerButton.setOnAction(e1 -> {
                //date must be entered in the following format yyyy-MM-dd with zeros in front of single digit months like: january -> 01
                LocalDate parseStartDateField = null;
                LocalDate parseEndDateField = null;
                try {
                    try {
                        parseStartDateField = LocalDate.parse(startDateField.getText());
                        startDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        startDateWarning.setVisible(true);
                        startDateField.setText("");
                        throw ex;
                    }

                    try {
                        parseEndDateField = LocalDate.parse(endDateField.getText());
                        endDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        endDateWarning.setVisible(true);
                        endDateField.setText("");
                        throw ex;
                    }

                    String bestseller = admin.getMostSoldProduct(parseStartDateField, parseEndDateField);
                    System.out.println("Best seller:" + bestseller);
                    Alert bestsellerAlert = new Alert(Alert.AlertType.INFORMATION);
                    bestsellerAlert.setTitle("Best seller");
                    bestsellerAlert.setHeaderText("Best seller Product: " + bestseller);
                    bestsellerAlert.setContentText("Press OK to continue");
                    bestsellerAlert.showAndWait();
                    primaryStage.setScene(adminMenu_BestsellerAndMostRevenueScene);
                } catch (DateTimeParseException ex) {
                    primaryStage.setScene(adminMenu_BestsellerAndMostRevenueScene);
                }
            });

            getMostRevenueButton.setOnAction(e1 -> {
                //date must be entered in the following format yyyy-MM-dd with zeros in front of single digit months like: january -> 01
                LocalDate parseStartDateField = null;
                LocalDate parseEndDateField = null;
                try {
                    try {
                        parseStartDateField = LocalDate.parse(startDateField.getText());
                        startDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        startDateWarning.setVisible(true);
                        startDateField.setText("");
                        throw ex;
                    }

                    try {
                        parseEndDateField = LocalDate.parse(endDateField.getText());
                        endDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        endDateWarning.setVisible(true);
                        endDateField.setText("");
                        throw ex;
                    }

                    String mostRevenue = admin.getMostRevenueProduct(parseStartDateField, parseEndDateField);
                    System.out.println("Most Revenue:" + mostRevenue);
                    Alert mostRevenueAlert = new Alert(Alert.AlertType.INFORMATION);
                    mostRevenueAlert.setTitle("Most Revenue");
                    mostRevenueAlert.setHeaderText("Most Revenue Product: " + mostRevenue);
                    mostRevenueAlert.setContentText("Press OK to continue");
                    mostRevenueAlert.showAndWait();
                    primaryStage.setScene(adminMenu_BestsellerAndMostRevenueScene);
                } catch (DateTimeParseException ex) {
                    primaryStage.setScene(adminMenu_BestsellerAndMostRevenueScene);
                }
            });

            bestSellerAndMostRevenueCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(adminMenuScene);
            });
        });

        //***********************************************************
        //Admin Menu -> Add User Menu
        Label adminMenu_addUser_ChoiceLabel = new Label("Click on your choice");
        Button adminMenu_addUser_addCashier = new Button("Add New Cashier");
        Button adminMenu_addUser_addCustomer = new Button("Add New Customer");
        Button adminMenu_addUser_addSupplier = new Button("Add New Supplier");
        Button adminMenu_addUser_back = new Button("Back");

        styleButton(adminMenu_addUser_addCashier);
        styleButton(adminMenu_addUser_addCustomer);
        styleButton(adminMenu_addUser_addSupplier);
        styleButton(adminMenu_addUser_back);

        adminMenu_addUser_addCashier.setPrefSize(300, 30);
        adminMenu_addUser_addCustomer.setPrefSize(300, 30);
        adminMenu_addUser_addSupplier.setPrefSize(300, 30);
        adminMenu_addUser_back.setPrefSize(300, 30);


        VBox adminMenu_addUser_Vbox = new VBox(adminMenu_addUser_ChoiceLabel, adminMenu_addUser_addCashier, adminMenu_addUser_addCustomer, adminMenu_addUser_addSupplier, adminMenu_addUser_back);
        adminMenu_addUser_Vbox.setAlignment(Pos.CENTER);
        adminMenu_addUser_Vbox.setSpacing(10);
        adminMenu_addUserScene = new Scene(adminMenu_addUser_Vbox, scene_width, scene_height);
        adminMenu_addUser.setOnAction(e -> primaryStage.setScene(adminMenu_addUserScene));
        adminMenu_addUser_back.setOnAction(e -> primaryStage.setScene(adminMenuScene));

        //*******************************************************************************
        //Admin Menu -> Add User Menu -> Add Cashier Button
        adminMenu_addUser_addCashier.setOnAction(e -> {

            Label adminMenu_addUser_addCashierNameLabel = new Label("Enter Name: ");
            styleLabel(adminMenu_addUser_addCashierNameLabel);
            Label adminMenu_addUser_addCashierInvalidNameLabel = new Label("Invalid Name!");
            adminMenu_addUser_addCashierInvalidNameLabel.setTextFill(Color.RED);
            adminMenu_addUser_addCashierInvalidNameLabel.setVisible(false);
            TextField adminMenu_addUser_addCashierNameTF = new TextField();
            styleTextField(adminMenu_addUser_addCashierNameTF);

            Label adminMenu_addUser_addCashierEmailLabel = new Label("Enter Email: ");
            styleLabel(adminMenu_addUser_addCashierEmailLabel);
            Label adminMenu_addUser_addCashierInvalidEmailLabel = new Label("Invalid Email!");
            adminMenu_addUser_addCashierInvalidEmailLabel.setTextFill(Color.RED);
            adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(false);
            TextField adminMenu_addUser_addCashierEmailTF = new TextField();
            styleTextField(adminMenu_addUser_addCashierEmailTF);

            Button adminMenu_addUser_addCashierButton = new Button("Add New Cashier");
            styleButton(adminMenu_addUser_addCashierButton);
            Button adminMenu_addUser_addCashierCancelButton = new Button("Cancel");
            styleButton(adminMenu_addUser_addCashierCancelButton);

            GridPane adminMenu_addUser_addCashier_GridPane = new GridPane();
            adminMenu_addUser_addCashier_GridPane.setHgap(10);
            adminMenu_addUser_addCashier_GridPane.setVgap(10);
            adminMenu_addUser_addCashier_GridPane.setAlignment(Pos.CENTER);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierNameLabel, 0, 0);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierNameTF, 1, 0);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierInvalidNameLabel, 2, 0);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierEmailLabel, 0, 1);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierEmailTF, 1, 1);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierInvalidEmailLabel, 2, 1);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierButton, 1, 2);
            adminMenu_addUser_addCashier_GridPane.add(adminMenu_addUser_addCashierCancelButton, 1, 3);

            Scene scene = new Scene(adminMenu_addUser_addCashier_GridPane, scene_width, scene_height);
            primaryStage.setScene(scene);
            adminMenu_addUser_addCashierButton.setOnAction(e1 -> {

                if (adminMenu_addUser_addCashierNameTF.getText().equalsIgnoreCase("")) {
                    adminMenu_addUser_addCashierInvalidNameLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addCashierInvalidNameLabel.setVisible(false);
                }
                if (adminMenu_addUser_addCashierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCashierEmailTF.getText())) {
                    adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(false);
                }
                if (adminMenu_addUser_addCashierNameTF.getText().equalsIgnoreCase("") || adminMenu_addUser_addCashierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCashierEmailTF.getText())) {
                    if (adminMenu_addUser_addCashierNameTF.getText().equalsIgnoreCase("")) {
                        adminMenu_addUser_addCashierInvalidNameLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addCashierInvalidNameLabel.setVisible(false);
                    }
                    if (adminMenu_addUser_addCashierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCashierEmailTF.getText())) {
                        adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addCashierInvalidEmailLabel.setVisible(false);
                    }
                } else {
                    admin.addNewCashier(adminMenu_addUser_addCashierNameTF.getText(), adminMenu_addUser_addCashierEmailTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_addUser_addCashier_CashierAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_addUser_addCashier_CashierAdditionFailed.setTitle("CASHIER ADDITION FAILED");
                        adminMenu_addUser_addCashier_CashierAdditionFailed.setHeaderText("Failed to add cashier to the database");
                        adminMenu_addUser_addCashier_CashierAdditionFailed.showAndWait();
                        primaryStage.setScene(adminMenu_addUserScene);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Cashier");
                    alert.setHeaderText("Cashier added Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(adminMenu_addUserScene);
                }
            });

            adminMenu_addUser_addCashierCancelButton.setOnAction(e2 -> {
                primaryStage.setScene(adminMenu_addUserScene);
            });
        });

        //********************************************************************************
        //Admin Menu -> Add User Menu -> Add Customer Button
        adminMenu_addUser_addCustomer.setOnAction(e -> {
            Label adminMenu_addUser_addCustomerNameLabel = new Label("Enter Name: ");
            styleLabel(adminMenu_addUser_addCustomerNameLabel);
            Label adminMenu_addUser_addCustomerInvalidNameLabel = new Label("Invalid Name!");
            adminMenu_addUser_addCustomerInvalidNameLabel.setTextFill(Color.RED);
            adminMenu_addUser_addCustomerInvalidNameLabel.setVisible(false);
            TextField adminMenu_addUser_addCustomerNameTF = new TextField();
            styleTextField(adminMenu_addUser_addCustomerNameTF);

            Label adminMenu_addUser_addCustomerEmailLabel = new Label("Enter Email: ");
            styleLabel(adminMenu_addUser_addCustomerEmailLabel);
            Label adminMenu_addUser_addCustomerInvalidEmailLabel = new Label("Invalid Email!");
            adminMenu_addUser_addCustomerInvalidEmailLabel.setTextFill(Color.RED);
            adminMenu_addUser_addCustomerInvalidEmailLabel.setVisible(false);
            TextField adminMenu_addUser_addCustomerEmailTF = new TextField();
            styleTextField(adminMenu_addUser_addCustomerEmailTF);

            Button adminMenu_addUser_addCustomerButton = new Button("Add New Customer");
            styleButton(adminMenu_addUser_addCustomerButton);
            Button adminMenu_addUser_addCustomerCancelButton = new Button("Cancel");
            styleButton(adminMenu_addUser_addCustomerCancelButton);

            GridPane adminMenu_addUser_addCustomer_GridPane = new GridPane();
            adminMenu_addUser_addCustomer_GridPane.setHgap(10);
            adminMenu_addUser_addCustomer_GridPane.setVgap(10);
            adminMenu_addUser_addCustomer_GridPane.setAlignment(Pos.CENTER);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerNameLabel, 0, 0);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerNameTF, 1, 0);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerInvalidNameLabel, 2, 0);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerEmailLabel, 0, 1);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerEmailTF, 1, 1);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerInvalidEmailLabel, 2, 1);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerButton, 1, 2);
            adminMenu_addUser_addCustomer_GridPane.add(adminMenu_addUser_addCustomerCancelButton, 1, 3);

            Scene scene = new Scene(adminMenu_addUser_addCustomer_GridPane, scene_width, scene_height);
            primaryStage.setScene(scene);
            adminMenu_addUser_addCustomerButton.setOnAction(e1 -> {

                if (adminMenu_addUser_addCustomerNameTF.getText().equalsIgnoreCase("")) {
                    adminMenu_addUser_addCustomerInvalidNameLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addCustomerInvalidNameLabel.setVisible(false);
                }
                if (adminMenu_addUser_addCustomerEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCustomerEmailTF.getText())) {
                    adminMenu_addUser_addCustomerInvalidEmailLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addCustomerInvalidEmailLabel.setVisible(false);
                }
                if (adminMenu_addUser_addCustomerNameTF.getText().equalsIgnoreCase("") || adminMenu_addUser_addCustomerEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCustomerEmailTF.getText())) {
                    if (adminMenu_addUser_addCustomerNameTF.getText().equalsIgnoreCase("")) {
                        adminMenu_addUser_addCustomerInvalidNameLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addCustomerInvalidNameLabel.setVisible(false);
                    }
                    if (adminMenu_addUser_addCustomerEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addCustomerEmailTF.getText())) {
                        adminMenu_addUser_addCustomerInvalidEmailLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addCustomerInvalidEmailLabel.setVisible(false);
                    }
                } else {
                    admin.addNewCustomer(adminMenu_addUser_addCustomerNameTF.getText(), adminMenu_addUser_addCustomerEmailTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_addUser_addCustomer_CustomerAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_addUser_addCustomer_CustomerAdditionFailed.setTitle("Customer ADDITION FAILED");
                        adminMenu_addUser_addCustomer_CustomerAdditionFailed.setHeaderText("Failed to add Customer to the database");
                        adminMenu_addUser_addCustomer_CustomerAdditionFailed.showAndWait();
                        primaryStage.setScene(adminMenu_addUserScene);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Customer");
                    alert.setHeaderText("Customer added Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(adminMenu_addUserScene);
                }
            });
            adminMenu_addUser_addCustomerCancelButton.setOnAction(e2 -> primaryStage.setScene(adminMenu_addUserScene));

        });

        //********************************************************************************
        //Admin Menu -> Add User Menu -> Add Supplier Button
        adminMenu_addUser_addSupplier.setOnAction(e -> {
            Label adminMenu_addUser_addSupplierNameLabel = new Label("Enter Name: ");
            styleLabel(adminMenu_addUser_addSupplierNameLabel);
            Label adminMenu_addUser_addSupplierInvalidNameLabel = new Label("Invalid Name!");
            adminMenu_addUser_addSupplierInvalidNameLabel.setTextFill(Color.RED);
            adminMenu_addUser_addSupplierInvalidNameLabel.setVisible(false);
            TextField adminMenu_addUser_addSupplierNameTF = new TextField();
            styleTextField(adminMenu_addUser_addSupplierNameTF);

            Label adminMenu_addUser_addSupplierEmailLabel = new Label("Enter Email: ");
            styleLabel(adminMenu_addUser_addSupplierEmailLabel);
            Label adminMenu_addUser_addSupplierInvalidEmailLabel = new Label("Invalid Email!");
            adminMenu_addUser_addSupplierInvalidEmailLabel.setTextFill(Color.RED);
            adminMenu_addUser_addSupplierInvalidEmailLabel.setVisible(false);
            TextField adminMenu_addUser_addSupplierEmailTF = new TextField();
            styleTextField(adminMenu_addUser_addSupplierEmailTF);

            Label adminMenu_addUser_addSupplierContactLabel = new Label("Enter Contact info: ");
            styleLabel(adminMenu_addUser_addSupplierContactLabel);
            Label adminMenu_addUser_addSupplierInvalidContactLabel = new Label("Invalid Contact!");
            adminMenu_addUser_addSupplierInvalidContactLabel.setTextFill(Color.RED);
            adminMenu_addUser_addSupplierInvalidContactLabel.setVisible(false);
            TextField adminMenu_addUser_addSupplierContactTF = new TextField();
            styleTextField(adminMenu_addUser_addSupplierContactTF);


            Button adminMenu_addUser_addSupplierButton = new Button("Add New Supplier");
            styleButton(adminMenu_addUser_addSupplierButton);
            Button adminMenu_addUser_addSupplierCancelButton = new Button("Cancel");
            styleButton(adminMenu_addUser_addSupplierCancelButton);

            GridPane adminMenu_addUser_addSupplier_GridPane = new GridPane();
            adminMenu_addUser_addSupplier_GridPane.setHgap(10);
            adminMenu_addUser_addSupplier_GridPane.setVgap(10);
            adminMenu_addUser_addSupplier_GridPane.setAlignment(Pos.CENTER);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierNameLabel, 0, 0);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierNameTF, 1, 0);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierInvalidNameLabel, 2, 0);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierEmailLabel, 0, 1);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierEmailTF, 1, 1);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierInvalidEmailLabel, 2, 1);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierContactLabel, 0, 2);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierContactTF, 1, 2);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierInvalidContactLabel, 2, 2);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierButton, 1, 3);
            adminMenu_addUser_addSupplier_GridPane.add(adminMenu_addUser_addSupplierCancelButton, 1, 4);

            Scene scene = new Scene(adminMenu_addUser_addSupplier_GridPane, scene_width, scene_height);
            primaryStage.setScene(scene);
            adminMenu_addUser_addSupplierButton.setOnAction(e1 -> {

                if (adminMenu_addUser_addSupplierNameTF.getText().equalsIgnoreCase("")) {
                    adminMenu_addUser_addSupplierInvalidNameLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addSupplierInvalidNameLabel.setVisible(false);
                }
                if (adminMenu_addUser_addSupplierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addSupplierEmailTF.getText())) {
                    adminMenu_addUser_addSupplierInvalidEmailLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addSupplierInvalidEmailLabel.setVisible(false);
                }
                if (adminMenu_addUser_addSupplierContactTF.getText().equalsIgnoreCase("") || !isValidContactNumber(adminMenu_addUser_addSupplierContactTF.getText())) {
                    adminMenu_addUser_addSupplierInvalidContactLabel.setVisible(true);
                } else {
                    adminMenu_addUser_addSupplierInvalidContactLabel.setVisible(false);
                }
                if (adminMenu_addUser_addSupplierNameTF.getText().equalsIgnoreCase("") || adminMenu_addUser_addSupplierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addSupplierEmailTF.getText()) || adminMenu_addUser_addSupplierContactTF.getText().equalsIgnoreCase("") || !isValidContactNumber(adminMenu_addUser_addSupplierContactTF.getText())) {
                    if (adminMenu_addUser_addSupplierNameTF.getText().equalsIgnoreCase("")) {
                        adminMenu_addUser_addSupplierInvalidNameLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addSupplierInvalidNameLabel.setVisible(false);
                    }
                    if (adminMenu_addUser_addSupplierEmailTF.getText().equalsIgnoreCase("") || !isValidEmailAddress(adminMenu_addUser_addSupplierEmailTF.getText())) {
                        adminMenu_addUser_addSupplierInvalidEmailLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addSupplierInvalidEmailLabel.setVisible(false);
                    }
                    if (adminMenu_addUser_addSupplierContactTF.getText().equalsIgnoreCase("") || !isValidContactNumber(adminMenu_addUser_addSupplierContactTF.getText())) {
                        adminMenu_addUser_addSupplierInvalidContactLabel.setVisible(true);
                    } else {
                        adminMenu_addUser_addSupplierInvalidContactLabel.setVisible(false);
                    }
                } else {
                    admin.addNewSupplier(adminMenu_addUser_addSupplierNameTF.getText(), adminMenu_addUser_addSupplierEmailTF.getText(), adminMenu_addUser_addSupplierContactTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_addUser_addSupplier_SupplierAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_addUser_addSupplier_SupplierAdditionFailed.setTitle("Supplier ADDITION FAILED");
                        adminMenu_addUser_addSupplier_SupplierAdditionFailed.setHeaderText("Failed to add Supplier to the database");
                        adminMenu_addUser_addSupplier_SupplierAdditionFailed.showAndWait();
                        primaryStage.setScene(adminMenu_addUserScene);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Supplier");
                    alert.setHeaderText("Supplier added Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(adminMenu_addUserScene);
                }
            });
            adminMenu_addUser_addSupplierCancelButton.setOnAction(e2 -> primaryStage.setScene(adminMenu_addUserScene));
        });

        //***********************************************************
        //Admin Menu -> Edit User Menu
        Label label7 = new Label("Click on your choice");
        styleLabel(label7);
        Button editCashier = new Button("Edit Cashier");
        Button editCustomer = new Button("Edit Customer");
        Button editSupplier = new Button("Edit Supplier");
        Button back2 = new Button("Back");

        styleButton(editCashier);
        styleButton(editCustomer);
        styleButton(editSupplier);
        styleButton(back2);

        editCashier.setPrefSize(300, 30);
        editCustomer.setPrefSize(300, 30);
        editSupplier.setPrefSize(300, 30);
        back2.setPrefSize(300, 30);

        VBox vbox5 = new VBox(label7, editCashier, editCustomer, editSupplier, back2);
        vbox5.setAlignment(Pos.CENTER);
        vbox5.setSpacing(10);
        scene7 = new Scene(vbox5, scene_width, scene_height);
        adminMenu_editUser.setOnAction(e -> primaryStage.setScene(scene7));
        back2.setOnAction(e -> primaryStage.setScene(adminMenuScene));

        //************************************************************
        //Admin Menu -> Edit User Menu -> Edit Cashier Button
        editCashier.setOnAction(e -> {
            GridPane adminMenu_editUser_editCashierGridPane = new GridPane();
            adminMenu_editUser_editCashierGridPane.setAlignment(Pos.CENTER);
            adminMenu_editUser_editCashierGridPane.setHgap(10);
            adminMenu_editUser_editCashierGridPane.setVgap(10);

            Label adminMenu_editUser_editCashierID = new Label("Cashier ID: ");
            styleLabel(adminMenu_editUser_editCashierID);
            TextField adminMenu_editUser_editCashierIDTF = new TextField();
            styleTextField(adminMenu_editUser_editCashierIDTF);
            Label adminMenu_editUser_editCashierInvalidIDLabel = new Label("Cashier ID Invalid");
            adminMenu_editUser_editCashierInvalidIDLabel.setTextFill(Color.RED);
            adminMenu_editUser_editCashierInvalidIDLabel.setVisible(false);

            Label adminMenu_editUser_editCashierField = new Label("Enter edit field: ");
            styleLabel(adminMenu_editUser_editCashierField);
            TextField adminMenu_editUser_editCashierFieldTF = new TextField();
            styleTextField(adminMenu_editUser_editCashierFieldTF);
            Label adminMenu_editUser_editCashierInvalidFieldLabel = new Label("Only Name Or E-mail can be used!");
            adminMenu_editUser_editCashierInvalidFieldLabel.setTextFill(Color.RED);
            adminMenu_editUser_editCashierInvalidFieldLabel.setVisible(false);

            Label adminMenu_editUser_editCashierValue = new Label("Enter edit value: ");
            styleLabel(adminMenu_editUser_editCashierValue);
            TextField adminMenu_editUser_editCashierValueTF = new TextField();
            styleTextField(adminMenu_editUser_editCashierValueTF);

            Button adminMenu_editUser_editCashierCancelButton = new Button("Cancel");
            Button adminMenu_editUser_editCashierSaveButton = new Button("Save");

            styleButton(adminMenu_editUser_editCashierCancelButton);
            styleButton(adminMenu_editUser_editCashierSaveButton);

            adminMenu_editUser_editCashierCancelButton.setPrefSize(200, 30);
            adminMenu_editUser_editCashierSaveButton.setPrefSize(200, 30);

            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierID, 0, 0);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierIDTF, 1, 0);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierInvalidIDLabel, 2, 0);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierField, 0, 1);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierFieldTF, 1, 1);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierInvalidFieldLabel, 2, 1);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierValue, 0, 2);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierValueTF, 1, 2);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierCancelButton, 1, 3);
            adminMenu_editUser_editCashierGridPane.add(adminMenu_editUser_editCashierSaveButton, 0, 3);

            Scene scene = new Scene(adminMenu_editUser_editCashierGridPane, scene_width, scene_height);
            primaryStage.setScene(scene);

            adminMenu_editUser_editCashierSaveButton.setOnAction(e1 -> {
                if (!CheckCashierExistence(admin, adminMenu_editUser_editCashierIDTF.getText())) {
                    adminMenu_editUser_editCashierInvalidIDLabel.setVisible(true);
                } else {
                    adminMenu_editUser_editCashierInvalidIDLabel.setVisible(false);
                }
                if (!(adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("")) {
                    adminMenu_editUser_editCashierInvalidFieldLabel.setVisible(true);
                } else {
                    adminMenu_editUser_editCashierInvalidFieldLabel.setVisible(false);
                }
                if (!CheckCashierExistence(admin, adminMenu_editUser_editCashierIDTF.getText()) || !(adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("")) {
                    if (!CheckCashierExistence(admin, adminMenu_editUser_editCashierIDTF.getText())) {
                        adminMenu_editUser_editCashierInvalidIDLabel.setVisible(true);
                    } else {
                        adminMenu_editUser_editCashierInvalidIDLabel.setVisible(false);
                    }
                    if (!(adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editCashierFieldTF.getText().equalsIgnoreCase("")) {
                        adminMenu_editUser_editCashierInvalidFieldLabel.setVisible(true);
                    } else {
                        adminMenu_editUser_editCashierInvalidFieldLabel.setVisible(false);
                    }
                } else {
                    admin.editCashier(adminMenu_editUser_editCashierIDTF.getText(), adminMenu_editUser_editCashierFieldTF.getText(), adminMenu_editUser_editCashierValueTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_editUser_editCashier_CashierAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_editUser_editCashier_CashierAdditionFailed.setTitle("CASHIER EDITING FAILED");
                        adminMenu_editUser_editCashier_CashierAdditionFailed.setHeaderText("Failed to edit cashier in the database");
                        adminMenu_editUser_editCashier_CashierAdditionFailed.showAndWait();
                        primaryStage.setScene(scene7);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Cashier");
                    alert.setHeaderText("Cashier edited Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(scene7);
                }
            });

            adminMenu_editUser_editCashierCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(scene7);
            });
        });

        //*************************************************************
        //Admin Menu -> Edit User Menu -> Edit Customer Button
        editCustomer.setOnAction(e -> {
            GridPane adminMenu_editUser_editCustomerGridPane = new GridPane();
            adminMenu_editUser_editCustomerGridPane.setAlignment(Pos.CENTER);
            adminMenu_editUser_editCustomerGridPane.setHgap(10);
            adminMenu_editUser_editCustomerGridPane.setVgap(10);

            Label adminMenu_editUser_editCustomerID = new Label("Customer ID: ");
            styleLabel(adminMenu_editUser_editCustomerID);
            TextField adminMenu_editUser_editCustomerIDTF = new TextField();
            styleTextField(adminMenu_editUser_editCustomerIDTF);
            Label adminMenu_editUser_editCustomerInvalidIDLabel = new Label("Customer ID Invalid");
            adminMenu_editUser_editCustomerInvalidIDLabel.setTextFill(Color.RED);
            adminMenu_editUser_editCustomerInvalidIDLabel.setVisible(false);

            Label adminMenu_editUser_editCustomerField = new Label("Enter edit field: ");
            styleLabel(adminMenu_editUser_editCustomerField);
            TextField adminMenu_editUser_editCustomerFieldTF = new TextField();
            styleTextField(adminMenu_editUser_editCustomerFieldTF);
            Label adminMenu_editUser_editCustomerInvalidFieldLabel = new Label("Only Name Or E-mail can be used!");
            adminMenu_editUser_editCustomerInvalidFieldLabel.setTextFill(Color.RED);
            adminMenu_editUser_editCustomerInvalidFieldLabel.setVisible(false);

            Label adminMenu_editUser_editCustomerValue = new Label("Enter edit value: ");
            styleLabel(adminMenu_editUser_editCustomerValue);
            TextField adminMenu_editUser_editCustomerValueTF = new TextField();
            styleTextField(adminMenu_editUser_editCustomerValueTF);

            Button adminMenu_editUser_editCustomerCancelButton = new Button("Cancel");
            Button adminMenu_editUser_editCustomerSaveButton = new Button("Save");

            styleButton(adminMenu_editUser_editCustomerCancelButton);
            styleButton(adminMenu_editUser_editCustomerSaveButton);

            adminMenu_editUser_editCustomerCancelButton.setPrefSize(200, 30);
            adminMenu_editUser_editCustomerSaveButton.setPrefSize(200, 30);

            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerID, 0, 0);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerIDTF, 1, 0);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerInvalidIDLabel, 2, 0);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerField, 0, 1);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerFieldTF, 1, 1);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerInvalidFieldLabel, 2, 1);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerValue, 0, 2);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerValueTF, 1, 2);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerCancelButton, 1, 3);
            adminMenu_editUser_editCustomerGridPane.add(adminMenu_editUser_editCustomerSaveButton, 0, 3);

            Scene scene = new Scene(adminMenu_editUser_editCustomerGridPane, scene_width, scene_height);
            primaryStage.setScene(scene);

            adminMenu_editUser_editCustomerSaveButton.setOnAction(e1 -> {
                if (!CheckCustomerExistence(admin, adminMenu_editUser_editCustomerIDTF.getText())) {
                    adminMenu_editUser_editCustomerInvalidIDLabel.setVisible(true);
                } else {
                    adminMenu_editUser_editCustomerInvalidIDLabel.setVisible(false);
                }
                if (!(adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("")) {
                    adminMenu_editUser_editCustomerInvalidFieldLabel.setVisible(true);
                } else {
                    adminMenu_editUser_editCustomerInvalidFieldLabel.setVisible(false);
                }
                if (!CheckCustomerExistence(admin, adminMenu_editUser_editCustomerIDTF.getText()) || !(adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("")) {
                    if (!CheckCustomerExistence(admin, adminMenu_editUser_editCustomerIDTF.getText())) {
                        adminMenu_editUser_editCustomerInvalidIDLabel.setVisible(true);
                    } else {
                        adminMenu_editUser_editCustomerInvalidIDLabel.setVisible(false);
                    }
                    if (!(adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editCustomerFieldTF.getText().equalsIgnoreCase("")) {
                        adminMenu_editUser_editCustomerInvalidFieldLabel.setVisible(true);
                    } else {
                        adminMenu_editUser_editCustomerInvalidFieldLabel.setVisible(false);
                    }
                } else {
                    admin.editCustomer(adminMenu_editUser_editCustomerIDTF.getText(), adminMenu_editUser_editCustomerFieldTF.getText(), adminMenu_editUser_editCustomerValueTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_editUser_editCustomer_CustomerAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_editUser_editCustomer_CustomerAdditionFailed.setTitle("CUSTOMER EDITING FAILED");
                        adminMenu_editUser_editCustomer_CustomerAdditionFailed.setHeaderText("Failed to edit cashier in the database");
                        adminMenu_editUser_editCustomer_CustomerAdditionFailed.showAndWait();
                        primaryStage.setScene(scene7);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Customer");
                    alert.setHeaderText("Customer edited Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(scene7);
                }
            });

            adminMenu_editUser_editCustomerCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(scene7);
            });
        });

        //*************************************************************
        //Admin Menu -> Edit User Menu -> Edit Supplier Button
        editSupplier.setOnAction(e -> {
            GridPane adminMenu_editUser_editSupplierGridPane = new GridPane();
            adminMenu_editUser_editSupplierGridPane.setAlignment(Pos.CENTER);
            adminMenu_editUser_editSupplierGridPane.setHgap(10);
            adminMenu_editUser_editSupplierGridPane.setVgap(10);

            Label adminMenu_editUser_editSupplierID = new Label("Supplier ID: ");
            styleLabel(adminMenu_editUser_editSupplierID);
            TextField adminMenu_editUser_editSupplierIDTF = new TextField();
            styleTextField(adminMenu_editUser_editSupplierIDTF);
            Label adminMenu_editUser_editSupplierInvalidIDLabel = new Label("Supplier ID Invalid");
            adminMenu_editUser_editSupplierInvalidIDLabel.setTextFill(Color.RED);
            adminMenu_editUser_editSupplierInvalidIDLabel.setVisible(false);

            Label adminMenu_editUser_editSupplierField = new Label("Enter edit field: ");
            styleLabel(adminMenu_editUser_editSupplierField);
            TextField adminMenu_editUser_editSupplierFieldTF = new TextField();
            styleTextField(adminMenu_editUser_editSupplierFieldTF);
            Label adminMenu_editUser_editSupplierInvalidFieldLabel = new Label("Only Name Or E-mail can be used!");
            adminMenu_editUser_editSupplierInvalidFieldLabel.setTextFill(Color.RED);
            adminMenu_editUser_editSupplierInvalidFieldLabel.setVisible(false);

            Label adminMenu_editUser_editSupplierValue = new Label("Enter edit value: ");
            styleLabel(adminMenu_editUser_editSupplierValue);
            TextField adminMenu_editUser_editSupplierValueTF = new TextField();
            styleTextField(adminMenu_editUser_editSupplierValueTF);

            Button adminMenu_editUser_editSupplierCancelButton = new Button("Cancel");
            Button adminMenu_editUser_editSupplierSaveButton = new Button("Save");

            styleButton(adminMenu_editUser_editSupplierCancelButton);
            styleButton(adminMenu_editUser_editSupplierSaveButton);

            adminMenu_editUser_editSupplierCancelButton.setPrefSize(200, 30);
            adminMenu_editUser_editSupplierSaveButton.setPrefSize(200, 30);

            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierID, 0, 0);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierIDTF, 1, 0);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierInvalidIDLabel, 2, 0);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierField, 0, 1);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierFieldTF, 1, 1);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierInvalidFieldLabel, 2, 1);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierValue, 0, 2);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierValueTF, 1, 2);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierCancelButton, 1, 3);
            adminMenu_editUser_editSupplierGridPane.add(adminMenu_editUser_editSupplierSaveButton, 0, 3);

            Scene scene = new Scene(adminMenu_editUser_editSupplierGridPane, scene_width, scene_height);
            primaryStage.setScene(scene);

            adminMenu_editUser_editSupplierSaveButton.setOnAction(e1 -> {
                if (!CheckSupplierExistence(admin, adminMenu_editUser_editSupplierIDTF.getText())) {
                    adminMenu_editUser_editSupplierInvalidIDLabel.setVisible(true);
                } else {
                    adminMenu_editUser_editSupplierInvalidIDLabel.setVisible(false);
                }
                if (!(adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("")) {
                    adminMenu_editUser_editSupplierInvalidFieldLabel.setVisible(true);
                } else {
                    adminMenu_editUser_editSupplierInvalidFieldLabel.setVisible(false);
                }
                if (!CheckSupplierExistence(admin, adminMenu_editUser_editSupplierIDTF.getText()) || !(adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("")) {
                    if (!CheckSupplierExistence(admin, adminMenu_editUser_editSupplierIDTF.getText())) {
                        adminMenu_editUser_editSupplierInvalidIDLabel.setVisible(true);
                    } else {
                        adminMenu_editUser_editSupplierInvalidIDLabel.setVisible(false);
                    }
                    if (!(adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("name") || adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("email")) || adminMenu_editUser_editSupplierFieldTF.getText().equalsIgnoreCase("")) {
                        adminMenu_editUser_editSupplierInvalidFieldLabel.setVisible(true);
                    } else {
                        adminMenu_editUser_editSupplierInvalidFieldLabel.setVisible(false);
                    }
                } else {
                    admin.editSupplier(adminMenu_editUser_editSupplierIDTF.getText(), adminMenu_editUser_editSupplierFieldTF.getText(), adminMenu_editUser_editSupplierValueTF.getText());
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert adminMenu_editUser_editSupplier_SupplierAdditionFailed = new Alert(Alert.AlertType.ERROR);
                        adminMenu_editUser_editSupplier_SupplierAdditionFailed.setTitle("SUPPLIER EDITING FAILED");
                        adminMenu_editUser_editSupplier_SupplierAdditionFailed.setHeaderText("Failed to edit cashier in the database");
                        adminMenu_editUser_editSupplier_SupplierAdditionFailed.showAndWait();
                        primaryStage.setScene(scene7);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Supplier");
                    alert.setHeaderText("Supplier edited Successfully!");
                    alert.showAndWait();
                    primaryStage.setScene(scene7);
                }
            });

            adminMenu_editUser_editSupplierCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(scene7);
            });
        });

        //***********************************************************
        //Admin Menu -> Remove User Menu
        Label label8 = new Label("Click on you choice");
        styleLabel(label8);
        Button removeCashier = new Button("Remove Cashier");
        Button removeCustomer = new Button("Remove Customer");
        Button removeSupplier = new Button("Remove Supplier");
        Button back3 = new Button("Back");

        styleButton(removeCashier);
        styleButton(removeCustomer);
        styleButton(removeSupplier);
        styleButton(back3);

        removeCashier.setPrefSize(200, 30);
        removeCustomer.setPrefSize(200, 30);
        removeSupplier.setPrefSize(200, 30);
        back3.setPrefSize(200, 30);

        VBox vbox6 = new VBox(label8, removeCashier, removeCustomer, removeSupplier, back3);
        vbox6.setAlignment(Pos.CENTER);
        vbox6.setSpacing(10);
        scene8 = new Scene(vbox6, scene_width, scene_height);
        adminMenu_removeUser.setOnAction(e -> primaryStage.setScene(scene8));
        back3.setOnAction(e -> primaryStage.setScene(adminMenuScene));

        //*****************************************************************
        //Admin Menu -> Remove User Menu -> Remove Cashier Button
        removeCashier.setOnAction(e -> {
            GridPane adminMenu_removeCashierGridPane = new GridPane();
            adminMenu_removeCashierGridPane.setAlignment(Pos.CENTER);

            Label removeCashierID = new Label("Enter ID of Cashier to be removed: ");
            styleLabel(removeCashierID);
            Label adminMenu_removeCashierIDWarning = new Label("Cashier Does Not Exist!");
            adminMenu_removeCashierIDWarning.setTextFill(Color.RED);
            adminMenu_removeCashierIDWarning.setVisible(false);
            TextField adminMenu_removeCashierID = new TextField();
            styleTextField(adminMenu_removeCashierID);

            Button adminMenu_removeCashierButton = new Button("Remove Cashier");
            Button adminMenu_removeCashierCancelButton = new Button("Cancel");
            adminMenu_removeCashierButton.setAlignment(Pos.CENTER);
            adminMenu_removeCashierCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_removeCashierButton);
            styleButton(adminMenu_removeCashierCancelButton);

            adminMenu_removeCashierButton.setPrefSize(200, 30);
            adminMenu_removeCashierCancelButton.setPrefSize(200, 30);

            adminMenu_removeCashierGridPane.add(removeCashierID, 0, 0);
            adminMenu_removeCashierGridPane.add(adminMenu_removeCashierID, 1, 0);
            adminMenu_removeCashierGridPane.add(adminMenu_removeCashierIDWarning, 2, 0);
            adminMenu_removeCashierGridPane.add(adminMenu_removeCashierButton, 1, 1);
            adminMenu_removeCashierGridPane.add(adminMenu_removeCashierCancelButton, 1, 2);

            adminMenu_removeCashierGridPane.setHgap(10);
            adminMenu_removeCashierGridPane.setVgap(10);

            Scene removeCashier_scene = new Scene(adminMenu_removeCashierGridPane, scene_width, scene_height);
            primaryStage.setScene(removeCashier_scene);

            adminMenu_removeCashierButton.setOnAction(e1 -> {
                if (!CheckCashierExistence(admin, adminMenu_removeCashierID.getText())) {
                    adminMenu_removeCashierIDWarning.setVisible(true);
                    adminMenu_removeCashierID.setText("");
                } else {
                    adminMenu_removeCashierIDWarning.setVisible(false);
                    if (admin.removeCashier(adminMenu_removeCashierID.getText())) {
                        Alert adminMenu_removeCashier_CashierRemovedAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_removeCashier_CashierRemovedAlert.setTitle("Remove Cashier");
                        try {
                            admin.saveData();
                        } catch (IOException ex) {
                            Alert adminMenu_removeCashier_CashierRemoveFailed = new Alert(Alert.AlertType.ERROR);
                            adminMenu_removeCashier_CashierRemoveFailed.setTitle("CASHIER REMOVE FAILED");
                            adminMenu_removeCashier_CashierRemoveFailed.setHeaderText("Failed to remove cashier from the database");
                            adminMenu_removeCashier_CashierRemoveFailed.showAndWait();
                            primaryStage.setScene(scene8);
                        }
                        adminMenu_removeCashier_CashierRemovedAlert.setHeaderText("Cashier successfully removed!");
                        adminMenu_removeCashier_CashierRemovedAlert.setContentText("Press OK to continue");
                        adminMenu_removeCashier_CashierRemovedAlert.showAndWait();
                        primaryStage.setScene(scene8);
                    }
                }
            });

            adminMenu_removeCashierCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(scene8);
            });
        });

        //*****************************************************************
        //Admin Menu -> Remove User Menu -> Remove Customer Button
        removeCustomer.setOnAction(e -> {
            GridPane adminMenu_removeCustomerGridPane = new GridPane();
            adminMenu_removeCustomerGridPane.setAlignment(Pos.CENTER);

            Label removeCustomerID = new Label("Enter ID of Customer to be removed: ");
            styleLabel(removeCustomerID);
            Label adminMenu_removeCustomerIDWarning = new Label("Customer Does Not Exist!");
            adminMenu_removeCustomerIDWarning.setTextFill(Color.RED);
            adminMenu_removeCustomerIDWarning.setVisible(false);
            TextField adminMenu_removeCustomerID = new TextField();
            styleTextField(adminMenu_removeCustomerID);

            Button adminMenu_removeCustomerButton = new Button("Remove Customer");
            Button adminMenu_removeCustomerCancelButton = new Button("Cancel");
            adminMenu_removeCustomerButton.setAlignment(Pos.CENTER);
            adminMenu_removeCustomerCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_removeCustomerButton);
            styleButton(adminMenu_removeCustomerCancelButton);

            adminMenu_removeCustomerButton.setPrefSize(200, 30);
            adminMenu_removeCustomerCancelButton.setPrefSize(200, 30);

            adminMenu_removeCustomerGridPane.add(removeCustomerID, 0, 0);
            adminMenu_removeCustomerGridPane.add(adminMenu_removeCustomerID, 1, 0);
            adminMenu_removeCustomerGridPane.add(adminMenu_removeCustomerIDWarning, 2, 0);
            adminMenu_removeCustomerGridPane.add(adminMenu_removeCustomerButton, 1, 1);
            adminMenu_removeCustomerGridPane.add(adminMenu_removeCustomerCancelButton, 1, 2);

            adminMenu_removeCustomerGridPane.setHgap(10);
            adminMenu_removeCustomerGridPane.setVgap(10);

            Scene removeCustomer_scene = new Scene(adminMenu_removeCustomerGridPane, scene_width, scene_height);
            primaryStage.setScene(removeCustomer_scene);

            adminMenu_removeCustomerButton.setOnAction(e1 -> {
                if (!CheckCustomerExistence(admin, adminMenu_removeCustomerID.getText())) {
                    adminMenu_removeCustomerIDWarning.setVisible(true);
                    adminMenu_removeCustomerID.setText("");
                } else {
                    adminMenu_removeCustomerIDWarning.setVisible(false);
                    if (admin.removeCustomer(adminMenu_removeCustomerID.getText())) {
                        Alert adminMenu_removeCustomer_CustomerRemovedAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_removeCustomer_CustomerRemovedAlert.setTitle("Remove Customer");
                        try {
                            admin.saveData();
                        } catch (IOException ex) {
                            Alert adminMenu_removeCustomer_CustomerRemoveFailed = new Alert(Alert.AlertType.ERROR);
                            adminMenu_removeCustomer_CustomerRemoveFailed.setTitle("CUSTOMER REMOVE FAILED");
                            adminMenu_removeCustomer_CustomerRemoveFailed.setHeaderText("Failed to remove customer from the database");
                            adminMenu_removeCustomer_CustomerRemoveFailed.showAndWait();
                            primaryStage.setScene(scene8);
                        }
                        adminMenu_removeCustomer_CustomerRemovedAlert.setHeaderText("Customer successfully removed!");
                        adminMenu_removeCustomer_CustomerRemovedAlert.setContentText("Press OK to continue");
                        adminMenu_removeCustomer_CustomerRemovedAlert.showAndWait();
                        primaryStage.setScene(scene8);
                    }
                }
            });

            adminMenu_removeCustomerCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(scene8);
            });
        });

        //*****************************************************************
        //Admin Menu -> Remove User Menu -> Remove Supplier Button
        removeSupplier.setOnAction(e -> {
            GridPane adminMenu_removeSupplierGridPane = new GridPane();
            adminMenu_removeSupplierGridPane.setAlignment(Pos.CENTER);

            Label removeSupplierID = new Label("Enter ID of Supplier to be removed: ");
            styleLabel(removeSupplierID);
            Label adminMenu_removeSupplierIDWarning = new Label("Supplier Does Not Exist!");
            adminMenu_removeSupplierIDWarning.setTextFill(Color.RED);
            adminMenu_removeSupplierIDWarning.setVisible(false);
            TextField adminMenu_removeSupplierID = new TextField();
            styleTextField(adminMenu_removeSupplierID);

            Button adminMenu_removeSupplierButton = new Button("Remove Supplier");
            Button adminMenu_removeSupplierCancelButton = new Button("Cancel");
            adminMenu_removeSupplierButton.setAlignment(Pos.CENTER);
            adminMenu_removeSupplierCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_removeSupplierButton);
            styleButton(adminMenu_removeSupplierCancelButton);

            adminMenu_removeSupplierButton.setPrefSize(200, 30);
            adminMenu_removeSupplierCancelButton.setPrefSize(200, 30);

            adminMenu_removeSupplierGridPane.add(removeSupplierID, 0, 0);
            adminMenu_removeSupplierGridPane.add(adminMenu_removeSupplierID, 1, 0);
            adminMenu_removeSupplierGridPane.add(adminMenu_removeSupplierIDWarning, 2, 0);
            adminMenu_removeSupplierGridPane.add(adminMenu_removeSupplierButton, 1, 1);
            adminMenu_removeSupplierGridPane.add(adminMenu_removeSupplierCancelButton, 1, 2);

            adminMenu_removeSupplierGridPane.setHgap(10);
            adminMenu_removeSupplierGridPane.setVgap(10);

            Scene removeSupplier_scene = new Scene(adminMenu_removeSupplierGridPane, scene_width, scene_height);
            primaryStage.setScene(removeSupplier_scene);

            adminMenu_removeSupplierButton.setOnAction(e1 -> {
                if (!CheckSupplierExistence(admin, adminMenu_removeSupplierID.getText())) {
                    adminMenu_removeSupplierIDWarning.setVisible(true);
                    adminMenu_removeSupplierID.setText("");
                } else {
                    adminMenu_removeSupplierIDWarning.setVisible(false);
                    if (admin.removeSupplier(adminMenu_removeSupplierID.getText())) {
                        Alert adminMenu_removeSupplier_SupplierRemovedAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_removeSupplier_SupplierRemovedAlert.setTitle("Remove Supplier");
                        try {
                            admin.saveData();
                        } catch (IOException ex) {
                            Alert adminMenu_removeSupplier_SupplierRemoveFailed = new Alert(Alert.AlertType.ERROR);
                            adminMenu_removeSupplier_SupplierRemoveFailed.setTitle("SUPPLIER REMOVE FAILED");
                            adminMenu_removeSupplier_SupplierRemoveFailed.setHeaderText("Failed to remove supplier from the database");
                            adminMenu_removeSupplier_SupplierRemoveFailed.showAndWait();
                            primaryStage.setScene(scene8);
                        }
                        adminMenu_removeSupplier_SupplierRemovedAlert.setHeaderText("Supplier successfully removed!");
                        adminMenu_removeSupplier_SupplierRemovedAlert.setContentText("Press OK to continue");
                        adminMenu_removeSupplier_SupplierRemovedAlert.showAndWait();
                        primaryStage.setScene(scene8);
                    }
                }
            });

            adminMenu_removeSupplierCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(scene8);
            });
        });


        //***********************************************************
        //Admin Menu -> Search User Menu
        Label label9 = new Label("Click on your choice");
        styleLabel(label9);
        Button searchCashier = new Button("Search for a Cashier");
        Button searchCustomer = new Button("Search for a Customer");
        Button searchSupplier = new Button("Search for a Supplier");
        Button back4 = new Button("Back");

        styleButton(searchCashier);
        styleButton(searchCustomer);
        styleButton(searchSupplier);
        styleButton(back4);

        searchCashier.setPrefSize(300, 30);
        searchCustomer.setPrefSize(300, 30);
        searchSupplier.setPrefSize(300, 30);
        back4.setPrefSize(300, 30);

        VBox vbox7 = new VBox(label9, searchCashier, searchCustomer, searchSupplier, back4);
        vbox7.setAlignment(Pos.CENTER);
        vbox7.setSpacing(10);
        scene9 = new Scene(vbox7, scene_width, scene_height);
        adminMenu_searchUser.setOnAction(e -> primaryStage.setScene(scene9));
        back4.setOnAction(e -> primaryStage.setScene(adminMenuScene));

        //****************************************************************************
        //Admin Menu -> Search User Menu -> Search Cashier Button
        searchCashier.setOnAction(e -> {
            GridPane adminMenu_searchCashierGridPane = new GridPane();
            adminMenu_searchCashierGridPane.setAlignment(Pos.CENTER);

            Label searchCashierField = new Label("Enter Search Field: ");
            styleLabel(searchCashierField);
            Label adminMenu_searchCashier_CashierFieldWarning = new Label("Only Name, or ID, or Email can be used!");
            adminMenu_searchCashier_CashierFieldWarning.setTextFill(Color.RED);
            adminMenu_searchCashier_CashierFieldWarning.setVisible(false);
            TextField adminMenu_searchCashier_CashierField = new TextField();
            styleTextField(adminMenu_searchCashier_CashierField);

            Label searchCashierValue = new Label("Enter Value to Search with: ");
            styleLabel(searchCashierValue);
            TextField adminMenu_searchCashier_CashierValue = new TextField();
            styleTextField(adminMenu_searchCashier_CashierValue);

            Button adminMenu_searchCashierButton = new Button("Search Cashier");
            Button adminMenu_searchCashierCancelButton = new Button("Cancel");
            adminMenu_searchCashierButton.setAlignment(Pos.CENTER);
            adminMenu_searchCashierCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_searchCashierButton);
            styleButton(adminMenu_searchCashierCancelButton);

            adminMenu_searchCashierButton.setPrefSize(300, 30);
            adminMenu_searchCashierCancelButton.setPrefSize(300, 30);

            adminMenu_searchCashierGridPane.add(searchCashierField, 0, 0);
            adminMenu_searchCashierGridPane.add(adminMenu_searchCashier_CashierField, 1, 0);
            adminMenu_searchCashierGridPane.add(adminMenu_searchCashier_CashierFieldWarning, 2, 0);
            adminMenu_searchCashierGridPane.add(searchCashierValue, 0, 1);
            adminMenu_searchCashierGridPane.add(adminMenu_searchCashier_CashierValue, 1, 1);
            adminMenu_searchCashierGridPane.add(adminMenu_searchCashierButton, 0, 3);
            adminMenu_searchCashierGridPane.add(adminMenu_searchCashierCancelButton, 0, 4);

            adminMenu_searchCashierGridPane.setHgap(10);
            adminMenu_searchCashierGridPane.setVgap(10);

            Scene searchCashier_scene = new Scene(adminMenu_searchCashierGridPane, scene_width, scene_height);
            primaryStage.setScene(searchCashier_scene);

            adminMenu_searchCashierButton.setOnAction(e1 -> {
                if (adminMenu_searchCashier_CashierField.getText().equalsIgnoreCase("name") || adminMenu_searchCashier_CashierField.getText().equalsIgnoreCase("id") || adminMenu_searchCashier_CashierField.getText().equalsIgnoreCase("email")) {
                    adminMenu_searchCashier_CashierFieldWarning.setVisible(false);
                    if (admin.searchCashierByField(adminMenu_searchCashier_CashierField.getText(), adminMenu_searchCashier_CashierValue.getText()) == null) {
                        Alert adminMenu_searchCashier_CashierSearchAlert = new Alert(Alert.AlertType.ERROR);
                        adminMenu_searchCashier_CashierSearchAlert.setHeaderText("CASHIER NOT FOUND!");
                        adminMenu_searchCashier_CashierSearchAlert.showAndWait();
                        adminMenu_searchCashier_CashierValue.setText("");
                        adminMenu_searchCashier_CashierField.setText("");
                        primaryStage.setScene(searchCashier_scene);
                    } else {
                        Cashier ca = new Cashier(admin.searchCashierByField(adminMenu_searchCashier_CashierField.getText(), adminMenu_searchCashier_CashierValue.getText()));
                        Alert adminMenu_searchCashier_CashierSearchAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_searchCashier_CashierSearchAlert.setTitle("Search Cashier");
                        adminMenu_searchCashier_CashierSearchAlert.setHeaderText("Cashier found:\n" + ca.toString());
                        adminMenu_searchCashier_CashierSearchAlert.setContentText("Press OK to continue");
                        adminMenu_searchCashier_CashierSearchAlert.showAndWait();
                        primaryStage.setScene(scene9);
                    }
                } else {
                    adminMenu_searchCashier_CashierFieldWarning.setVisible(true);
                    adminMenu_searchCashier_CashierField.setText("");
                }
            });

            adminMenu_searchCashierCancelButton.setOnAction(e2 -> {
                primaryStage.setScene(scene9);
            });
        });

        //*************************************************************************************
        //Admin Menu -> Search User Menu -> Search Customer Button
        searchCustomer.setOnAction(e -> {
            GridPane adminMenu_searchCustomerGridPane = new GridPane();
            adminMenu_searchCustomerGridPane.setAlignment(Pos.CENTER);

            Label searchCustomerField = new Label("Enter Search Field: ");
            styleLabel(searchCustomerField);
            Label adminMenu_searchCustomer_CustomerFieldWarning = new Label("Only Name, or ID, or Email can be used!");
            adminMenu_searchCustomer_CustomerFieldWarning.setTextFill(Color.RED);
            adminMenu_searchCustomer_CustomerFieldWarning.setVisible(false);
            TextField adminMenu_searchCustomer_CustomerField = new TextField();
            styleTextField(adminMenu_searchCustomer_CustomerField);

            Label searchCustomerValue = new Label("Enter Value to Search with: ");
            styleLabel(searchCustomerValue);
            TextField adminMenu_searchCustomer_CustomerValue = new TextField();
            styleTextField(adminMenu_searchCustomer_CustomerValue);

            Button adminMenu_searchCustomerButton = new Button("Search Customer");
            Button adminMenu_searchCustomerCancelButton = new Button("Cancel");
            adminMenu_searchCustomerButton.setAlignment(Pos.CENTER);
            adminMenu_searchCustomerButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_searchCustomerButton);
            styleButton(adminMenu_searchCustomerCancelButton);

            adminMenu_searchCustomerButton.setPrefSize(300, 30);
            adminMenu_searchCustomerCancelButton.setPrefSize(300, 30);

            adminMenu_searchCustomerGridPane.add(searchCustomerField, 0, 0);
            adminMenu_searchCustomerGridPane.add(adminMenu_searchCustomer_CustomerField, 1, 0);
            adminMenu_searchCustomerGridPane.add(adminMenu_searchCustomer_CustomerFieldWarning, 2, 0);
            adminMenu_searchCustomerGridPane.add(searchCustomerValue, 0, 1);
            adminMenu_searchCustomerGridPane.add(adminMenu_searchCustomer_CustomerValue, 1, 1);
            adminMenu_searchCustomerGridPane.add(adminMenu_searchCustomerButton, 0, 3);
            adminMenu_searchCustomerGridPane.add(adminMenu_searchCustomerCancelButton, 0, 4);

            adminMenu_searchCustomerGridPane.setHgap(10);
            adminMenu_searchCustomerGridPane.setVgap(10);

            Scene searchCustomer_scene = new Scene(adminMenu_searchCustomerGridPane, scene_width, scene_height);
            primaryStage.setScene(searchCustomer_scene);

            adminMenu_searchCustomerButton.setOnAction(e1 -> {
                if (adminMenu_searchCustomer_CustomerField.getText().equalsIgnoreCase("name") || adminMenu_searchCustomer_CustomerField.getText().equalsIgnoreCase("id") || adminMenu_searchCustomer_CustomerField.getText().equalsIgnoreCase("email")) {
                    adminMenu_searchCustomer_CustomerFieldWarning.setVisible(false);
                    if (admin.searchCustomerByField(adminMenu_searchCustomer_CustomerField.getText(), adminMenu_searchCustomer_CustomerValue.getText()) == null) {
                        Alert adminMenu_searchCustomer_CustomerSearchAlert = new Alert(Alert.AlertType.ERROR);
                        adminMenu_searchCustomer_CustomerSearchAlert.setHeaderText("CUSTOMER NOT FOUND!");
                        adminMenu_searchCustomer_CustomerSearchAlert.showAndWait();
                        adminMenu_searchCustomer_CustomerValue.setText("");
                        adminMenu_searchCustomer_CustomerField.setText("");
                        primaryStage.setScene(searchCustomer_scene);
                    } else {
                        Customer cu = new Customer(admin.searchCustomerByField(adminMenu_searchCustomer_CustomerField.getText(), adminMenu_searchCustomer_CustomerValue.getText()));
                        Alert adminMenu_searchCustomer_CustomerSearchAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_searchCustomer_CustomerSearchAlert.setTitle("Search Customer");
                        adminMenu_searchCustomer_CustomerSearchAlert.setHeaderText("Customer found:\n" + cu.toString());
                        adminMenu_searchCustomer_CustomerSearchAlert.setContentText("Press OK to continue");
                        adminMenu_searchCustomer_CustomerSearchAlert.showAndWait();
                        primaryStage.setScene(scene9);
                    }
                } else {
                    adminMenu_searchCustomer_CustomerFieldWarning.setVisible(true);
                    adminMenu_searchCustomer_CustomerField.setText("");
                }
            });

            adminMenu_searchCustomerCancelButton.setOnAction(e2 -> {
                primaryStage.setScene(scene9);
            });
        });

        //*****************************************************************************
        //Admin Menu -> Search User Menu -> Search Supplier Button
        searchSupplier.setOnAction(e -> {
            GridPane adminMenu_searchSupplierGridPane = new GridPane();
            adminMenu_searchSupplierGridPane.setAlignment(Pos.CENTER);

            Label searchSupplierField = new Label("Enter Search Field: ");
            styleLabel(searchSupplierField);
            Label adminMenu_searchSupplier_SupplierFieldWarning = new Label("Only Name, or ID, or Email can be used!");
            adminMenu_searchSupplier_SupplierFieldWarning.setTextFill(Color.RED);
            adminMenu_searchSupplier_SupplierFieldWarning.setVisible(false);
            TextField adminMenu_searchSupplier_SupplierField = new TextField();
            styleTextField(adminMenu_searchSupplier_SupplierField);

            Label searchSupplierValue = new Label("Enter Value to Search with: ");
            styleLabel(searchSupplierValue);
            TextField adminMenu_searchSupplier_SupplierValue = new TextField();
            styleTextField(adminMenu_searchSupplier_SupplierValue);

            Button adminMenu_searchSupplierButton = new Button("Search Supplier");
            Button adminMenu_searchSupplierCancelButton = new Button("Cancel");
            adminMenu_searchSupplierButton.setAlignment(Pos.CENTER);
            adminMenu_searchSupplierCancelButton.setAlignment(Pos.CENTER);

            styleButton(adminMenu_searchSupplierButton);
            styleButton(adminMenu_searchSupplierCancelButton);

            adminMenu_searchSupplierButton.setPrefSize(300, 30);
            adminMenu_searchSupplierCancelButton.setPrefSize(300, 30);

            adminMenu_searchSupplierGridPane.add(searchSupplierField, 0, 0);
            adminMenu_searchSupplierGridPane.add(adminMenu_searchSupplier_SupplierField, 1, 0);
            adminMenu_searchSupplierGridPane.add(adminMenu_searchSupplier_SupplierFieldWarning, 2, 0);
            adminMenu_searchSupplierGridPane.add(searchSupplierValue, 0, 1);
            adminMenu_searchSupplierGridPane.add(adminMenu_searchSupplier_SupplierValue, 1, 1);
            adminMenu_searchSupplierGridPane.add(adminMenu_searchSupplierButton, 0, 3);
            adminMenu_searchSupplierGridPane.add(adminMenu_searchSupplierCancelButton, 0, 4);

            adminMenu_searchSupplierGridPane.setHgap(10);
            adminMenu_searchSupplierGridPane.setVgap(10);

            Scene searchSupplier_scene = new Scene(adminMenu_searchSupplierGridPane, scene_width, scene_height);
            primaryStage.setScene(searchSupplier_scene);

            adminMenu_searchSupplierButton.setOnAction(e1 -> {
                if (adminMenu_searchSupplier_SupplierField.getText().equalsIgnoreCase("name") || adminMenu_searchSupplier_SupplierField.getText().equalsIgnoreCase("id") || adminMenu_searchSupplier_SupplierField.getText().equalsIgnoreCase("email")) {
                    adminMenu_searchSupplier_SupplierFieldWarning.setVisible(false);
                    if (admin.searchSupplierByField(adminMenu_searchSupplier_SupplierField.getText(), adminMenu_searchSupplier_SupplierValue.getText()) == null) {
                        Alert adminMenu_searchSupplier_SupplierSearchAlert = new Alert(Alert.AlertType.ERROR);
                        adminMenu_searchSupplier_SupplierSearchAlert.setHeaderText("SUPPLIER NOT FOUND!");
                        adminMenu_searchSupplier_SupplierSearchAlert.showAndWait();
                        adminMenu_searchSupplier_SupplierValue.setText("");
                        adminMenu_searchSupplier_SupplierField.setText("");
                        primaryStage.setScene(searchSupplier_scene);
                    } else {
                        Supplier s = new Supplier(admin.searchSupplierByField(adminMenu_searchSupplier_SupplierField.getText(), adminMenu_searchSupplier_SupplierValue.getText()));
                        Alert adminMenu_searchSupplier_SupplierSearchAlert = new Alert(Alert.AlertType.INFORMATION);
                        adminMenu_searchSupplier_SupplierSearchAlert.setTitle("Search Supplier");
                        adminMenu_searchSupplier_SupplierSearchAlert.setHeaderText("Supplier found:\n" + s.toString());
                        adminMenu_searchSupplier_SupplierSearchAlert.setContentText("Press OK to continue");
                        adminMenu_searchSupplier_SupplierSearchAlert.showAndWait();
                        primaryStage.setScene(scene9);
                    }
                } else {
                    adminMenu_searchSupplier_SupplierFieldWarning.setVisible(true);
                    adminMenu_searchSupplier_SupplierField.setText("");
                }
            });

            adminMenu_searchSupplierCancelButton.setOnAction(e2 -> {
                primaryStage.setScene(scene9);
            });
        });


        //***********************************************************
        //Admin Menu -> User Report Menu
        Label label10 = new Label("Click on your choice");
        styleLabel(label10);
        Button cashierReport = new Button("View Report About Cashiers");
        Button customerReport = new Button("View Report About Customers");
        Button supplierReport = new Button("View Report About Suppliers");
        Button back5 = new Button("Back");

        styleButton(cashierReport);
        styleButton(customerReport);
        styleButton(supplierReport);
        styleButton(back5);

        cashierReport.setPrefSize(300, 30);
        customerReport.setPrefSize(300, 30);
        supplierReport.setPrefSize(300, 30);
        back5.setPrefSize(300, 30);

        VBox vbox8 = new VBox(cashierReport, customerReport, supplierReport, back5);
        vbox8.setAlignment(Pos.CENTER);
        vbox8.setSpacing(10);
        Scene userReportScene = new Scene(vbox8, scene_width, scene_height);
        adminMenu_userReport.setOnAction(e -> primaryStage.setScene(userReportScene));
        back5.setOnAction(e -> primaryStage.setScene(adminMenuScene));

        //********************************************************************************
        //Admin Menu -> User Report Menu -> Cashier Report Button
        cashierReport.setOnAction(e -> {
            Label titleLabel = new Label("Cashier Reports");
            titleLabel.setFont(Font.font("System", FontWeight.BOLD, 25));
            titleLabel.setUnderline(true);

            // Creates a GridPane for layout
            GridPane cashierReportGridPane = new GridPane();
            cashierReportGridPane.setAlignment(Pos.CENTER);
            cashierReportGridPane.setHgap(15);
            cashierReportGridPane.setVgap(15);
            cashierReportGridPane.add(titleLabel, 0, 0);

            int rowIndex = 1;

            // Placeholder for Cashier Data
            Map<Cashier, List<Cart>> cashierOrders = new HashMap<>();
            for (Cashier cashier1 : admin.getCashiers()) {
                cashierOrders.put(cashier1, cashier1.getOrdersHandled());
            }

            // Display Number of Orders and Order Details per Cashier
            for (Map.Entry<Cashier, List<Cart>> entry : cashierOrders.entrySet()) {
                Cashier cashier1 = entry.getKey();
                List<Cart> orders = entry.getValue();

                Label cashierLabel = new Label("Cashier: " + cashier1.getName());
                cashierLabel.setFont(Font.font("System", FontWeight.BOLD, 15));
                Label orderCountLabel = new Label("Number of Orders: " + orders.size());

                cashierReportGridPane.add(cashierLabel, 0, rowIndex++);
                cashierReportGridPane.add(orderCountLabel, 0, rowIndex++);

                for (Cart order : orders) {
                    Label orderDetails = new Label("Order: " + order.toString());
                    cashierReportGridPane.add(orderDetails, 0, rowIndex++);
                }

                rowIndex++;
            }

            // Calculate Cashier with Maximum Orders
            Cashier maxOrdersCashier = null;
            int maxOrders = 0;

            for (Map.Entry<Cashier, List<Cart>> entry : cashierOrders.entrySet()) {
                if (entry.getValue().size() > maxOrders) {
                    maxOrders = entry.getValue().size();
                    maxOrdersCashier = entry.getKey();
                }
            }

            Label maxOrdersLabel = new Label("Cashier with Maximum Number of Orders:");
            maxOrdersLabel.setFont(Font.font("System", FontWeight.BOLD, 20));
            cashierReportGridPane.add(maxOrdersLabel, 0, rowIndex++);

            if (maxOrdersCashier != null) {
                Label cashierNameLabel = new Label("Cashier: " + maxOrdersCashier.getName());
                Label maxOrdersCountLabel = new Label("Number of Orders: " + maxOrders);
                cashierReportGridPane.add(cashierNameLabel, 0, rowIndex++);
                cashierReportGridPane.add(maxOrdersCountLabel, 0, rowIndex++);
            } else {
                Label noOrdersLabel = new Label("No cashiers to determine the maximum number of orders.");
                cashierReportGridPane.add(noOrdersLabel, 0, rowIndex++);
            }

            // Calculate Cashier with Maximum Revenue
            Cashier maxRevenueCashier = null;
            double maxRevenue = 0;

            for (Map.Entry<Cashier, List<Cart>> entry : cashierOrders.entrySet()) {
                double totalRevenue = 0;
                for (Cart order : entry.getValue()) {
                    totalRevenue += order.getTotalPrice();
                }
                if (totalRevenue > maxRevenue) {
                    maxRevenue = totalRevenue;
                    maxRevenueCashier = entry.getKey();
                }
            } //s

            Label maxRevenueLabel = new Label("Cashier with Maximum Revenue:");
            maxRevenueLabel.setFont(Font.font("System", FontWeight.BOLD, 20));
            cashierReportGridPane.add(maxRevenueLabel, 0, rowIndex++);

            if (maxRevenueCashier != null) {
                Label cashierRevenueLabel = new Label("Cashier: " + maxRevenueCashier.getName());
                Label maxRevenueValueLabel = new Label("Total Revenue: $" + String.format("%.2f", maxRevenue));
                cashierReportGridPane.add(cashierRevenueLabel, 0, rowIndex++);
                cashierReportGridPane.add(maxRevenueValueLabel, 0, rowIndex++);
            } else {
                Label noRevenueLabel = new Label("No cashiers to determine the maximum revenue.");
                cashierReportGridPane.add(noRevenueLabel, 0, rowIndex++);
            }

            // Back Button to return to Admin Menu
            Button backButton = new Button("Back");
            styleButton(backButton);
            backButton.setPrefSize(100, 30);
            cashierReportGridPane.add(backButton, 0, rowIndex++);
            backButton.setOnAction(e1 -> primaryStage.setScene(userReportScene));

            // Add GridPane to a ScrollPane for large data
            ScrollPane scrollPane = new ScrollPane(cashierReportGridPane);
            scrollPane.setFitToWidth(true);

            // Creates and sets the Scene
            Scene cashierReportScene = new Scene(scrollPane, scene_width, scene_height);
            primaryStage.setScene(cashierReportScene);
        });

        //********************************************************************************
        //Admin Menu -> User Report Menu -> Customer Report Button
        customerReport.setOnAction(e -> {
            Label label11 = new Label("Number of Orders per each Customer and their details:");
            label11.setFont(Font.font("System", FontWeight.BOLD, 25));
            label11.setUnderline(true);
            GridPane adminMenu_userReportGridPane = new GridPane();
            adminMenu_userReportGridPane.setAlignment(Pos.CENTER);
            adminMenu_userReportGridPane.setHgap(15);
            adminMenu_userReportGridPane.setVgap(15);
            adminMenu_userReportGridPane.add(label11, 0, 0);
            int i1 = 1;
            for (Customer customer1 : admin.getCustomers()) {
                Label label12 = new Label(customer1.getId() + " Order History:");
                Label label13 = new Label("Number of Orders for customer: " + customer1.getOrderHistory().size());
                label12.setFont(Font.font("System", FontWeight.BOLD, 15));
                adminMenu_userReportGridPane.add(label12, 0, i1);
                i1++;
                adminMenu_userReportGridPane.add(label13, 0, i1);
                i1++;
                for(Cart order : customer1.getOrderHistory()) {
                    Label label14 = new Label(order.toString());
                    adminMenu_userReportGridPane.add(label14, 0, i1++);
                }
            }


            //Customer with the maximum number of Orders and Revenue
            Label CustomerMaxOrder = new Label("Customer with the maximum number of Orders: ");
            CustomerMaxOrder.setFont(Font.font("System", FontWeight.BOLD, 25));
            CustomerMaxOrder.setUnderline(true);
            Label CustomerMaxRevenue = new Label("Customer with the maximum Revenue: ");
            CustomerMaxRevenue.setFont(Font.font("System", FontWeight.BOLD, 25));
            CustomerMaxRevenue.setUnderline(true);
            adminMenu_userReportGridPane.add(CustomerMaxOrder, 0, i1);
            i1++;
            Customer maxOrderCustomer = null;
            double maxOrders_customer = 0;
            Customer maxRevenueCustomer = null;
            double maxRevenue_customer = 0;
            for (Customer customer2 : admin.getCustomers()) {
                if (customer2.getOrderHistory().size() > maxOrders_customer) {
                    maxOrders_customer = customer2.getOrderHistory().size() ;
                    maxOrderCustomer = customer2;
                }
                if (customer2.getTotalPriceOfAllOrders() > maxRevenue_customer) {
                    maxRevenue_customer = customer2.getTotalPriceOfAllOrders();
                    maxRevenueCustomer = customer2;
                }
            }
            if (maxOrderCustomer != null && maxRevenueCustomer != null) {
                Label CustomerMaxOrderInfo = new Label("Customer: " + maxOrderCustomer);
                adminMenu_userReportGridPane.add(CustomerMaxOrderInfo, 0, i1);
                i1++;
                Label CustomerMaxNumOfOrder = new Label("Number of Orders: " + maxOrders_customer);
                adminMenu_userReportGridPane.add(CustomerMaxNumOfOrder, 0, i1);
                i1++;
                adminMenu_userReportGridPane.add(CustomerMaxRevenue, 0, i1);
                i1++;
                Label CustomerMaxRevenueInfo = new Label("Customer: " + maxRevenueCustomer);
                adminMenu_userReportGridPane.add(CustomerMaxRevenueInfo, 0, i1);
                i1++;
                Label maxRevenueInfo = new Label("Revenue: " + maxRevenue_customer);
                adminMenu_userReportGridPane.add(maxRevenueInfo, 0, i1);
            } else {
                Label noCustomer = new Label("No customers to determine the maximum no. of Orders");
                adminMenu_userReportGridPane.add(noCustomer, 0, i1);
            }

            i1++;
            Button back6 = new Button("Back");
            styleButton(back6);
            back6.setPrefSize(100, 30);
            adminMenu_userReportGridPane.add(back6, 0, i1);
            back6.setOnAction(e1 -> primaryStage.setScene(userReportScene));
            ScrollPane scrollPane = new ScrollPane(adminMenu_userReportGridPane);
            scrollPane.setFitToWidth(true);
            Scene scene11 = new Scene(scrollPane, scene_width, scene_width);
            primaryStage.setScene(scene11);
        });

        //********************************************************************************
        //Admin Menu -> User Report Menu -> Supplier Report Button
        supplierReport.setOnAction(e -> {
            Label label19 = new Label("Number of Orders per each Supplier and their details:");
            label19.setFont(Font.font("System", FontWeight.BOLD, 25));
            label19.setUnderline(true);

            GridPane adminMenu_supplierReportGridPane = new GridPane();
            adminMenu_supplierReportGridPane.setAlignment(Pos.CENTER);
            adminMenu_supplierReportGridPane.setHgap(15);
            adminMenu_supplierReportGridPane.setVgap(15);
            adminMenu_supplierReportGridPane.add(label19, 0, 0);
            int i2 = 1;
            for (Supplier supplier : admin.getSuppliers()) {
                Label label20 = new Label(supplier.getName() + " Orders Details:");
                Label label21 = new Label("Number of Orders: " + supplier.getProductCount());
                label20.setFont(Font.font("System", FontWeight.BOLD, 15));
                adminMenu_supplierReportGridPane.add(label20, 0, i2);
                i2++;
                adminMenu_supplierReportGridPane.add(label21, 0, i2);
                i2++;
                for(Product order : supplier.getProductSupplied()) {
                    Label label22 = new Label(order.toString());
                    adminMenu_supplierReportGridPane.add(label22, 0, i2);
                    i2++;
                }
                i2++;
            }
            //Supplier with maximum number of Orders
            Label label23 = new Label("Supplier with maximum number of Orders:");
            label23.setFont(Font.font("System", FontWeight.BOLD, 25));
            label23.setUnderline(true);
            adminMenu_supplierReportGridPane.add(label23, 0, i2);
            i2++;
            int maxOrders_sup = 0;
            Supplier maxOrderSupplier = null;
            for (Supplier supplier : admin.getSuppliers()) {
                if(supplier.getProductCount() > maxOrders_sup)
                {
                    maxOrders_sup = supplier.getProductCount();
                    //maxOrderSupplier = supplier;
                    maxOrderSupplier = new Supplier(supplier);
                }
            }
            if (maxOrderSupplier != null) {
                Label label24 = new Label("Supplier: " + maxOrderSupplier);
                adminMenu_supplierReportGridPane.add(label24, 0, i2);
                i2++;
                Label label25 = new Label("Number of Orders: " + maxOrders_sup);
                adminMenu_supplierReportGridPane.add(label25, 0, i2);
            } else {
                Label label26 = new Label("No suppliers to determine the maximum no. of Orders");
                adminMenu_supplierReportGridPane.add(label26, 0, i2);
            }
            i2++;
            //Supplier with maximum number of revenue
            Label label27 = new Label("Supplier with maximum number of revenue:");
            label27.setFont(Font.font("System", FontWeight.BOLD, 25));
            label27.setUnderline(true);
            adminMenu_supplierReportGridPane.add(label27, 0, i2);
            i2++;
            Supplier maxRevSupplier = null;
            double maxRevSupplierRev = 0.0;
            for (Supplier supplier : admin.getSuppliers()) {
                if (supplier.getTotalPriceOfAllOrders() > maxRevSupplierRev) {
                    maxRevSupplierRev = supplier.getTotalPriceOfAllOrders();
                    maxRevSupplier = supplier;
                }
            }
            if (maxRevSupplier != null) {
                Label label28 = new Label("Supplier: " + maxRevSupplier);
                adminMenu_supplierReportGridPane.add(label28, 0, i2);
                i2++;
                Label label29 = new Label("Revenue: " + maxRevSupplierRev);
                adminMenu_supplierReportGridPane.add(label29, 0, i2);
                i2++;
            } else {
                Label label30 = new Label("No suppliers to determine the maximum revenue");
                adminMenu_supplierReportGridPane.add(label30, 0, i2);
            }
            i2++;
            Button back7 = new Button("Back");
            styleButton(back7);
            back7.setPrefSize(100, 30);
            adminMenu_supplierReportGridPane.add(back7, 0, i2);
            back7.setOnAction(e1 -> primaryStage.setScene(userReportScene));
            ScrollPane scrollPane = new ScrollPane(adminMenu_supplierReportGridPane);
            scrollPane.setFitToWidth(true);
            Scene scene12 = new Scene(scrollPane, scene_width, scene_width);
            primaryStage.setScene(scene12);
        });

        //***********************************************************
        //Admin Menu -> Order Report Button
        adminMenu_orderReport.setOnAction(e -> {
            // Wrapper for mutable variables
            final LocalDate[] start = {LocalDate.of(2024, 1, 1)};
            final LocalDate[] end = {LocalDate.of(2025, 1, 1)};
            final int[] rowIndex = {2};

            Label label32 = new Label("Orders Report:");
            label32.setFont(Font.font("System", FontWeight.BOLD, 25));
            label32.setUnderline(true);

            GridPane adminMenu_orderReportGridPane = new GridPane();
            adminMenu_orderReportGridPane.setAlignment(Pos.CENTER);
            adminMenu_orderReportGridPane.setHgap(15);
            adminMenu_orderReportGridPane.setVgap(15);
            adminMenu_orderReportGridPane.add(label32, 0, 0);

            Label label33 = new Label("Order Details:");
            label33.setFont(Font.font("System", FontWeight.BOLD, 15));
            adminMenu_orderReportGridPane.add(label33, 0, 1);

            for (Cart order : admin.getOrders()) {
                Label orderLabel = new Label(order.toString());
                adminMenu_orderReportGridPane.add(orderLabel, 0, rowIndex[0]++);
            }

            Button back10 = new Button("Back");
            styleButton(back10);
            back10.setPrefSize(100, 30);
            adminMenu_orderReportGridPane.add(back10, 0, rowIndex[0]++);
            back10.setOnAction(e1 -> primaryStage.setScene(adminMenuScene));
            ScrollPane scrollPane = new ScrollPane(adminMenu_orderReportGridPane);
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            Scene scene = new Scene(scrollPane, scene_width, scene_height);
            primaryStage.setScene(scene);
        });

        //***********************************************************
        //Admin Menu -> AvgRevenueAndTotalRevenueForOrders Button
        adminMenu_AvgRevenueAndTotalRevenueForOrders.setOnAction(e -> {
            GridPane avgRevenueAndTotalRevenueForOrdersGridPane = new GridPane();
            avgRevenueAndTotalRevenueForOrdersGridPane.setAlignment(Pos.CENTER);
            avgRevenueAndTotalRevenueForOrdersGridPane.setHgap(10);
            avgRevenueAndTotalRevenueForOrdersGridPane.setVgap(10);

            //check when you parse the string into a date(because no entry of it directly) if an exception may occur unintentionally by user
            Label startDate = new Label("Enter Start Date: ");
            styleLabel(startDate);
            Label startDateWarning = new Label("Invalid input!");
            startDateWarning.setTextFill(Color.RED);
            startDateWarning.setVisible(false);
            TextField startDateField = new TextField();
            styleTextField(startDateField);

            Label endDate = new Label("Enter End Date: ");
            styleLabel(endDate);
            Label endDateWarning = new Label("Invalid input!");
            endDateWarning.setTextFill(Color.RED);
            endDateWarning.setVisible(false);
            TextField endDateField = new TextField();
            styleTextField(endDateField);

            Button getAvgRevenueButton = new Button("Average Revenue For Orders");
            Button getTotalRevenueButton = new Button("Total Revenue For Orders");
            Button avgAndTotalRevenueCancelButton = new Button("Cancel");
            getAvgRevenueButton.setAlignment(Pos.CENTER);
            getTotalRevenueButton.setAlignment(Pos.CENTER);

            styleButton(getAvgRevenueButton);
            styleButton(getTotalRevenueButton);
            styleButton(avgAndTotalRevenueCancelButton);

            getAvgRevenueButton.setPrefSize(300, 30);
            getTotalRevenueButton.setPrefSize(300, 30);
            avgAndTotalRevenueCancelButton.setPrefSize(300, 30);

            avgRevenueAndTotalRevenueForOrdersGridPane.add(startDate, 0, 0);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(startDateField, 1, 0);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(startDateWarning, 2, 0);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(endDate, 0, 1);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(endDateField, 1, 1);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(endDateWarning, 2, 1);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(getAvgRevenueButton, 0, 2);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(getTotalRevenueButton, 0, 3);
            avgRevenueAndTotalRevenueForOrdersGridPane.add(avgAndTotalRevenueCancelButton, 0, 4);

            Scene avgRevenueAndTotalRevenueForOrdersScene = new Scene(avgRevenueAndTotalRevenueForOrdersGridPane, scene_width, scene_height);
            primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);

            getAvgRevenueButton.setOnAction(e1 -> {
                //date must be entered in the following format yyyy-MM-dd with zeros in front of single digit months like: january -> 01
                LocalDate parseStartDateField = null;
                LocalDate parseEndDateField = null;
                try {
                    try {
                        parseStartDateField = LocalDate.parse(startDateField.getText());
                        startDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        startDateWarning.setVisible(true);
                        startDateField.setText("");
                        throw ex;
                    }

                    try {
                        parseEndDateField = LocalDate.parse(endDateField.getText());
                        endDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        endDateWarning.setVisible(true);
                        endDateField.setText("");
                        throw ex;
                    }

                    if (parseStartDateField.isAfter(parseEndDateField)) {
                        Alert invalidSetOfDates = new Alert(Alert.AlertType.ERROR);
                        invalidSetOfDates.setTitle("INVALID SET OF DATES!");
                        invalidSetOfDates.setHeaderText("This is an invalid set of dates");
                        invalidSetOfDates.showAndWait();
                        primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);
                        startDateField.setText("");
                        endDateField.setText("");
                    }

                    double totalRevenue = 0;
                    int cartCount = 0;

                    for (Cart order : admin.getOrders())
                    {
                        if (order.getOrderDate().isAfter(parseStartDateField) && order.getOrderDate().isBefore(parseEndDateField) && order.getStatus() == Cart.Status.COMPLETED) {
                            totalRevenue += order.getTotalPrice();
                            cartCount++;
                        }
                    }

                    if (cartCount == 0)
                    {
                        Alert noOrdersAlert = new Alert(Alert.AlertType.ERROR);
                        noOrdersAlert.setTitle("NO ORDERS FOUND");
                        noOrdersAlert.setHeaderText("No orders were made in the specified time");
                        noOrdersAlert.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                    else
                    {
                        Alert avgRevenueAlert = new Alert(Alert.AlertType.INFORMATION);
                        avgRevenueAlert.setTitle("Average Revenue for Orders");
                        avgRevenueAlert.setHeaderText("Average Revenue for Orders: " + totalRevenue/cartCount);
                        avgRevenueAlert.setContentText("Press OK to continue");
                        avgRevenueAlert.showAndWait();
                        primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);
                    }

                } catch (DateTimeParseException ex) {
                    primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);
                }
            });

            getTotalRevenueButton.setOnAction(e1 -> {
                LocalDate parseStartDateField = null;
                LocalDate parseEndDateField = null;
                try {
                    try {
                        parseStartDateField = LocalDate.parse(startDateField.getText());
                        startDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        startDateWarning.setVisible(true);
                        startDateField.setText("");
                        throw ex;
                    }

                    try {
                        parseEndDateField = LocalDate.parse(endDateField.getText());
                        endDateWarning.setVisible(false);
                    } catch (DateTimeParseException ex) {
                        endDateWarning.setVisible(true);
                        endDateField.setText("");
                        throw ex;
                    }

                    if (parseStartDateField.isAfter(parseEndDateField)) {
                        Alert invalidSetOfDates = new Alert(Alert.AlertType.ERROR);
                        invalidSetOfDates.setTitle("INVALID SET OF DATES!");
                        invalidSetOfDates.setHeaderText("This is an invalid set of dates");
                        invalidSetOfDates.showAndWait();
                        primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);
                        startDateField.setText("");
                        endDateField.setText("");
                    }

                    double totalRevenue = 0;
                    int cartCount = 0;

                    for (Cart order : admin.getOrders())
                    {
                        if (order.getOrderDate().isAfter(parseStartDateField) && order.getOrderDate().isBefore(parseEndDateField) && order.getStatus() == Cart.Status.COMPLETED) {
                            totalRevenue += order.getTotalPrice();
                            cartCount++;
                        }
                    }

                    if (cartCount == 0)
                    {
                        Alert noOrdersAlert = new Alert(Alert.AlertType.ERROR);
                        noOrdersAlert.setTitle("NO ORDERS FOUND");
                        noOrdersAlert.setHeaderText("No orders were made in the specified time");
                        noOrdersAlert.showAndWait();
                        primaryStage.setScene(adminMenuScene);
                    }
                    else
                    {
                        Alert totalRevenueAlert = new Alert(Alert.AlertType.INFORMATION);
                        totalRevenueAlert.setTitle("Total Revenue for Orders");
                        totalRevenueAlert.setHeaderText("Total Revenue for Orders: " + totalRevenue);
                        totalRevenueAlert.setContentText("Press OK to continue");
                        totalRevenueAlert.showAndWait();
                        primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);
                    }

                } catch (DateTimeParseException ex) {
                    primaryStage.setScene(avgRevenueAndTotalRevenueForOrdersScene);
                }
            });

            avgAndTotalRevenueCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(adminMenuScene);
            });
        });

        //***********************************************************
        //Customer Menu
        Label label3 = new Label("What would you like to do?");
        styleLabel(label3);
        Button viewOrders = new Button("View Orders History");
        Button rateOrder = new Button("Rate Order");
        Button LogOut = new Button("Log Out");

        styleButton(viewOrders);
        styleButton(rateOrder);
        styleButton(LogOut);

        viewOrders.setPrefSize(300, 30);
        rateOrder.setPrefSize(300, 30);
        LogOut.setPrefSize(300, 30);

        Label customerLoginLabel = new Label("Enter Customer ID: ");
        styleLabel(customerLoginLabel);
        TextField customerLoginIDTextField = new TextField();
        styleTextField(customerLoginIDTextField);
        Button customerLoginButton = new Button("Login");
        Button customerLoginCancelButton = new Button("Cancel");
        Label customerLoginMessage = new Label();

        styleButton(customerLoginButton);
        styleButton(customerLoginCancelButton);

        customerLoginButton.setPrefSize(300, 30);
        customerLoginCancelButton.setPrefSize(300, 30);

        GridPane customerLoginGridPane = new GridPane();
        customerLoginGridPane.setAlignment(Pos.CENTER);

        customerLoginGridPane.add(customerLoginLabel, 0, 0);
        customerLoginGridPane.add(customerLoginIDTextField, 1, 0);
        customerLoginGridPane.add(customerLoginButton, 2, 0);
        customerLoginGridPane.add(customerLoginCancelButton, 3, 0);
        customerLoginGridPane.add(customerLoginMessage, 0, 1);

        customerLoginGridPane.setHgap(10);
        customerLoginGridPane.setVgap(10);

        Scene customerLoginScene = new Scene(customerLoginGridPane, scene_width, scene_height);

        VBox vbox = new VBox(label3, viewOrders, rateOrder, LogOut);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        Scene customerScene = new Scene(vbox, scene_width, scene_height);
        mainMenu_customerButton.setOnAction(e -> primaryStage.setScene(customerLoginScene));
        LogOut.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        //*************************************************************
        //Customer Login
        customerLoginButton.setOnAction(e -> {
            String customerId = customerLoginIDTextField.getText();
            boolean customerExists = CheckCustomerExistence(admin, customerId);
            if (customerExists) {
                currentCustomer = new Customer(admin.searchCustomerByField("id", customerId));

                if (currentCustomer != null) {
                    customerLoginMessage.setText("Login successful!");
                    primaryStage.setScene(customerScene);
                } else {
                    customerLoginMessage.setText("Customer retrieval failed");
                }
            } else {
                customerLoginMessage.setText("Invalid ID. Please try again");
            }
        });

        customerLoginCancelButton.setOnAction(e -> {
            primaryStage.setScene(mainMenuScene);
        });

        //*********************************************************************
        //Customer Menu -> View Orders History Button
        viewOrders.setOnAction(e1 -> {
            GridPane orderHistoryGridPane = new GridPane();
            orderHistoryGridPane.setAlignment(Pos.TOP_LEFT);
            orderHistoryGridPane.setHgap(15);
            orderHistoryGridPane.setVgap(15);
            Label l1 = new Label("Order History:");
            l1.setFont(Font.font("System", FontWeight.BOLD, 25));
            l1.setUnderline(true);
            orderHistoryGridPane.add(l1, 0, 0);
            int row = 1;
            int index = 1;
            int size = currentCustomer.getOrderHistory().size();
            System.out.println(size);
            if (currentCustomer.getOrderHistory().isEmpty()){
                Label empty = new Label("No orders found!");
                orderHistoryGridPane.add(empty, 0, row++);
            }
            else {
                for (Cart order : currentCustomer.getOrderHistory()) {
                    Label orderIndex = new Label("Order " + index + ":");
                    orderIndex.setFont(Font.font("System", FontWeight.BOLD, 10));
                    orderHistoryGridPane.add(orderIndex, 0, row++);
                    Label id = new Label("ID: " + order.getId());
                    orderHistoryGridPane.add(id, 0, row++);
                    Label price = new Label("Total Price: " + order.getTotalPrice());
                    orderHistoryGridPane.add(price, 0, row++);
                    Label date = new Label("Date: " + order.getOrderDate());
                    orderHistoryGridPane.add(date, 0, row++);
                    index++;
                }
            }
            Button back = new Button("Back");
            back.setOnAction(e2 -> primaryStage.setScene(customerScene));
            orderHistoryGridPane.add(back, 0, row);
            ScrollPane scrollPane = new ScrollPane(orderHistoryGridPane);
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            Scene customerMenu_viewOrder_scene = new Scene(scrollPane, scene_width, scene_height);
            primaryStage.setScene(customerMenu_viewOrder_scene);
        });


        //**********************************************************************
        //Customer Menu -> Rate Order Button
        Scene customerMenu_rateOrder_scene;
        Label customerMenu_OrderIDLabel = new Label("Order ID: ");
        styleLabel(customerMenu_OrderIDLabel);
        TextField customerMenu_OrderIDTF = new TextField();
        styleTextField(customerMenu_OrderIDTF);
        Label customerMenu_OrderIDWarningLabel = new Label("Order does not exist for this customer");
        customerMenu_OrderIDWarningLabel.setVisible(false);
        customerMenu_OrderIDWarningLabel.setTextFill(Color.RED);

        Label customerMenu_orderRating = new Label("Rate:");
        styleLabel(customerMenu_orderRating);
        Label customerMenu_rateWarningLabel = new Label("Rating has to be between 0 and 10");
        customerMenu_rateWarningLabel.setTextFill(Color.RED);
        customerMenu_rateWarningLabel.setVisible(false);
        TextField customerMenu_rateTF = new TextField();
        styleTextField(customerMenu_rateTF);
        Button customerMenu_doneRating = new Button("Done");
        Button customerMenu_cancelRating = new Button("Cancel");

        styleButton(customerMenu_doneRating);
        styleButton(customerMenu_cancelRating);

        customerMenu_doneRating.setPrefSize(100, 30);
        customerMenu_cancelRating.setPrefSize(100, 30);

        GridPane rateOrderGridPane = new GridPane();
        rateOrderGridPane.setAlignment(Pos.CENTER);

        rateOrderGridPane.add(customerMenu_OrderIDLabel, 0, 0);
        rateOrderGridPane.add(customerMenu_OrderIDTF, 1, 0);
        rateOrderGridPane.add(customerMenu_OrderIDWarningLabel, 2, 0);
        rateOrderGridPane.add(customerMenu_orderRating, 0, 1);
        rateOrderGridPane.add(customerMenu_rateTF, 1, 1);
        rateOrderGridPane.add(customerMenu_rateWarningLabel, 2, 1);
        rateOrderGridPane.add(customerMenu_doneRating, 1, 2);
        rateOrderGridPane.add(customerMenu_cancelRating, 1, 3);
        rateOrderGridPane.setHgap(10);
        rateOrderGridPane.setVgap(10);


        customerMenu_rateOrder_scene = new Scene(rateOrderGridPane, scene_width, scene_height);
        rateOrder.setOnAction(e1 -> primaryStage.setScene(customerMenu_rateOrder_scene));
        customerMenu_doneRating.setOnAction(e2 -> {

            Cart thisCart = currentCustomer.checkOrderExistance(admin.searchCartByField("id", customerMenu_OrderIDTF.getText()));

            if (!(Integer.parseInt(customerMenu_rateTF.getText()) <= 10) || !(Integer.parseInt(customerMenu_rateTF.getText()) >= 0) )
            {
                customerMenu_rateWarningLabel.setVisible(true);
            }
            else{
                customerMenu_rateWarningLabel.setVisible(false);
            }
            if (thisCart != null)
            {
                customerMenu_OrderIDWarningLabel.setVisible(false);
            }
            else {
                customerMenu_OrderIDWarningLabel.setVisible(true);
            }
            if (thisCart == null || !(Integer.parseInt(customerMenu_rateTF.getText()) <= 10) || !(Integer.parseInt(customerMenu_rateTF.getText()) >= 0)) {
                if (!(Integer.parseInt(customerMenu_rateTF.getText()) <= 10 || Integer.parseInt(customerMenu_rateTF.getText()) >= 0)) {
                    Alert ratingNotInRangeAlert = new Alert(Alert.AlertType.ERROR);
                    ratingNotInRangeAlert.setTitle("Rating not in range");
                    ratingNotInRangeAlert.setHeaderText("Rating has to be between 0 and 10");
                    ratingNotInRangeAlert.showAndWait();
                    primaryStage.setScene(customerMenu_rateOrder_scene);
                }
                if (thisCart == null) {
                    Alert orderNotFoundAlert = new Alert(Alert.AlertType.ERROR);
                    orderNotFoundAlert.setTitle("Order not found");
                    orderNotFoundAlert.setHeaderText("Order does not exist for this customer");
                    orderNotFoundAlert.showAndWait();
                    primaryStage.setScene(customerMenu_rateOrder_scene);
                }
            }
            else if (thisCart != null) {
                if (admin.searchCartByField("id", customerMenu_OrderIDTF.getText()).getStatus() != Cart.Status.COMPLETED) {
                    System.out.println("status: " + thisCart.getStatus());
                    Alert cartNotCompletedAlert = new Alert(Alert.AlertType.ERROR);
                    cartNotCompletedAlert.setTitle("Cart not completed");
                    cartNotCompletedAlert.setHeaderText("Cart Not Completed");
                    cartNotCompletedAlert.showAndWait();
                    primaryStage.setScene(customerMenu_rateOrder_scene);
                }
                if (currentCustomer.rateOrder(thisCart, Integer.parseInt(customerMenu_rateTF.getText()))) {
                    Alert ratingSaved = new Alert(Alert.AlertType.INFORMATION);
                    ratingSaved.setTitle("Rating saved");
                    ratingSaved.setHeaderText("Rating has been saved");
                    ratingSaved.showAndWait();
                    primaryStage.setScene(customerScene);
                }
                try {
                    admin.saveData();
                    /*Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setTitle("Rate Order");
                    alert.setHeaderText("Successfully rated order!");
                    alert.showAndWait();
                    primaryStage.setScene(customerScene);*/
                }
                catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(e.getMessage());
                    alert.showAndWait();
                    primaryStage.setScene(mainMenuScene);
                }
            }
            primaryStage.setScene(customerScene);
        });
        customerMenu_cancelRating.setOnAction(e1 -> {
            primaryStage.setScene(customerScene);
        });

        //**********************************************************
        //Cashier Menu
        Label label5 = new Label("What would you like to do?");
        styleLabel(label5);
        Button createCart = new Button("Create Cart");
        Button addProToCart = new Button("Add Product to Cart");
        Button removeProFromCart = new Button("Remove Product from Cart");
        Button payment = new Button("Calculate Payment");
        Button cancelCart = new Button("Cancel Cart");
        Button confirmOrderCompletion = new Button("Confirm Order Completion");
        Button lg = new Button("Log Out");

        styleButton(createCart);
        styleButton(addProToCart);
        styleButton(removeProFromCart);
        styleButton(payment);
        styleButton(cancelCart);
        styleButton(confirmOrderCompletion);
        styleButton(lg);

        createCart.setPrefSize(300, 30);
        addProToCart.setPrefSize(300, 30);
        removeProFromCart.setPrefSize(300, 30);
        payment.setPrefSize(300, 30);
        cancelCart.setPrefSize(300, 30);
        confirmOrderCompletion.setPrefSize(300, 30);
        lg.setPrefSize(300, 30);

        Label cashierLoginLabel = new Label("Enter Cashier ID: ");
        styleLabel(cashierLoginLabel);
        TextField cashierLoginIDTextField = new TextField();
        styleTextField(cashierLoginIDTextField);
        Button cashierLoginButton = new Button("Login");
        Button cashierLoginCancelButton = new Button("Cancel");
        Label cashierLoginMessage = new Label();

        styleButton(cashierLoginButton);
        styleButton(cashierLoginCancelButton);

        cashierLoginButton.setPrefSize(300, 30);
        cashierLoginCancelButton.setPrefSize(300, 30);

        GridPane cashierLoginGridPane = new GridPane();
        cashierLoginGridPane.setAlignment(Pos.CENTER);

        cashierLoginGridPane.add(cashierLoginLabel, 0, 0);
        cashierLoginGridPane.add(cashierLoginIDTextField, 1, 0);
        cashierLoginGridPane.add(cashierLoginButton, 2, 0);
        cashierLoginGridPane.add(cashierLoginCancelButton, 3, 0);
        cashierLoginGridPane.add(cashierLoginMessage, 0, 1);

        cashierLoginGridPane.setHgap(10);
        cashierLoginGridPane.setVgap(10);

        Scene cashierLoginScene = new Scene(cashierLoginGridPane, scene_width, scene_height);

        VBox vbox3 = new VBox(label5, createCart, addProToCart, removeProFromCart, payment, cancelCart, confirmOrderCompletion, lg);
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(10);
        Scene cashierScene = new Scene(vbox3, scene_width, scene_height);
        mainMenu_cashierButton.setOnAction(e -> primaryStage.setScene(cashierLoginScene));
        lg.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        //**************************************************************
        //Cashier Login
        cashierLoginButton.setOnAction(e -> {
            String cashierId = cashierLoginIDTextField.getText();
            boolean cashierExists = CheckCashierExistence(admin, cashierId);
            if (cashierExists) {
                currentCashier = admin.searchCashierByField("id", cashierId);

                if (currentCashier != null) {
                    primaryStage.setScene(cashierScene);
                } else {
                    cashierLoginMessage.setText("Cashier retrieval failed");
                }
            } else {
                cashierLoginMessage.setText("Invalid ID.\n Please try again");
            }
        });

        cashierLoginCancelButton.setOnAction(e -> {
            primaryStage.setScene(mainMenuScene);
        });

        //**************************************************************
        //Cashier Menu -> Create Cart Button
        createCart.setOnAction(e -> {
            if (currentCashier != null) {
                GridPane cashierMenu_createCartGridPane = new GridPane();
                cashierMenu_createCartGridPane.setAlignment(Pos.CENTER);

                Label customerIdLabel = new Label("Enter Customer ID: ");
                styleLabel(customerIdLabel);
                Label cashierMenu_createCart_CustomerIDWarning = new Label("Customer Does Not Exist!");
                cashierMenu_createCart_CustomerIDWarning.setTextFill(Color.RED);
                cashierMenu_createCart_CustomerIDWarning.setVisible(false);
                TextField cashierMenu_createCart_customerId = new TextField();
                styleTextField(cashierMenu_createCart_customerId);

                Button cashierMenu_createCartButton = new Button("Create Cart");
                Button cashierMenu_createCartCancelButton = new Button("Cancel");
                cashierMenu_createCartButton.setAlignment(Pos.CENTER);

                styleButton(cashierMenu_createCartButton);
                styleButton(cashierMenu_createCartCancelButton);

                cashierMenu_createCartButton.setPrefSize(300, 30);
                cashierMenu_createCartCancelButton.setPrefSize(300, 30);

                cashierMenu_createCartGridPane.add(customerIdLabel, 0, 0);
                cashierMenu_createCartGridPane.add(cashierMenu_createCart_customerId, 1, 0);
                cashierMenu_createCartGridPane.add(cashierMenu_createCart_CustomerIDWarning, 2, 0);
                cashierMenu_createCartGridPane.add(cashierMenu_createCartButton, 1, 1);
                cashierMenu_createCartGridPane.add(cashierMenu_createCartCancelButton, 1, 2);

                cashierMenu_createCartGridPane.setHgap(10);
                cashierMenu_createCartGridPane.setVgap(10);

                Scene createCartScene = new Scene(cashierMenu_createCartGridPane, scene_width, scene_height);
                primaryStage.setScene(createCartScene);

                cashierMenu_createCartButton.setOnAction(e1 -> {
                    if (!CheckCustomerExistence(admin, cashierMenu_createCart_customerId.getText())) {
                        cashierMenu_createCart_CustomerIDWarning.setVisible(true);
                        cashierMenu_createCart_CustomerIDWarning.setText("");
                    } else {
                        cashierMenu_createCart_CustomerIDWarning.setVisible(false);
                        Customer cashierCustomer = (admin.searchCustomerByField("id", cashierMenu_createCart_customerId.getText()));
                        if (currentCashier.createOrder(cashierCustomer)) {
                            admin.getOrders().add(currentCashier.getOrdersHandled().getLast());
                            Alert cashierMenu_createCart_CartCreatedAlert = new Alert(Alert.AlertType.INFORMATION);
                            cashierMenu_createCart_CartCreatedAlert.setTitle("Create Cart");
                            try {
                                admin.saveData();
                            } catch (IOException ex) {
                                Alert cashierMenu_createCart_CreatingCartFailed = new Alert(Alert.AlertType.ERROR);
                                cashierMenu_createCart_CreatingCartFailed.setTitle("CART CREATION FAILED");
                                cashierMenu_createCart_CreatingCartFailed.setHeaderText("Failed to create cart");
                                cashierMenu_createCart_CreatingCartFailed.showAndWait();
                                primaryStage.setScene(cashierScene);
                            }
                            cashierMenu_createCart_CartCreatedAlert.setHeaderText("Cart successfully created!");
                            cashierMenu_createCart_CartCreatedAlert.setContentText("Press OK to continue");
                            cashierMenu_createCart_CartCreatedAlert.showAndWait();
                            primaryStage.setScene(cashierScene);
                        }
                    }
                });

                cashierMenu_createCartCancelButton.setOnAction(e1 -> {
                    primaryStage.setScene(cashierScene);
                });
            }
            else {
                Alert cashierNotFound = new Alert(Alert.AlertType.ERROR);
                cashierNotFound.setTitle("CASHIER NOT FOUND");
                cashierNotFound.setHeaderText("Failed to find cashier");
                cashierNotFound.showAndWait();
                primaryStage.setScene(mainMenuScene);
            }
        });

        //**************************************************************
        //Cashier Menu -> Add Product to Cart Button
        addProToCart.setOnAction(e -> {
            GridPane cashierMenu_addProToCartGridPane = new GridPane();
            cashierMenu_addProToCartGridPane.setAlignment(Pos.CENTER);

            Label cartId = new Label("Enter Cart ID: ");
            styleLabel(cartId);
            Label cashierMenu_addProToCart_CartIDWarning = new Label("Cart Does Not Exist!");
            cashierMenu_addProToCart_CartIDWarning.setTextFill(Color.RED);
            cashierMenu_addProToCart_CartIDWarning.setVisible(false);
            TextField cashierMenu_addProToCart_cartId = new TextField();
            styleTextField(cashierMenu_addProToCart_cartId);

            Label cartProductName = new Label("Enter Product Name: ");
            styleLabel(cartProductName);
            Label cashierMenu_addProToCart_ProductNameWarning = new Label("Product Does Not Exist!");
            cashierMenu_addProToCart_ProductNameWarning.setTextFill(Color.RED);
            cashierMenu_addProToCart_ProductNameWarning.setVisible(false);
            TextField cashierMenu_addProToCart_ProductName = new TextField();
            styleTextField(cashierMenu_addProToCart_ProductName);

            Label cartProductQuantity = new Label("Enter Product Quantity: ");
            styleLabel(cartProductQuantity);
            Label cashierMenu_addProToCart_ProductQuantityWarning = new Label("Quantity Must be Integer!");
            cashierMenu_addProToCart_ProductQuantityWarning.setTextFill(Color.RED);
            cashierMenu_addProToCart_ProductQuantityWarning.setVisible(false);
            TextField cashierMenu_addProToCart_ProductQuantity = new TextField();
            styleTextField(cashierMenu_addProToCart_ProductQuantity);

            Button cashierMenu_addProToCartButton = new Button("Add Product to Cart");
            Button cashierMenu_addProToCartCancelButton = new Button("Cancel");
            cashierMenu_addProToCartButton.setAlignment(Pos.CENTER);

            styleButton(cashierMenu_addProToCartButton);
            styleButton(cashierMenu_addProToCartCancelButton);

            cashierMenu_addProToCartButton.setPrefSize(300, 30);
            cashierMenu_addProToCartCancelButton.setPrefSize(300, 30);

            cashierMenu_addProToCartGridPane.add(cartId, 0, 0);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCart_cartId, 1, 0);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCart_CartIDWarning, 2, 0);
            cashierMenu_addProToCartGridPane.add(cartProductName, 0, 1);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCart_ProductName, 1, 1);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCart_ProductNameWarning, 2, 1);
            cashierMenu_addProToCartGridPane.add(cartProductQuantity, 0, 2);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCart_ProductQuantity, 1, 2);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCart_ProductQuantityWarning, 2, 2);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCartButton, 0, 3);
            cashierMenu_addProToCartGridPane.add(cashierMenu_addProToCartCancelButton, 0, 4);

            cashierMenu_addProToCartGridPane.setHgap(10);
            cashierMenu_addProToCartGridPane.setVgap(10);

            Scene addProToCartScene = new Scene(cashierMenu_addProToCartGridPane, scene_width, scene_height);
            primaryStage.setScene(addProToCartScene);

            cashierMenu_addProToCartButton.setOnAction(e1 -> {
                if (!CheckCartExistence(admin, cashierMenu_addProToCart_cartId.getText()) || !CheckProductExistence(admin, cashierMenu_addProToCart_ProductName.getText())) {
                    if (!CheckCartExistence(admin, cashierMenu_addProToCart_cartId.getText())) {
                        cashierMenu_addProToCart_CartIDWarning.setVisible(true);
                        cashierMenu_addProToCart_CartIDWarning.setText("");
                    } else {
                        cashierMenu_addProToCart_CartIDWarning.setVisible(false);
                    }
                    if (!CheckProductExistence(admin, cashierMenu_addProToCart_ProductName.getText())) {
                        cashierMenu_addProToCart_ProductNameWarning.setVisible(true);
                        cashierMenu_addProToCart_ProductNameWarning.setText("");
                    } else {
                        cashierMenu_addProToCart_ProductNameWarning.setVisible(false);
                    }
                } else {
                    cashierMenu_addProToCart_CartIDWarning.setVisible(false);
                    cashierMenu_addProToCart_ProductNameWarning.setVisible(false);
                    Cart cashierCart = new Cart(admin.searchCartByField("id", cashierMenu_addProToCart_cartId.getText()));
                    Product cashierProduct = new Product(admin.searchProductByField("name", cashierMenu_addProToCart_ProductName.getText()));

                    int parseCashierMenu_addProToCart_ProductQuantity = 0;
                    try {
                        parseCashierMenu_addProToCart_ProductQuantity = Integer.parseInt(cashierMenu_addProToCart_ProductQuantity.getText());
                        if (currentCashier.addProductToCart(cashierCart, cashierProduct, parseCashierMenu_addProToCart_ProductQuantity)) {

                            Alert cashierMenu_addProductToCart_ProductAddedAlert = new Alert(Alert.AlertType.INFORMATION);
                            cashierMenu_addProductToCart_ProductAddedAlert.setTitle("Add Product To Cart");
                            try {
                                admin.saveData();
                            } catch (IOException ex) {
                                Alert cashierMenu_addProductToCart_ProductAddingFailled = new Alert(Alert.AlertType.ERROR);
                                cashierMenu_addProductToCart_ProductAddingFailled.setTitle("PRODUCT ADDITION TO CART FAILED");
                                cashierMenu_addProductToCart_ProductAddingFailled.setHeaderText("Failed to add product to cart");
                                cashierMenu_addProductToCart_ProductAddingFailled.showAndWait();
                                primaryStage.setScene(cashierScene);
                            }
                            cashierMenu_addProductToCart_ProductAddedAlert.setHeaderText("Product successfully added!");
                            cashierMenu_addProductToCart_ProductAddedAlert.setContentText("Press OK to continue");
                            cashierMenu_addProductToCart_ProductAddedAlert.showAndWait();
                            primaryStage.setScene(cashierScene);
                        }
                        else {
                            Alert notEnoughProductsAlert = new Alert(Alert.AlertType.ERROR);
                            notEnoughProductsAlert.setTitle("NOT ENOUGH PRODUCTS");
                            notEnoughProductsAlert.setHeaderText("Not enough of this product in the pharmacy");
                            notEnoughProductsAlert.showAndWait();
                            primaryStage.setScene(cashierScene);
                        }
                    } catch (NumberFormatException ex) {
                        cashierMenu_addProToCart_ProductQuantityWarning.setVisible(true);
                        primaryStage.setScene(addProToCartScene);
                        cashierMenu_addProToCart_ProductQuantity.setText("");
                    }
                }
            });
            cashierMenu_addProToCartCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(cashierScene);
            });
        });

        //**************************************************************
        //Cashier Menu -> Remove Product from Cart Button
        removeProFromCart.setOnAction(e -> {
            GridPane cashierMenu_removeProFromCartGridPane = new GridPane();
            cashierMenu_removeProFromCartGridPane.setAlignment(Pos.CENTER);

            Label removeProductCartId = new Label("Enter ID of Cart you want to remove from: ");
            styleLabel(removeProductCartId);
            Label cashierMenu_removeProductCartIDWarning = new Label("Cart Does Not Exist!");
            cashierMenu_removeProductCartIDWarning.setTextFill(Color.RED);
            cashierMenu_removeProductCartIDWarning.setVisible(false);
            TextField cashierMenu_removeProductCartID = new TextField();
            styleTextField(cashierMenu_removeProductCartID);

            Label removeProductName = new Label("Enter Name of Product to be removed: ");
            styleLabel(removeProductName);
            Label cashierMenu_removeProductNameWarning = new Label("Product Does Not Exist!");
            cashierMenu_removeProductNameWarning.setTextFill(Color.RED);
            cashierMenu_removeProductNameWarning.setVisible(false);
            TextField cashierMenu_removeProductName = new TextField();
            styleTextField(cashierMenu_removeProductName);

            Button cashierMenu_removeProductButton = new Button("Remove Product");
            Button cashierMenu_removeProductCancelButton = new Button("Cancel");
            cashierMenu_removeProductButton.setAlignment(Pos.CENTER);
            cashierMenu_removeProductCancelButton.setAlignment(Pos.CENTER);

            styleButton(cashierMenu_removeProductButton);
            styleButton(cashierMenu_removeProductCancelButton);

            cashierMenu_removeProductButton.setPrefSize(300, 30);
            cashierMenu_removeProductCancelButton.setPrefSize(300, 30);

            cashierMenu_removeProFromCartGridPane.add(removeProductCartId, 0, 0);
            cashierMenu_removeProFromCartGridPane.add(cashierMenu_removeProductCartID, 1, 0);
            cashierMenu_removeProFromCartGridPane.add(cashierMenu_removeProductCartIDWarning, 2, 0);
            cashierMenu_removeProFromCartGridPane.add(removeProductName, 0, 1);
            cashierMenu_removeProFromCartGridPane.add(cashierMenu_removeProductName, 1, 1);
            cashierMenu_removeProFromCartGridPane.add(cashierMenu_removeProductNameWarning, 2, 1);
            cashierMenu_removeProFromCartGridPane.add(cashierMenu_removeProductButton, 0, 2);
            cashierMenu_removeProFromCartGridPane.add(cashierMenu_removeProductCancelButton, 0, 3);

            cashierMenu_removeProFromCartGridPane.setHgap(10);
            cashierMenu_removeProFromCartGridPane.setVgap(10);

            Scene removeProFromCartScene = new Scene(cashierMenu_removeProFromCartGridPane, scene_width, scene_height);
            primaryStage.setScene(removeProFromCartScene);

            cashierMenu_removeProductButton.setOnAction(e1 -> {
                if (!CheckCartExistence(admin, cashierMenu_removeProductCartID.getText()) || !CheckProductExistence(admin, cashierMenu_removeProductName.getText())) {
                    if (!CheckCartExistence(admin, cashierMenu_removeProductCartID.getText())) {
                        cashierMenu_removeProductCartIDWarning.setVisible(true);
                        cashierMenu_removeProductCartID.setText("");
                    } else {
                        cashierMenu_removeProductCartIDWarning.setVisible(false);
                    }
                    if (!CheckProductExistence(admin, cashierMenu_removeProductName.getText())) {
                        cashierMenu_removeProductNameWarning.setVisible(true);
                        cashierMenu_removeProductName.setText("");
                    } else {
                        cashierMenu_removeProductNameWarning.setVisible(false);
                    }
                } else {
                    Cart cart =  admin.searchCartByField("id", cashierMenu_removeProductCartID.getText());
                    Product product = admin.searchProductByField("name", cashierMenu_removeProductName.getText());
                    if (currentCashier.removeProductFromCart(cart, product)) {
                        Alert cashierMenu_removeProduct_ProductRemovedAlert = new Alert(Alert.AlertType.INFORMATION);
                        cashierMenu_removeProduct_ProductRemovedAlert.setTitle("Remove Product");
                        try {
                            admin.saveData();
                        } catch (IOException ex) {
                            Alert cashierMenu_removeProduct_ProductRemoveFailed = new Alert(Alert.AlertType.ERROR);
                            cashierMenu_removeProduct_ProductRemoveFailed.setTitle("PRODUCT REMOVE FROM CART FAILED");
                            cashierMenu_removeProduct_ProductRemoveFailed.setHeaderText("Failed to remove product from cart");
                            cashierMenu_removeProduct_ProductRemoveFailed.showAndWait();
                            primaryStage.setScene(cashierScene);
                        }
                        cashierMenu_removeProduct_ProductRemovedAlert.setHeaderText("Product successfully removed!");
                        cashierMenu_removeProduct_ProductRemovedAlert.setContentText("Press OK to continue");
                        cashierMenu_removeProduct_ProductRemovedAlert.showAndWait();
                        primaryStage.setScene(cashierScene);
                    }
                }
            });
            cashierMenu_removeProductCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(cashierScene);
            });
        });

        //**************************************************************
        //Cashier Menu -> Calculate Payment Button
        payment.setOnAction(e -> {
            GridPane cashierMenu_calculatePaymentGridPane = new GridPane();
            cashierMenu_calculatePaymentGridPane.setAlignment(Pos.CENTER);
            cashierMenu_calculatePaymentGridPane.setHgap(10);
            cashierMenu_calculatePaymentGridPane.setVgap(10);

            Label cashierCartId = new Label("Enter Cart ID: ");
            styleLabel(cashierCartId);
            Label cashierMenu_CartIDWarning = new Label("Cart Does Not Exist!");
            cashierMenu_CartIDWarning.setTextFill(Color.RED);
            cashierMenu_CartIDWarning.setVisible(false);
            TextField cashierMenu_CartID = new TextField();
            styleTextField(cashierMenu_CartID);

            Button cashierMenu_cartIDButton = new Button("Calculate Payment");
            Button cashierMenu_cartIDCancelButton = new Button("Cancel");
            cashierMenu_cartIDButton.setAlignment(Pos.CENTER);
            cashierMenu_cartIDCancelButton.setAlignment(Pos.CENTER);

            styleButton(cashierMenu_cartIDButton);
            styleButton(cashierMenu_cartIDCancelButton);

            cashierMenu_cartIDButton.setPrefSize(300, 30);
            cashierMenu_cartIDCancelButton.setPrefSize(300, 30);

            cashierMenu_calculatePaymentGridPane.add(cashierCartId, 0, 0);
            cashierMenu_calculatePaymentGridPane.add(cashierMenu_CartID, 1, 0);
            cashierMenu_calculatePaymentGridPane.add(cashierMenu_CartIDWarning, 2, 0);
            cashierMenu_calculatePaymentGridPane.add(cashierMenu_cartIDButton, 0, 1);
            cashierMenu_calculatePaymentGridPane.add(cashierMenu_cartIDCancelButton, 0, 2);

            Scene calculatePaymentScene = new Scene(cashierMenu_calculatePaymentGridPane, scene_width, scene_height);
            primaryStage.setScene(calculatePaymentScene);

            cashierMenu_cartIDButton.setOnAction(e1 -> {
                if (!CheckCartExistence(admin, cashierMenu_CartID.getText())) {
                    cashierMenu_CartIDWarning.setVisible(true);
                    cashierMenu_CartID.setText("");
                } else {
                    cashierMenu_CartIDWarning.setVisible(false);
                    Cart cart = new Cart(admin.searchCartByField("id", cashierMenu_CartID.getText()));
                    double price;
                    price = cart.calculateTotalPrice();
                    Alert cashierMenu_paymentAlert = new Alert(Alert.AlertType.INFORMATION);
                    cashierMenu_paymentAlert.setTitle("Payment Calculation");
                    cashierMenu_paymentAlert.setHeaderText("Payment for " + cashierMenu_CartID.getText() + " is: " + price);
                    cashierMenu_paymentAlert.setContentText("Press OK to continue");
                    cashierMenu_paymentAlert.showAndWait();
                    primaryStage.setScene(cashierScene);
                }
            });

            cashierMenu_cartIDCancelButton.setOnAction(e1 -> {
                primaryStage.setScene(cashierScene);
            });
        });

        //**************************************************************
        //Cashier Menu -> Cancel Cart
        cancelCart.setOnAction(e -> {
            GridPane cancelCart_gridPane = new GridPane();
            cancelCart_gridPane.setAlignment(Pos.CENTER);

            Label cancelCart_ID = new Label("Enter Cart ID: ");
            styleLabel(cancelCart_ID);
            Label cancelCart_IDWarning = new Label("Cart Does Not Exist!");
            cancelCart_IDWarning.setTextFill(Color.RED);
            cancelCart_IDWarning.setVisible(false);
            TextField cancelCart_Id_textField = new TextField();
            styleTextField(cancelCart_Id_textField);

            Button cancelCart_Button = new Button("Confirm Cancel Cart");
            Button cancelCart_CancelButton = new Button("Cancel");
            cancelCart_Button.setAlignment(Pos.CENTER);
            cancelCart_CancelButton.setAlignment(Pos.CENTER);

            styleButton(cancelCart_Button);
            styleButton(cancelCart_CancelButton);

            cancelCart_Button.setPrefSize(300, 30);
            cancelCart_CancelButton.setPrefSize(300, 30);

            cancelCart_gridPane.add(cancelCart_ID, 0, 0);
            cancelCart_gridPane.add(cancelCart_Id_textField,1,0);
            cancelCart_gridPane.add(cancelCart_IDWarning, 2, 0);
            cancelCart_gridPane.add(cancelCart_Button, 1, 1);
            cancelCart_gridPane.add(cancelCart_CancelButton, 1, 2);

            cancelCart_gridPane.setHgap(10);
            cancelCart_gridPane.setVgap(10);

            Scene cancelCartScene = new Scene(cancelCart_gridPane, scene_width, scene_height);
            primaryStage.setScene(cancelCartScene);

            cancelCart_Button.setOnAction(e1 -> {
                if(CheckCartExistence(admin, cancelCart_Id_textField.getText())) {
                    //The cart actually exists
                    cancelCart_IDWarning.setVisible(false);
                    Cart cart = admin.searchCartByField("id", cancelCart_Id_textField.getText());

                    if (admin.getOrders().remove(cart)) {
                        currentCashier.cancelCart(cart);
                        for (Customer customers: admin.getCustomers())
                        {
                            customers.getOrderHistory().remove(cart);
                        }
                        Alert cashierMenu_cancelCart_CartCancelledAlert = new Alert(Alert.AlertType.INFORMATION);
                        cashierMenu_cancelCart_CartCancelledAlert.setTitle("Cancel Cart");
                        try {
                            admin.saveData();
                        } catch (IOException ex) {
                            Alert cashierMenu_cancelCart_CartCancellationFailed = new Alert(Alert.AlertType.ERROR);
                            cashierMenu_cancelCart_CartCancellationFailed.setTitle("CANCEL CART FAILED");
                            cashierMenu_cancelCart_CartCancellationFailed.setContentText("Failed to cancel cart");
                            cashierMenu_cancelCart_CartCancellationFailed.showAndWait();
                            primaryStage.setScene(cashierScene);
                        }
                        cashierMenu_cancelCart_CartCancelledAlert.setHeaderText("Cart cancelled successfully");
                        cashierMenu_cancelCart_CartCancelledAlert.setContentText("Press OK to continue");
                        cashierMenu_cancelCart_CartCancelledAlert.showAndWait();
                        primaryStage.setScene(cashierScene);
                    } else {
                        Alert cashierMenu_cancelCart_CartCancellationFailed = new Alert(Alert.AlertType.ERROR);
                        cashierMenu_cancelCart_CartCancellationFailed.setTitle("CANCEL CART FAILED");
                        cashierMenu_cancelCart_CartCancellationFailed.setContentText("Failed to cancel cart");
                        cashierMenu_cancelCart_CartCancellationFailed.showAndWait();
                        primaryStage.setScene(cashierScene);
                    }
                } else {
                    cancelCart_IDWarning.setVisible(true);
                    cancelCart_ID.setText("");
                }
            });
            cancelCart_CancelButton.setOnAction(e1 -> {
                primaryStage.setScene(cashierScene);
            });
        });

        //**************************************************************
        //Cashier Menu -> Confirm Order Completion
        confirmOrderCompletion.setOnAction(e -> {
            GridPane confirmOrderCompletionGridPane = new GridPane();
            confirmOrderCompletionGridPane.setAlignment(Pos.CENTER);

            Label cartId = new Label("Enter Cart ID: ");
            styleLabel(cartId);
            Label cartIdWarning = new Label("Cart Does Not Exist!");
            cartIdWarning.setTextFill(Color.RED);
            cartIdWarning.setVisible(false);
            TextField cartIdTextField = new TextField();
            styleTextField(cartIdTextField);

            Button orderCompletionButton = new Button("Confirm Order Completion");
            Button cancelOrderCompletionButton = new Button("Cancel");
            orderCompletionButton.setAlignment(Pos.CENTER);
            cancelOrderCompletionButton.setAlignment(Pos.CENTER);

            styleButton(orderCompletionButton);
            styleButton(cancelOrderCompletionButton);

            orderCompletionButton.setPrefSize(300, 30);
            cancelOrderCompletionButton.setPrefSize(300, 30);

            confirmOrderCompletionGridPane.add(cartId, 0, 0);
            confirmOrderCompletionGridPane.add(cartIdTextField, 1, 0);
            confirmOrderCompletionGridPane.add(cartIdWarning, 2, 0);
            confirmOrderCompletionGridPane.add(orderCompletionButton, 1, 1);
            confirmOrderCompletionGridPane.add(cancelOrderCompletionButton, 1, 2);

            confirmOrderCompletionGridPane.setHgap(10);
            confirmOrderCompletionGridPane.setVgap(10);

            Scene confirmOrderCompletionScene = new Scene(confirmOrderCompletionGridPane, scene_width, scene_height);
            primaryStage.setScene(confirmOrderCompletionScene);

            orderCompletionButton.setOnAction(e1 -> {
                if(CheckCartExistence(admin, cartIdTextField.getText())) {
                    cartIdWarning.setVisible(false);
                    Cart cart = admin.searchCartByField("id", cartIdTextField.getText());
                    admin.searchCartByField("id", cartIdTextField.getText()).setStatus(Cart.Status.CANCELLED);
                    cart.setStatus(Cart.Status.COMPLETED);

                    Alert cashierMenu_completeCart_CartCompletedAlert = new Alert(Alert.AlertType.INFORMATION);
                    cashierMenu_completeCart_CartCompletedAlert.setTitle("Complete Cart");
                    try {
                        admin.saveData();
                    } catch (IOException ex) {
                        Alert cashierMenu_completeCart_CartCompletionFailed = new Alert(Alert.AlertType.ERROR);
                        cashierMenu_completeCart_CartCompletionFailed.setTitle("COMPLETE CART FAILED");
                        cashierMenu_completeCart_CartCompletionFailed.setContentText("Failed to complete cart");
                        cashierMenu_completeCart_CartCompletionFailed.showAndWait();
                        primaryStage.setScene(cashierScene);
                    }
                    cashierMenu_completeCart_CartCompletedAlert.setHeaderText("Cart completion successfully");
                    cashierMenu_completeCart_CartCompletedAlert.setContentText("Press OK to continue");
                    cashierMenu_completeCart_CartCompletedAlert.showAndWait();
                    primaryStage.setScene(cashierScene);
                }
                else {
                    cartIdWarning.setVisible(true);
                    cartIdTextField.setText("");
                }
            });

            cancelOrderCompletionButton.setOnAction(e1 -> {
                primaryStage.setScene(cashierScene);
            });
        });


        //**************************************************************

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
    private boolean isValidContactNumber(String contact) {
        return contact.matches("0\\d{10}"); //11 digits starting with 0
    }
    public static void styleButton(Button button) {
        // Set a custom background color and rounded corners
        button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-background-radius: 20;" +
                        "-fx-border-radius: 20;"
        );

        // Add a subtle shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("#000000", 0.3));
        shadow.setRadius(5);
        shadow.setOffsetX(3);
        shadow.setOffsetY(3);
        button.setEffect(shadow);

        // Add hover effects
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #66BB6A, #388E3C);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-background-radius: 20;" +
                        "-fx-border-radius: 20;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-background-radius: 20;" +
                        "-fx-border-radius: 20;"
        ));
    }
    public static void styleTextField(TextField textField) {
        // Set a custom background and border
        textField.setStyle(
                "-fx-background-color: #F9F9F9;" +
                        "-fx-border-color: #BDBDBD;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-radius: 10;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 5 10 5 10;" +
                        "-fx-font-size: 14px;"
        );

        // Add focus effects
        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                textField.setStyle(
                        "-fx-background-color: #FFFFFF;" +
                                "-fx-border-color: #4CAF50;" +
                                "-fx-border-width: 2;" +
                                "-fx-border-radius: 10;" +
                                "-fx-background-radius: 10;" +
                                "-fx-padding: 5 10 5 10;" +
                                "-fx-font-size: 14px;"
                );
            } else {
                textField.setStyle(
                        "-fx-background-color: #F9F9F9;" +
                                "-fx-border-color: #BDBDBD;" +
                                "-fx-border-width: 1;" +
                                "-fx-border-radius: 10;" +
                                "-fx-background-radius: 10;" +
                                "-fx-padding: 5 10 5 10;" +
                                "-fx-font-size: 14px;"
                );
            }
        });

        // Add a subtle shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("#000000", 0.1));
        shadow.setRadius(3);
        shadow.setOffsetX(1);
        shadow.setOffsetY(1);
        textField.setEffect(shadow);
    }
    public static void styleLabel(Label label) {
        // Set a custom font style and color
        label.setStyle(
                "-fx-text-fill: #333333;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;"
        );

        // Add a subtle shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("#000000", 0.2));
        shadow.setRadius(2);
        shadow.setOffsetX(1);
        shadow.setOffsetY(1);
        label.setEffect(shadow);
    }



}