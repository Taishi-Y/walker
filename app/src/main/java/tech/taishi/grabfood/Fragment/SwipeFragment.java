package tech.taishi.grabfood.Fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.facebook.Profile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wenchao.cardstack.CardStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import retrofit2.Call;
import tech.taishi.grabfood.Adapter.ItemCardsDataAdapter;
import tech.taishi.grabfood.Animation.FloatingAnimationListener;

import tech.taishi.grabfood.FirebaseModel.FavoriteItem;
import tech.taishi.grabfood.Listener.SwipeCardListener;
import tech.taishi.grabfood.Model.Explore.Explore;
import tech.taishi.grabfood.Model.Explore.Group;
import tech.taishi.grabfood.Model.Explore.Item_;
import tech.taishi.grabfood.Model.Photo.Photos;
import tech.taishi.grabfood.R;

import tech.taishi.grabfood.Service.FourSquareService;


/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeFragment extends Fragment implements CardStack.CardEventListener {

	CardStack mCardStack;
	ItemCardsDataAdapter mItemCardsDataAdapter;

	String clientId = "UHXRWJ5JG10S55CR3B5ABEWEBKOKEIEJZRAE1NUS4ZKMJKR4";
	String clientSecret = "NTOBJSYD20GQF5ISUMGB5S32RVWJ5ANQQSB3CTU2UJBJIH4J";
	String apiVersion = "20161010";
	int numberOfRequestVenue = 10;

	String geoLocation,query;

	PulsatorLayout pulsator;

	ImageView ivWalkBg;
	TranslateAnimation animation1;
	int swipeCount;
	List<Item_> itemList;
	List<Item_> likedItemList;
	int totalResults;

	FavoriteItem favoriteItem;

	String facebookUserId;


	private DatabaseReference mDatabase;

	public SwipeFragment() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getArguments();

		geoLocation = bundle.getString("G");
		query = bundle.getString("Q");

		facebookUserId = Profile.getCurrentProfile().getId();

		if(!(geoLocation.isEmpty()) && !(query.isEmpty())){
			geoLocation = bundle.getString("G");
			query = bundle.getString("Q");

			Log.v("geoLocation",geoLocation);
			Log.v("query",query);
		}

		mDatabase = FirebaseDatabase.getInstance().getReference();



	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_swipe, container, false);
		likedItemList = new ArrayList<Item_>();

//		avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
		pulsator = (PulsatorLayout) v.findViewById(R.id.pulsator);
		pulsator.start();

		mCardStack = (CardStack) v.findViewById(R.id.container);


		ivWalkBg = (ImageView) v.findViewById(R.id.iv_walk_icon_bg);
		animation1 = new TranslateAnimation(0,1500,0,-4000);
		animation1.setDuration(4000);
		animation1.setFillAfter(false);
		animation1.setAnimationListener(new FloatingAnimationListener(ivWalkBg));
		mCardStack.setContentResource(R.layout.card_layout);
		mCardStack.setStackMargin(20);

		ExploreAndPhotoAsyncTask atClass = new ExploreAndPhotoAsyncTask();
		atClass.execute();

		return v;
	}

	@Override
	public boolean swipeEnd(int direction, float distance) {
//		if(direction == 1 || direction ==3 && distance >300){
//			ivWalkBg.startAnimation(animation1);
//			likedItemList.add(itemList.get(swipeCount));
//		} else {
//		}

		Log.v("totalResults", String.valueOf(totalResults));
		return (distance>600)? true : false;
	}

	@Override
	public boolean swipeStart(int direction, float distance) {

		return false;
	}

	@Override
	public boolean swipeContinue(int direction, float distanceX, float distanceY) {

		return false;
	}

	@Override
	public void discarded(int id, int direction) {

		if(direction == 1 || direction ==3){
			ivWalkBg.startAnimation(animation1);
			likedItemList.add(itemList.get(swipeCount));

			String venueId = itemList.get(swipeCount).getVenue().getId();
			String venueName = itemList.get(swipeCount).getVenue().getName();
			String venueLocation = itemList.get(swipeCount).getVenue().getLocation().getLat() + "," + itemList.get(swipeCount).getVenue().getLocation().getLng();
			writeNewPost(facebookUserId,venueId,venueName, venueLocation);

		} else {
		}

		if(swipeCount >= totalResults-1){

			Bundle bundle = new Bundle();
			FavoriteFragment fragment = new FavoriteFragment();
			fragment.setArguments(bundle);
			// FragmentをFragmentManagerにセットする
			getFragmentManager().beginTransaction()
					.replace(R.id.container, fragment)
					.commit();


		}
		swipeCount ++;
		Log.v("swipeCount", String.valueOf(swipeCount));
	}

	@Override
	public void topCardTapped() {

	}

	private void writeNewPost(String userId, String placeId, String title, String geoLocation) {
		// Create new post at /user-posts/$userid/$postid and at
		// /posts/$postid simultaneously
		String users_favorite_items_key = mDatabase.child("users_favorite_items").push().getKey();
		String user_favorite_item_key = mDatabase.child(facebookUserId).push().getKey();
		FavoriteItem favoriteItem = new FavoriteItem(userId, placeId, title, geoLocation);
		Map<String, Object> favoriteItemValues = favoriteItem.toMap();

		Map<String, Object> childUpdates = new HashMap<>();
		childUpdates.put("/users_favorite_items/" + facebookUserId + "/" + user_favorite_item_key, favoriteItemValues);
//		childUpdates.put("/user-posts/" + userId + "/" + key, favoriteItemValues);

		mDatabase.updateChildren(childUpdates);
	}

//	void favoriteSwipte(){
//		String venueId = itemList.get(swipeCount).getVenue().getId();
//		String venueName = itemList.get(swipeCount).getVenue().getName();
//		String venueLocation = itemList.get(swipeCount).getVenue().getLocation().getLat() + "," + itemList.get(swipeCount).getVenue().getLocation().getLng();
//		String venueCategory = itemList.get(swipeCount).getVenue().getCategories().
//
//		writeNewPost(facebookUserId,venueId,venueName, venueLocation);
//	}

/*	Hello! My name is */

	public class ExploreAndPhotoAsyncTask extends AsyncTask<Void,Void,List<Item_>> {

		public ExploreAndPhotoAsyncTask() {
			super();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			itemList = null;
			mItemCardsDataAdapter = null;
		}

		@Override
		protected List<Item_> doInBackground(Void... voids) {
			FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
			final Call<Explore> call = fourSquareService.requestExplore(clientId, clientSecret, apiVersion, geoLocation, numberOfRequestVenue, query,1);

			try {
				Explore explore =  call.execute().body();

				Log.v("explore", String.valueOf(explore));
				totalResults = explore.getResponse().getTotalResults();

				List<Group> groupList = explore.getResponse().getGroups();
				itemList = groupList.get(0).getItems();
				totalResults = (totalResults<numberOfRequestVenue)? totalResults : numberOfRequestVenue;

				for(int i = 0; i<totalResults; i++) {
					String placeId = itemList.get(i).getVenue().getId();
					final Call<Photos> callPhoto = fourSquareService.requestPhotos(placeId,clientId, clientSecret,apiVersion);

					try{
						Photos photos = callPhoto.execute().body();
						int numberOfPhotos = photos.getResponse().getPhotos().getCount();
						ArrayList<String> photoUrlList = new ArrayList<String>();

						numberOfPhotos = (numberOfPhotos<9)? numberOfPhotos: 9;
						for(int j = 0; j<numberOfPhotos;j++){
							String prefix = photos.getResponse().getPhotos().getItems().get(j).getPrefix();
							String suffix = photos.getResponse().getPhotos().getItems().get(j).getSuffix();
							String imageThumbnailUrl = prefix + "150x150" + suffix;
							Log.v("imageThumbnailUrl",imageThumbnailUrl);
							photoUrlList.add(imageThumbnailUrl);
							itemList.get(i).setPhotoUrl(photoUrlList);
						}
					}catch (IOException e){
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<Item_> item_s) {
			super.onPostExecute(item_s);
			mItemCardsDataAdapter = new ItemCardsDataAdapter(getActivity(), R.layout.card_layout, itemList);
			mCardStack.setAdapter(mItemCardsDataAdapter);

			SwipeCardListener swipeCardListener = new SwipeCardListener();

			mCardStack.setListener(SwipeFragment.this);
//			avi.hide();
			pulsator.stop();
		}
	}
}
