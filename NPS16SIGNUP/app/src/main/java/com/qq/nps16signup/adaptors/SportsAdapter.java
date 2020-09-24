package com.qq.nps16signup.adaptors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qq.nps16signup.R;
import com.qq.nps16signup.data.User;
import com.qq.nps16signup.data.Users;

import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private final String TAG = SportsAdapter.class.getSimpleName();
    List<User> users = null;
    private final Context mContext;

    public SportsAdapter(Context sports, List<User> newscategory) {
        users = newscategory;
        mContext = sports;
        Log.d(TAG, "NewsCategoryAdapter");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view_generic, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;
        ImageView tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.country_name);
            tv2 = itemView.findViewById(R.id.country_abbrev);
            tv3 = itemView.findViewById(R.id.country_icon);
        }

        public void setData(User user) {
            tv1.setText(user.getmUsername());
            tv2.setText(user.getmEmail());
            Glide.with(tv3.getContext()).load(user.getmImageurl()).into(tv3);
        }
    }
    public interface ItemClickListner{
        void onItemClick(Users users);
    }
}
