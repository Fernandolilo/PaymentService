package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

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

		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(obj, n);
		
		System.out.println("parcelas: ");
		
		for(Installment installment: obj.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();

	}

}
