package com.assignment_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.Scanner;
@SpringBootApplication
class Vaccine {
	private int id;
	private String name;
	private double cost;
	private static int quantity;
	private Date expiryDate;

	public Vaccine() {
		this.id = 0;
		this.name = "Unknown";
		this.cost = 0.0;
		this.quantity = 0;
		this.expiryDate = new Date();
	}

	public Vaccine(int id, String name, double cost, int quantity, Date expiryDate) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void display(boolean tableFormat) {
		if (tableFormat) {
			System.out.println("SKU | Vaccine Name | Unit Cost | QTY | Expiry");
			System.out.println("----|--------------|-----------|-----|--------");
			System.out.printf("%-3d | %-13s | %-9.2f | %-3d | %s\n", this.id, this.name, this.cost, this.quantity, (new SimpleDateFormat("MM/dd/yyyy")).format(this.expiryDate));
		} else {
			System.out.println("SKU: " + this.id);
			System.out.println("Vaccine Name: " + this.name);
			System.out.println("Unit Cost: " + this.cost);
			System.out.println("Quantity on hand: " + this.quantity);
			System.out.println("Expiry Date: " + (new SimpleDateFormat("MM/dd/yyyy")).format(this.expiryDate));
		}
	}

	public static Vaccine createVaccineFromUserInput(Scanner scanner) {
		Vaccine vaccine = new Vaccine();
		System.out.println("\nEnter ID:");
		int id = 0;
		boolean validId = false;

		while (!validId) {
			if (scanner.hasNextInt()) {
				id = scanner.nextInt();
				if (id > 0) {
					validId = true;
				} else {
					System.out.println("Please enter a valid positive integer for ID:");
				}
			} else {
				System.out.println("Please enter a valid positive integer for ID:");
				scanner.next(); // Clear the input buffer
			}
		}
		scanner.nextLine(); // Consume the newline character left by nextInt()

		// Follow a similar approach for other fields (name, cost, quantity, expiryDate)

		// Input for Name
		System.out.println("Enter Vaccine Name:");
		String name = scanner.nextLine();

		// Input for Cost
		System.out.println("Enter Unit Cost:");
		double cost = 0.0;
		boolean validCost = false;

		while (!validCost) {
			if (scanner.hasNextDouble()) {
				cost = scanner.nextDouble();
				if (cost >= 0.0) {
					validCost = true;
				} else {
					System.out.println("Please enter a valid positive number for Cost:");
				}
			} else {
				System.out.println("Please enter a valid number for Cost:");
				scanner.next(); // Clear the input buffer
			}
		}
		scanner.nextLine(); // Consume the newline character left by nextDouble()

		// Input for Quantity
		// Similar approach for quantity input...

		// Input for Expiry Date
		System.out.println("Enter Expiry Date (MM/dd/yyyy):");
		Date expiryDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		while (expiryDate == null) {
			String dateString = scanner.nextLine();
			try {
				expiryDate = dateFormat.parse(dateString);
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please enter the date in MM/dd/yyyy format:");
			}
		}

		vaccine.setId(id);
		vaccine.setName(name);
		vaccine.setCost(cost);
		vaccine.setQuantity(quantity);
		vaccine.setExpiryDate(expiryDate);
		return vaccine;
	}
}
