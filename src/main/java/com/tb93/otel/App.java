package com.tb93.otel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggingEventBuilder;

public class App {
    public static final org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger("TEST");

    public void callApi()
    {
        slf4jLogger.info("hello world");
        
        try {
                // Creating a URL object
                URL url = new URL("https://api.apis.guru/v2/list.json");
                
                // Opening a connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                
                // Setting the request method to GET
                connection.setRequestMethod("GET");

                // Retrieving the response code
                int responseCode = connection.getResponseCode();

                // Processing the response
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // System.out.println("API Response: " + response.toString());
                } else {
                    System.out.println("API Call Failed. Response Code: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        
        App app = new App();

        while (true) {
            try {
                app.callApi();
                Thread.sleep(1000);
            }
            catch (Exception e) {

            }
        }
        
    }
}