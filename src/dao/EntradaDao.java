package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Entrada;


public class EntradaDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Entrada e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(e);
			transaction.commit();
		session.close();
	}
	
	public void update (Entrada e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(e);
		transaction.commit();
	session.close();
	}
	
	public void delete (Entrada e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(e);
		transaction.commit();
	session.close();
	}
	
	public Entrada porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Entrada e = (Entrada) session.get(Entrada.class, id);
			session.close();
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public List <Entrada> todasEntradas(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Entrada order by idEntrada desc");
			List<Entrada> lista = query.list();
			session.close();
		return lista;
	}
	
	public Double somaEntradas(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("select sum(valorEntrada) from Entrada");
			Double soma = (Double) query.uniqueResult();
		return soma;
			
	}

}
