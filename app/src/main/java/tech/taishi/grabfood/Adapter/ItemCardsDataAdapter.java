package tech.taishi.grabfood.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tech.taishi.grabfood.Model.Explore.Item_;
import tech.taishi.grabfood.Model.Explore.Venue;
import tech.taishi.grabfood.R;

/**
 * Created by yamasakitaishi on 2016/09/22.
 */



//https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
public class ItemCardsDataAdapter extends ArrayAdapter<Item_> {

	String CLIENT_ID = "UHXRWJ5JG10S55CR3B5ABEWEBKOKEIEJZRAE1NUS4ZKMJKR4";
	String CLIENT_SECRET = "NTOBJSYD20GQF5ISUMGB5S32RVWJ5ANQQSB3CTU2UJBJIH4J";


	public ItemCardsDataAdapter(Context context,int layout , List<Item_> itemList) {
		super(context, layout, itemList);
	}

	ImageView ivFood,ivFood2,ivFood3,ivFood4,ivFood5,ivFood6,ivFood7,ivFood8,ivFood9,ivReviewedUser;
	Integer price = null;

	String tip,userPhotoUrl;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		tip = null;

		Item_ items = getItem(position);

		Venue venue = items.getVenue();

		String placeName = venue.getName();
		Double venueRating = venue.getRating();
		String category = venue.getCategories().get(0).getName();
		String ratingColor = venue.getRatingColor();
		if(venue.getPrice() != null){
			price = venue.getPrice().getTier();
		}
		Integer distance = venue.getLocation().getDistance();
		distance = distance/80;
//		String area = items.getVenue().getLocation().getCity();


		List<String> photoUrl = items.getPhotoUrl();


		if(items.getTips().size() != 0){
			tip = items.getTips().get(0).getText();
			userPhotoUrl = items.getTips().get(0).getUser().getPhoto().getPrefix() +"80x80" + items.getTips().get(0).getUser().getPhoto().getSuffix();
		}


		if (convertView == null) {
			//We must create a View:
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.card_layout, parent, false);
		}

		TextView tvPlaceName = (TextView) (convertView.findViewById(R.id.tv_place_name));
		TextView tvVenueRating = (TextView) (convertView.findViewById(R.id.tv_venue_rating));
		TextView tvCategory = (TextView) (convertView.findViewById(R.id.tv_category));
//		TextView tvPrice = (TextView) (convertView.findViewById(R.id.tv_price_howmuch));
		ImageView ivCoinIcon = (ImageView) convertView.findViewById(R.id.iv_coin_icon);
		TextView tvDistance = (TextView) (convertView.findViewById(R.id.tv_distance));
//		TextView tvArea = (TextView) (convertView.findViewById(R.id.tv_area));
		TextView tvTips = (TextView) convertView.findViewById(R.id.tv_tip);

		ivFood = (ImageView) convertView.findViewById(R.id.iv_food);
		ivFood2 = (ImageView) convertView.findViewById(R.id.iv_food2);
		ivFood3 = (ImageView) convertView.findViewById(R.id.iv_food3);
		ivFood4 = (ImageView) convertView.findViewById(R.id.iv_food4);
		ivFood5 = (ImageView) convertView.findViewById(R.id.iv_food5);
		ivFood6 = (ImageView) convertView.findViewById(R.id.iv_food6);
		ivFood7 = (ImageView) convertView.findViewById(R.id.iv_food7);
		ivFood8 = (ImageView) convertView.findViewById(R.id.iv_food8);
		ivFood9 = (ImageView) convertView.findViewById(R.id.iv_food9);
		ivReviewedUser = (ImageView) convertView.findViewById(R.id.iv_reviwed_user);


		ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();
		imageViewArrayList.add(ivFood);
		imageViewArrayList.add(ivFood2);
		imageViewArrayList.add(ivFood3);
		imageViewArrayList.add(ivFood4);
		imageViewArrayList.add(ivFood5);
		imageViewArrayList.add(ivFood6);
		imageViewArrayList.add(ivFood7);
		imageViewArrayList.add(ivFood8);
		imageViewArrayList.add(ivFood9);

		tvPlaceName.setText(placeName);
		tvVenueRating.setText(String.valueOf(venueRating));
		if(ratingColor != null){
			tvVenueRating.setBackgroundColor(Color.parseColor("#"+ratingColor));
		}

		tvCategory.setText(category);



		if(price != null){
			if(price == 1){
//				ivCoinIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.icon_coin_1));
				ivCoinIcon.setImageResource(R.drawable.coin_1);
			} else if(price == 2){
				ivCoinIcon.setImageResource(R.drawable.coin_2);
			} else if(price == 3){
				ivCoinIcon.setImageResource(R.drawable.coin_3);
			} else if(price == 4){
				ivCoinIcon.setImageResource(R.drawable.coin_4);
			}
//			ivCoinIcon
//			tvPrice.setText(String.valueOf(price));
		}

		tvDistance.setText(String.valueOf(distance)+" min");
//		tvArea.setText(area);


		if(!(photoUrl == null)){
			int numberOfPhotos = photoUrl.size();
			for(int i=0;i<numberOfPhotos;i++){
				Glide.with(getContext()).load(photoUrl.get(i)).into(imageViewArrayList.get(i));
			}
		}


		if(tip != null){
			tvTips.setText(tip);
			if(!(userPhotoUrl == null)){
				Glide.with(getContext()).load(userPhotoUrl).into(ivReviewedUser);
			}
		}


		return convertView;
	}

}
