package com.example.springboot.Interfaces;

import com.example.springboot.Models.Person;

public interface DataReader {
    boolean HasNew() throws Exception;

    Person ReadNext() throws Exception;
}
