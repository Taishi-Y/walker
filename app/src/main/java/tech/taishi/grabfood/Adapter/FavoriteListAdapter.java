package tech.taishi.grabfood.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import tech.taishi.grabfood.Model.Favorite.Reasons;
import tech.taishi.grabfood.Model.Favorite.Response;
import tech.taishi.grabfood.Model.Favorite.Venue;
import tech.taishi.grabfood.R;

/**
 * Created by yamasakitaishi on 2016/10/20.
 */

public class FavoriteListAdapter extends ArrayAdapter<Response> {
	private LayoutInflater layoutInflater_;

	public FavoriteListAdapter(Context context, int layout, List<Response> objects) {
		super(context, layout, objects);
		layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 特定の行(position)のデータを得る
		Response response = getItem(position);

		Log.v("aaa", String.valueOf(response));

		String name = response.getVenue().getName();
		Log.v("aaa", String.valueOf(name));



		// convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
		if (null == convertView) {
			convertView = layoutInflater_.inflate(R.layout.favorite_list, null);
		}

		// CustomDataのデータをViewの各Widgetにセットする
//		ImageView imageView;
//		imageView = (ImageView)convertView.findViewById(R.id.image);
////		imageView.setImageBitmap(item.getImageData());

		TextView textView;
		textView = (TextView)convertView.findViewById(R.id.tv_favorite_name);
		textView.setText(name);

		return convertView;
	}


}