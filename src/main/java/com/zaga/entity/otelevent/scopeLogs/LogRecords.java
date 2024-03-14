package com.zaga.entity.otelevent.scopeLogs;

import java.util.List;

import com.zaga.entity.otelevent.scopeLogs.logRecord.Body;
import com.zaga.entity.otelevent.scopeLogs.logRecord.LogAttributes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRecords {

  private String timeUnixNano;
  private int severityNumber;
  private String severityText;
  private String spanId;
  private String traceId;
  private Body body;  
  private List<LogAttributes> attributes;
}
