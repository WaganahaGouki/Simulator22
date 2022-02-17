import JSON.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

//"https://ltsdev.tracemytrack.com/lts/status/"

public class Simulator22 {
    public static void main(String[] args) throws IOException {
        JsonParser parser = new JsonParser();
        parser.parsing();

        URL status = new URL(parser.getLts() + "status/");

        HttpURLConnection connection = (HttpURLConnection)status.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        System.out.println("Code: " + code);

        URLConnection yc = status.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}