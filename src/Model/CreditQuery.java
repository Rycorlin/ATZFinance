package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 *
 * @author Pankaj, also Taren
 * Source:
 * https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post
 */

/**
 *
 * A class that pulls the user's credit score
 */

public class CreditQuery {
    
    private static final String GET_URL = "http://www.randomnumberapi.com/api/v1.0/random?min=450&max=850&count=1";

    public int getScore() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        StringBuffer response;
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try ( // success
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            connection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            String responseString = response.toString();
            int responseInt = Integer.parseInt(responseString.substring(1, responseString.length() - 1));
            
            // response success, return credit score as int.
            return responseInt;
        } else {
            System.out.println("GET request not worked");
        }
        // return -1 if request failed.
        return -1;
    }
}
