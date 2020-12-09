
package Controller;

import Model.Loan;
import Model.LoanApplication;
import Model.User;
import Model.UserTable;
import View.ApplyForLoanView;
import View.HomeView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author xxani
 */

public class ApplyForLoanController
{
    // Maybe we check if this user already has this type of loan? etc.
    User user;
    
    ApplyForLoanView applyForLoanView;
    Stage primaryStage;
    LoanApplication loanApp;

    public ApplyForLoanController(ApplyForLoanView view, Stage stage, User u)
    {
        this.applyForLoanView = view;
        this.primaryStage = stage;
        this.user = u; 
        this.save();
        this.autoSave();

        this.apply();
        this.back();
    }

    //method to automatically save data
    private void autoSave() {
        //read from autosave
        try {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("loanappsave.ser"));
            loanApp = (LoanApplication) oin.readObject();
            applyForLoanView.getFirstName().setText(loanApp.getfName());
            applyForLoanView.getLastName().setText(loanApp.getlName());
            applyForLoanView.getAddressLine1().setText((loanApp.getAddress1()));
            applyForLoanView.getAddressLine2().setText((loanApp.getAddress2()));
            applyForLoanView.getCity().setText(loanApp.getCity());
            applyForLoanView.getState().setText(loanApp.getState());
            applyForLoanView.getZip().setText((loanApp.getZipCode()));
            applyForLoanView.getLoanType().setValue(loanApp.getLoanType());
            applyForLoanView.getLoanAmount().setText(loanApp.getLoanAmount());
        } catch (Exception e) {
            loanApp = new LoanApplication();
        }

        applyForLoanView.getFirstName().textProperty().addListener((observable, oldValue, newValue) -> {
            loanApp.setfName(newValue);
            save();
        });
        applyForLoanView.getLastName().textProperty().addListener((observable, oldValue, newValue) -> {
            loanApp.setlName(newValue);
            save();
        });
        applyForLoanView.getLoanType().valueProperty().addListener((observable, oldValue, newValue) -> {
            loanApp.setLoanType(newValue.toString());
            save();
        });
        applyForLoanView.getLoanAmount().textProperty().addListener((observable, oldValue, newValue) -> {
            loanApp.setlName(newValue);
            save();
        });
    }

    //method to apply
    private void apply() {
        applyForLoanView.getApply().setOnAction((ActionEvent event) -> {
            loanApp = new LoanApplication();
            save();

            Stage tyStage = new Stage();
            tyStage.initModality(Modality.APPLICATION_MODAL);
            tyStage.setTitle("Thank You");
            tyStage.setMinWidth(250);
            tyStage.setAlwaysOnTop(true);

            Label label = new Label();
            label.setText("Thank you, your application is now being processed.");
            Button closeButton = new Button("OK");
            closeButton.setOnAction(e -> tyStage.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene tyScene = new Scene(layout);
            tyStage.setScene(tyScene);
            tyStage.showAndWait();

            HomeView hv = new HomeView(primaryStage, user);

        });
    }

    //method to return back to the home screen
    private void back()
    {
        applyForLoanView.getBack().setOnAction((ActionEvent event) ->
        {
            HomeView hv = new HomeView(primaryStage, this.user);
        });
    }

//method to save data to database
    private void save() {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("loanappsave.ser"));
            ous.writeObject(loanApp);
            ous.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
