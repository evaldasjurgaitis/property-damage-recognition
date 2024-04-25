package ba.propertydamgerecognition.DTO;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class DocumentDTO {
  private int id;
  private MultipartFile base64Bytes;
}
