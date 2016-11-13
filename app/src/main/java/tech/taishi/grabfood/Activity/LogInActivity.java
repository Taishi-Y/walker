package tech.taishi.grabfood.Activity;


import tech.taishi.grabfood.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class LogInActivity extends AppCompatActivity {

	LoginButton loginButton;
	CallbackManager callbackManager;
	ProfileTracker profileTracker;
	SharedPreferences data;
	String facebookId = null;
	String currentFacebookId = null;

	void initializeElements(){
		loginButton = (LoginButton) findViewById(R.id.login_button);
		loginButton.setReadPermissions(Arrays.asList("public_profile"));
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FacebookSdk.sdkInitialize(getApplicationContext());
		setContentView(R.layout.activity_log_in);


		data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
		facebookId= data.getString("facebookId",null);

		try {
			currentFacebookId = Profile.getCurrentProfile().getId();
		} catch (Exception e) {
			currentFacebookId = null;
			e.printStackTrace();
		}

//		Log.v("FB USER ID",currentFacebookId);

		if (currentFacebookId != null) {
			Log.v("FB USER ID",currentFacebookId);
			Intent intent = new Intent(getApplicationContext(),MainActivity.class);
			startActivity(intent);
			finish();
		}

//		Toast.makeText(LogInActivity.this, Profile.getCurrentProfile().getId(), Toast.LENGTH_SHORT).show();


		callbackManager = CallbackManager.Factory.create();
		AppEventsLogger.activateApp(this);

		initializeElements();

		profileTracker = new ProfileTracker() {
			@Override
			protected void onCurrentProfileChanged(
					Profile oldProfile,
					Profile currentProfile) {
				if (currentProfile==null){
					Toast.makeText(LogInActivity.this, "ログアウト", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(LogInActivity.this, currentProfile.getName(), Toast.LENGTH_SHORT).show();
					Log.v("FB USER ID",currentProfile.getId());
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();
				}
			}
		};


		loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {
				facebookId = loginResult.getAccessToken().getUserId();
				Toast.makeText(LogInActivity.this, loginResult.getAccessToken().getUserId(), Toast.LENGTH_SHORT).show();
				Log.v("FB USER ID",loginResult.getAccessToken().getUserId());
				Log.v("FB USER Name",Profile.getCurrentProfile().getName());


//				data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
//				SharedPreferences.Editor editor = data.edit();
//				editor.putString("faceBookId",facebookId);
//				editor.apply();

//				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//				startActivity(intent);
//				finish();
			}

			@Override
			public void onCancel() {
				Toast.makeText(LogInActivity.this, "canceled", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onError(FacebookException error) {
				Toast.makeText(LogInActivity.this, "Error:" + error, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		profileTracker.stopTracking();
	}
}