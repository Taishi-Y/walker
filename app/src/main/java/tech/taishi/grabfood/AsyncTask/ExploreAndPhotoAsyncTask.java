package tech.taishi.grabfood.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import tech.taishi.grabfood.Application.Common;
import tech.taishi.grabfood.Model.Explore.Explore;
import tech.taishi.grabfood.Model.Explore.Group;
import tech.taishi.grabfood.Model.Explore.Item_;
import tech.taishi.grabfood.Model.Photo.Photos;
import tech.taishi.grabfood.Service.FourSquareService;

/**
 * Created by yamasakitaishi on 2016/10/16.
 */

public class ExploreAndPhotoAsyncTask extends AsyncTask<Void,Void,List<Item_>> {
	String clientId = "UHXRWJ5JG10S55CR3B5ABEWEBKOKEIEJZRAE1NUS4ZKMJKR4";
	String clientSecret = "NTOBJSYD20GQF5ISUMGB5S32RVWJ5ANQQSB3CTU2UJBJIH4J";
	String apiVersion = "20161010";
	int numberOfRequestVenue = 10;
	String geoLocation = "34.674734,135.70235";

	List<Item_> itemList;

	public ExploreAndPhotoAsyncTask() {
		super();
	}

	@Override
	protected List<Item_> doInBackground(Void... voids) {
		FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
		final Call<Explore> call = fourSquareService.requestExplore(clientId, clientSecret, apiVersion, geoLocation, numberOfRequestVenue, "ramen",1);

		try {
			Explore explore =  call.execute().body();
			int totalResults = explore.getResponse().getTotalResults();
			List<Group> groupList = explore.getResponse().getGroups();
			itemList = groupList.get(0).getItems();
			totalResults = (totalResults<10)? totalResults : 10;

			for(int i = 0; i<totalResults; i++) {
				String placeId = itemList.get(i).getVenue().getId();
				final Call<Photos> callPhoto = fourSquareService.requestPhotos(placeId,clientId, clientSecret,apiVersion);

				try{
					Photos photos = callPhoto.execute().body();
					int numberOfPhotos = photos.getResponse().getPhotos().getCount();
					ArrayList<String> photoUrlList = new ArrayList<String>();

					numberOfPhotos = (numberOfPhotos<9)? numberOfPhotos: 9;
					for(int j = 0; j<numberOfPhotos;j++){
						String prefix = photos.getResponse().getPhotos().getItems().get(j).getPrefix();
						String suffix = photos.getResponse().getPhotos().getItems().get(j).getSuffix();
						String imageThumbnailUrl = prefix + "150x150" + suffix;
						Log.v("imageThumbnailUrl",imageThumbnailUrl);
						photoUrlList.add(imageThumbnailUrl);
						itemList.get(i).setPhotoUrl(photoUrlList);
					}
				}catch (IOException e){
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(List<Item_> item_s) {
		super.onPostExecute(item_s);
	}
}
