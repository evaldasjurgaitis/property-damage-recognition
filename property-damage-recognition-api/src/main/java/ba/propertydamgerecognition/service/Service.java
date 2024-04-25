package ba.propertydamgerecognition.service;


import ba.propertydamgerecognition.DTO.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

  private static final String AZURE_PHOTO_RECOGNOTION_URL = "https://propertydamagerecognition20240425135222.azurewebsites.net/analyse";
  private static final String AUTHORIZATION = "39faa2d7ee7b4fe8a586ae18a7d5e6d4";

  private final RestTemplate restTemplate;

  @Autowired
  public Service(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String postToAzureCloud(PhotoDTO photoDTO) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Authorization", AUTHORIZATION);

    HttpEntity<PhotoDTO> requestEntity = new HttpEntity<>(photoDTO, headers);

    ResponseEntity<String> responseEntity = restTemplate.exchange(
        AZURE_PHOTO_RECOGNOTION_URL,
        HttpMethod.POST,
        requestEntity,
        String.class);

    return responseEntity.getBody();
  }

}
