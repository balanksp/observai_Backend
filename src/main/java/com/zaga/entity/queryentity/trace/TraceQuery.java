package com.zaga.entity.queryentity.trace;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraceQuery {
    private List<String> methodName;
    private List<String> serviceName;
    private List<StatusCodeRange> statusCode;
    private QueryDuration duration;
}
