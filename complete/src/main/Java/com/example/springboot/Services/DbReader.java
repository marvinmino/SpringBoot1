package com.example.springboot.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.springboot.Interfaces.DataReader;
import com.example.springboot.Models.Person;

public class DbReader implements DataReader {
    private Connection _connect = null;
    private Statement _statement = null;
    private ResultSet _resultSet = null;

    public DbReader() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        _connect = DriverManager
                .getConnection("jdbc:mysql://195.179.236.1:3306/u323045651_citta?"
                        + "user=u323045651_java&password=P3MYEx!,Q!d!");
        _statement = _connect.createStatement();
        _resultSet = _statement
                .executeQuery("select * from u323045651_citta.citta");
    }

    public boolean HasNew() throws SQLException {
        if (_resultSet.next()) {
            return true;
        } else {
            if (_resultSet != null) {
                _resultSet.close();
            }

            if (_statement != null) {
                _statement.close();
            }

            if (_connect != null) {
                _connect.close();
            }
        }

        return false;
    }

    public Person ReadNext() throws SQLException {
        String nome = _resultSet.getString("nome");
        String cognome = _resultSet.getString("cognome");
        String indirizzo = _resultSet.getString("indirizzo");
        String citta = _resultSet.getString("citta");

        return new Person(nome, cognome, citta, indirizzo);
    }
}
