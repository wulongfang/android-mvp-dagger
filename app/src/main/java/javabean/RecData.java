package javabean;

/**
 * Created by win10 on 2017/8/3.
 */

public class RecData {

    int imgSrc;

    public int getImgSrc() {
        return imgSrc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }


    public RecData(int imgSrc, String itemName) {
        this.imgSrc = imgSrc;
        this.itemName = itemName;
    }

    String itemName;
}
