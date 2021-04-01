package com.moondroid.deliveryservice.home;

public class StoreItem {
    int storeImgId;
    String name, minute, summary;

    public StoreItem() {
    }

    public StoreItem(int storeImgId, String name, String minute, String summary) {
        this.storeImgId = storeImgId;
        this.name = name;
        this.minute = minute;
        this.summary = summary;
    }
}
