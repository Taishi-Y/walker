package tech.taishi.grabfood.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import im.delight.android.webview.AdvancedWebView;
import tech.taishi.grabfood.R;


public class WebViewActivity extends Activity implements AdvancedWebView.Listener {

	private AdvancedWebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		Intent intent = getIntent();
		String placeId = intent.getStringExtra("PLACEID");


		mWebView = (AdvancedWebView) findViewById(R.id.webview);
		mWebView.setListener(this, this);
//		https://www.yelp.com/biz/montesacro-pinseria-enoteca-san-francisco-5
		mWebView.loadUrl("https://foursquare.com/v/" + placeId);
//		mWebView.loadUrl("https://www.yelp.com/biz/montesacro-pinseria-enoteca-san-francisco-5?uid=-QwcJ3ma9_1Wrw4usAG8uQ&utm_campaign=www_business_share_popup&utm_medium=copy_link&utm_source=(direct)" + placeId);

		// ...
	}

	@SuppressLint("NewApi")
	@Override
	protected void onResume() {
		super.onResume();
		mWebView.onResume();
		// ...
	}

	@SuppressLint("NewApi")
	@Override
	protected void onPause() {
		mWebView.onPause();
		// ...
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		mWebView.onDestroy();
		// ...
		super.onDestroy();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		mWebView.onActivityResult(requestCode, resultCode, intent);
		// ...
	}

	@Override
	public void onBackPressed() {
		if (!mWebView.onBackPressed()) { return; }
		// ...
		super.onBackPressed();
	}

	@Override
	public void onPageStarted(String url, Bitmap favicon) { }

	@Override
	public void onPageFinished(String url) { }

	@Override
	public void onPageError(int errorCode, String description, String failingUrl) { }

	@Override
	public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

	@Override
	public void onExternalPageRequest(String url) { }

}


