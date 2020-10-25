/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author xxanim
 */
public class ApplyForLoanView extends Application
{

    private StackPane root = new StackPane();
    private Stage stage;
    private TextField firstName;
    private TextField lastName;
    private ChoiceBox loanType;
    private ChoiceBox loanAmount;
    public Button apply;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("ATZ Loan Application");

        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        vBox.getChildren().addAll(
                new Label("First Name"),
                firstName = new TextField(),
                new Label("Last Name"),
                lastName = new TextField(),
                new Label("Loan Type"),
                loanType = new ChoiceBox(),
                new Label("Loan Amount"),
                loanAmount = new ChoiceBox(),
                apply = new Button("APPLY"));
        root.getChildren().addAll(vBox);

        loanType.setItems(FXCollections.observableArrayList("Personal Loan", "Car Loan"));
        loanAmount.setItems(FXCollections.observableArrayList("500", "1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "10000", "15000", "20000", "30000", "40000"));

        apply.setOnAction((ActionEvent event) ->
        {

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

            HomeView hv = new HomeView(primaryStage);

        });
    }

    public StackPane getRoot()
    {
        return root;
    }

    public void setRoot(StackPane root)
    {
        this.root = root;
    }

    public Stage getStage()
    {
        return stage;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public TextField getFirstName()
    {
        return firstName;
    }

    public void setFirstName(TextField firstName)
    {
        this.firstName = firstName;
    }

    public TextField getLastName()
    {
        return lastName;
    }

    public void setLastName(TextField lastName)
    {
        this.lastName = lastName;
    }

    public ChoiceBox getLoanType()
    {
        return loanType;
    }

    public void setLoanType(ChoiceBox loanType)
    {
        this.loanType = loanType;
    }

    public ChoiceBox getloanAmount()
    {
        return loanAmount;
    }

    public void setloanAmount(ChoiceBox ploanAmount)
    {
        this.loanAmount = loanAmount;
    }

    public Button getApply()
    {
        return apply;
    }

    public void setApply(Button apply)
    {
        this.apply = apply;
    }

}
