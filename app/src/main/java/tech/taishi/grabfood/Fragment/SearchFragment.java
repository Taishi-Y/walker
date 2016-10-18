package tech.taishi.grabfood.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import tech.taishi.grabfood.Activity.SearchActivity;
import tech.taishi.grabfood.Activity.SwipeActivity;
import tech.taishi.grabfood.R;

/**
 * Created by yamasakitaishi on 2016/10/18.
 */

public class SearchFragment extends Fragment
		implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,View.OnClickListener {

	GoogleApiClient mGoogleApiClient;
	String geoLocation;

	EditText etSearch;
	TextView tvTitle;

	Button btnBreakfast,btnLunch,btnDinner,btnCafe,btnSweet,btnFastfood;



	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_breakfast:
				etSearch.setText("breakfast");
				break;
			case R.id.btn_lunch:
				etSearch.setText("lunch");
				break;
			case R.id.btn_dinner:
				etSearch.setText("dinner");
				break;
			case R.id.btn_cafe:
				etSearch.setText("cafe");
				break;
			case R.id.btn_sweet:
				etSearch.setText("sweet");
				break;
			case R.id.btn_fastfood:
				etSearch.setText("fastfood");
				break;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_search, container, false);
		permissionCheck();
		createInstanceOfGoogleAPIClient();



		btnBreakfast = (Button) v.findViewById(R.id.btn_breakfast);
		btnLunch = (Button) v.findViewById(R.id.btn_lunch);
		btnDinner = (Button) v.findViewById(R.id.btn_dinner);
		btnCafe = (Button) v.findViewById(R.id.btn_cafe);
		btnSweet = (Button) v.findViewById(R.id.btn_sweet);
		btnFastfood = (Button) v.findViewById(R.id.btn_fastfood);

		btnBreakfast.setOnClickListener(this);
		btnLunch.setOnClickListener(this);
		btnDinner.setOnClickListener(this);
		btnCafe.setOnClickListener(this);
		btnSweet.setOnClickListener(this);
		btnFastfood.setOnClickListener(this);


		tvTitle = (TextView) v.findViewById(R.id.tv_title);
		etSearch = (EditText) v.findViewById(R.id.et_search);
		etSearch.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View view, int i, KeyEvent keyEvent) {
				Log.v("tttt","ddddd");
				//イベントを取得するタイミングには、ボタンが押されてなおかつエンターキーだったときを指定
				if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)){
//					//キーボードを閉じる

					String query = String.valueOf(etSearch.getText());

					// データを渡す為のBundleを生成し、渡すデータを内包させる
					Bundle bundle = new Bundle();
					bundle.putString("Q",query);
					bundle.putString("G",geoLocation);

					// Fragmentを生成し、setArgumentsで先ほどのbundleをセットする
					SwipeFragment fragment = new SwipeFragment();
					fragment.setArguments(bundle);

// FragmentをFragmentManagerにセットする
					getFragmentManager().beginTransaction()
							.replace(R.id.container, fragment)
							.commit();

					return true;
				}
				return false;
			}
		});
		return v;
	}

	@Override
	public void onConnected(@Nullable Bundle bundle) {
		if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
				mGoogleApiClient);
		if (mLastLocation != null) {

			geoLocation = mLastLocation.getLatitude() + "," + mLastLocation.getLongitude();

		}
	}

	@Override
	public void onStart() {
		super.onStart();
		mGoogleApiClient.connect();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mGoogleApiClient.disconnect();
	}

	@Override
	public void onConnectionSuspended(int i) {

	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}

	void permissionCheck(){
		// Here, thisActivity is the current activity
		if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

			String[] PERMISSIONS = {android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.CAMERA};
			ActivityCompat.requestPermissions(getActivity(), PERMISSIONS,1);

		}
	}
	public void createInstanceOfGoogleAPIClient() {
		// Create an instance of GoogleAPIClient.
		if (mGoogleApiClient == null) {
			mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
					.addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this)
					.addApi(LocationServices.API)
					.build();
		}
	}
}