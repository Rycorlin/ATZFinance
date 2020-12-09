/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
 * @author rycor
 */
public class HomeView {

    public Button logoutButton;
    User user;
    Stage stage;


    public HomeView(Stage primaryStage, User u) {
        //Stage stage = new Stage();
        this.user = u;
        stage = primaryStage;
        stage.setTitle("ATZ Finance Login");
        
//        //BRET USER TESTING - Displays user's first and last name, and how much is on their first loan (Which we have set up as a default loan.)
//        System.out.println("User "+user.getFirstName()+" "+user.getLastName()+" has a loan balance on loan 1 of: $"+user.getLoanList().get(0).getBalanceDue());
        
        BorderPane border = new BorderPane();

        HBox hbox = new HBox();
        HBox hboxBot = new HBox();

        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(5);
        hbox.setStyle("-fx-background-color: #336699;");

        hboxBot.setPadding(new Insets(15, 12, 15, 12));
        hboxBot.setSpacing(5);
        hboxBot.setStyle("-fx-background-color: #336699;");
        hboxBot.setAlignment(Pos.BOTTOM_LEFT);

        Button buttonSummary = new Button("Account Summary");
        buttonSummary.setPrefSize(150, 20);

        logoutButton = new Button("Log off");

        logoutButton.setPrefSize(150, 20);

        hbox.getChildren().addAll(buttonSummary);

        hboxBot.getChildren().addAll(logoutButton);

        Button userListButton = new Button("User list");
        hbox.getChildren().addAll(userListButton);
        
        //Apply For Loan
        Button applyForLoanButton = new Button("Apply For Loan");
        hbox.getChildren().addAll(applyForLoanButton);

        HBox.setHgrow(buttonSummary, Priority.ALWAYS);

        border.setTop(hbox);

        // Moved this hyperlink stuff into Homeview so I can use the 
        // stage to start my LoanTransactionView.
        VBox vBox = homeviewVBox();
        ArrayList<Hyperlink> listOfLoansHyperlinks = new ArrayList();
        listOfLoansHyperlinks.add(new Hyperlink("Loan #" + String.valueOf(user.getLoanList().get(0).getLoanID()) + ", " + user.getLoanList().get(0).getLoanType()));
        listOfLoansHyperlinks.add(new Hyperlink("Loan #" + String.valueOf(user.getLoanList().get(1).getLoanID()) + ", " + user.getLoanList().get(1).getLoanType()));
        listOfLoansHyperlinks.add(new Hyperlink("Loan #" + String.valueOf(user.getLoanList().get(2).getLoanID()) + ", " + user.getLoanList().get(2).getLoanType()));
        

        for (Hyperlink link : listOfLoansHyperlinks) {
            link.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    LoanTransactionView ltv = new LoanTransactionView(user.getLoanList().get(listOfLoansHyperlinks.indexOf((link))),user);
                    try {
                        // Go to Summary View
                        ltv.start(stage);
                    } catch (IOException ex) {
                        Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }

        for (int i = 0; i < listOfLoansHyperlinks.size(); i++) {
            VBox.setMargin(listOfLoansHyperlinks.get(i), new Insets(0, 0, 0, 8));
            vBox.getChildren().add(listOfLoansHyperlinks.get(i));
        }

        border.setLeft(vBox);

        border.setBottom(hboxBot);

        // User list view
        userListButton.setOnAction((ActionEvent event) -> {

            UserView uv = new UserView(user);

            uv.start(stage);

        });

        //Action for btnLogin
        logoutButton.setOnAction((ActionEvent event) -> {

            //System.out.print("test");
            //UserView uv = new UserView(stage, border, hbox);
            LoginView lv = new LoginView();

            lv.start(primaryStage);

        });

        //Action for btnLogin
        buttonSummary.setOnAction((ActionEvent event) -> {

            //System.out.print("test");
            //UserView uv = new UserView(stage, border, hbox);
            AccountSummaryView accountSummaryView = new AccountSummaryView(user);

            try {
                // Go to Summary View
                accountSummaryView.start(stage, this.user);
            } catch (Exception ex) {
                Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Apply for loan logic
        applyForLoanButton.setOnAction((ActionEvent event) -> {

            ApplyForLoanView apv = new ApplyForLoanView(user);

            try {
                apv.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.show();

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
    }
    
    
    // View for homeView
    public static VBox homeviewVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Loans:");
        Text payLoan = new Text("Click on a loan to pay...");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        vbox.getChildren().add(payLoan);
        
        return vbox;
    }
}
