package tech.taishi.grabfood.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.RelativeLayout;
import android.widget.TabHost;


import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;

import tech.taishi.grabfood.Fragment.FavoriteFragment;
import tech.taishi.grabfood.Fragment.SearchFragment;
import tech.taishi.grabfood.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainActivity extends AppCompatActivity implements FragmentTabHost.OnTabChangeListener {

	RelativeLayout rlTabSearch, rlTabFavorite, rlTabMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			SearchFragment fragment = new SearchFragment();
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(R.id.container_main, fragment).commit();
		}

		FacebookSdk.sdkInitialize(getApplicationContext());
		AppEventsLogger.activateApp(this);

		Log.v("FB USER IDddd", Profile.getCurrentProfile().getId());
		Log.v("FB USER Name", Profile.getCurrentProfile().getName());

		rlTabSearch = (RelativeLayout) findViewById(R.id.rl_search);
		rlTabFavorite = (RelativeLayout) findViewById(R.id.rl_favorite);
//		rlTabMap = (RelativeLayout) findViewById(R.id.rl_map);

		rlTabSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				SearchFragment fragment = new SearchFragment();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.container_main, fragment).commit();
			}
		});

		rlTabFavorite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FavoriteFragment fragment = new FavoriteFragment();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.container_main, fragment).commit();
			}
		});
//		// FragmentTabHost を取得する
//		FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
//		tabHost.setup(this, getSupportFragmentManager(), R.id.container);
//
//		TabHost.TabSpec tabSpec1, tabSpec2, tabSpec3, tabSpec4, tabSpec5;
//
//		// 1
//		tabSpec1 = tabHost.newTabSpec("fff");
//		View childview1 = new CustomTabContentView(this,  R.drawable.ic_search_black_24dp);
//		tabSpec1.setIndicator(childview1);
//		tabHost.addTab(tabSpec1, SearchFragment.class, null);
//
//		// 2
//		tabSpec2 = tabHost.newTabSpec("tab2");
//		View childview2 = new CustomTabContentView(this,  R.drawable.ic_favorite_black_24dp);
//		tabSpec2.setIndicator(childview2);
//		tabHost.addTab(tabSpec2, FavoriteFragment.class, null);
//
////		// 3
//		tabSpec3 = tabHost.newTabSpec("tab3");
//		View childview3 = new CustomTabContentView(this,  R.drawable.ic_flag_black_24dp);
//		tabSpec3.setIndicator(childview3);
//		tabHost.addTab(tabSpec3, SearchFragment.class, null);
////
//		// 4
//		tabSpec4 = tabHost.newTabSpec("tab4");
//		View childview4 = new CustomTabContentView(this,  R.drawable.ic_account_circle_black_24dp);
//		tabSpec4.setIndicator(childview4);
//		tabHost.addTab(tabSpec4, SearchFragment.class, null);
//
//		// リスナー登録
//		tabHost.setOnTabChangedListener(this);


		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			findViewById(android.R.id.content).setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
		}

		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
				.setDefaultFontPath("fonts/Lato/Lato-Regular.ttf")
				.setFontAttrId(R.attr.fontPath)
				.build());


	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabChanged(String s) {

	}





}
