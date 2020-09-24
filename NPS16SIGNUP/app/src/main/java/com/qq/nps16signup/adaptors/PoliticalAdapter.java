package com.qq.nps16signup.adaptors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qq.nps16signup.R;
import com.qq.nps16signup.data.User;

import java.util.List;


public class PoliticalAdapter extends BaseAdapter {
    private final Context mContext;
    private final String TAG = PoliticalAdapter.class.getSimpleName();
    List<User> users = null;
    private ItemClickListner mClickListner;
    private int i = 0;

    public PoliticalAdapter(Context political, List<User> newscategory, ItemClickListner mClickListner) {
        users = newscategory;
        mContext = political;
        this.mClickListner = mClickListner;

        Log.d(TAG,"NewsCategoryAdapter" );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG,"getView"+ i++ );
        ViewHolder viewHolder = null;
        if (convertView == null) {
            Log.d(TAG,"getView when convert is null "+ i );
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_view_generic, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv1 = convertView.findViewById(R.id.country_name);
            viewHolder.tv2 = convertView.findViewById(R.id.country_abbrev);
            viewHolder.tv3 = convertView.findViewById(R.id.country_icon);
            convertView.setTag(viewHolder);

            final User user = getItem(position);
            viewHolder.tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //startActivity(intent);
                    mClickListner.onItemClick(user);
                }
            });
        } else {
            Log.d(TAG,"getView when convert is not null "+ i );
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv1.setText(getItem(position).getmUsername());
        viewHolder.tv2.setText(getItem(position).getmEmail());
        //viewHolder.tv3.setText(getItem(position).getmPassword());
        return convertView;
    }

    public class ViewHolder {
        TextView tv1;
        TextView tv2;
        ImageView tv3;
    }



    @Nullable
    @Override
    public User getItem(int position) {
        Log.d(TAG,"getItem" );
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        Log.d(TAG,"getCount" );
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    public interface ItemClickListner{
        void onItemClick(User user);
    }
}
