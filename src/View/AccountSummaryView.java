package View;

import Model.Loan;
import Model.LoanTemplate;
import Model.User;
import static View.HomeView.homeviewVBox;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * class responsible for displaying the account summary
 */
class AccountSummaryView {
    
    User user;
    String accountHolderName;
    String accountHolderNameNoSpaces;
    
    // Decimal formatting for money
    DecimalFormat decim = new DecimalFormat("0.00");
    
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
        accountHolderNameNoSpaces = firstName + lastName;
        
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
        
        Button generateReportButton = new Button("Generate Report");
        generateReportButton.setPrefSize(150,20);
        hbox.getChildren().addAll(generateReportButton);

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
        
        
        
        // Iterate through loans and populate display
        int counter = 2;
        for (LoanTemplate loan : user.getLoanList()){
            Text loanBalanceText = new Text();
            Text loanIDText = new Text();
            Text loanTypeText = new Text();
            Text loanInterestRateText = new Text();
            
            
            loanIDText.setText(String.valueOf(loan.getLoanID()));
            loanTypeText.setText(String.valueOf(loan.getLoanType()));
            loanBalanceText.setText("$" + String.valueOf(decim.format(loan.getBalanceDue())));
            loanInterestRateText.setText(String.valueOf(loan.getInterestRate()));
            
            grid.add(loanIDText, 0, counter);
            grid.add(loanTypeText, 1, counter);
            grid.add(loanBalanceText, 2, counter);
            grid.add(loanInterestRateText, 3, counter);
            
            counter++;
            
        }
        
        // Set borderpane Top to grid.
        borderpane.setTop(grid);

        borderpane.setBottom(hbox);

        // Return to HomeView
        backButton.setOnAction((ActionEvent event) -> {
            // Why is this line of code necessary?
            HomeView hv = new HomeView(stage, this.user);

            backButton.getScene().setRoot(homeviewVBox());
        });

        generateReportButton.setOnAction((ActionEvent event) -> {

            try (PrintWriter out = new PrintWriter(accountHolderNameNoSpaces + "AccountStatement.txt")) {
                
                out.println("First name: " + user.getFirstName());
                out.println("Last name: " + user.getLastName());
                out.println("Username: " + user.getUserName());
                
                out.println("");
                out.println("");
                out.println("Loans:");
                
                for (LoanTemplate loan : user.getLoanList()){
                    
                    
                    out.println("Loan ID: " + loan.getLoanID());
                    out.println("Type: " + loan.getLoanType());
                    out.println("Balance: " + loan.getBalanceDue());
                    out.println("Interest Rate : " + loan.getInterestRate());
                }
                
                System.out.println("Report Generated");

            } catch (FileNotFoundException ex) {
                System.out.println("File already exists");
            }

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
    
    public void printLoans(){
        
    }
}
