
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stats {

    private Integer checkinsCount;
    private Integer usersCount;
    private Integer tipCount;
    private Integer visitsCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The checkinsCount
     */
    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    /**
     * 
     * @param checkinsCount
     *     The checkinsCount
     */
    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    /**
     * 
     * @return
     *     The usersCount
     */
    public Integer getUsersCount() {
        return usersCount;
    }

    /**
     * 
     * @param usersCount
     *     The usersCount
     */
    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    /**
     * 
     * @return
     *     The tipCount
     */
    public Integer getTipCount() {
        return tipCount;
    }

    /**
     * 
     * @param tipCount
     *     The tipCount
     */
    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

    /**
     * 
     * @return
     *     The visitsCount
     */
    public Integer getVisitsCount() {
        return visitsCount;
    }

    /**
     * 
     * @param visitsCount
     *     The visitsCount
     */
    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
