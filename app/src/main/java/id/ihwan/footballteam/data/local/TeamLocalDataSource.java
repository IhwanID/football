package id.ihwan.footballteam.data.local;

import android.content.Context;

import id.ihwan.footballteam.data.TeamDataSource;

/**
 * Created by ihwan on 20,December,2018
 */
public class TeamLocalDataSource implements TeamDataSource {

    @Override
    public void getListTeams(Context context, GetListTeamsCallback callback) {
        TeamsDatabase teamsDatabase = TeamsDatabase.getTeamsDatabase(context);
        if (teamsDatabase.teamsDao().select() != null){
            callback.onSuccess(teamsDatabase.teamsDao().select());
        }else {
            callback.onFailed("local database is empty");
        }
    }
}
