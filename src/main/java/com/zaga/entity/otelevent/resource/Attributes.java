package com.zaga.entity.otelevent.resource;

import com.zaga.entity.otelevent.resource.attributes.Value;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attributes {

private String key;
private Value value;

}
