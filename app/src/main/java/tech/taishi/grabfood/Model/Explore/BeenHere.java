
package tech.taishi.grabfood.Model.Explore;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class BeenHere {

    private Integer count;
    private Integer unconfirmedCount;
    private Boolean marked;
    private Integer lastCheckinExpiredAt;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The unconfirmedCount
     */
    public Integer getUnconfirmedCount() {
        return unconfirmedCount;
    }

    /**
     * 
     * @param unconfirmedCount
     *     The unconfirmedCount
     */
    public void setUnconfirmedCount(Integer unconfirmedCount) {
        this.unconfirmedCount = unconfirmedCount;
    }

    /**
     * 
     * @return
     *     The marked
     */
    public Boolean getMarked() {
        return marked;
    }

    /**
     * 
     * @param marked
     *     The marked
     */
    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    /**
     * 
     * @return
     *     The lastCheckinExpiredAt
     */
    public Integer getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    /**
     * 
     * @param lastCheckinExpiredAt
     *     The lastCheckinExpiredAt
     */
    public void setLastCheckinExpiredAt(Integer lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
