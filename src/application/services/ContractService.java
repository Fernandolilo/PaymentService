package application.services;

import java.time.LocalDate;

import application.entities.Contract;
import application.entities.Installment;

public class ContractService {

	private  OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		//pegando o valor do contrato de dividindo pelos numero de parcelas;
		double basicQuota = contract.getTotalValue() / months;
		
		for(int i = 1; i <= months; i++) {
			
			//pegamos um localDate => busca o date do conrato => 
			//o plusMonths faz a soma da data original mais 1 mes 
			//é um method do Localdate
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(basicQuota, i);
			// calculo de juros por parcela
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			
			double quota = basicQuota + interest + fee;
			
			contract.getInstallments().add(new Installment(dueDate, quota));
			
		}
	}
	
}
