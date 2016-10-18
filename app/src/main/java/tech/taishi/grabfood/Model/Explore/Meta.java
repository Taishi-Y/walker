
package tech.taishi.grabfood.Model.Explore;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Meta {

    private Integer code;
    private String requestId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 
     * @param requestId
     *     The requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
