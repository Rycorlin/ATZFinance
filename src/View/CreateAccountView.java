package View;

import Controller.CreateAccountController;
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
 * class responsible for displaying the creation of an account
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
    public Label nameNumberError;
    public Label passwordMatchError;
    public Label passwordSecurityError;
    public Label usernameError;

    public CreateAccountView() {
        super();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Set the scene / Stage
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("ATZ User Registration");
        primaryStage.setAlwaysOnTop(true);

        
        // VBox settings
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
                nameNumberError = new Label("No numbers/Special characters in First/Last name"),
                passwordMatchError = new Label("Passwords do not match"),
                passwordSecurityError = new Label("Password does not meet security requirements"),
                register = new Button("REGISTER"));
        root.getChildren().addAll(vBox);
        
        
        // GUI visual settings for password errors
        nameNumberError.setVisible(false);
        passwordMatchError.setVisible(false);
        passwordSecurityError.setVisible(false);
        usernameError.setVisible(false);
        
        nameNumberError.setTextFill(Color.RED);
        passwordMatchError.setTextFill(Color.RED);
        passwordSecurityError.setTextFill(Color.RED);
        usernameError.setTextFill(Color.RED);

        //create conroller and pass user table to it
        createAccountController = new CreateAccountController(this, primaryStage);
    }
    
    // Getters and setters
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
