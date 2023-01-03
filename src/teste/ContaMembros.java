package teste;

import dao.MembroDao;

public class ContaMembros {

	public static void main(String[] args) {
		
		MembroDao dao = new MembroDao();
		
		int total = dao.contaMembro();
		
		System.out.println(total);
	

	}

}
