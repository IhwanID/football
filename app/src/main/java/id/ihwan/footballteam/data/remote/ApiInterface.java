package id.ihwan.footballteam.data.remote;

import id.ihwan.footballteam.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ihwan on 20,December,2018
 */
public interface ApiInterface {

    @GET("api/v1/json/1/search_all_teams.php")
    Call<ResponseTeams> getAllTeams(
            @Query("l") String l
//            @Query("s") String s,
//            @Query("c") String c
    );


}
