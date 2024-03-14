package com.zaga.entity.otelmetric.scopeMetric.sum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumDataPointAttributeValue {
     private boolean boolValue;
     
    private String stringValue;

    

    /**
     * @return boolean return the boolValue
     */
    public boolean isBoolValue() {
        return boolValue;
    }

    /**
     * @param boolValue the boolValue to set
     */
    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    /**
     * @return String return the stringValue
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * @param stringValue the stringValue to set
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

}