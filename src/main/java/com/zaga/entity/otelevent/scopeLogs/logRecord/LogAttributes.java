package com.zaga.entity.otelevent.scopeLogs.logRecord;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogAttributes {


    private String key;
    private LogValue value;
    
}
