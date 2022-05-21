package kz.astrium.personalblog.handler.accountInformation;

import kz.astrium.personalblog.handler.abstracts.WebInfo;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class GitHubHandler extends WebInfo {
    private final static String WebName = "Github";
    private final static String URL = "https://api.github.com";

    public GitHubHandler() {
        super(WebName, URL, new ArrayList<String>());
    }

    public GitHubHandler(String webName, String main_url, List<?> seconds_url) {
        super(webName, main_url, seconds_url);
    }

    public String getAccountInfo(String username) {
        try {
            java.net.URL url = new URL(URL + "/users/" + username);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int connResponseCode = conn.getResponseCode();

            if (connResponseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + connResponseCode);
            } else {

                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parser = new JSONParser();

                JSONObject data_obj = (JSONObject) parser.parse(inline.toString());

                return data_obj.toString();
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
