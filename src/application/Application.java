package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número do contrato: ");

		int number = sc.nextInt();

		System.out.print("Data (dd/mm/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Valor do contrato: ");
		double totalValue =  sc.nextDouble();
		
		Contract obj = new Contract(number, data, totalValue);

		sc.close();

	}

}
