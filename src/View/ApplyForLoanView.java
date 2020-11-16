/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.LoanApplication;
import Model.UserTable;
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

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

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
    private TextField addressLine1;
    private TextField addressLine2;
    private TextField city;
    private TextField state;
    private TextField zip;
    private ChoiceBox loanType;
    private TextField loanAmount;
    public Button apply;
    public Button back;
    private LoanApplication loanApp;
    private UserTable userTbl;
    private ComboBox combo_box;
    private VBox vBox;

    //initial scene is launched
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(root, 400, 775);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("ATZ Loan Application");

        
        ComboBox combo_box
                = new ComboBox(FXCollections.observableArrayList(userTbl.getUsernames()));
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        
        //This vBox hold the main form.
        vBox.getChildren().addAll(
                new Label("Choose User"),
                combo_box,
                new Label("First Name"),
                firstName = new TextField(),
                new Label("Last Name"),
                lastName = new TextField(),
                new Label("Address Line 1"),
                addressLine1 = new TextField(),
                new Label("Address Line 2"),
                addressLine2 = new TextField(),
                new Label("City"),
                city = new TextField(),
                new Label("State"),
                state = new TextField(),
                new Label("Zip Code"),
                zip = new TextField(),
                new Label("Loan Type"),
                loanType = new ChoiceBox(),
                new Label("Please Enter Desired Loan Amount"),
                loanAmount = new TextField(),
                apply = new Button("APPLY"),
                back = new Button("BACK"));

        loanType.setItems(FXCollections.observableArrayList("Personal Loan", "Car Loan"));
        
        //this event allows the combo box to be automatically populated with the users information
        EventHandler<ActionEvent> comboHandler = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                for (String string : getUserTbl().getUsernames())
                {
                    if ((string.contains(combo_box.getValue().toString())))
                    {
                        int temp = getUserTbl().getUsernames().indexOf(string);
                        firstName.setText(getUserTbl().getUser(temp).getFirstName());
                        lastName.setText(getUserTbl().getUser(temp).getLastName());
                    }
                };
            }
        };
        combo_box.setOnAction(comboHandler);

        //read from autosave
        try
        {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("loanappsave.ser"));
            loanApp = (LoanApplication) oin.readObject();
            firstName.setText(loanApp.getfName());
            lastName.setText(loanApp.getlName());
            addressLine1.setText((loanApp.getAddress1()));
            addressLine2.setText((loanApp.getAddress2()));
            city.setText(loanApp.getCity());
            state.setText(loanApp.getState());
            zip.setText((loanApp.getZipCode()));
            loanType.setValue(loanApp.getLoanType());
            loanAmount.setText(loanApp.getLoanAmount());
        } catch (Exception e)
        {
            loanApp = new LoanApplication();
        }

        firstName.textProperty().addListener((observable, oldValue, newValue) ->
        {
            loanApp.setfName(newValue);
            save();
        });
        lastName.textProperty().addListener((observable, oldValue, newValue) ->
        {
            loanApp.setlName(newValue);
            save();
        });
//        loanType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
//            loanApp.setLoanType(newValue);
//            save();
//        });
        loanType.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            loanApp.setLoanType(newValue.toString());
            save();
        });
        loanAmount.textProperty().addListener((observable, oldValue, newValue) ->
        {
            loanApp.setlName(newValue);
            save();
        });

        root.getChildren().addAll(vBox);

        apply.setOnAction((ActionEvent event) ->
        {
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

            HomeView hv = new HomeView(primaryStage);
        });

        back.setOnAction((ActionEvent event) ->
        {
            HomeView hv = new HomeView(primaryStage);
        });
    }

    private void save()
    {
        try
        {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("loanappsave.ser"));
            ous.writeObject(loanApp);
            ous.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
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

    public TextField getloanAmount()
    {
        return loanAmount;
    }

    public void setloanAmount(TextField ploanAmount)
    {
        this.loanAmount = ploanAmount;
    }

    public Button getApply()
    {
        return apply;
    }

    public void setApply(Button apply)
    {
        this.apply = apply;
    }

    public ComboBox getCombo_box()
    {
        return combo_box;
    }

    public void setCombo_box(ComboBox combo_box)
    {
        this.combo_box = combo_box;
    }

    public UserTable getUserTbl()
    {
        return userTbl;
    }

    public void setUserTbl(UserTable userTbl)
    {
        this.userTbl = userTbl;
    }

    public TextField getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(TextField addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public TextField getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(TextField addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public TextField getCity()
    {
        return city;
    }

    public void setCity(TextField city)
    {
        this.city = city;
    }

    public TextField getState()
    {
        return state;
    }

    public void setState(TextField state)
    {
        this.state = state;
    }

    public TextField getZip()
    {
        return zip;
    }

    public void setZip(TextField zip)
    {
        this.zip = zip;
    }

    public TextField getLoanAmount()
    {
        return loanAmount;
    }

    public void setLoanAmount(TextField loanAmount)
    {
        this.loanAmount = loanAmount;
    }

    public Button getBack()
    {
        return back;
    }

    public void setBack(Button back)
    {
        this.back = back;
    }

    public LoanApplication getLoanApp()
    {
        return loanApp;
    }

    public void setLoanApp(LoanApplication loanApp)
    {
        this.loanApp = loanApp;
    }

    public VBox getvBox()
    {
        return vBox;
    }

    public void setvBox(VBox vBox)
    {
        this.vBox = vBox;
    }

}
