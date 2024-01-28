package com.example.lab23watch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private LayoutInflater inflater;
    private int layout;
    private List<Dish> dishes;

    public DishAdapter(Context context, int resource, List<Dish> dishes){
        super(context, resource, dishes);
        this.dishes = dishes;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);

        ImageView foodView = (ImageView) view.findViewById(R.id.DishImage);
        TextView nameView = (TextView) view.findViewById(R.id.DishName);


        Dish dish = dishes.get(position);

        foodView.setImageResource(dish.getDishResource());
        nameView.setText(dish.getName());

        return view;
    }
}
