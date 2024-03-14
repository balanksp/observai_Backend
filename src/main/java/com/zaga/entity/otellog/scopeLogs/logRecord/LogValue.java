package com.zaga.entity.otellog.scopeLogs.logRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogValue {
    private String stringValue;
    private Integer intValue;
}
