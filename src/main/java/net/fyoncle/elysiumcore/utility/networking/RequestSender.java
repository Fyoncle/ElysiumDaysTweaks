package net.fyoncle.elysiumcore.utility.networking;

import net.fyoncle.elysiumcore.ElysiumCore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
    public String sendRequestTo(String urlString) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) return "request_failed";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String result = reader.readLine();
                return result != null ? result : "invalid_result";
            }
        } catch (IOException e) {
            ElysiumCore.LOGGER.error("Request to {} failed: {}", urlString, e.getMessage());
            return "request_failed";
        }
    }
}