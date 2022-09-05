package com.example.springboot.Services;

import java.util.HashMap;
import java.util.HashSet;

import com.example.springboot.Interfaces.DataReader;
import com.example.springboot.Models.Person;

public class PerformCalculations {
    public HashMap Perform(DataReader dataReader) throws Exception {
        HashSet<String> names = new HashSet<String>();
        HashSet<String> cities = new HashSet<String>();

        while (dataReader.HasNew()) {
            Person person = dataReader.ReadNext();
            names.add(person.get_name());
            cities.add(person.get_city());
        }

        HashMap result = new HashMap();
        result.put("city_count", cities.size());
        result.put("name_count", names.size());
        return result;
    }
}
