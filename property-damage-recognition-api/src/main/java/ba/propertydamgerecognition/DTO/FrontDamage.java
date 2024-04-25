package ba.propertydamgerecognition.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontDamage {
    private Float bumper;
    private Float glass;
    private Float hood;
    private Float lampLeft;
    private Float lampRight;
    private Float grill;

}
