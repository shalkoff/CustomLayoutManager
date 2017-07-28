package com.example.student.customlayoutmanager;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Кастомный лайаутМенеджер
 */
public class SpecificationLayoutManager extends RecyclerView.LayoutManager {


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void calculateItemDecorationsForChild(View child, Rect outRect) {
        super.calculateItemDecorationsForChild(child, outRect);
    }
}
