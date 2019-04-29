package nalog.nak;

public class tax {
	public double calcTax(double d,double pr) {
	// переменная tax хранит результат вычисления
			double tax;
			// try отлавливает исключения
			try {
				// алгоритм расчета налога

				tax = pr/100*d;


			}
			// обработчик ошибок заносит -1 в tax в случае возникновения исключения
			catch (ArithmeticException exception) {
				tax = -1;
			}
			return tax;
}
	public double calcTax2(double d,double pr) {
		// переменная tax хранит результат вычисления
				double tax2;
				// try отлавливает исключения
				try {
					// алгоритм расчета налога

					tax2 = d - pr/100*d;


				}
				// обработчик ошибок заносит -1 в tax в случае возникновения исключения
				catch (ArithmeticException exception) {
					tax2 = -1;
				}
				return tax2;
	}
}