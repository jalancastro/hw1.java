package com.cse360.hw1.joesdeli;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.text.DecimalFormat;

public class hw1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HW1");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        // Interface
        BorderPane border = new BorderPane();
        VBox eatButtons = new VBox(8);
        VBox drinkButtons = new VBox(8);
        VBox rightSide = new VBox(8);
        Text sceneTitle = new Text("Joe's Deli");
            sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        TextArea billText = new TextArea();
        billText.setPrefSize(100,100);
        border.setTop(sceneTitle);
        border.setLeft(eatButtons);
        border.setCenter(drinkButtons);
        border.setRight(rightSide);
        eatButtons.setAlignment(Pos.CENTER_LEFT);
        eatButtons.setPrefSize(200, 200);
        drinkButtons.setAlignment(Pos.CENTER_LEFT);
        drinkButtons.setPrefSize(200, 200);
        rightSide.setAlignment(Pos.CENTER_LEFT);
        rightSide.setPrefSize(200, 200);

        // Initiating Titles for Labels
        Text eat = new Text("Eat:");
            eat.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        Text drink = new Text("Drink:");
            drink.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        Text bill = new Text("Bill");
            bill.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        // Creating the Buttons
        CheckBox esButton = new CheckBox("Egg Sandwich");
        CheckBox csButton = new CheckBox("Chicken Sandwich");
        CheckBox bagelButton = new CheckBox("Bagel");
        CheckBox psButton = new CheckBox("Potato Salad");
        RadioButton btButton = new RadioButton("Black Tea");
        RadioButton gtButton = new RadioButton("Green Tea");
        RadioButton coffeeButton = new RadioButton("Coffee");
        RadioButton ojButton = new RadioButton("Orange Juice");

        Button cancel = new Button("Cancel");
        Button confirm = new Button("Confirm");
        Button order = new Button("Order");

        // Setting the Layout
        rightSide.getChildren().addAll(bill, billText, confirm);
        eatButtons.getChildren().addAll(eat, esButton, csButton, bagelButton, psButton, order);
        drinkButtons.getChildren().addAll(drink, btButton, gtButton, coffeeButton, ojButton, cancel);
        VBox.setMargin(eatButtons, new Insets(100, 100, 100, 50));
        VBox.setMargin(drinkButtons, new Insets(100, 100, 100, 50));
        VBox.setMargin(rightSide, new Insets(100, 100, 100, 50));

        // Button Actions
        order.setOnAction(e -> {

            // Initiating Price Values
            double esPrice = 0;
            double csPrice = 0;
            double bagelPrice = 0;
            double psPrice = 0;
            double btPrice = 0;
            double gtPrice = 0;
            double coffeePrice = 0;
            double ojPrice = 0;

            // Checkbox Actions
            if (esButton.isSelected()) {
                esPrice = 7.99;
                billText.appendText("Egg Sandwich $" + esPrice + "\n");
            }
            if (csButton.isSelected()) {
                csPrice = 9.99;
                billText.appendText("Chicken Sandwich $" + csPrice + "\n");
            }
            if (bagelButton.isSelected()) {
                bagelPrice = 2.50;
                billText.appendText("Bagel $" + bagelPrice + "\n");
            }
            if (psButton.isSelected()) {
                psPrice = 4.49;
                billText.appendText("Potato Salad $" + psPrice + "\n");
            }
            if (btButton.isSelected()) {
                btPrice = 1.25;
                billText.appendText("Black Tea $" + btPrice + "\n");
            }
            if (gtButton.isSelected()) {
                gtPrice = 0.99;
                billText.appendText("Green Tea $" + gtPrice + "\n");
            }
            if (coffeeButton.isSelected()) {
                coffeePrice = 1.99;
                billText.appendText("Coffee $" + coffeePrice + "\n");
            }
            if (ojButton.isSelected()) {
                ojPrice = 2.25;
                billText.appendText("Orange Juice $" + ojPrice + "\n");
            }
            billText.appendText("------------------\n");
            double sum = esPrice + csPrice + bagelPrice + psPrice + btPrice + gtPrice + coffeePrice + ojPrice;
            billText.appendText("Subtotal: $" + decimalFormat.format(sum));

            // If cancel is clicked after Order button is clicked
            cancel.setOnAction(f -> {
                billText.clear();
            });

            // If confirm is clicked after Order button is clicked
            confirm.setOnAction(g -> {
                esButton.setSelected(false);
                csButton.setSelected(false);
                bagelButton.setSelected(false);
                psButton.setSelected(false);
                btButton.setSelected(false);
                gtButton.setSelected(false);
                coffeeButton.setSelected(false);
                ojButton.setSelected(false);
                double tax = sum * .07;
                billText.appendText("\nTax: $" + decimalFormat.format(tax) + "\n");
                billText.appendText("Total: $" + decimalFormat.format(tax + sum));
            });
        });

        Scene scene = new Scene(border, 600, 300, Color.WHITE);

        border.setTop(sceneTitle);
        border.setAlignment(sceneTitle,Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
        }
}
