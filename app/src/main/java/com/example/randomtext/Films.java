package com.example.randomtext;

public class Films {
    String imgUrl;
    String name;

    public Films(String imgUrl, String name) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }
}
