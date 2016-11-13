
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Open {

    private String renderedTime;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The renderedTime
     */
    public String getRenderedTime() {
        return renderedTime;
    }

    /**
     * 
     * @param renderedTime
     *     The renderedTime
     */
    public void setRenderedTime(String renderedTime) {
        this.renderedTime = renderedTime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
