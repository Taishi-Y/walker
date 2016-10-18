package tech.taishi.grabfood.Fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.wenchao.cardstack.CardStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import retrofit2.Call;
import tech.taishi.grabfood.Activity.SwipeActivity;
import tech.taishi.grabfood.Adapter.ItemCardsDataAdapter;
import tech.taishi.grabfood.Animation.FloatingAnimationListener;
import tech.taishi.grabfood.Application.Common;
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


	public SwipeFragment() {
		// Required empty public constructor
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getArguments();

		geoLocation = bundle.getString("G");
		query = bundle.getString("Q");


		if(!(geoLocation.isEmpty()) && !(query.isEmpty())){
			geoLocation = bundle.getString("G");
			query = bundle.getString("Q");

			Log.v("geoLocation",geoLocation);
			Log.v("query",query);
		}



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
		if(direction == 1 || direction ==3 && distance >300){
			ivWalkBg.startAnimation(animation1);
			likedItemList.add(itemList.get(swipeCount));
		} else {
		}
		swipeCount ++;

		if(swipeCount == 9){
			SearchFragment fragment = new SearchFragment();
//			fragment.setArguments(bundle);

// FragmentをFragmentManagerにセットする
			getFragmentManager().beginTransaction()
					.replace(R.id.container, fragment)
					.commit();
		}
		return (distance>300)? true : false;
	}

	@Override
	public boolean swipeStart(int i, float v) {
		return false;
	}

	@Override
	public boolean swipeContinue(int i, float v, float v1) {
		return false;
	}

	@Override
	public void discarded(int i, int i1) {

	}

	@Override
	public void topCardTapped() {

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
				int totalResults = explore.getResponse().getTotalResults();

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