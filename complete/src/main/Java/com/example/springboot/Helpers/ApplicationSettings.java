package com.example.springboot.Helpers;

import java.sql.SQLException;
import java.util.Random;

import com.example.springboot.Interfaces.DataReader;
import com.example.springboot.Services.DbReader;
import com.example.springboot.Services.FileReader;

public class ApplicationSettings {
    private static ApplicationSettings _instance;

    private ApplicationSettings() {
    }

    public static ApplicationSettings getInstance() {
        if (_instance == null) {
            _instance = new ApplicationSettings();
        }

        return _instance;
    }

    public DataReader getReader(String path) throws Exception {
        if (path.equals("")) {
            return new DbReader();
        }
        return new FileReader(path);
    }
}
