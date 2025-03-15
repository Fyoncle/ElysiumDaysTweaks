package net.fyoncle.elysiumdaystweaks.utility.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
    public String sendRequestTo(String urlString) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result;
            while((result = reader.readLine()) != null) {
                return result;
            }
        } catch (IOException e) {throw new RuntimeException(e);}
        return "invalid_result";
    }
}
