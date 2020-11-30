package Model;

import java.util.*;

/**
 *
 * A sub user class that handles tech-support users
 */
public class TechSupport extends User {

    //private User nullTest = new User("nullTest", "nullTest", "nullTest", "test", Loan l);

    /**
     *
     *
     * @param fName First name of the tech support user
     * @param lName Last name of the tech support user
     * @param userName
     * @param socialSecurityNumber
     */
    public TechSupport(String fName, String lName, String userName, String password, Loan l) {
        super(fName, lName, userName, password, l);
    }

    /**
     * Searches through the database of error reports and retrieve all reports
     * that match user
     *
     * @param user A user object used for reports
     * @return Returns a report for a user
     */

    public ArrayList<IncidentReport> getUserIncidentReports(User user, ArrayList<IncidentReport> searchReports) {
        ArrayList<IncidentReport> errorReports = new ArrayList<>();
        for( IncidentReport incident : searchReports){
            if (user.equals(incident.getUser())){
                errorReports.add(incident);
            }
        }
        return errorReports;
    }
}
