package com.zinco.react_back.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManiaDbApiResponse {
    @JsonProperty("title")
    private String title;

    @JsonProperty("singer")
    private String singer;
}
