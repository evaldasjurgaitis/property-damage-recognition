package ba.propertydamgerecognition.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DocumentDTO {
  private int id;
  private String base64Bytes;
}
