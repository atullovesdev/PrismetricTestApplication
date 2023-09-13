package com.e.prismetrictestapplication.ListModel;

public class TopHorizintalModel {
    private int img;
    private String  img_title;

    public TopHorizintalModel(int img, String img_title) {
        this.img = img;
        this.img_title = img_title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getImg_title() {
        return img_title;
    }

    public void setImg_title(String img_title) {
        this.img_title = img_title;
    }
}
