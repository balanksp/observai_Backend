package com.zaga.entity.oteltrace.resource.attributes;

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
