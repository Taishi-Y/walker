
package tech.taishi.grabfood.Model.Favorite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Venue {

    private String id;
    private String name;
    private Contact contact;
    private Location location;
    private String canonicalUrl;
    private List<Category> categories = new ArrayList<Category>();
    private Boolean verified;
    private Stats stats;
    private String url;
    private Likes likes;
    private Boolean like;
    private Boolean dislike;
    private Boolean ok;
    private Double rating;
    private String ratingColor;
    private Integer ratingSignals;
    private Boolean allowMenuUrlEdit;
    private BeenHere beenHere;
    private Specials specials;
    private Photos photos;
    private Reasons reasons;
    private HereNow hereNow;
    private Integer createdAt;
    private Tips tips;
    private List<Object> tags = new ArrayList<Object>();
    private String shortUrl;
    private String timeZone;
    private Listed listed;
    private List<Phrase> phrases = new ArrayList<Phrase>();
    private Popular popular;
    private PageUpdates pageUpdates;
    private Inbox inbox;
    private List<Object> venueChains = new ArrayList<Object>();
    private Attributes attributes;
    private BestPhoto bestPhoto;
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
     *     The contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * 
     * @param contact
     *     The contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
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
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * 
     * @return
     *     The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
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
     *     The likes
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Likes likes) {
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
     *     The dislike
     */
    public Boolean getDislike() {
        return dislike;
    }

    /**
     * 
     * @param dislike
     *     The dislike
     */
    public void setDislike(Boolean dislike) {
        this.dislike = dislike;
    }

    /**
     * 
     * @return
     *     The ok
     */
    public Boolean getOk() {
        return ok;
    }

    /**
     * 
     * @param ok
     *     The ok
     */
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The ratingColor
     */
    public String getRatingColor() {
        return ratingColor;
    }

    /**
     * 
     * @param ratingColor
     *     The ratingColor
     */
    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    /**
     * 
     * @return
     *     The ratingSignals
     */
    public Integer getRatingSignals() {
        return ratingSignals;
    }

    /**
     * 
     * @param ratingSignals
     *     The ratingSignals
     */
    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    /**
     * 
     * @return
     *     The allowMenuUrlEdit
     */
    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    /**
     * 
     * @param allowMenuUrlEdit
     *     The allowMenuUrlEdit
     */
    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    /**
     * 
     * @return
     *     The beenHere
     */
    public BeenHere getBeenHere() {
        return beenHere;
    }

    /**
     * 
     * @param beenHere
     *     The beenHere
     */
    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    /**
     * 
     * @return
     *     The specials
     */
    public Specials getSpecials() {
        return specials;
    }

    /**
     * 
     * @param specials
     *     The specials
     */
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    /**
     * 
     * @return
     *     The photos
     */
    public Photos getPhotos() {
        return photos;
    }

    /**
     * 
     * @param photos
     *     The photos
     */
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    /**
     * 
     * @return
     *     The reasons
     */
    public Reasons getReasons() {
        return reasons;
    }

    /**
     * 
     * @param reasons
     *     The reasons
     */
    public void setReasons(Reasons reasons) {
        this.reasons = reasons;
    }

    /**
     * 
     * @return
     *     The hereNow
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     * 
     * @param hereNow
     *     The hereNow
     */
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
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
     *     The tips
     */
    public Tips getTips() {
        return tips;
    }

    /**
     * 
     * @param tips
     *     The tips
     */
    public void setTips(Tips tips) {
        this.tips = tips;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The shortUrl
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * 
     * @param shortUrl
     *     The shortUrl
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The timeZone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * 
     * @return
     *     The listed
     */
    public Listed getListed() {
        return listed;
    }

    /**
     * 
     * @param listed
     *     The listed
     */
    public void setListed(Listed listed) {
        this.listed = listed;
    }

    /**
     * 
     * @return
     *     The phrases
     */
    public List<Phrase> getPhrases() {
        return phrases;
    }

    /**
     * 
     * @param phrases
     *     The phrases
     */
    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    /**
     * 
     * @return
     *     The popular
     */
    public Popular getPopular() {
        return popular;
    }

    /**
     * 
     * @param popular
     *     The popular
     */
    public void setPopular(Popular popular) {
        this.popular = popular;
    }

    /**
     * 
     * @return
     *     The pageUpdates
     */
    public PageUpdates getPageUpdates() {
        return pageUpdates;
    }

    /**
     * 
     * @param pageUpdates
     *     The pageUpdates
     */
    public void setPageUpdates(PageUpdates pageUpdates) {
        this.pageUpdates = pageUpdates;
    }

    /**
     * 
     * @return
     *     The inbox
     */
    public Inbox getInbox() {
        return inbox;
    }

    /**
     * 
     * @param inbox
     *     The inbox
     */
    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }

    /**
     * 
     * @return
     *     The venueChains
     */
    public List<Object> getVenueChains() {
        return venueChains;
    }

    /**
     * 
     * @param venueChains
     *     The venueChains
     */
    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The bestPhoto
     */
    public BestPhoto getBestPhoto() {
        return bestPhoto;
    }

    /**
     * 
     * @param bestPhoto
     *     The bestPhoto
     */
    public void setBestPhoto(BestPhoto bestPhoto) {
        this.bestPhoto = bestPhoto;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
