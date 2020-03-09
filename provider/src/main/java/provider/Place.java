package provider;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {

    private String placeName;
    private String state;
    private String stateAbbreviation;
}
