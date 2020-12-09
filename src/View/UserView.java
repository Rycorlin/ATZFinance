/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import Model.UserTable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static View.HomeView.homeviewVBox;

/**
 *
 * @author rycor
 */
public class UserView extends Application {
    User user;
    
    UserView(User u){
        this.user = u;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {
        
        
        // Adding bottom bar and back button
        BorderPane borderpane = new BorderPane();
        HBox hbox = new HBox();
        
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(5);
        hbox.setStyle("-fx-background-color: #336699;");
        
        Button backButton = new Button("Back");
        backButton.setPrefSize(150, 20);
        hbox.getChildren().addAll(backButton);
        
        HBox.setHgrow(backButton, Priority.ALWAYS);
        
        borderpane.setBottom(hbox);
        
        
        // Return to HomeView
        backButton.setOnAction((ActionEvent event) -> {
            // Why is this line of code necessary?
            HomeView hv = new HomeView(stage, this.user);
            
            backButton.getScene().setRoot(homeviewVBox());  
        });

        // Create a TableView with a list of customers
        TableView<User> table = new TableView<>();
        // Add rows to the TableView
        table.getItems().addAll(UserTable.getPersonList());
        // Add columns to the TableView
        table.getColumns().addAll(UserTable.getFirstNameColumn(),
                UserTable.getLastNameColumn(), UserTable.getUserNameColumn());

        // Set the column resize policy to constrained resize policy
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Set the Placeholder for an empty table
        table.setPlaceholder(new Label("No visible columns and/or data exist."));

        // Create the VBox
        VBox root = new VBox();
        // Add the Table, and the borderpane to the VBox
        root.getChildren().addAll(table, borderpane);

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
        stage.setTitle("User List");
        // Display the Stage
        stage.show();
    }
}
