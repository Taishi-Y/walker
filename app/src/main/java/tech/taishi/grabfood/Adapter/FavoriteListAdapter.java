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
		String categoryName = response.getVenue().getCategories().get(0).getName();
		String point = response.getVenue().getRating().toString();


		// convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
		if (null == convertView) {
			convertView = layoutInflater_.inflate(R.layout.favorite_list, null);
		}

		TextView tvName = (TextView)convertView.findViewById(R.id.tv_favorite_name);
		TextView tvCategoryName = (TextView) convertView.findViewById(R.id.tv_favorite_category);
		TextView tvDistance = (TextView) convertView.findViewById(R.id.tv_distance);
//		TextView tvComment = (TextView) convertView.findViewById(R.id.tv_favorite_comment);
		TextView tvPoint = (TextView) convertView.findViewById(R.id.tv_favorite_point);
		ImageView ivFavoriteImage = (ImageView) convertView.findViewById(R.id.iv_favorite_image);
//		ImageView ivFavoritePrice = (ImageView) convertView.findViewById(R.id.iv_favorite_price);




		tvName.setText(name);
		tvCategoryName.setText(categoryName);
		tvPoint.setText(point);


		return convertView;
	}


}