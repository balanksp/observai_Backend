package com.zaga.entity.kepler.scopeMetric.gauge;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaugeDataPoint {
    private List<GaugeDataPointAttribute> attributes;
    private String startTimeUnixNano;
    private String timeUnixNano;
    private String asInt;
    private String asDouble;



    /**
     * @return List<GaugeDataPointAttribute> return the attributes
     */
    public List<GaugeDataPointAttribute> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(List<GaugeDataPointAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return String return the startTimeUnixNano
     */
    public String getStartTimeUnixNano() {
        return startTimeUnixNano;
    }

    /**
     * @param startTimeUnixNano the startTimeUnixNano to set
     */
    public void setStartTimeUnixNano(String startTimeUnixNano) {
        this.startTimeUnixNano = startTimeUnixNano;
    }

    /**
     * @return String return the timeUnixNano
     */
    public String getTimeUnixNano() {
        return timeUnixNano;
    }

    /**
     * @param timeUnixNano the timeUnixNano to set
     */
    public void setTimeUnixNano(String timeUnixNano) {
        this.timeUnixNano = timeUnixNano;
    }

    /**
     * @return String return the asInt
     */
    public String getAsInt() {
        return asInt;
    }

    /**
     * @param asInt the asInt to set
     */
    public void setAsInt(String asInt) {
        this.asInt = asInt;
    }

    /**
     * @return String return the asDouble
     */
    public String getAsDouble() {
        return asDouble;
    }

    /**
     * @param asDouble the asDouble to set
     */
    public void setAsDouble(String asDouble) {
        this.asDouble = asDouble;
    }

    @Override
    public String toString() {
        return "GaugeDataPoint [attributes=" + attributes + ", startTimeUnixNano=" + startTimeUnixNano
                + ", timeUnixNano=" + timeUnixNano + ", asInt=" + asInt + ", asDouble=" + asDouble + "]";
    }

}
