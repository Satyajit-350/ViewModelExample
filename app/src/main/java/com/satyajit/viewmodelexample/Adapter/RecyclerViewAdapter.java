package com.satyajit.viewmodelexample.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satyajit.viewmodelexample.R;
import com.satyajit.viewmodelexample.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Hero> heroArrayList;

    public RecyclerViewAdapter(Context context, List<Hero> heroArrayList) {
        this.context = context;
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = heroArrayList.get(position);
        Picasso.get().load(hero.getPicture()).placeholder(R.drawable.profile_image).into(holder.profileImage);
        holder.nameText.setText(hero.getName());
        holder.realName.setText(hero.getRealName());
        holder.team.setText(hero.getTeam());
        holder.appearance.setText(hero.getFirstAppearance());
        holder.bio.setText(hero.getBio());
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView profileImage;
        private TextView nameText;
        private TextView realName;
        private TextView team;
        private TextView appearance;
        private TextView bio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.profile_image);
            nameText = itemView.findViewById(R.id.name_text_view);
            realName = itemView.findViewById(R.id.real_name_text_view);
            team = itemView.findViewById(R.id.team_text_view);
            appearance = itemView.findViewById(R.id.appearance_text_view);
            bio = itemView.findViewById(R.id.bio_text_view);
        }
    }
}
