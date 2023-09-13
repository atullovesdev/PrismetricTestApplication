package com.e.prismetrictestapplication.ListModel;

public class DealsHorizintalModel {
    private int img_deals;
    private String dealsimg_title;
    private String dealsimg_smalltitle;

    public DealsHorizintalModel(int img_deals, String dealsimg_title, String dealsimg_smalltitle) {
        this.img_deals = img_deals;
        this.dealsimg_title = dealsimg_title;
        this.dealsimg_smalltitle = dealsimg_smalltitle;
    }

    public int getImg_deals() {
        return img_deals;
    }

    public void setImg_deals(int img_deals) {
        this.img_deals = img_deals;
    }

    public String getDealsimg_title() {
        return dealsimg_title;
    }

    public void setDealsimg_title(String dealsimg_title) {
        this.dealsimg_title = dealsimg_title;
    }

    public String getDealsimg_smalltitle() {
        return dealsimg_smalltitle;
    }

    public void setDealsimg_smalltitle(String dealsimg_smalltitle) {
        this.dealsimg_smalltitle = dealsimg_smalltitle;
    }
}
