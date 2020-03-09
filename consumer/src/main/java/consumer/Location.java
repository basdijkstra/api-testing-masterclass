package consumer;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

    private String zipCode;
    private String country;
    private String countryAbbreviation;
    private List<Place> places;

}
