package com.tce.sampleapp;

public class FeedModel {
    private String Title,Subtitle; //Title and Subtitle are taken as String Inputs
    private int Image; // as Res id is in int format , image is taken as int format

    public String getTitle() {
        return Title;
    }

    public FeedModel(String title, String subtitle, int image) {
        Title = title;
        Subtitle = subtitle;
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
