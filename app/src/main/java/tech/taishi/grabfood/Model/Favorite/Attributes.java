
package tech.taishi.grabfood.Model.Favorite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Attributes {

    private List<Group____> groups = new ArrayList<Group____>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The groups
     */
    public List<Group____> getGroups() {
        return groups;
    }

    /**
     * 
     * @param groups
     *     The groups
     */
    public void setGroups(List<Group____> groups) {
        this.groups = groups;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
