package id.ihwan.footballteam.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.ihwan.footballteam.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView badge;
    private TextView team, year, manager, stadium, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        badge = findViewById(R.id.detailBadge);
        team = findViewById(R.id.detailName);
        year = findViewById(R.id.detailYear);
        manager = findViewById(R.id.detailManager);
        stadium = findViewById(R.id.detailStadium);
        description = findViewById(R.id.detailDescription);

        String strImg = getIntent().getStringExtra("BADGE");
        String name = getIntent().getStringExtra("TEAM");
        String strYear = getIntent().getStringExtra("YEAR");
        String strDescription = getIntent().getStringExtra("DESCRIPTION");
        String strStadium = getIntent().getStringExtra("STADIUM");
        String strManager = getIntent().getStringExtra("MANAGER");

        Glide.with(getApplicationContext()).load(strImg).into(badge);
        team.setText(name);
        year.setText(strYear);
        manager.setText(strManager);
        description.setText(strDescription);
        stadium.setText(strStadium);

    }
}
