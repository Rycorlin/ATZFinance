/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Loan;
import Model.LoanTemplate;
import Model.User;
import javafx.scene.image.Image;
import static View.HomeView.homeviewVBox;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author taren
 */
class AccountSummaryView {
    
    User user;
    String accountHolderName;
    
    AccountSummaryView(User u){
        user = u;
    }
    
    public void start(Stage stage, User u) {
        System.out.println(user.getFirstName());
        this.user = u;
        
        
        // Process name.
        int firstNameLength = user.getFirstName().length();
        int lastNameLength = user.getLastName().length();
        String firstName = user.getFirstName().substring(0,1).toUpperCase() + user.getFirstName().substring(1, firstNameLength);
        String lastName = user.getLastName().substring(0,1).toUpperCase() + user.getLastName().substring(1, lastNameLength);
        accountHolderName = firstName + " " + lastName;
        
        // Loans Held
        ArrayList<Loan> loanList = new ArrayList();
        
        for (LoanTemplate loan : user.getLoanList()){
            
        }
        
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

        GridPane grid = new GridPane();
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        // Category in column 2, row 1
        Text category = new Text("Account Holder:");
        GridPane.setVgrow(category, Priority.ALWAYS);
        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(category, 1, 0);

        // Title in column 3, row 1
        Text chartTitle = new Text(accountHolderName);
        GridPane.setHgrow(chartTitle, Priority.ALWAYS);
        chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(chartTitle, 2, 0);

        // Set Row for loan descriptions
        // item, column, row
        Text loans = new Text("Loan ID:");
        grid.add(loans, 0, 1);
        
        Text loanType = new Text("Loan Type: ");
        grid.add(loanType, 1, 1);
        
        Text balanceDue = new Text("Balance Due:");
        grid.add(balanceDue, 2, 1);
        
        Text interestRate = new Text("Interest Rate:");
        grid.add(interestRate, 3, 1);
        
        
        
     
        int counter = 2;
        for (LoanTemplate loan : user.getLoanList()){
            Text newText = new Text();
            newText.setText(String.valueOf(loan.getBalanceDue()));
            grid.add(newText, 2, counter);
            counter++;
        }
        
        
//        
//        //GridPane.setConstraints(label, 2, 0); // column=2 row=0
//        loanBalance.setText(String.valueOf(user.getLoanList().get(0).getBalanceDue()));
//        grid.add(loanBalance, 0, 2);
        

        // Set borderpane Top to grid.
        borderpane.setTop(grid);

        borderpane.setBottom(hbox);

        // Return to HomeView
        backButton.setOnAction((ActionEvent event) -> {
            // Why is this line of code necessary?
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
        // Set the Title of the Stage
        stage.setTitle("Account Summary");
        // Display the Stage
        stage.show();
    }
}
