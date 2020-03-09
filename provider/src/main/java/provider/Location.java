package provider;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class Location {

    private String zipCode;
    private String country;
    private String countryAbbreviation;
    @Singular
    private List<Place> places;
}
