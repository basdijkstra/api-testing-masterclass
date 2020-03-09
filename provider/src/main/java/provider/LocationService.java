package provider;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

    public Location findLocation(String countryCode, String zipCode) {
        return Location.builder()
            .zipCode(zipCode)
            .country("United States")
            .countryAbbreviation(countryCode)
            .place(Place.builder()
                .placeName("Beverly Hills")
                .state("California")
                .stateAbbreviation("CA")
                .build())
            .build();
    }
}
