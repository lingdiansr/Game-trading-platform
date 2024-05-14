package com.hnucm.c202201020245.entity;

import java.util.List;

public class ShopCarShopItem {
    private boolean selected;
    private String shopName;
    private List<ShopCarGoodItem> shopCarGoods;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<ShopCarGoodItem> getShopCarGoods() {
        return shopCarGoods;
    }

    public void setShopCarGoods(List<ShopCarGoodItem> shopCarGoods) {
        this.shopCarGoods = shopCarGoods;
    }
}
