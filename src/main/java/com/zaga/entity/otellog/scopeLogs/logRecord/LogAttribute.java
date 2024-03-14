package com.zaga.entity.otellog.scopeLogs.logRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogAttribute {
    private String key;
    private LogValue value;
}
