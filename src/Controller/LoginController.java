package Controller;

import View.HomeView;
import View.LoginView;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {

    private String user = "";
    private String pw = "";
    private LoginView loginView;
    private HomeView hv;

    public LoginController(String[] args) {
        
        Application.launch(LoginView.class, args);
    }

    public LoginController(LoginView loginview) {
        loginView = loginview;
    }

    public void login(String username, String password, Stage primaryStage) {
        if (username.equalsIgnoreCase(user) && password.equals(pw)) {

            loginView.getLblMessage().setTextFill(Color.GREEN);
            hv = new HomeView(primaryStage);
        } else {
            loginView.getLblMessage().setText("Incorrect user or pw.");
            loginView.getLblMessage().setTextFill(Color.RED);
        }
        loginView.getTxtUserName().setText("");
        loginView.getPf().setText("");
    }
}
