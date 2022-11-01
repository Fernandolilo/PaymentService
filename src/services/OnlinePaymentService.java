package services;

public interface OnlinePaymentService {

	//taxa
	double paymenteFee(double amount);
	
	//juros
	double interes(double amount, int months);
	
}
