package com.practice.recyclerview_mvvm_demo.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.practice.recyclerview_mvvm_demo.R;
import com.practice.recyclerview_mvvm_demo.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
/**
 * ============================================================================================================
 * File Name：
 * Description：
 * Author： KC Fang.
 * Created Date： 22,July,2020
 * =============================================================================================================
 * Number    Modified Date      User      Description
 * -----------------------------------------------------------------------------------------------------------
 * 00       0000/00/00          kc        TODO
 * =============================================================================================================
 */
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {

    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter2( Context mContext, List<NicePlace> mNicePlaces) {
        this.mNicePlaces = mNicePlaces;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageName.setText(mNicePlaces.get(position).getTitle());
        Glide.with(mContext)
                .asBitmap()
                .load(mNicePlaces.get(position).getImageUrl())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        //宣告元件
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        //Constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_Name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,
                            mNicePlaces.get(getAdapterPosition()).getTitle(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
