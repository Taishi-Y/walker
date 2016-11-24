# TinderSwipe card UI with Foursquare API for Android sample project

<a href="https://www.youtube.com/watch?v=1RBs7V72MF8&t=7s
" target="_blank"><img src="https://github.com/Taishi-Y/walker/blob/master/images/food.png?raw=true" 
alt="IMAGE ALT TEXT HERE" width="240" border="10" /></a>
<br>
<a href="https://www.youtube.com/watch?v=1RBs7V72MF8&t=7s">You can see the video of this project from here!</a>

## Overview
I like hanging out with my friends without any plan. When I get hungry I use yelp or foursquare before. But there is too much information and also I wanted to make my decision by how foods are good in the restaurant.(I'm looking for nice meal. Not restaurant.) More visual, intuitive, fast, easy...Tinder!!
This is my experiment that using Tinder UI for food. You can fall in love with food! :)


## Set up
This project is using [FourSqure api](https://ja.foursquare.com/developers/apps), [Facebook Login](https://developers.facebook.com/docs/facebook-login/android) and [Firebase](
https://firebase.google.com/) to save user's data.

## Card Swipe Fragment
```xml
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"

    android:paddingTop="20dp"

    >

    <pl.bclogic.pulsator4droid.library.PulsatorLayout
        android:id="@+id/pulsator"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:pulse_count="7"
        app:pulse_duration="1500"
        app:pulse_repeat="10"
        app:pulse_color="@color/yellow"
        app:pulse_startFromScratch="false"
        app:pulse_interpolator="Linear">
    </pl.bclogic.pulsator4droid.library.PulsatorLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
        <com.wenchao.cardstack.CardStack
            android:id="@+id/container"
            android:layout_width="match_parent"
            android:layout_height="630dp"
            android:minHeight="200dp"
            android:padding = "20dp"
            android:clipChildren="false"
            android:clipToPadding="false"
            >
        </com.wenchao.cardstack.CardStack>
    </LinearLayout>


    <!--<android.support.design.widget.FloatingActionButton-->
        <!--android:id="@+id/search"-->
        <!--android:layout_width="wrap_content"-->
        <!--android:layout_height="wrap_content"-->
        <!--android:layout_gravity="bottom|end"-->
        <!--android:layout_margin="@dimen/fab_margin"-->
        <!--app:srcCompat="@drawable/ic_search_white_24dp"/>-->

    <ImageView
        android:id="@+id/iv_walk_icon_bg"
        android:layout_width="24dp"
        android:layout_height="24dp"
        android:src="@drawable/icon_heart"
        android:layout_gravity="bottom"

        android:layout_alignParentRight="true"
        android:layout_margin="4dp"
        />

</FrameLayout>

```

ss
```java
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

		mDatabase.updateChildren(childUpdates);
	}
	

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
```
Adapter for cardview
```java
public class ItemCardsDataAdapter extends ArrayAdapter<Item_> {

	public ItemCardsDataAdapter(Context context,int layout , List<Item_> itemList) {
		super(context, layout, itemList);
	}

	ImageView ivFood,ivFood2,ivFood3,ivFood4,ivFood5,ivFood6,ivFood7,ivFood8,ivFood9,ivReviewedUser;
	Integer price = null;

	String tip,userPhotoUrl;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		tip = null;

		Item_ items = getItem(position);

		Venue venue = items.getVenue();

		String placeName = venue.getName();
		Double venueRating = venue.getRating();
		String category = venue.getCategories().get(0).getName();
		String ratingColor = venue.getRatingColor();
		if(venue.getPrice() != null){
			price = venue.getPrice().getTier();
		}
		Integer distance = venue.getLocation().getDistance();
		distance = distance/80;
//		String area = items.getVenue().getLocation().getCity();
		
		List<String> photoUrl = items.getPhotoUrl();
		
		if(items.getTips().size() != 0){
			tip = items.getTips().get(0).getText();
			userPhotoUrl = items.getTips().get(0).getUser().getPhoto().getPrefix() +"80x80" + items.getTips().get(0).getUser().getPhoto().getSuffix();
		}


		if (convertView == null) {
			//We must create a View:
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.card_layout, parent, false);
		}

		TextView tvPlaceName = (TextView) (convertView.findViewById(R.id.tv_place_name));
		TextView tvVenueRating = (TextView) (convertView.findViewById(R.id.tv_venue_rating));
		TextView tvCategory = (TextView) (convertView.findViewById(R.id.tv_category));
		ImageView ivCoinIcon = (ImageView) convertView.findViewById(R.id.iv_coin_icon);
		TextView tvDistance = (TextView) (convertView.findViewById(R.id.tv_distance));
		TextView tvTips = (TextView) convertView.findViewById(R.id.tv_tip);

		ivFood = (ImageView) convertView.findViewById(R.id.iv_food);
		ivFood2 = (ImageView) convertView.findViewById(R.id.iv_food2);
		ivFood3 = (ImageView) convertView.findViewById(R.id.iv_food3);
		ivFood4 = (ImageView) convertView.findViewById(R.id.iv_food4);
		ivFood5 = (ImageView) convertView.findViewById(R.id.iv_food5);
		ivFood6 = (ImageView) convertView.findViewById(R.id.iv_food6);
		ivFood7 = (ImageView) convertView.findViewById(R.id.iv_food7);
		ivFood8 = (ImageView) convertView.findViewById(R.id.iv_food8);
		ivFood9 = (ImageView) convertView.findViewById(R.id.iv_food9);
		ivReviewedUser = (ImageView) convertView.findViewById(R.id.iv_reviwed_user);
		
		ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
		imageViewArrayList.add(ivFood);
		imageViewArrayList.add(ivFood2);
		imageViewArrayList.add(ivFood3);
		imageViewArrayList.add(ivFood4);
		imageViewArrayList.add(ivFood5);
		imageViewArrayList.add(ivFood6);
		imageViewArrayList.add(ivFood7);
		imageViewArrayList.add(ivFood8);
		imageViewArrayList.add(ivFood9);

		tvPlaceName.setText(placeName);
		tvVenueRating.setText(String.valueOf(venueRating));
		if(ratingColor != null){
			tvVenueRating.setBackgroundColor(Color.parseColor("#"+ratingColor));
		}

		tvCategory.setText(category);

		if(price != null){
			if(price == 1){
//				ivCoinIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_coin_1));
				ivCoinIcon.setImageResource(R.drawable.coin_1);
			} else if(price == 2){
				ivCoinIcon.setImageResource(R.drawable.coin_2);
			} else if(price == 3){
				ivCoinIcon.setImageResource(R.drawable.coin_3);
			} else if(price == 4){
				ivCoinIcon.setImageResource(R.drawable.coin_4);
			}
//			ivCoinIcon
//			tvPrice.setText(String.valueOf(price));
		}

		tvDistance.setText(String.valueOf(distance)+" min");
//		tvArea.setText(area);

		if(!(photoUrl == null)){
			int numberOfPhotos = photoUrl.size();
			for(int i=0;i<numberOfPhotos;i++){
				Glide.with(getContext()).load(photoUrl.get(i)).into(imageViewArrayList.get(i));
			}
		}
		
		if(tip != null){
			tvTips.setText(tip);
			if(!(userPhotoUrl == null)){
				Glide.with(getContext()).load(userPhotoUrl).into(ivReviewedUser);
			}
		}
		
		return convertView;
	}
}
```
