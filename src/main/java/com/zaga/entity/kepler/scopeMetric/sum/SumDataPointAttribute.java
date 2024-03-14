package com.zaga.entity.kepler.scopeMetric.sum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumDataPointAttribute {
    private String key;
    private SumDataPointAttributeValue value;

    


    /**
     * @return String return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return SumDataPointAttributeValue return the value
     */
    public SumDataPointAttributeValue getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(SumDataPointAttributeValue value) {
        this.value = value;
    }

}
