package com.example.student.customlayoutmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SpecificationAdapter specificationAdapter;
    private SpecificationLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initRecycler();
        setupRecycler();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
    }

    private void initRecycler() {
        StaggeredGridLayoutManager test = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        specificationAdapter = new SpecificationAdapter();
        //HeaderAdapter headerAdapter = new HeaderAdapter(specificationAdapter);
        recyclerView.setAdapter(specificationAdapter);

        ExStaggeredGridLayoutManager staggeredGridLayoutManager = new ExStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup((SpecificationAdapter) recyclerView.getAdapter(), staggeredGridLayoutManager.getSpanCount()));
        recyclerView.setLayoutManager(test);
    }

    private void setupRecycler() {
        List<String> stringList = new ArrayList<>();
        List<String> ageList = new ArrayList<>();
        for (int i=0; i < 21; i++) {
                stringList.add("stringList"+i);
        }
        for (int i=0; i < 10; i++) {
            ageList.add("ageList"+i);
        }
        specificationAdapter.setData(new DataModel("Surf", "Mail.ru", stringList, ageList));
    }
}
