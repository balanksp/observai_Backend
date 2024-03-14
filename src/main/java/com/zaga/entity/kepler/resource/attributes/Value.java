package com.zaga.entity.kepler.resource.attributes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Value {
     private String stringValue;
    private int intValue;
    private ArrayValue arrayValue;
}
