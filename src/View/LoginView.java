package View;

import Controller.LoginController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * The login screen for ATZ Finance
 */
public class LoginView extends Application {

    private String user = "Myliu";
    private String pw = "password";
    private String checkUser;
    private String checkPw;
    private LoginController loginController;
    private Hyperlink newAccount;

    private Label lblUserName, lblPassword, lblMessage;
    private TextField txtUserName;
    private PasswordField pf;
    private Button btnLogin;

    @Override
    public void start(Stage primaryStage) {
        loginController = new LoginController(this, primaryStage);
        primaryStage.setTitle("ATZ Finance Login");

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        lblUserName = new Label("Username");
        txtUserName = new TextField();
        lblPassword = new Label("Password");
        pf = new PasswordField();
        btnLogin = new Button("Login");
        lblMessage = new Label();

        setNewAccount(new Hyperlink("Create Account"));
        getNewAccountHyperLink().setTextFill(Color.CHARTREUSE);
        

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);
        gridPane.add(getNewAccountHyperLink(), 1, 5);

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("ATZ Finance Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");

        //Action for btnLogin
        btnLogin.setOnAction((ActionEvent event) -> {
            setCheckUser(txtUserName.getText());
//            verifyPassword(pj.);

            setCheckPw(pf.getText());
            loginController.login(getCheckUser(), getCheckPw(), primaryStage);
            loginController.login(user, user);

        });
        
        //Action on click "Create Account" for new account sends to LoginController
        getNewAccountHyperLink().setOnAction((ActionEvent event) -> {
            
            try {
                loginController.createAccount(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        });

        //Action for KeyPress Enter key
        pf.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                setCheckUser(txtUserName.getText());
                setCheckPw(pf.getText());
                loginController.login(getCheckUser(), getCheckPw(), primaryStage);
            }
        });

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pw
     */
    public String getPw() {
        return pw;
    }

    /**
     * @param pw the pw to set
     */
    public void setPw(String pw) {
        this.pw = pw;
    }

    /**
     * @return the checkUser
     */
    public String getCheckUser() {
        return checkUser;
    }

    /**
     * @param checkUser the checkUser to set
     */
    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    /**
     * @return the checkPw
     */
    public String getCheckPw() {
        return checkPw;
    }

    /**
     * @param checkPw the checkPw to set
     */
    public void setCheckPw(String checkPw) {
        this.checkPw = checkPw;
    }

    /**
     * @return username Label object
     */
    public Label getLblUserName() {
        return lblUserName;
    }

    /**
     * @return password Label object
     */
    public Label getLblPassword() {
        return lblPassword;
    }

    /**
     * @return message Label object
     */
    public Label getLblMessage() {
        return lblMessage;
    }

    /**
     * @return username TextField object
     */
    public TextField getTxtUserName() {
        return txtUserName;
    }

    /**
     * @return PasswordField object
     */
    public PasswordField getPf() {
        return pf;
    }

    /**
     * @return login Button object
     */
    public Button getBtnLogin() {
        return btnLogin;
    }

    /**
     * @return the newAccount
     */
    public Hyperlink getNewAccountHyperLink() {
        return newAccount;
    }

    /**
     * @param newAccount the newAccount to set
     */
    public void setNewAccount(Hyperlink newAccount) {
        this.newAccount = newAccount;
    }
}
