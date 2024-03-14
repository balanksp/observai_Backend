package com.zaga.entity.oteltrace.scopeSpans.spans;


import com.zaga.entity.oteltrace.scopeSpans.spans.attributes.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attributes {
    private String key;
    private Value value;
   
}
