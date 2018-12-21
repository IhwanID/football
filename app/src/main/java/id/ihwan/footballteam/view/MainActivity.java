package id.ihwan.footballteam.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.ihwan.footballteam.Injection;
import id.ihwan.footballteam.R;
import id.ihwan.footballteam.adapter.TeamAdapter;
import id.ihwan.footballteam.main.MainContract;
import id.ihwan.footballteam.main.MainPresenter;
import id.ihwan.footballteam.model.Teams;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TeamAdapter adapter;
    private final List<Teams> teamsArrayList = new ArrayList<>();
    private final MainPresenter mainPresenter = new MainPresenter(Injection.provideRepository(), this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new TeamAdapter(getApplicationContext(), teamsArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        mainPresenter.getDataListTeams(MainActivity.this);

    }

    @Override
    public void showProgress() {
        progressBar = new ProgressBar(MainActivity.this);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void showDataList(List<Teams> teamsList) {
        teamsArrayList.addAll(teamsList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
