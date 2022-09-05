package com.example.springboot;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Factories.Factory;
import com.example.springboot.Interfaces.DataReader;
import com.example.springboot.Services.PerformCalculations;

@RestController
public class ReaderController {

	private Factory factory = Factory.getInstance();

	@GetMapping("/file-reader")
	public HashMap fileReader() {
		HashMap result = new HashMap();
		try {
			DataReader reader = factory.getReader("src/main/java/com/example/springboot/file.txt");

			PerformCalculations calculator = new PerformCalculations();

			return calculator.Perform(reader);
		} catch (FileNotFoundException e) {
			result.put("error", "File not found");
		} catch (Exception e) {
			result.put("error", "There was an error with the system");
		}
		return result;
	}

	@GetMapping("/db-reader")
	public HashMap database() {
		HashMap result = new HashMap();

		try {
			DataReader reader = factory.getReader("");

			PerformCalculations calculator = new PerformCalculations();

			return calculator.Perform(reader);
		} catch (SQLException e) {
			result.put("error", "There was an error with the database");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", "There was an error with the system");
		}

		return result;
	}
}
