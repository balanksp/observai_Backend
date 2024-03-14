package com.zaga.entity.otelmetric.scopeMetric.gauge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaugeDataPointAttribute {
    private String key;
    private GaugeDataPointAttributeValue value;

    


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
     * @return GaugeDataPointAttributeValue return the value
     */
    public GaugeDataPointAttributeValue getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(GaugeDataPointAttributeValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GaugeDataPointAttribute [key=" + key + ", value=" + value + "]";
    }

}
