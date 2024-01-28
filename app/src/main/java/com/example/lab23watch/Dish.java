package com.example.lab23watch;

public class Dish {
    private String name;
    private int foodResource;

    public Dish(String name, int food){

        this.name=name;

        this.foodResource=food;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDishResource() {
        return this.foodResource;
    }

    public void setDishResource(int foodResource) {
        this.foodResource = foodResource;
    }


}
