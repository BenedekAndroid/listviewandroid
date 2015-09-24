package com.benedek.listview;

import android.graphics.drawable.Drawable;

/**
 * Created by pbenedek on 9/24/15.
 */
public class Row {

    private int drawableId;
    private String text;

    public Row(int drawableId, String text) {
        this.drawableId = drawableId;
        this.text = text;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getText() {
        return text;
    }
}
