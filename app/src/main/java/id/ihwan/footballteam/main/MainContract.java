package id.ihwan.footballteam.main;

import android.content.Context;

import java.util.List;

import id.ihwan.footballteam.model.Teams;

/**
 * Created by ihwan on 20,December,2018
 */
public interface MainContract {

    interface View {
        void showProgress();
        void hideProgress();
        void showDataList(List<Teams> teamsList);
        void showFailureMessage(String msg);
    }

    interface Presenter {
        void getDataListTeams(Context context);
    }
}
