package ru.netology;

import java.io.Serial;
import java.io.Serializable;

public class ProductString implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected String title;
    protected String category;
    protected String date;
    protected String sum;

    public ProductString(String title, String category, String date, String sum) {
        this.title = title;
        this.category = category;
        this.date = date;
        this.sum = sum;
    }



    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getSum() {
        return sum;
    }


}


