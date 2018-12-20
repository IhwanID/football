package id.ihwan.footballteam.data;

import android.content.Context;

import java.util.List;

import id.ihwan.footballteam.model.Teams;

/**
 * Created by ihwan on 20,December,2018
 */
public interface TeamDataSource {

    void getListTeams(Context context, GetListTeamsCallback callback);

    interface GetListTeamsCallback{
        void onSuccess(List<Teams> data);
        void onFailed(String errorMessage);
    }

}
