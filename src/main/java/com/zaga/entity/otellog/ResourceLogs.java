package com.zaga.entity.otellog;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceLogs {
  private Resource resource;
  private List<ScopeLogs> scopeLogs;
  private String schemaUrl;  
}
 