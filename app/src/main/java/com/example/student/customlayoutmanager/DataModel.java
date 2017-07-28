package com.example.student.customlayoutmanager;

import java.util.List;

/**
 * Модель данных
 */
public class DataModel {

    private String name;
    private String age;
    private List<String> nameList;
    private List<String> ageList;

    public DataModel(String name, String age, List<String> nameList, List<String> ageList) {
        this.name = name;
        this.age = age;
        this.nameList = nameList;
        this.ageList = ageList;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public List<String> getAgeList() {
        return ageList;
    }
}
