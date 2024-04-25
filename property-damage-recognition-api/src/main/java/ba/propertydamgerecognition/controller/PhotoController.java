package ba.propertydamgerecognition.controller;

import ba.propertydamgerecognition.DTO.DocumentDTO;
import ba.propertydamgerecognition.DTO.PhotoDTO;
import ba.propertydamgerecognition.DTO.VehicleInfo;
import ba.propertydamgerecognition.service.AzureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
@RequiredArgsConstructor
public class PhotoController {

    private final AzureService azureService;

    @PostMapping("/upload-image")
    public ResponseEntity<VehicleInfo> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        PhotoDTO photoDTO = new PhotoDTO();
        String encoded = Base64.encodeBase64String(file.getBytes());
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setBase64Bytes(encoded);
        photoDTO.setDocuments(List.of(documentDTO));
        VehicleInfo vehicleInfo = azureService.postPhotoToAzureCloud(photoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleInfo);
    }

}
