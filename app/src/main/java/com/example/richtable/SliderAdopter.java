package com.example.richtable;
//
//public class  {
//
//}

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdopter extends SliderViewAdapter<SliderAdopter.Holder> {
    int [] images ;

    public  SliderAdopter(int [] images){
        this.images = images;
    }

    @Override
    public SliderAdopter.Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdopter.Holder viewHolder, int position) {
        viewHolder.img.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }
    public  class Holder extends  SliderViewAdapter.ViewHolder{
        ImageView img;
        public Holder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgSlider);
        }




    }
}
