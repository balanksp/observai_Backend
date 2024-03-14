package com.zaga.entity.oteltrace.scopeSpans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String timeUnixNano;
    private String name;
    
}
