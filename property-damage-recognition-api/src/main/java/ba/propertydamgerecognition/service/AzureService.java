package ba.propertydamgerecognition.service;


import ba.propertydamgerecognition.DTO.PhotoDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class AzureService {
  private static final String AZURE_PHOTO_RECOGNITION_URL = "https://propertydamagerecognition20240425135222.azurewebsites.net/analyse";
  private static final String AUTHORIZATION = "39faa2d7ee7b4fe8a586ae18a7d5e6d4";

  private final RestTemplate restTemplate;

  public AzureService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String postPhotoToAzureCloud(PhotoDTO photoDTO) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Authorization", AUTHORIZATION);

    ResponseEntity<String> responseEntity = restTemplate.exchange(
        AZURE_PHOTO_RECOGNITION_URL,
        HttpMethod.POST,
        new HttpEntity<>(photoDTO, headers),
        String.class);

    return responseEntity.getBody();
  }

}
