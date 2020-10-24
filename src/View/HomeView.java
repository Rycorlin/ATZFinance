/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
    
    public HomeView(Stage primaryStage) {
        //Stage stage = new Stage();
        Stage stage = primaryStage;
        stage.setTitle("ATZ Finance Login");

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

        //Button buttonPayment = new Button("Make a Payment");
        //buttonPayment.setPrefSize(150, 20);
        hbox.getChildren().addAll(buttonSummary);
        
        hboxBot.getChildren().addAll(logoutButton);

        Button userListButton = new Button("User list");
        //buttonPayment.setPrefSize(150, 20);

        Button testTwoButton = new Button("Test 2");
        //buttonPayment.setPrefSize(150, 20);
        hbox.getChildren().addAll(userListButton, testTwoButton);

        HBox.setHgrow(buttonSummary, Priority.ALWAYS);
        //HBox.setHgrow(buttonPayment, Priority.ALWAYS);

        //bp.setPadding(new Insets(10, 50, 50, 50));
        border.setTop(hbox);
        border.setLeft(homeviewVBox());
        
        border.setBottom(hboxBot);

        //Action for btnLogin
        userListButton.setOnAction((ActionEvent event) -> {

            //System.out.print("test");
            //UserView uv = new UserView(stage, border, hbox);
            UserView uv = new UserView();

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
            SummaryView sv = new SummaryView();

            
            try {
                // Go to Summary View
                sv.start(stage);
            } catch (IOException ex) {
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

    public static VBox homeviewVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[]{
            new Hyperlink("Loan 1"),
            new Hyperlink("Loan 2"),
            new Hyperlink("Loan 3"),
            new Hyperlink("Loan 4")};

        for (int i = 0; i < 4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }

        return vbox;
    }

    //    primaryStage.show();
}
