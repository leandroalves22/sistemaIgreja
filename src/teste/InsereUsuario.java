package teste;

import dao.UsuarioDao;
import modelo.Usuario;

public class InsereUsuario {

	public static void main(String[] args) {

		Usuario u = new Usuario();
		UsuarioDao dao = new UsuarioDao();

		try {
			u.setIdUsuario(null);
			u.setNomeUsuario("LEANDRO ALVES");
			u.setLogin("admin");
			u.setSenha("admin");
			dao.create(u);

			System.out.println("Dados Gravados");

		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}

	}

}
