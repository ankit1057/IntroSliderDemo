package com.demo.introsliderdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.VH> {
    List<IntroModel> introModelList;
    Context context;

    public IntroAdapter(List<IntroModel> introModelList, Context context) {
        this.introModelList = introModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_intro,parent,false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.imageView.setImageDrawable(context.getResources().getDrawable(introModelList.get(position).getImgPath()));
        YoYo.with(Techniques.SlideInRight)
                .duration(2000)
                .playOn(holder.imageView);
        YoYo.with(Techniques.SlideInLeft)
                .duration(2000)
                .playOn(holder.tvTitle);
    }
    @Override
    public void onViewDetachedFromWindow(@NonNull IntroAdapter.VH holder) {
        super.onViewDetachedFromWindow(holder);
        holder.imageView.clearAnimation();
        holder.tvTitle.clearAnimation();

    }
    @Override
    public int getItemCount() {
        return introModelList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvDescription;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgRecycler);
            tvTitle=itemView.findViewById(R.id.txt);
        }
    }
}
