package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {


	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		//instanciando installment para test
		
		contract.getInstallments().add(new Installment(LocalDate.of(2022, 11, 01), 206.01));
	}
	
	
}
