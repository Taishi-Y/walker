
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Phrase {

    private String phrase;
    private Sample sample;
    private Integer count;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The phrase
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * 
     * @param phrase
     *     The phrase
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * 
     * @return
     *     The sample
     */
    public Sample getSample() {
        return sample;
    }

    /**
     * 
     * @param sample
     *     The sample
     */
    public void setSample(Sample sample) {
        this.sample = sample;
    }

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
