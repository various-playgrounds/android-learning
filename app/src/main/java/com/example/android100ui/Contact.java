package com.example.android100ui;

import java.util.ArrayList;
import java.util.List;

class Contact {
    private String name;
    private Boolean isOnline;

    public Contact(String name, Boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public static List<Contact> createContactLists(int limit) {
        List<Contact> lists = new ArrayList<Contact>();
        for(int i = 0; i < limit; i++) {
            lists.add(new Contact("lol", i % 2 == 0));
        }
        return lists;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOnline() {
        return this.isOnline;
    }
}
