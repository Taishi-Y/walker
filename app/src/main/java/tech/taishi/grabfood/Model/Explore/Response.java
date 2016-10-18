
package tech.taishi.grabfood.Model.Explore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Response {

    private SuggestedFilters suggestedFilters;
    private Integer suggestedRadius;
    private String headerLocation;
    private String headerFullLocation;
    private String headerLocationGranularity;
    private String query;
    private Integer totalResults;
    private SuggestedBounds suggestedBounds;
    private List<Group> groups = new ArrayList<Group>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The suggestedFilters
     */
    public SuggestedFilters getSuggestedFilters() {
        return suggestedFilters;
    }

    /**
     * 
     * @param suggestedFilters
     *     The suggestedFilters
     */
    public void setSuggestedFilters(SuggestedFilters suggestedFilters) {
        this.suggestedFilters = suggestedFilters;
    }

    /**
     * 
     * @return
     *     The suggestedRadius
     */
    public Integer getSuggestedRadius() {
        return suggestedRadius;
    }

    /**
     * 
     * @param suggestedRadius
     *     The suggestedRadius
     */
    public void setSuggestedRadius(Integer suggestedRadius) {
        this.suggestedRadius = suggestedRadius;
    }

    /**
     * 
     * @return
     *     The headerLocation
     */
    public String getHeaderLocation() {
        return headerLocation;
    }

    /**
     * 
     * @param headerLocation
     *     The headerLocation
     */
    public void setHeaderLocation(String headerLocation) {
        this.headerLocation = headerLocation;
    }

    /**
     * 
     * @return
     *     The headerFullLocation
     */
    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    /**
     * 
     * @param headerFullLocation
     *     The headerFullLocation
     */
    public void setHeaderFullLocation(String headerFullLocation) {
        this.headerFullLocation = headerFullLocation;
    }

    /**
     * 
     * @return
     *     The headerLocationGranularity
     */
    public String getHeaderLocationGranularity() {
        return headerLocationGranularity;
    }

    /**
     * 
     * @param headerLocationGranularity
     *     The headerLocationGranularity
     */
    public void setHeaderLocationGranularity(String headerLocationGranularity) {
        this.headerLocationGranularity = headerLocationGranularity;
    }

    /**
     * 
     * @return
     *     The query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The totalResults
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The suggestedBounds
     */
    public SuggestedBounds getSuggestedBounds() {
        return suggestedBounds;
    }

    /**
     * 
     * @param suggestedBounds
     *     The suggestedBounds
     */
    public void setSuggestedBounds(SuggestedBounds suggestedBounds) {
        this.suggestedBounds = suggestedBounds;
    }

    /**
     * 
     * @return
     *     The groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * 
     * @param groups
     *     The groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
