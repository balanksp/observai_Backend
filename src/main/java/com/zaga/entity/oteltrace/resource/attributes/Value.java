package com.zaga.entity.oteltrace.resource.attributes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {
    private String stringValue;
    private Integer intValue;
    private ArrayValue arrayValue;
}
