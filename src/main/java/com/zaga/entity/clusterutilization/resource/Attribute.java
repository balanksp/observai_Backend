package com.zaga.entity.clusterutilization.resource;

import com.zaga.entity.clusterutilization.resource.attributes.Value;

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
