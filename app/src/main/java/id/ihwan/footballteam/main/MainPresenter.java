package id.ihwan.footballteam.main;

import android.content.Context;

import java.util.List;

import id.ihwan.footballteam.data.TeamDataSource;
import id.ihwan.footballteam.data.TeamRepository;
import id.ihwan.footballteam.model.Teams;

/**
 * Created by ihwan on 20,December,2018
 */
public class MainPresenter implements MainContract.Presenter {

    private final TeamRepository repository;
    private final MainContract.View view;

    public MainPresenter(TeamRepository repository, MainContract.View view) {
        this.repository = repository;
        this.view = view;
    }


    @Override
    public void getDataListTeams(Context context) {
        view.showProgress();
        repository.getListTeams(context, new TeamDataSource.GetListTeamsCallback() {
            @Override
            public void onSuccess(List<Teams> data) {
                view.hideProgress();
                view.showDataList(data);
            }

            @Override
            public void onFailed(String errorMessage) {
                view.hideProgress();
                view.showFailureMessage(errorMessage);
            }
        });

    }
}
