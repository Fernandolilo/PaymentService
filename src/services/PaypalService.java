package services;

public class PaypalService implements OnlinePaymentService{

	//calculo de taxa
	@Override
	public double paymenteFee(double amount) {
		return amount * 0.02;
	}

	//calculo de juros
	@Override
	public double interes(double amount, int months) {
		return amount * 0.01 * months;
	}

}
