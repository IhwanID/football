package id.ihwan.footballteam.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ihwan on 20,December,2018
 */
public class ResponseTeams {

    @SerializedName("teams")
    private final List<Teams> teams;

    public ResponseTeams(List<Teams> teams){
        this.teams = teams;
    }

    public List<Teams> getTeams() {
        return teams;
    }
}
