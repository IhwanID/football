package id.ihwan.footballteam.data.local;

/**
 * Created by ihwan on 20,December,2018
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import id.ihwan.footballteam.model.Teams;

@Database(entities = Teams.class,version = 1)
public abstract class TeamsDatabase extends RoomDatabase {

    public abstract TeamsDao teamsDao();
    private static TeamsDatabase teamsDatabase;
    public static TeamsDatabase getTeamsDatabase(Context context){
        synchronized (TeamsDatabase.class){
            if (teamsDatabase == null){
                teamsDatabase = Room.databaseBuilder(context, TeamsDatabase.class, "db_teams")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return teamsDatabase;
    }

}
