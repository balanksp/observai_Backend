package com.zaga.entity.otellog.resource.attributes;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrayValue {
    private List<Value> values;
}
