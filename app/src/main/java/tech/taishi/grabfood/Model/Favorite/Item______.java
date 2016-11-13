
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item______ {

    private String displayName;
    private String displayValue;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The displayValue
     */
    public String getDisplayValue() {
        return displayValue;
    }

    /**
     * 
     * @param displayValue
     *     The displayValue
     */
    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
