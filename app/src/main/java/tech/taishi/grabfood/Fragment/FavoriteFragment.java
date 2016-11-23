package tech.taishi.grabfood.Fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.facebook.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wenchao.cardstack.CardStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import retrofit2.Call;
import retrofit2.Callback;
import tech.taishi.grabfood.Activity.WebViewActivity;
import tech.taishi.grabfood.Adapter.FavoriteListAdapter;
import tech.taishi.grabfood.Adapter.ItemCardsDataAdapter;
//import tech.taishi.grabfood.Database.FavoriteItem;
import tech.taishi.grabfood.FirebaseModel.FavoriteItem;
import tech.taishi.grabfood.Listener.SwipeCardListener;
import tech.taishi.grabfood.Model.Explore.Explore;
import tech.taishi.grabfood.Model.Explore.Group;
import tech.taishi.grabfood.Model.Explore.Item_;
import tech.taishi.grabfood.Model.Favorite.Favorite;
import tech.taishi.grabfood.Model.Favorite.Response;
import tech.taishi.grabfood.Model.Photo.Photos;
import tech.taishi.grabfood.R;
import tech.taishi.grabfood.Service.FourSquareService;

import static com.facebook.login.widget.ProfilePictureView.TAG;



/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {


	String clientId = "UHXRWJ5JG10S55CR3B5ABEWEBKOKEIEJZRAE1NUS4ZKMJKR4";
	String clientSecret = "NTOBJSYD20GQF5ISUMGB5S32RVWJ5ANQQSB3CTU2UJBJIH4J";
	String apiVersion = "20161010";

	List<Response> responseList = new ArrayList<Response>();

	ListView listView;

	private DatabaseReference mDatabase;

	public FavoriteFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_favorite, container, false);


//		List<FavoriteItem> favoriteItems = new Select().from(FavoriteItem.class).execute();
//		for(FavoriteItem record : favoriteItems){
////			Log.d("items.name", record.name);
//			Log.d("items.id", record.venueId);
//		}

		mDatabase = FirebaseDatabase.getInstance().getReference();

		// ListViewの読み込み
		listView = (ListView)v.findViewById(R.id.listView);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Object listItem = listView.getItemAtPosition(i);
				listItem.toString();
				Log.v("test",listItem.toString());


				String placeId = responseList.get(i).getVenue().getId();
				Intent intent = new Intent(getActivity(), WebViewActivity.class);
				intent.putExtra("PLACEID",placeId);
				startActivity(intent);
			}
		});

//		FavoriteAsyncTask atClass = new FavoriteAsyncTask();
//		atClass.execute();


		mDatabase.child("users_favorite_items/"+ Profile.getCurrentProfile().getId() +"/").addValueEventListener(postListener);
//		mDatabase.child("users_favorite_items/191791917944932/").addValueEventListener(postListener);

		return v;
	}



	ValueEventListener postListener = new ValueEventListener() {
		@Override
		public void onDataChange(DataSnapshot dataSnapshot) {
			// Get Post object and use the values to update the UI
			Log.v("woo", String.valueOf(dataSnapshot));
//			FavoriteItem favoriteItem = dataSnapshot.getValue(FavoriteItem.class);

			for (DataSnapshot favoriteSnapshot: dataSnapshot.getChildren()) {
				FavoriteItem favoriteItem = favoriteSnapshot.getValue(FavoriteItem.class);
//				<YourClass> post = postSnapshot.getValue(<YourClass>.class);
				Log.e("Get Data",favoriteItem.title);
				Log.e("Get Data",favoriteItem.placeId);

				FavoriteAsyncTask atClass = new FavoriteAsyncTask(favoriteItem.placeId);
				atClass.execute();
			}

		}

		@Override
		public void onCancelled(DatabaseError databaseError) {
			// Getting Post failed, log a message
			Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
			// ...
		}
	};

//	mDatabase.addValueEventListener(postListener);

	public class FavoriteAsyncTask extends AsyncTask<Void,Void,List<Favorite>> {


		String placeId;
		public FavoriteAsyncTask() {
			super();
		}

		public FavoriteAsyncTask(String placeId) {
			super();
			this.placeId = placeId;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected List<Favorite> doInBackground(Void... voids) {
			FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
			final Call<Favorite> call = fourSquareService.requestFavorite(placeId,clientId, clientSecret,apiVersion);

			try {
				Favorite favorite =  call.execute().body();
				Response response = favorite.getResponse();

				responseList.add(response);

				Log.v("response", String.valueOf(response));


			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<Favorite> favorites) {
			super.onPostExecute(favorites);
			FavoriteListAdapter favoriteListAdapter = new FavoriteListAdapter(getActivity(), R.layout.favorite_list, responseList);
			listView.setAdapter(favoriteListAdapter);

		}
	}
}