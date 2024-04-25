package ba.propertydamgerecognition.controller;

import ba.propertydamgerecognition.DTO.PhotoDTO;
import ba.propertydamgerecognition.service.Service;
import java.io.IOException;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

  @Autowired
  private Service service;


  @PostMapping("/upload-image")
  public ResponseEntity<String> uploadImage(@RequestBody PhotoDTO photoDTO) {
      return ResponseEntity.status(HttpStatus.OK).body(service.postToAzureCloud(photoDTO));
    }

}
