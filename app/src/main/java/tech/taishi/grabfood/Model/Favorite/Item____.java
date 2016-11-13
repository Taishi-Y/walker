
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item____ {

    private String id;
    private String name;
    private String description;
    private String type;
    private User__ user;
    private Boolean editable;
    private Boolean _public;
    private Boolean collaborative;
    private String url;
    private String canonicalUrl;
    private Integer createdAt;
    private Integer updatedAt;
    private Photo____ photo;
    private Followers followers;
    private ListItems listItems;
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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User__ getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User__ user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The editable
     */
    public Boolean getEditable() {
        return editable;
    }

    /**
     * 
     * @param editable
     *     The editable
     */
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    /**
     * 
     * @return
     *     The _public
     */
    public Boolean getPublic() {
        return _public;
    }

    /**
     * 
     * @param _public
     *     The public
     */
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    /**
     * 
     * @return
     *     The collaborative
     */
    public Boolean getCollaborative() {
        return collaborative;
    }

    /**
     * 
     * @param collaborative
     *     The collaborative
     */
    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * 
     * @param canonicalUrl
     *     The canonicalUrl
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The createdAt
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The updatedAt
     */
    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The photo
     */
    public Photo____ getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo
     *     The photo
     */
    public void setPhoto(Photo____ photo) {
        this.photo = photo;
    }

    /**
     * 
     * @return
     *     The followers
     */
    public Followers getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    /**
     * 
     * @return
     *     The listItems
     */
    public ListItems getListItems() {
        return listItems;
    }

    /**
     * 
     * @param listItems
     *     The listItems
     */
    public void setListItems(ListItems listItems) {
        this.listItems = listItems;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
