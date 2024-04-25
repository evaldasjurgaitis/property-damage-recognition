package ba.propertydamgerecognition.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleInfo {
    private Long id;
    private String model;
    private String vin;
    private String licencePlate;
    private FrontDamage frontDamages;
    private String base64Output;
}
