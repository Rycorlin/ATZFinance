/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CreateAccountController;
import Model.UserTable;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author rycor
 */
public class CreateAccountView extends Application {

    private StackPane root = new StackPane();
    private TextField firstName;
    private CreateAccountController createAccountController;
    public TextField lastName;
    public TextField userName;
    public PasswordField password;
    public PasswordField confirmPass;
    public Button register;
    public Label passwordMatchError;
    public Label passwordSecurityError;
    public Label usernameError;

    public CreateAccountView() {
        super();
    }

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
                usernameError = new Label("Username is taken"),
                new Label("Password must be 8+ characters"),
                new Label("It also must contain a number and an uppercase letter"),
                new Label("Your Password"),
                password = new PasswordField(),
                new Label("Confirm Password"),
                confirmPass = new PasswordField(),
                passwordMatchError = new Label("Passwords do not match"),
                passwordSecurityError = new Label("Password does not meet security requirements"),
                register = new Button("REGISTER"));
        root.getChildren().addAll(vBox);

        passwordMatchError.setVisible(false);
        passwordSecurityError.setVisible(false);
        usernameError.setVisible(false);

        passwordMatchError.setTextFill(Color.RED);
        passwordSecurityError.setTextFill(Color.RED);
        usernameError.setTextFill(Color.RED);

        //create conroller and pass user table to it
        createAccountController = new CreateAccountController(this, primaryStage);
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
    public String getConfirmPassword()
    {
        return confirmPass.getText();
    }
}
