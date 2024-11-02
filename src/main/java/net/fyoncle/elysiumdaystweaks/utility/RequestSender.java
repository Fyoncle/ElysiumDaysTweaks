// This code was written by VipCoder.

package net.fyoncle.elysiumdaystweaks.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
    private HttpURLConnection connection;
    private String result;
    public String sendRequestTo(String urlString) {
        try {
            connection = (HttpURLConnection) new URL(urlString).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((result = reader.readLine()) != null) {
                return result;
            }
        } catch (IOException e) {throw new RuntimeException(e);}
        return "invalid_result";
    }
}