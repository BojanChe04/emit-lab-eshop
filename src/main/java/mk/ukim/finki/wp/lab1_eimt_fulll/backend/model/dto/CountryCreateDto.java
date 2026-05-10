package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import jakarta.validation.constraints.NotNull;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Country;

public record CountryCreateDto (
        @NotNull
        String name,
        @NotNull
        String continent
){
    public Country toCountry() {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        return country;
    }
}
