package com.example.student.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Адаптер с хедером
 */
public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CATALOG_HEADER_VIEW_TYPE = 0;
    private static final int SPEC_USER_HEADER_VIEW_TYPE = 1;
    private static final int SPEC_ABC_HEADER_VIEW_TYPE = 3;

    private RecyclerView.Adapter<RecyclerView.ViewHolder> mInnerAdapter;

    public HeaderAdapter(RecyclerView.Adapter innerAdapter) {
        setAdapter(innerAdapter);
    }

    public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {

        if (adapter != null) {
            if (!(adapter instanceof RecyclerView.Adapter))
                throw new RuntimeException("your adapter must be a RecyclerView.Adapter");
        }

        if (mInnerAdapter != null) {
            notifyItemRangeRemoved(1, mInnerAdapter.getItemCount());
        }

        this.mInnerAdapter = adapter;
        notifyItemRangeInserted(1, mInnerAdapter.getItemCount());
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.catalog_header_view_holder, parent, false));
        } else if (viewType == 1) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.specification_user_header_holder, parent, false));
        } else {
            return mInnerAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int headerViewsCountCount = 2;
        if (position >= headerViewsCountCount && position < headerViewsCountCount + mInnerAdapter.getItemCount()) {
            mInnerAdapter.onBindViewHolder(holder, position);
        } else {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0; // первый хедер
        } else if (position == 1) {
            return 1; // второй хедер
        } else {
            return 2; // список
        }
    }

    @Override
    public int getItemCount() {
        return 2 + mInnerAdapter.getItemCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
