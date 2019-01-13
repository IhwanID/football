package id.ihwan.footballteam.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import id.ihwan.footballteam.R;
import id.ihwan.footballteam.model.Teams;
import id.ihwan.footballteam.view.DetailActivity;

/**
 * Created by ihwan on 20,December,2018
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private final Context context;
    private final List<Teams> teamsList;

    public TeamAdapter(Context context, List<Teams> teamsList) {
        this.context = context;
        this.teamsList = teamsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_team, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Teams teams = teamsList.get(i);
        Glide.with(context).load(teams.getBadge()).into(viewHolder.badge);
        viewHolder.clubName.setText(teams.getTeam());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("TEAM", teams.getTeam());
                intent.putExtra("YEAR", teams.getYear());
                intent.putExtra("MANAGER", teams.getManager());
                intent.putExtra("STADIUM", teams.getStadium());
                intent.putExtra("BADGE", teams.getBadge());
                intent.putExtra("DESCRIPTION", teams.getDescription());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, teams.getTeam() + " is Awesome !");
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView badge;
        private final CardView cardView;
        private final TextView clubName;
        private final Button btnShare;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);

            badge = itemView.findViewById(R.id.badge);
            cardView = itemView.findViewById(R.id.cardView);
            clubName = itemView.findViewById(R.id.name);
            btnShare = itemView.findViewById(R.id.btnShare);

        }
    }
}
