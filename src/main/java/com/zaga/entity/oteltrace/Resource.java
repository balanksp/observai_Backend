package com.zaga.entity.oteltrace;

import java.util.List;

import com.zaga.entity.oteltrace.resource.Attribute;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private List<Attribute> attributes;
}
