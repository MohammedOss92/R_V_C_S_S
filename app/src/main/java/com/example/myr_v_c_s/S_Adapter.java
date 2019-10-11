package com.example.myr_v_c_s;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class S_Adapter extends RecyclerView.Adapter<S_Adapter.MyViewHolder> {
    private static final String TAG = "S_Adapter";
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    Context con;
    private Callback mCallback;
    private List<Sport> mSportList;

    public S_Adapter(Context context,List<Sport> sportList ) {
        this.con = context;
        this.mSportList = sportList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new MyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false)) {

                };
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Sport mSport = mSportList.get(position);

//            if (mSport.getImageUrl() != null) {
//                Glide.with(itemView.getContext())
//                        .load(mSport.getImageUrl())
//                        .into(coverImageView);
//            }

        if (mSport.getTitle() != null) {
            holder.titleTextView.setText(mSport.getTitle());
        }

        if (mSport.getSubTitle() != null) {
            holder.newsTextView.setText(mSport.getSubTitle());
        }

        if (mSport.getInfo() != null) {
            holder.infoTextView.setText(mSport.getInfo());
        }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                if (mSport.getImageUrl() != null) {
//                    try {
//                        Intent intent = new Intent();
//                        intent.setAction(Intent.ACTION_VIEW);
//                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                        intent.setData(Uri.parse(mSport.getImageUrl()));
//                        itemView.getContext().startActivity(intent);
//                    } catch (Exception e) {
//                        Log.e(TAG, "onClick: Image url is not correct");
//                    }
//                }

                    if (mSport.getInfo() != null) {
                        try {
                            Intent intent = new Intent(con, Main2Activity.class);
                            con.startActivity(intent);
//                        holder.itemView.getContext().startActivity(intent);
                        } catch (Exception e) {
                        }
                    }
                }
            });
    }

    @Override
    public int getItemViewType(int position) {
        if (mSportList != null && mSportList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mSportList != null && mSportList.size() > 0) {
            return mSportList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Sport> sportList) {
        mSportList.addAll(sportList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onEmptyViewRetryClick();
    }

    public abstract class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView coverImageView;

        TextView titleTextView;

        TextView newsTextView;
        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTextView.setText("");
            newsTextView.setText("");
            infoTextView.setText("");
        }
        TextView infoTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImageView=(ImageView)itemView.findViewById(R.id.thumbnail);
            titleTextView =(TextView)itemView.findViewById(R.id.title);
            newsTextView  =(TextView)itemView.findViewById(R.id.newsTitle);
            infoTextView  =(TextView)itemView.findViewById(R.id.newsInfo);

        }
    }

    public class EmptyViewHolder extends MyViewHolder {


        TextView messageTextView;

        TextView buttonRetry;


        EmptyViewHolder(View itemView) {
            super(itemView);
            messageTextView=(TextView)itemView.findViewById(R.id.tv_message);
            buttonRetry=(TextView)itemView.findViewById(R.id.buttonRetry);

            buttonRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onEmptyViewRetryClick();
                }
            });
        }

        @Override
        protected void clear() {

        }

    }
}
