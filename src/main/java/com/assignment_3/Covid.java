package com.assignment_3;

import java.util.Scanner;

public class Covid {
    private int numberOfVaccinees;

    public Covid() {
        this.numberOfVaccinees = 0;
    }

    public int getNumberOfVaccinees() {
        return numberOfVaccinees;
    }

    public void setNumberOfVaccinees(int numberOfVaccinees) {
        this.numberOfVaccinees = numberOfVaccinees;
    }

    public void requestVaccineInformation(Scanner scanner, boolean tableFormat) {
        System.out.println("Enter the number of vaccinees:");
        int numberOfVaccinees = scanner.nextInt();
        setNumberOfVaccinees(numberOfVaccinees);

        Vaccine[] vaccines = new Vaccine[numberOfVaccinees];

        // Creating vaccine objects for each vaccinee
        for (int i = 0; i < numberOfVaccinees; i++) {
            System.out.println("\nVaccine Information for Vaccinee " + (i + 1) + ":");
            vaccines[i] = Vaccine.createVaccineFromUserInput(scanner);
        }

        // Printing vaccine details based on the user-selected format
        System.out.println("\nPrinting Vaccine Details:");
        for (Vaccine vaccine : vaccines) {
            vaccine.display(tableFormat);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Covid covid = new Covid();

        // Requesting user input for display format
        System.out.println("Do you want to display vaccine details in table format? (true/false)");
        boolean tableFormat = scanner.nextBoolean();

        // Requesting vaccine information based on user-selected format
        covid.requestVaccineInformation(scanner, tableFormat);

        // Accessing the number of vaccinees after input
        System.out.println("\nNumber of Vaccinees: " + covid.getNumberOfVaccinees());
    }
}
