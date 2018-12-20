package id.ihwan.footballteam.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import id.ihwan.footballteam.model.Teams;

/**
 * Created by ihwan on 20,December,2018
 */
@Dao
public interface TeamsDao {

    @Insert
    void insert(List<Teams> teamsList);

    @Query("SELECT * FROM teams ORDER BY id ASC")
    List<Teams> select();

    @Delete
    void delete(Teams teams);

    @Update
    void update(Teams teams);


}
