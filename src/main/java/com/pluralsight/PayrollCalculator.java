/*
Java application named PayrollCalculator. You will read employee
data from a .csv file and generate the pay information for each employee. For
this exercise read the file using either the BufferedReader.
 */
package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            // Scanner object to read file from user
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for the name of a file to read and process, then prompt them for
            //the name of the payroll file to create.
            System.out.print("Enter the name of the file employee file to process: ");
            String fileToProcess = scanner.nextLine();
            System.out.print("Enter the name of the payroll file to create: ");
            String fileToCreate = scanner.nextLine();

            // Create file writer and buffered writer
            FileWriter fileWriter = new FileWriter(fileToCreate);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);


            // Create file reader and buffered reader
            FileReader fileReader = new FileReader("src/main/resources/" + fileToProcess);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Make an array of tokens with employees information
            String[] tokens;

            // Skip over the first line of headers
            bufferedReader.readLine();
            // Write the header to new payroll file
            bufWriter.write("id|name|gross pay\n");

            // Read each line from the file until it is empty
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                // Split each line into individual fields using the | character as the delimiter
                tokens = input.split("\\|");

                // Create a new employee object with each token
                Employee employee = new Employee(Integer.parseInt(tokens[0]),
                        tokens[1],Float.parseFloat(tokens[2]),
                        Float.parseFloat(tokens[3]));

                // Rather than displaying your payroll report to the screen, write it to a .csv file in
                //the following format
                bufWriter.write(tokens[0] + "|" + tokens[1] + "|" + employee.getGrossPay() + "\n");


//                // Display the employee info
//                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f \n",employee.getEmployeeId(),
//                        employee.getName(), employee.getGrossPay());
            }

            // Close the buffered reader and buffered writer
            bufferedReader.close();
            bufWriter.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}