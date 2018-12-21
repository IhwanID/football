package id.ihwan.footballteam.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.List;

import id.ihwan.footballteam.data.local.TeamLocalDataSource;
import id.ihwan.footballteam.data.local.TeamsDatabase;
import id.ihwan.footballteam.data.remote.TeamRemoteDataSource;
import id.ihwan.footballteam.model.Teams;

/**
 * Created by ihwan on 20,December,2018
 */
public class TeamRepository implements TeamDataSource {

    private final TeamRemoteDataSource remoteDataSource;
    private final TeamLocalDataSource localDataSource;
    private TeamsDatabase teamsDatabase;

    public TeamRepository(TeamRemoteDataSource remoteDataSource, TeamLocalDataSource localDataSource, TeamsDatabase teamsDatabase) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.teamsDatabase = teamsDatabase;
    }

    @Override
    public void getListTeams(Context context, final GetListTeamsCallback callback) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        teamsDatabase = TeamsDatabase.getTeamsDatabase(context);
        if (teamsDatabase.teamsDao().select().size() != 0){
            Toast.makeText(context, "local database", Toast.LENGTH_SHORT).show();
            localDataSource.getListTeams(context, new GetListTeamsCallback() {
                @Override
                public void onSuccess(List<Teams> data) {
                    callback.onSuccess(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callback.onFailed(errorMessage);
                }
            });
        }else if (info != null && info.isConnected()){
            Toast.makeText(context, "use api database", Toast.LENGTH_SHORT).show();
            remoteDataSource.getListTeams(context, new GetListTeamsCallback() {
                @Override
                public void onSuccess(List<Teams> data) {
                    callback.onSuccess(data);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callback.onFailed(errorMessage);
                }
            });
        }else {
            callback.onSuccess(null);
            callback.onFailed("");
        }
    }
}
