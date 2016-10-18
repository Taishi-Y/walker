package tech.taishi.grabfood.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

import com.wang.avi.AVLoadingIndicatorView;
import com.wenchao.cardstack.CardStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.taishi.grabfood.Adapter.ItemCardsDataAdapter;
import tech.taishi.grabfood.Animation.FloatingAnimationListener;
import tech.taishi.grabfood.Application.Common;
import tech.taishi.grabfood.AsyncTask.ExploreAndPhotoAsyncTask;
import tech.taishi.grabfood.Listener.SwipeCardListener;
import tech.taishi.grabfood.Model.Explore.Explore;
import tech.taishi.grabfood.Model.Explore.Group;
import tech.taishi.grabfood.Model.Explore.Item_;
import tech.taishi.grabfood.Model.Photo.Photos;
import tech.taishi.grabfood.R;
import tech.taishi.grabfood.Service.FourSquareService;

import static tech.taishi.grabfood.R.id.pulsator;

public class SwipeActivity extends AppCompatActivity implements CardStack.CardEventListener {
	Common common;

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



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		geoLocation = intent.getStringExtra("G");
		query = intent.getStringExtra("Q");

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			findViewById(android.R.id.content).setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
		}
		setContentView(R.layout.activity_swipe);
//		getActionBar().hide();

		likedItemList = new ArrayList<Item_>();

//		avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
		pulsator = (PulsatorLayout) findViewById(R.id.pulsator);
		pulsator.start();

		// グローバル変数を扱うクラスを取得する
		common = (Common) getApplicationContext();
		// グローバル変数を扱うクラスを初期化する
		common.init();


		mCardStack = (CardStack) findViewById(R.id.container);


		ivWalkBg = (ImageView) findViewById(R.id.iv_walk_icon_bg);
		animation1 = new TranslateAnimation(0,1500,0,-4000);
		animation1.setDuration(4000);
		animation1.setFillAfter(false);
		animation1.setAnimationListener(new FloatingAnimationListener(ivWalkBg));



//		ivWalkBg.startAnimation(animation1);
//		ivWalkBg.startAnimation(animation2);

		// AsyncTaskの実行
//		atClass.execute();

		mCardStack.setContentResource(R.layout.card_layout);
		mCardStack.setStackMargin(20);

		ExploreAndPhotoAsyncTask atClass = new ExploreAndPhotoAsyncTask();
		atClass.execute();
//		avi.show();
	}

	@Override
	public boolean swipeEnd(int direction, float distance) {
//		Toast.makeText(this, String.valueOf((direction == 1 || direction == 3)? true : false), Toast.LENGTH_SHORT).show();


		if(direction == 1 || direction ==3 && distance >300){
			ivWalkBg.startAnimation(animation1);
			likedItemList.add(itemList.get(swipeCount));
		} else {
//			ivWalkBg.startAnimation(animation1);
		}

//		return (direction == 1 || direction == 3)? true : false;
		swipeCount ++;
		return (distance>300)? true : false;
	}

	@Override
	public boolean swipeStart(int direction, float distance) {
		return true;
	}

	@Override
	public boolean swipeContinue(int direction, float distanceX, float distanceY) {
		return true;
	}

	@Override
	public void discarded(int id, int direction) {
	}

	@Override
	public void topCardTapped() {
	}


	/**
	 * Get venues by using explore api
	 * */
//	void sendRequest() {
//		common.init();
//		FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
//		final Call<Explore> call = fourSquareService.requestExplore(clientId, clientSecret, apiVersion, geoLocation, numberOfRequestVenue, query);
//
//		call.enqueue(new Callback<Explore>() {
//			@Override
//			public void onResponse(Call<Explore> call, Response<Explore> response) {
//				Explore explore = response.body();
//				common.totalResults = explore.getResponse().getTotalResults(); //total number of response
//				Log.v("totalResults1", String.valueOf(common.totalResults));
//				List<Group> groupList = explore.getResponse().getGroups();
//				common.itemList = groupList.get(0).getItems();
//				common.totalResults = (common.totalResults<10)? common.totalResults : 10;
//				Log.v("totalResults2", String.valueOf(common.totalResults));
//
//				for(int i = 0; i<common.totalResults; i++){
////					common.photoUrlList = null;
//					String placeId = null;
//					placeId = common.itemList.get(i).getVenue().getId();
//					Log.v("place id",placeId);
//
//					FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
//					final Call<Photos> callPhoto = fourSquareService.requestPhotos(placeId,clientId, clientSecret,apiVersion);
//					callPhoto.enqueue(new Callback<Photos>() {
//						@Override
//						public void onResponse(Call<Photos> call, Response<Photos> response) {
//							Photos responseBody = response.body();
//							int numberOfPhotos = responseBody.getResponse().getPhotos().getCount();
//
//							//getting 9 photos
//							ArrayList<String> photoUrlList = new ArrayList<String>();
//							numberOfPhotos = (numberOfPhotos<9)? numberOfPhotos: 9;
//							for(int j = 0; j<numberOfPhotos;j++){
//								String prefix = responseBody.getResponse().getPhotos().getItems().get(j).getPrefix();
//								String suffix = responseBody.getResponse().getPhotos().getItems().get(j).getSuffix();
//								imageThumbnailUrl = prefix + "150x150" + suffix;
//								common.photoUrlList.add(imageThumbnailUrl);
//							}
//
//							Log.v("itemCount", String.valueOf(common.i));
//							common.itemList.get(common.itemCount).setPhotoUrl(photoUrlList);
//							common.itemCount ++;
//							if(common.itemCount == 10){
//								Log.v("set for adapter","OK");
//								mItemCardsDataAdapter = new ItemCardsDataAdapter(getApplicationContext(), R.layout.card_layout, common.itemList);
//								mCardStack.setAdapter(mItemCardsDataAdapter);
//								mCardStack.setListener(new SwipeCardListener());
////								avi.hide();
//							}
//						}
//						@Override
//						public void onFailure(Call<Photos> call, Throwable t) {
//							Log.v("response", String.valueOf(t));
//						}
//					});
//				}
//
//			}
//			@Override
//			public void onFailure(Call<Explore> call, Throwable t) {
//				Log.v("response", String.valueOf(t));
//			}
//		});
//	}
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
			mItemCardsDataAdapter = new ItemCardsDataAdapter(getApplicationContext(), R.layout.card_layout, itemList);
			mCardStack.setAdapter(mItemCardsDataAdapter);

			SwipeCardListener swipeCardListener = new SwipeCardListener();

			mCardStack.setListener(SwipeActivity.this);
//			avi.hide();
			pulsator.stop();
		}
	}
}
