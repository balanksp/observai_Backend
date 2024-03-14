package com.zaga.entity.clusterutilization;

import java.util.List;

import com.zaga.entity.clusterutilization.resource.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
   private List<Attribute> attributes; 
}
