package com.example.springboot.Factories;

import com.example.springboot.Helpers.ApplicationSettings;
import com.example.springboot.Interfaces.DataReader;

public class Factory {
    private static Factory _instance = null;

    private Factory() {
    }

    public static Factory getInstance() {
        if (_instance == null) {
            _instance = new Factory();
        }

        return _instance;
    }

    public DataReader getReader(String path) throws Exception {
        return ApplicationSettings.getInstance().getReader(path);
    }
}
