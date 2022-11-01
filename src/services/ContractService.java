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
		// gerando parcelas e cobrando juros

		// o valor do contrato dividindo pelo numero de parcelas
		double basicQuota = contract.getTotalvalue() / months;
		for (int i = 1; i <= months; i++) {
			/*
			 * gerando um atributo tipo data, pegando a data em contrato, somando a data com
			 * o plusMonths que é um method the in Date java! na posição i
			 */
			LocalDate dueDate = contract.getDate().plusMonths(i);
			//juros
			double interes = onlinePaymentService.interes(basicQuota, i);
			
			//taxa
			double fee = onlinePaymentService.paymenteFee(basicQuota + interes);
			
			//value total			
			double quota = basicQuota + fee + interes;
			
			//add contract date e value the Installment
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
	}

}
