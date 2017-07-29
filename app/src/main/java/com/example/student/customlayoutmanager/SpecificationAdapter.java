package com.example.student.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.customlayoutmanager.enums.LayoutGravity;
import com.example.student.customlayoutmanager.enums.SpanCount;
import com.example.student.customlayoutmanager.interfaces.LayoutInfoLookup;

import java.util.List;

/**
 * Адаптер для МаинАктивити
 */
public class SpecificationAdapter extends RecyclerView.Adapter {

    private static final int CATALOG_HEADER_VIEW_TYPE = 0;
    private static final int SPEC_USER_HEADER_VIEW_TYPE = 1;
    private static final int SPEC_USER_LIST_VIEW_TYPE = 2;
    private static final int SPEC_ABC_HEADER_VIEW_TYPE = 3;
    private static final int SPEC_ABC_LIST_VIEW_TYPE = 4;
    private static final int SPEC_EMPTY_VIEW_TYPE = 5;

    private DataModel dataModel;
    private List<String> nameList;
    private List<String> ageList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case CATALOG_HEADER_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.catalog_header_view_holder, parent, false);
                viewHolder = new CatalogHeaderViewHolder(view);
                break;
            case SPEC_USER_HEADER_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.specification_user_header_holder, parent, false);
                viewHolder = new SpecificationUserHeaderViewHolder(view);
                break;
            case SPEC_USER_LIST_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.specification_user_list_holder, parent, false);
                viewHolder = new SpecificationUserListViewHolder(view);
                break;
            case SPEC_ABC_HEADER_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.specification_abc_header_holder, parent, false);
                viewHolder = new SpecificationAbcHeaderViewHolder(view);
                break;
            case SPEC_ABC_LIST_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.specification_abc_list_holder, parent, false);
                viewHolder = new SpecificationAbcListViewHolder(view);
                break;
            case SPEC_EMPTY_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.specification_empty_holder, parent, false);
                viewHolder = new SpecificationEmptyViewHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {

        int firstListSize = 0;
        int secondListSize = 0;

        if (ageList == null && nameList == null) return 0;

        if (ageList != null)
            secondListSize = ageList.size();
        if (nameList != null)
            firstListSize = nameList.size();

        if (secondListSize > 0 && firstListSize > 0)
            // первый хедер, хедер "Спецификации", лист из спецификаций пользователя, хедер "ОТ ABC", список спецификаций от АВС
            return 1 + 1 + firstListSize + 1 + secondListSize;
        else if (secondListSize > 0 && firstListSize == 0)
            return 1 + 1 + secondListSize;                       // первый хедер, хедер "ОТ ABC",, список спецификаций от АВС
        else if (secondListSize == 0 && firstListSize > 0)
            return 1 + 1 + firstListSize;                            // первый хедер, хедер "Спецификации", лист из спецификаций пользователя
        else return 0;
    }

    @Override
    public int getItemViewType(int position) {
        int firstListSize = 0;
        int secondListSize = 0;

        if (ageList == null && nameList == null)
            return super.getItemViewType(position);

        if (ageList != null)
            secondListSize = ageList.size();
        if (nameList != null)
            firstListSize = nameList.size();

        if (secondListSize > 0 && firstListSize > 0) {
            if (position == 0) return CATALOG_HEADER_VIEW_TYPE;
            else if (position == 1)
                return SPEC_USER_HEADER_VIEW_TYPE;
            else if (position == secondListSize + 1)
                return SPEC_ABC_HEADER_VIEW_TYPE;
            else if (position > firstListSize + 1)
                return SPEC_USER_LIST_VIEW_TYPE;
            else return SPEC_ABC_LIST_VIEW_TYPE;

        } else if (secondListSize > 0 && firstListSize == 0) {
            if (position == 0) return CATALOG_HEADER_VIEW_TYPE;
            else if (position == 1)
                return SPEC_USER_HEADER_VIEW_TYPE;
            else if (position == 2) return SPEC_EMPTY_VIEW_TYPE;
            else if (position == 3) {
                return SPEC_ABC_HEADER_VIEW_TYPE;
            } else return SPEC_ABC_LIST_VIEW_TYPE;

        } else if (secondListSize == 0 && firstListSize > 0) {
            if (position == 0)
                return CATALOG_HEADER_VIEW_TYPE;
            else if (position == 1) {
                return SPEC_USER_HEADER_VIEW_TYPE;
            } else return SPEC_USER_LIST_VIEW_TYPE;
        }

        return super.getItemViewType(position);
    }

    public void setData(DataModel dataModel) {
        this.dataModel = dataModel;
        nameList = dataModel.getNameList();
        ageList = dataModel.getAgeList();
        notifyDataSetChanged();
    }

    private class CatalogHeaderViewHolder extends RecyclerView.ViewHolder {

        public CatalogHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SpecificationUserHeaderViewHolder extends RecyclerView.ViewHolder {

        public SpecificationUserHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SpecificationUserListViewHolder extends RecyclerView.ViewHolder {

        public SpecificationUserListViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SpecificationAbcHeaderViewHolder extends RecyclerView.ViewHolder {

        public SpecificationAbcHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SpecificationAbcListViewHolder extends RecyclerView.ViewHolder {

        public SpecificationAbcListViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SpecificationEmptyViewHolder extends RecyclerView.ViewHolder {

        public SpecificationEmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public LayoutInfoLookup getLayoutInfoLookup() {
        return layoutInfoLookup;
    }

    private final LayoutInfoLookup layoutInfoLookup = new LayoutInfoLookup() {
        @Override
        public SpanCount getRowSpan(int position) {
            return SpanCount.ONE;
        }

        @Override
        public SpanCount getColumnSpan(int position) {
            int viewType = getItemViewType(position);
            if (viewType == CATALOG_HEADER_VIEW_TYPE ||
                    viewType == SPEC_ABC_HEADER_VIEW_TYPE ||
                    viewType == SPEC_USER_HEADER_VIEW_TYPE) {
                return SpanCount.TWO;
            } else {
                return SpanCount.ONE;
            }
        }

        @Override
        public boolean useViewSize(int position) {
           /* int viewType = getItemViewType(position);
            if (viewType == SPEC_USER_LIST_VIEW_TYPE || viewType == SPEC_ABC_LIST_VIEW_TYPE) {
                return true;
            } else {
                return false;
            }*/
            return true;
        }

        @Override
        public LayoutGravity getGravity(int position) {
            int viewType = getItemViewType(position);
            if (viewType == SPEC_USER_LIST_VIEW_TYPE || viewType == SPEC_ABC_LIST_VIEW_TYPE) {
                return position % 2 == 0 ? LayoutGravity.LEFT : LayoutGravity.RIGHT;
            } else {
                return LayoutGravity.LEFT;
            }
        }
    };
}
