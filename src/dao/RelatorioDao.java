package dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Entrada;
import modelo.Saida;

public class RelatorioDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	Entrada e = new Entrada();
	EntradaDao ed = new EntradaDao();
	Saida s = new Saida();
	SaidaDao sd = new SaidaDao();
	
	public Double saldoTotal(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("select sum(valorEntrada) from Entrada");
			Double entrada = (Double) query.uniqueResult();
			query = session.createQuery("select sum(valorSaida) from Saida");
			Double saida = (Double) query.uniqueResult();
			Double saldo = entrada - saida;			
		return saldo;			
	}

}
