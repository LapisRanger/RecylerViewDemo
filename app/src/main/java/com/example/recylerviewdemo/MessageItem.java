package com.example.recylerviewdemo;

public class MessageItem {
    private String name;
    private String text;
    private String sendTime;
    private int imgId;

    public MessageItem(String name, String text, String sendTime, int imgId) {
        this.name = name;
        this.text = text;
        this.sendTime = sendTime;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getImgId() {
        return imgId;
    }

    public String getSendTime() {
        return sendTime;
    }

}
