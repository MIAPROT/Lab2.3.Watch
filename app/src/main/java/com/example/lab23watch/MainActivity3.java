package com.example.lab23watch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab23watch.databinding.ActivityMain2Binding;
import com.example.lab23watch.databinding.ActivityMain3Binding;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding binding;
    private ArrayList<FoodPage> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String currentTime = dateFormat.format(new Date());
        binding.textTime.setText(currentTime);

        Intent intent = new Intent(this, MainActivity2.class);
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


        String dishName = getIntent().getStringExtra("dishName");

        foods = new ArrayList<>();
        foods.add(new FoodPage("Блинчики", R.drawable.ic_blinchik, R.drawable.blinchik, R.raw.blinchik));
        foods.add(new FoodPage("Борщ", R.drawable.ic_borsch, R.drawable.borsch, R.raw.borsch));
        foods.add(new FoodPage("Цезарь", R.drawable.ic_cesar, R.drawable.cesar, R.raw.cesar));
        foods.add(new FoodPage("Милкшейк", R.drawable.ic_milkshake, R.drawable.milkshake, R.raw.milkshake));
        foods.add(new FoodPage("Спагетти", R.drawable.ic_spagetti, R.drawable.spagetti, R.raw.spagetti));


        FoodPage selectedDish = findFoodPageByName(dishName);

        if (selectedDish != null) {

            binding.lImage.setImageResource(selectedDish.getLargeImage());


            binding.foodIco.setImageResource(selectedDish.getIcoResource());
            binding.foodName.setText(selectedDish.getName2());


            int textResourceId = selectedDish.getTextResource();
            String text = readTextFromResource(textResourceId);
            binding.textRecept.setText(text);
        }
    }


    private FoodPage findFoodPageByName(String name) {
        for (FoodPage foodPage : foods) {
            if (foodPage.getName2().equals(name)) {
                return foodPage;
            }
        }
        return null;
    }


    private String readTextFromResource(int resourceId) { //загрузка текста рецептов
        StringBuilder text = new StringBuilder();
        InputStream inputStream = getResources().openRawResource(resourceId);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        return text.toString();
    }
}