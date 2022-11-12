package com.emse.spring.faircorp.Gouv;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class AdressSearchService {

        private final RestTemplate restTemplate;

    public AdressSearchService(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.rootUri("https://api-adresse.data.gouv.fr").build();
        }

   // add a method to return the List<ApiGouvAdressDto>
    public List<ApiGouvAdressDto> findAdress(List<String> keys){


        String params = String.join("+", keys);
        String Uri =UriComponentsBuilder.fromUriString("/search").queryParam("q", params).queryParam("limit", 15).build().toUriString();
        return restTemplate.getForObject(Uri, ApiGouvResponseDto.class).getFeatures().stream().map(ApiGouvFeatureDto::getProperties).toList();
    }

}
