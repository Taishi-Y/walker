package tech.taishi.grabfood.FirebaseModel;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yamasakitaishi on 2016/11/09.
 */

@IgnoreExtraProperties
public class FavoriteItem {

	public String uid;
	public String placeId;
	public String title;
	public String geoLocation;

//	public int starCount = 0;
//	public Map<String, Boolean> stars = new HashMap<>();

	public FavoriteItem() {
		// Default constructor required for calls to DataSnapshot.getValue(Post.class)
	}

	public FavoriteItem(String uid, String placeId, String title, String geoLocation) {
		this.uid = uid;
		this.placeId = placeId;
		this.title = title;
		this.geoLocation = geoLocation;
	}

	@Exclude
	public Map<String, Object> toMap() {
		HashMap<String, Object> result = new HashMap<>();
		result.put("uid", uid);
		result.put("placeId", placeId);
		result.put("title", title);
		result.put("geoLocation", geoLocation);
//		result.put("starCount", starCount);
//		result.put("stars", stars);

		return result;
	}

}
