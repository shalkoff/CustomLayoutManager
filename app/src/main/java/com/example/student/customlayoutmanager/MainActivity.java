package com.example.student.customlayoutmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.student.customlayoutmanager.layoutmanagers.AdLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SpecificationAdapter specificationAdapter;
    private SpecificationLayoutManager layoutManager;
    private AdLayoutManager adLayoutManager;

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
        LinearLayoutManager test = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        specificationAdapter = new SpecificationAdapter();
        adLayoutManager = new AdLayoutManager(specificationAdapter.getLayoutInfoLookup());


        layoutManager = new SpecificationLayoutManager();
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(adLayoutManager);
        recyclerView.setAdapter(specificationAdapter);
    }

    private void setupRecycler() {
        List<String> stringList = new ArrayList<>();
        List<String> ageList = new ArrayList<>();
        for (int i=0; i < 20; i++) {
                stringList.add("stringList"+i);
                ageList.add("ageList"+i);
        }
        specificationAdapter.setData(new DataModel("Surf", "Mail.ru", stringList, ageList));
    }
}
