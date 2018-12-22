package id.ihwan.footballteam.data.remote;

import android.content.Context;

import id.ihwan.footballteam.adapter.Contract;
import id.ihwan.footballteam.data.TeamDataSource;
import id.ihwan.footballteam.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ihwan on 20,December,2018
 */
public class TeamRemoteDataSource implements TeamDataSource {

    private final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListTeams(Context context, final GetListTeamsCallback callback) {
        Call<ResponseTeams> call = apiInterface.getAllTeams(Contract.l);
        call.enqueue(new Callback<ResponseTeams>() {
            @Override
            public void onResponse(Call<ResponseTeams> call, Response<ResponseTeams> response) {
                if (response.body() != null){
                    callback.onSuccess(response.body().getTeams());
                }
            }

            @Override
            public void onFailure(Call<ResponseTeams> call, Throwable t) {
                callback.onFailed(t.toString());
            }
        });
    }
}
