package tech.taishi.grabfood.Service;



import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import tech.taishi.grabfood.Model.Explore.Explore;
import tech.taishi.grabfood.Model.Photo.Photos;

/**
 * Created by yamasakitaishi on 2016/09/13.
 */



public interface FourSquareService {


//	https://api.foursquare.com/v2/venues/explore?ll=40.7,-74&limit=2&oauth_token=MJZ4MKUF1UTW3VB5FO13OWKPRS3FD3NHQD4SFWS2QNB1BVKG&v=20160922
	@GET("venues/explore/")
	Call<Explore> requestExplore(
			@Query("client_id") String client_id,
			@Query("client_secret") String client_secret,
			@Query("v") String v,
			@Query("ll") String ll,
			@Query("limit") int limit,
			@Query("query") String query,
			@Query("sortByDistance") int sortByDistance);




//	v=20130815


//	https://api.foursquare.com/v2/venues/51eabef6498e10cf3aea7942/photos?oauth_token=MJZ4MKUF1UTW3VB5FO13OWKPRS3FD3NHQD4SFWS2QNB1BVKG&v=20160924

//	https://irs1.4sqi.net/img/general/100x100/63892328_N0A_9qgk0N30lHiqDWIRtNb-0YfO84BIxHc9SP7h4rY.jpg

	@GET("venues/{venue_id}/photos/")
	Call<Photos> requestPhotos(
			@Path("venue_id") String venue_id,
			@Query("client_id") String client_id,
			@Query("client_secret") String client_secret,
			@Query("v") String v);


	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.foursquare.com/v2/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

//	https://medium.freecodecamp.com/rxandroid-and-retrofit-2-0-66dc52725fff#.dor7xn3tq
//	Retrofit retrofitRxJava = new Retrofit.Builder()
//			.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//			.addConverterFactory(GsonConverterFactory.create())
//			.baseUrl("https://api.foursquare.com/v2/")
//			.build();
}
