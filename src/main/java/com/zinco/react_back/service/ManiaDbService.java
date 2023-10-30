package com.zinco.react_back.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ManiaDbService {
    private final RestTemplate restTemplate;
    private final String apiKey = "YOUR_API_KEY";
    private final String apiUrl = "http://www.maniadb.com/api/";

    public ManiaDbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ManiaDbApiResponse getMusicInfo(String musicTitle) {
        String url = apiUrl + "search/{musicTitle}?apikey={apiKey}&display=1&v=1&sr=1"; // Update URL as per API
        Map<String, String> params = new HashMap<>();
        params.put("musicTitle", musicTitle);
        params.put("apiKey", apiKey);

        // Assuming API responds with an object that can be mapped to MusicDto
        return restTemplate.getForObject(url, ManiaDbApiResponse.class, params);
    }
}