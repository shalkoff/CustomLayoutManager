package com.example.student.customlayoutmanager;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by pkorl on 30.07.2017.
 */

public class HeaderSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    private SpecificationAdapter adapter;
    private int mSpanSize = 1;

    public HeaderSpanSizeLookup(SpecificationAdapter adapter, int spanSize) {
        this.adapter = adapter;
        this.mSpanSize = spanSize;
    }

    @Override
    public int getSpanSize(int position) {
        boolean isHeaderOrFooter = false;
        return isHeaderOrFooter ? mSpanSize : 1;
    }
}