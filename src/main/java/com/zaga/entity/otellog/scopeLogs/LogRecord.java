package com.zaga.entity.otellog.scopeLogs;

import java.util.List;

import com.zaga.entity.otellog.scopeLogs.logRecord.Body;
import com.zaga.entity.otellog.scopeLogs.logRecord.LogAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRecord {
    private String timeUnixNano;
    private String observedTimeUnixNano;
    private int severityNumber;
    private String severityText;
    private Body body;
    private List<LogAttribute> attributes;
    private int flags;
    private String traceId;
    private String spanId;
    
}
