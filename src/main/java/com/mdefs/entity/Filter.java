package com.mdefs.entity;

import java.util.List;

public class Filter {

    private String searchFirstName;
    private String searchLastName;
    private String searchPhone;

    private List<Phone> list;

    public String getSearchFirstName() {
        return searchFirstName;
    }

    public void setSearchFirstName(String searchFirstName) {
        this.searchFirstName = searchFirstName;
    }

    public String getSearchLastName() {
        return searchLastName;
    }

    public void setSearchLastName(String searchLastName) {
        this.searchLastName = searchLastName;
    }

    public String getSearchPhone() {
        return searchPhone;
    }

    public void setSearchPhone(String searchPhone) {
        this.searchPhone = searchPhone;
    }

    public List<Phone> getList() {
        return list;
    }

    public void setList(List<Phone> list) {
        this.list = list;
    }

}
