package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.Gouv.ApiGouvAdressDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.emse.spring.faircorp.Gouv.AdressSearchService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/adress")
@Transactional
public class AdressController {
    private final AdressSearchService adressSearchService;

    public AdressController(AdressSearchService adressSearchService) {
        this.adressSearchService = adressSearchService;
    }
    @GetMapping
    public List<ApiGouvAdressDto> getAdress(@RequestParam List<String> keys) {
        return  adressSearchService.findAdress(keys);


    }

}
