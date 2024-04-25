package ba.propertydamgerecognition.DTO;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class DocumentDTO {
  private int id;
  private String base64Bytes;
}
