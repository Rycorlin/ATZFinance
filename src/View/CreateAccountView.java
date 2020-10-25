/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rycor
 */
public class CreateAccountView extends Application {

    private StackPane root = new StackPane();
    private Stage stage;
    private TextField firstName;
    public TextField lastName;
    public TextField userName;
    public PasswordField password;
    public PasswordField confirmPass;
    public Button register;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("ATZ User Registration");
        primaryStage.setAlwaysOnTop(true);

        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        vBox.getChildren().addAll(
                new Label("First Name"),
                firstName = new TextField(),
                new Label("Last Name"),
                lastName = new TextField(),
                new Label("Your Username"),
                userName = new TextField(),
                new Label("Your Password"),
                password = new PasswordField(),
                new Label("Confirm Password"),
                confirmPass = new PasswordField(),
                register = new Button("REGISTER"));
        root.getChildren().addAll(vBox);



    }
    
    public String getFirstName()
    {
        return firstName.getText();
    }
    public String getLastName()
    {
        return lastName.getText();
    }
    public String getUsername()
    {
        return userName.getText();
    }
    public String getPassword()
    {
        return password.getText();
    }
    
    

}
