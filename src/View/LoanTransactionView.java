/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.HomeView.homeviewVBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.time.Month;
import java.time.YearMonth;
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

/**
 *
 * @author taren
 */
public class LoanTransactionView implements ItemListener {

    LoanTransactionView() {

    }

    public void start(Stage stage) throws IOException {

        // BOTTOM BAR / BUTTON
        BorderPane borderpane = new BorderPane();
        HBox hbox = new HBox();

        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(5);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        Button backButton = new Button("Back");
        backButton.setPrefSize(150, 20);
        hbox.getChildren().addAll(backButton);

        HBox.setHgrow(backButton, Priority.ALWAYS);
        
        // Pay loan Button
        final Button payLoanButton = new Button("Pay Loan");
        // Text field for payment total
        final TextField paymentField = new TextField("");

        // Combo box for Month
        final ComboBox monthComboBox = new ComboBox();
        monthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
        monthComboBox.setValue("January");

        // Days in month, Combo box for days
        final ComboBox dayComboBox = new ComboBox();
        YearMonth yearMonth = YearMonth.of(2020, Month.JANUARY);
        int daysInMonth = yearMonth.lengthOfMonth();

        // Populate days
        for (int i = 1; i < daysInMonth + 1; i++) {
            dayComboBox.getItems().addAll(i);
        }

        // Default day = 1
        dayComboBox.setValue("1");

        // Combo box for Year (Always stays at current year)
        final ComboBox yearComboBox = new ComboBox();

        // add year
        yearComboBox.getItems().addAll(yearMonth.getYear());
        yearComboBox.setValue(yearMonth.getYear());

        
        
        GridPane grid = new GridPane();

        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        // Select date
        grid.add(new Label("Select Date: "), 0, 0);
        grid.add(monthComboBox, 1, 0);
        grid.add(dayComboBox, 2, 0);
        grid.add(yearComboBox, 3, 0);

        // Input payment amount
        grid.add(new Label("Payment Amount: "), 0, 1);
        grid.add(paymentField, 1, 1, 3, 1);
        // Pay loan
        grid.add(payLoanButton, 0, 3);

        // Set borderpane Top to grid.
        borderpane.setTop(grid);
        // Borderpane Bottom = hbox
        borderpane.setBottom(hbox);

        // Return to HomeView on back button click
        backButton.setOnAction((ActionEvent event) -> {
            HomeView hv = new HomeView(stage);
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
}
