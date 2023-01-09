package teste;

import dao.EntradaDao;

public class VerificaSaldo {

	public static void main(String[] args) {
		
		EntradaDao ed = new EntradaDao();
		Double soma;

		try {
			soma = ed.somaEntradas();

			System.out.println("Saldo Total: " + soma);

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}

	}

}
