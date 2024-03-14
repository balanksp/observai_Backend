package com.zaga.entity.pod.resource;



import com.zaga.entity.pod.resource.attributes.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
     private String key;
    private Value value;
    
}
