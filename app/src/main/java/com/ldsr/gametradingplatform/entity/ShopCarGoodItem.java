package com.ldsr.gametradingplatform.entity;

public class ShopCarGoodItem {
    private boolean selected;
    private String imgUrl;
    private String title;
    private String ShippingForm;
    private double price;
    private int number;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShippingForm() {
        return ShippingForm;
    }

    public void setShippingForm(String shippingForm) {
        ShippingForm = shippingForm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
