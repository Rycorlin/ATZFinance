/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atzfinance;

/**
 *
 * A class that contains user information.
 */
public class User {

    private String fName;
    private String lName;
    private String userName;
    private int socialSecurityNumber;

    /**
     *
     * @param fName First name of the user
     * @param lName Last name of the user
     */
    public User(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

    }

    /**
     * Returns the first name of the user
     *
     * @return A string returning the first name of the user
     */
    public String getfName() {
        return fName;
    }
 
    /**
     * Sets the first name of the user
     *
     * @param fName Sets the first name of the user
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Returns the last name of the user
     *
     * @return A string returning the first name of the user
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets the last name of the user
     *
     * @param lName Sets the last name of the user
     *
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Returns the social security number of the user
     *
     * @return An integer returning the social security number of the user
     */
    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets the social security number for the user
     *
     * @param socialSecurityNumber Sets the social security number of the user
     */
    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the user name for the user
     *
     * @return Returns the user name for the user account
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name for the user
     *
     * @param userName Sets the user name for the user account
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
