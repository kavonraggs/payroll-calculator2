package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the name of the file you are accessing?");
        String fileRead = scanner.nextLine();

        System.out.println("What do you want to name the file you are creating?");
        String fileCreated = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader(fileRead);
            BufferedReader bufReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(fileCreated);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            String input;

            bufReader.readLine();
            while ((input = bufReader.readLine()) != null) {
                String[] employeeInfo = input.split("\\|");

                int employeeId = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);


                try {
                    String text = String.format("%-5d | %-22s | $%6.2f", employeeId, name, (hoursWorked * payRate) );
                    bufWriter.write(text);
                    bufWriter.newLine();

                } catch (IOException e){
                    System.out.println("Error.");
                }

            }
            bufReader.close();
            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }