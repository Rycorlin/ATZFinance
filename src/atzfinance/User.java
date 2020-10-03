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

    private String firstName;
    private String lastName;
    private String userName;
    private int socialSecurityNumber;

    /**
     *
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param userName User name of the user account
     * @param socialSecuritynumber Social security number of the suer
     */
    public User(String firstName, String lastName, String userName, Integer socialSecuritynumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.socialSecurityNumber = socialSecuritynumber;

    }

    /**
     * Returns the first name of the user
     *
     * @return A string returning the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user
     *
     * @param firstName Sets the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the user
     *
     * @return A string returning the first name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user
     *
     * @param lastName Sets the last name of the user
     *
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
