package com.zaga.entity.kepler.scopeMetric.sum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SumDataPoint {
   
    @JsonProperty("attributes")
    private List<SumDataPointAttribute> attributes;

    @JsonProperty("startTimeUnixNano")
    private String startTimeUnixNano;

    @JsonProperty("timeUnixNano")
    private String timeUnixNano;

    @JsonProperty("asInt")
    private String asInt;

    @JsonProperty("asDouble")
    private String asDouble;

    @JsonProperty("exemplars")
    private List<Exemplar> exemplars;
}
