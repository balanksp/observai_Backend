package com.zaga.entity.otelevent;

import java.util.List;
import java.util.Map;

import com.zaga.entity.otelevent.scopeLogs.LogRecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeLogs {
    private Map<String,Object> scope;
    private List<LogRecords> logRecords;
}
