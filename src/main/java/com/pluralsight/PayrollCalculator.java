/*
Java application named PayrollCalculator. You will read employee
data from a .csv file and generate the pay information for each employee. For
this exercise read the file using either the BufferedReader.
 */
package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            // Create file reader and buffered reader
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Make an array of employees
            String[] tokens;

            // Skip over the first line of headers
            bufferedReader.readLine();

            // Read each line from the file until it is empty
            int i = 0;
            String input;
            while ((input = bufferedReader.readLine()) != null) {

                // Split each line into individual fields using the | character as the delimiter
                tokens = input.split("\\|");
                Employee[] employees = new Employee[tokens.length];

                // Create a new employee object with each token
                employees[i] = new Employee(Integer.parseInt(tokens[i]),
                            tokens[i + 1], Float.parseFloat(tokens[i + 2]),
                            Float.parseFloat(tokens[i + 3]));

                // Display the employee info
                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f \n",employees[i].getEmployeeId(),
                            employees[i].getName(), employees[i].getGrossPay());
            }

            // Close the buffered reader
            bufferedReader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}