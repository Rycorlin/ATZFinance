/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atzfinance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author rycor
 */
public class UserTable {

    // Returns an observable list of persons
    public static ObservableList<User> getPersonList() {
        User u1 = new User("Ryan", "Milici", "Myliu", 12312412);
        User u2 = new User("Ted", "Tedson", "Tdawg", 223412);
        User u3 = new User("John", "Johnson", "Jman", 00123);

        return FXCollections.<User>observableArrayList(u1, u2, u3);
    }

    // Returns User First Name TableColumn
    public static TableColumn<User, String> getFirstNameColumn() {
        TableColumn<User, String> fNameCol = new TableColumn<>("First name");
        PropertyValueFactory<User, String> fNameCellValueFactory = new PropertyValueFactory<>("firstName");
        fNameCol.setCellValueFactory(fNameCellValueFactory);
        return fNameCol;
    }
    // Returns Last Name TableColumn

    public static TableColumn<User, String> getLastNameColumn() {
        TableColumn<User, String> lastNameCol = new TableColumn<>("Last name");
        PropertyValueFactory<User, String> lastNameCellValueFactory = new PropertyValueFactory<>("lastName");
        lastNameCol.setCellValueFactory(lastNameCellValueFactory);
        return lastNameCol;
    }

    // Returns user name column
    public static TableColumn<User, String> getUserNameColumn() {
        TableColumn<User, String> userNameColumn = new TableColumn<>("User name");
        PropertyValueFactory<User, String> userNameCellValueFactory = new PropertyValueFactory<>("userName");
        userNameColumn.setCellValueFactory(userNameCellValueFactory);
        return userNameColumn;
    }

    // Returns social security TableColumn
    public static TableColumn<User, Integer> getSocialSecurityColumn() {
        TableColumn<User, Integer> socialCol = new TableColumn<>("Social security number");
        PropertyValueFactory<User, Integer> socialCellValueFactory = new PropertyValueFactory<>("socialSecurityNumber");
        socialCol.setCellValueFactory(socialCellValueFactory);
        return socialCol;
    }

}
