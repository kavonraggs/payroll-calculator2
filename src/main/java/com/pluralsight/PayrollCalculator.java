package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args)  {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;
            bufReader.readLine();
            while ((input = bufReader.readLine()) != null) {
                String[] employeeInfo = input.split("\\|");

                int employeeId = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);


                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.printf("""
                                Employee ID: %d\s
                                 Name: %s\s
                                 Hours Worked: %.2f\s
                                 Pay Rate: $%.2f\s
                                 Gross Pay: $%.2f""",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getHoursWorked(),
                        employee.getPayRate(),
                        employee.getGrossPay());
                System.out.println();
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }