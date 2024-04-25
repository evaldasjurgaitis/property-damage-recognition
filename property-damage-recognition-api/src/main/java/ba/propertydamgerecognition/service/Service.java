package ba.propertydamgerecognition.service;


import ba.propertydamgerecognition.DTO.PhotoDTO;
import com.nimbusds.jose.shaded.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@org.springframework.stereotype.Service
public class Service {

  public String postRequest(PhotoDTO photoDTO) throws IOException, ParseException {
    URL url = new URL("https://propertydamagerecognition20240425135222.azurewebsites.net/analyse");

    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy", 9090));
    HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

    connection.setRequestMethod("POST");

    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    connection.setRequestProperty("Authorization", "39faa2d7ee7b4fe8a586ae18a7d5e6d4");

    connection.setDoOutput(true);
    connection.setDoInput(true);

    Gson gson = new Gson();
    String jsonPayload = gson.toJson(photoDTO);

    try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
      wr.writeBytes(jsonPayload);
      wr.flush();
    }

    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
      StringBuilder response = new StringBuilder();
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      return response.toString();
    }
  }

}
