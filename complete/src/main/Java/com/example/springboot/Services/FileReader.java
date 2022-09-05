package com.example.springboot.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.example.springboot.Interfaces.DataReader;
import com.example.springboot.Models.Person;

public class FileReader implements DataReader {
    private String _filePath;
    private File _file;
    private Scanner _scanner;

    public FileReader(String filePath) throws FileNotFoundException {
        _filePath = filePath;
        _file = new File(_filePath);

        if (!_file.exists()) {
            throw new FileNotFoundException("File not found");
        }

        _scanner = new Scanner(_file);
    }

    public boolean HasNew() {
        if (_scanner.hasNextLine()) {
            return true;
        }
        _scanner.close();
        return false;
    }

    public Person ReadNext() {
        String data = _scanner.nextLine();
        return new Person(data.split(","));
    }
}