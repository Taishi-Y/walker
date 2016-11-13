
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class User___ {

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private Photo_____ photo;
    private Boolean isAnonymous;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The photo
     */
    public Photo_____ getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo
     *     The photo
     */
    public void setPhoto(Photo_____ photo) {
        this.photo = photo;
    }

    /**
     * 
     * @return
     *     The isAnonymous
     */
    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 
     * @param isAnonymous
     *     The isAnonymous
     */
    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
