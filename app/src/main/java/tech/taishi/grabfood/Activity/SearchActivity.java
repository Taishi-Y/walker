package tech.taishi.grabfood.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import tech.taishi.grabfood.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SearchActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

	GoogleApiClient mGoogleApiClient;
	String geoLocation;

	EditText etSearch;
	TextView tvTitle;



	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			findViewById(android.R.id.content).setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
		}
		setContentView(R.layout.activity_search);

		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
						.setDefaultFontPath("fonts/Lato/Lato-Regular.ttf")
						.setFontAttrId(R.attr.fontPath)
						.build());

		permissionCheck();
		createInstanceOfGoogleAPIClient();

		tvTitle = (TextView) findViewById(R.id.tv_title);

		etSearch = (EditText) findViewById(R.id.et_search);
		etSearch.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View view, int i, KeyEvent keyEvent) {
				Log.v("tttt","ddddd");
				//イベントを取得するタイミングには、ボタンが押されてなおかつエンターキーだったときを指定
				if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)){
//					//キーボードを閉じる

					String query = String.valueOf(etSearch.getText());
//					Toast.makeText(SearchActivity.this, etSearch.getText(), Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(getApplicationContext(),SwipeActivity.class);
					intent.putExtra("Q",query);
					intent.putExtra("G",geoLocation);
					startActivity(intent);

					return true;
				}
				return false;
			}
		});

	}

	public void onStart() {
		mGoogleApiClient.connect();
		super.onStart();
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		mGoogleApiClient.disconnect();
	}



	@Override
	public void onConnected(@Nullable Bundle bundle) {
		if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			return;
		}
		Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
				mGoogleApiClient);
		if (mLastLocation != null) {

			geoLocation = mLastLocation.getLatitude() + "," + mLastLocation.getLongitude();
//			Toast.makeText(getApplicationContext(), String.valueOf(mLastLocation.getLatitude()), Toast.LENGTH_SHORT).show();
			Log.v("ttttt",String.valueOf(mLastLocation.getLatitude()));

//			sendRequest();
//            mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
//            mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
		}
	}

	@Override
	public void onConnectionSuspended(int i) {

	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}
	void permissionCheck(){
		// Here, thisActivity is the current activity
		if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

			String[] PERMISSIONS = {android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.CAMERA};
			ActivityCompat.requestPermissions(SearchActivity.this, PERMISSIONS,1);

		}
	}
	public void createInstanceOfGoogleAPIClient() {
		// Create an instance of GoogleAPIClient.
		if (mGoogleApiClient == null) {
			mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
					.addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this)
					.addApi(LocationServices.API)
					.build();
		}
	}
}
