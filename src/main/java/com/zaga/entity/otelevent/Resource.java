package com.zaga.entity.otelevent;

import java.util.List;

import com.zaga.entity.otelevent.resource.Attributes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private List<Attributes> attributes;
}
