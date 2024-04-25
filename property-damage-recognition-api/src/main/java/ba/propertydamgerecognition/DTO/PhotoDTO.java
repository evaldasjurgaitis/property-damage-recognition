package ba.propertydamgerecognition.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDTO {
  private List<DocumentDTO> documents;
}
