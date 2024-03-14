package com.zaga.entity.kepler;

import java.util.List;

import com.zaga.entity.kepler.resource.Attribute;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeplerResource {
    private List<Attribute> attributes; 
}
