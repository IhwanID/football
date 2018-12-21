package id.ihwan.footballteam;

import id.ihwan.footballteam.data.TeamRepository;
import id.ihwan.footballteam.data.local.TeamLocalDataSource;
import id.ihwan.footballteam.data.remote.TeamRemoteDataSource;

/**
 * Created by ihwan on 20,December,2018
 */
public class Injection {

    public static TeamRepository provideRepository(){
        return new TeamRepository(new TeamRemoteDataSource(), new TeamLocalDataSource());
    }

}
