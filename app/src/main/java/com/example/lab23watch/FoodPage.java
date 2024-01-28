package com.example.lab23watch;

public class FoodPage {
    private String name;
    private int icoResource;
    private int largeImage;
    private int textResource;

    public FoodPage(String name, int icoResource, int largeImage, int textResource){
        this.name = name;
        this.icoResource = icoResource;
        this.largeImage = largeImage;
        this.textResource = textResource;
    }

    public String getName2() {
        return name;
    }

    public int getIcoResource() {
        return icoResource;
    }

    public int getLargeImage() {
        return largeImage;
    }

    public int getTextResource() {
        return textResource;
    }
}