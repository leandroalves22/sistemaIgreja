package teste;

import dao.RelatorioDao;

public class VerificaSaldo {

	public static void main(String[] args) {
		
		RelatorioDao rd = new RelatorioDao();
		Double saldo;

		try {
			saldo = rd.saldoTotal();
			System.out.println("Saldo Total: " + saldo);

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}

	}

}
