package com.example.lab23watch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.lab23watch.databinding.ActivityMain2Binding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    ArrayList<Dish> dishes = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setInitialData();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String currentTime = dateFormat.format(new Date());
        binding.textTime.setText(currentTime);

        DishAdapter stateAdapter = new DishAdapter(this, R.layout.item_view, dishes);
        binding.DishesList.setAdapter(stateAdapter);


        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String dishName = dishes.get(position).getName();
                /*Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
                intent2.putExtra("dishName", dishName);
                startActivity(intent2);*/
            }
        };
        binding.DishesList.setOnItemClickListener(itemListener);


        Intent intent = new Intent(this,MainActivity.class);
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }

    private void setInitialData(){
        dishes.add(new Dish ("Блинчики",R.drawable.ic_blinchik));
        dishes.add(new Dish ("Борщ", R.drawable.ic_borsch));
        dishes.add(new Dish ("Цезарь", R.drawable.ic_cesar));
        dishes.add(new Dish ("Милкшейк",R.drawable.ic_milkshake));
        dishes.add(new Dish ("Спагетти",R.drawable.ic_spagetti));
        dishes.add(new Dish ("Каша",R.drawable.ic_spagetti));
    }
}