
package tech.taishi.grabfood.Model.Favorite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Popular {

    private Boolean isOpen;
    private Boolean isLocalHoliday;
    private List<Timeframe> timeframes = new ArrayList<Timeframe>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The isOpen
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     * 
     * @param isOpen
     *     The isOpen
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 
     * @return
     *     The isLocalHoliday
     */
    public Boolean getIsLocalHoliday() {
        return isLocalHoliday;
    }

    /**
     * 
     * @param isLocalHoliday
     *     The isLocalHoliday
     */
    public void setIsLocalHoliday(Boolean isLocalHoliday) {
        this.isLocalHoliday = isLocalHoliday;
    }

    /**
     * 
     * @return
     *     The timeframes
     */
    public List<Timeframe> getTimeframes() {
        return timeframes;
    }

    /**
     * 
     * @param timeframes
     *     The timeframes
     */
    public void setTimeframes(List<Timeframe> timeframes) {
        this.timeframes = timeframes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
