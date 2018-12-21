package id.ihwan.footballteam.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ihwan on 20,December,2018
 */

@Entity(tableName = "teams")
public class Teams {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("idTeam")
    private final int id;

    @ColumnInfo(name = "team")
    @SerializedName("strTeam")
    private final String team;

    @ColumnInfo(name = "year")
    @SerializedName("intFormedYear")
    private final String year;

    @ColumnInfo(name = "manager")
    @SerializedName("strManager")
    private final String manager;

    @ColumnInfo(name = "stadium")
    @SerializedName("strStadium")
    private final String stadium;

    @ColumnInfo(name = "badge")
    @SerializedName("strTeamBadge")
    private final String badge;

    @ColumnInfo(name = "description")
    @SerializedName("strDescriptionEN")
    private final String description;


    public Teams(int id, String team, String year, String manager, String stadium, String badge, String description){
        this.id = id;
        this.team = team;
        this.year = year;
        this.manager = manager;
        this.stadium = stadium;
        this.badge = badge;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getYear() {
        return year;
    }

    public String getManager() {
        return manager;
    }

    public String getStadium() {
        return stadium;
    }

    public String getBadge() {
        return badge;
    }

    public String getDescription() {
        return description;
    }
}
