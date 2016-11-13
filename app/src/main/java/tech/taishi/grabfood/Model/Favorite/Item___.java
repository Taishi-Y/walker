
package tech.taishi.grabfood.Model.Favorite;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item___ {

    private String id;
    private Integer createdAt;
    private String text;
    private String type;
    private String canonicalUrl;
    private Photo_ photo;
    private String photourl;
    private Likes_ likes;
    private Boolean like;
    private Boolean logView;
    private Integer agreeCount;
    private Integer disagreeCount;
    private Todo todo;
    private User_ user;
    private String authorInteractionType;
    private String lang;
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
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
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
     *     The photo
     */
    public Photo_ getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo
     *     The photo
     */
    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    /**
     * 
     * @return
     *     The photourl
     */
    public String getPhotourl() {
        return photourl;
    }

    /**
     * 
     * @param photourl
     *     The photourl
     */
    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    /**
     * 
     * @return
     *     The likes
     */
    public Likes_ getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Likes_ likes) {
        this.likes = likes;
    }

    /**
     * 
     * @return
     *     The like
     */
    public Boolean getLike() {
        return like;
    }

    /**
     * 
     * @param like
     *     The like
     */
    public void setLike(Boolean like) {
        this.like = like;
    }

    /**
     * 
     * @return
     *     The logView
     */
    public Boolean getLogView() {
        return logView;
    }

    /**
     * 
     * @param logView
     *     The logView
     */
    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    /**
     * 
     * @return
     *     The agreeCount
     */
    public Integer getAgreeCount() {
        return agreeCount;
    }

    /**
     * 
     * @param agreeCount
     *     The agreeCount
     */
    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    /**
     * 
     * @return
     *     The disagreeCount
     */
    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    /**
     * 
     * @param disagreeCount
     *     The disagreeCount
     */
    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    /**
     * 
     * @return
     *     The todo
     */
    public Todo getTodo() {
        return todo;
    }

    /**
     * 
     * @param todo
     *     The todo
     */
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User_ getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User_ user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The authorInteractionType
     */
    public String getAuthorInteractionType() {
        return authorInteractionType;
    }

    /**
     * 
     * @param authorInteractionType
     *     The authorInteractionType
     */
    public void setAuthorInteractionType(String authorInteractionType) {
        this.authorInteractionType = authorInteractionType;
    }

    /**
     * 
     * @return
     *     The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * 
     * @param lang
     *     The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
