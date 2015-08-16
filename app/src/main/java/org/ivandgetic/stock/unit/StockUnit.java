package org.ivandgetic.stock.unit;

/**
 * Created by ivandgetic on 2015/7/19 0019.
 */
public class StockUnit {
    String name;
    String code;
    float price;
    float quoteChange;
    float change;

    public StockUnit(String name, String price, String change, String quoteChange) {
        this.name = name;
        this.price = Float.valueOf(price);
        this.change = Float.valueOf(change);
        this.quoteChange = Float.valueOf(quoteChange);
    }

    public StockUnit(String name, String code, float price, float quoteChange, float change) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quoteChange = quoteChange;
        this.change = change;
    }

    public float getChange() {

        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuoteChange() {
        return quoteChange;
    }

    public void setQuoteChange(float quoteChange) {
        this.quoteChange = quoteChange;
    }
}
