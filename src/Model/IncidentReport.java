package Model;

/**
 *
 * A class that generates reports
 */

import java.util.ArrayList;

public class IncidentReport {

    private User user;
    private String message;
    private ArrayList<IncidentReport> incidentReportArray = new ArrayList<>();
    
    public IncidentReport(){

    }
    
    public IncidentReport(User user, String message) {
        this.user = user;
        this.message = message;
        if (!user.getFirstName().contentEquals("nullTest"))
        {
        incidentReportArray.add(this);
        }
    }

    public void setUser(User u){
        this.user = u;
    }
    
    public User getUser() {
        return user;
    }

    public void setMessage(String m){
        this.message = m;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void printReport(){
        System.out.println(this.message);
    }
    
    public void setIncidentReportArray(ArrayList<IncidentReport> report){
        incidentReportArray = report;
    }
    
    public ArrayList<IncidentReport> getIncidentReportArray() {
        return incidentReportArray;
    }
    
}
