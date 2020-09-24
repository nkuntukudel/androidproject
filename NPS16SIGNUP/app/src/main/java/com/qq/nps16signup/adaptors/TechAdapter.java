package com.qq.nps16signup.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qq.nps16signup.R;
import com.qq.nps16signup.data.User;

import java.util.List;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {
    List<User> users= null;
    private final Context mContext;

    public TechAdapter(Context tech, List<User> newscategory) {
        this.mContext = tech;
        users= newscategory;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_view_generic,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(users.get(position));
    }

    @Override
    public int getItemCount() {
        if (users != null)return users.size();
        else return 0;}

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        ImageView tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.country_name);
            tv2=itemView.findViewById(R.id.country_abbrev);
            tv3=itemView.findViewById(R.id.country_icon);
        }
        public void setData(User user){
            tv1.setText(user.getmUsername());
            tv2.setText(user.getmEmail());
        }
    }
}
