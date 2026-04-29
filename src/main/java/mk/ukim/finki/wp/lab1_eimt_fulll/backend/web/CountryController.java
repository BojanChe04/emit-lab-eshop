package mk.ukim.finki.wp.lab1_eimt_fulll.backend.web;



import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayCountryDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return countryService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}