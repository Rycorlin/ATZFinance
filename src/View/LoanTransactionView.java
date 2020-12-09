/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoanTransactionController;
import Model.Loan;
import Model.LoanTemplate;
import Model.User;
import static View.HomeView.homeviewVBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.awt.event.*;  
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author taren
 */
public class LoanTransactionView extends Application implements ItemListener, ActionListener {

    private User user;
    private LoanTemplate loan;

    public LoanTransactionView(LoanTemplate l1, User u1)
    {
        loan = l1;
        user = u1;
    }
    
    @Override
    public void start(Stage stage) throws IOException {

        // BOTTOM BAR / BUTTON
        BorderPane borderpane = new BorderPane();
        
        // Loan balance label
        Label loanBalance = new Label();
        
        // Buttons
        Button backButton = new Button("Back");
        backButton.setPrefSize(150, 20);
        
        // Decimal formatting for money
        DecimalFormat decim = new DecimalFormat("0.00");

        
        // Hbox
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(5);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().addAll(backButton);
        HBox.setHgrow(backButton, Priority.ALWAYS);
        
        // Pay loan Button
        final Button payLoanButton = new Button("Pay Loan");
        // payLoanButton.ActionPerformed HERE
        
        // Text field for payment total
        final TextField paymentField = new TextField("");

        GridPane grid = new GridPane();

        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        // item, column, row
        // Add Loan ID
        grid.add(new Label("Loan ID: "+loan.getLoanID()),0,0);
        
        // Add loan type
        grid.add(new Label("Loan Type: " + loan.getLoanType()),0,1);
        
        // Add loan balance
        loanBalance.setText("Balance: $" + decim.format(loan.getBalanceDue()));
        grid.add(loanBalance, 0, 2);
        
        // Date picker
        LocalDate date = LocalDate.now();  
        DatePicker datePicker = new DatePicker(date); 
        grid.add(new Label("Select Date: "), 0, 3);
        grid.add(datePicker, 1, 3);
        
        // Input payment amount
        grid.add(new Label("Payment Amount: "), 0, 4);
        grid.add(paymentField, 1, 4, 3, 1);
        // Pay loan
        grid.add(payLoanButton, 0, 5);

        // Set borderpane Top to grid.
        borderpane.setTop(grid);
        // Borderpane Bottom = hbox
        borderpane.setBottom(hbox);

        
        // String (needs to be converted to double) to store the payment made.
        String paymentAmount = paymentField.getText();
        // THIS LocalDate variable will need to be stored as a payment in the LOAN object. We need to modify the loan
        // object to handle this. (Include a list of payments and their dates within the loan object? Or a dictionary with Dictionary<Payment, Date>?
        // Something like this.
        LocalDate i = datePicker.getValue(); 
        
        payLoanButton.setOnAction((ActionEvent event) -> {
            loan.setBalanceDue(loan.getBalanceDue()-Double.parseDouble(paymentField.getText()));
            System.out.println("Subtracting $"+Double.parseDouble(paymentField.getText())+" from loan balance.");
            System.out.println("New loan balance: "+loan.getBalanceDue());
            
            // Reset balance due
            loanBalance.setText("Balance: $" + decim.format(loan.getBalanceDue()));
            
        });
        
        // Return to HomeView on back button click
        backButton.setOnAction((ActionEvent event) -> {
            HomeView hv = new HomeView(stage, this.user);
            backButton.getScene().setRoot(homeviewVBox());
        });

        // Create the VBox
        VBox root = new VBox();
        // Set alignment
        root.setAlignment(Pos.BOTTOM_LEFT);

        // Add the Table to the VBox
        root.getChildren().addAll(grid, borderpane);

        // Set the Padding and Border for the VBox
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage to Pay Loan
        stage.setTitle("Pay Loan");
        // Display the Stage
        stage.show();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
