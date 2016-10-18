package tech.taishi.grabfood.Application;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import tech.taishi.grabfood.Model.Explore.Item_;
import tech.taishi.grabfood.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by yamasakitaishi on 2016/10/11.
 */

public class Common extends Application {
	// グローバルに扱う変数
	public int countOfGettingPhotos;
	public List<Item_> itemList;
	public int totalResults;
	public int itemCount;
	public int i;
	public String placeId;
	public List<String> photoUrlList;
	/**
	 * 変数を初期化する
	 */
	public void init(){
		itemList = null;
		countOfGettingPhotos = 0;
		totalResults = 0;
		itemCount = 0;
		i = 0;
		placeId = null;
		photoUrlList = null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
				.setDefaultFontPath("fonts/Lato/Lato-Regular.ttf")
				.setFontAttrId(R.attr.fontPath)
				.build()
		);
	}
}