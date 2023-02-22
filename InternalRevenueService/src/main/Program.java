package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		List<Person> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		Integer payers = in.nextInt();

		for (int i = 1; i <= payers; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			Character person = in.next().charAt(0);
			if (person == 'i' || person == 'c') {
				System.out.print("Name: ");
				String name = in.next();
				System.out.print("Anual income:");
				Double anualIncome = in.nextDouble();
				if (person == 'i') {
					System.out.print("Health expenditures: ");
					Double healthExpends = in.nextDouble();
					list.add(new NaturalPerson(name, anualIncome, healthExpends));
				} else {
					System.out.print("Number of employees: ");
					Integer numberEmployees = in.nextInt();
					list.add(new LegalPerson(name, anualIncome, numberEmployees));
				}
			} else {
				System.out.println("Digito não condiz com as opções");
			}
		}

		System.out.println("\nTAXES PAID:");

		double totalTaxes = 0.00;
		for (Person person : list) {
			System.out.println(person);
			totalTaxes += person.taxes();
		}

		System.out.printf("\nTOTAL TAXES: $ %.2f", totalTaxes);

		in.close();
	}

}
