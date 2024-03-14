package com.zaga.entity.oteltrace;

import java.util.List;

import com.zaga.entity.oteltrace.scopeSpans.Scope;
import com.zaga.entity.oteltrace.scopeSpans.Spans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeSpans {
    private Scope scope;
    private List<Spans> spans;
}
