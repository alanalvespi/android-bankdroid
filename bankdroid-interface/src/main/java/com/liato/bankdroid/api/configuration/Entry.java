package com.liato.bankdroid.api.configuration;

public class Entry {

    private final String mKey;
    private final String mValue;

    public Entry(String key, String value) {
        mKey = key;
        mValue = value;
    }

    public String getKey() {
        return mKey;
    }

    public String getValue() {
        return mValue;
    }
}
