
package tech.taishi.grabfood.Model.Favorite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Timeframe {

    private String days;
    private Boolean includesToday;
    private List<Open> open = new ArrayList<Open>();
    private List<Object> segments = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The days
     */
    public String getDays() {
        return days;
    }

    /**
     * 
     * @param days
     *     The days
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * 
     * @return
     *     The includesToday
     */
    public Boolean getIncludesToday() {
        return includesToday;
    }

    /**
     * 
     * @param includesToday
     *     The includesToday
     */
    public void setIncludesToday(Boolean includesToday) {
        this.includesToday = includesToday;
    }

    /**
     * 
     * @return
     *     The open
     */
    public List<Open> getOpen() {
        return open;
    }

    /**
     * 
     * @param open
     *     The open
     */
    public void setOpen(List<Open> open) {
        this.open = open;
    }

    /**
     * 
     * @return
     *     The segments
     */
    public List<Object> getSegments() {
        return segments;
    }

    /**
     * 
     * @param segments
     *     The segments
     */
    public void setSegments(List<Object> segments) {
        this.segments = segments;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
