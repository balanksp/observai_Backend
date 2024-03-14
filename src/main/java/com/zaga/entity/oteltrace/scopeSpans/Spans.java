package com.zaga.entity.oteltrace.scopeSpans;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zaga.entity.oteltrace.scopeSpans.spans.Attributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spans {
    private String traceId;
    private String spanId;
    private String parentSpanId;
    private String name;
    private int kind;
    private String startTimeUnixNano;
    private String endTimeUnixNano;
    private List<Attributes> attributes;
    private Map<String, Object> status;
    @JsonIgnore
    private List<Event> events;
}
