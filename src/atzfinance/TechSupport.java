package atzfinance;

import java.util.*;

/**
 *
 * A sub user class that handles tech-support users
 */
public class TechSupport extends User {
    private ArrayList<IncidentReport> searchReports = new ArrayList<>();
    private User nullTest = new User("nullTest", "nullTest", "nullTest", 123456789);
    private IncidentReport shellReport = new IncidentReport(nullTest, "shell");
    /**
     *
     *
     * @param fName First name of the tech support user
     * @param lName Last name of the tech support user
     * @param userName
     * @param socialSecurityNumber
     */
    public TechSupport(String fName, String lName, String userName, Integer socialSecurityNumber) {
        super(fName, lName, userName, socialSecurityNumber);
    }

    /**
     * Searches through the database of error reports and retrieve all reports
     * that match user
     *
     * @param user A user object used for reports
     * @return Returns a report for a user
     */
    public List<IncidentReport> searchErrorReports(User user) {
        searchReports = shellReport.getIncidentReportArray();
        List<IncidentReport> errorReports = new ArrayList<>();
            for( IncidentReport incident : searchReports){
                if (user.equals(incident.getUser())){
                    errorReports.add(incident);
                }
        }
        return errorReports;
    }
}
