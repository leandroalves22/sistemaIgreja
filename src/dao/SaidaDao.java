package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Saida;



public class SaidaDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Saida s) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(s);
			transaction.commit();
		session.close();
	}
	
	public void update (Saida s) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(s);
		transaction.commit();
	session.close();
	}
	
	public void delete (Saida s) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(s);
		transaction.commit();
	session.close();
	}
	
	public Saida porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Saida s = (Saida) session.get(Saida.class, id);
			session.close();
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public List <Saida> todasSaidas(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Saida order by idSaida desc");
			List<Saida> lista = query.list();
			session.close();
		return lista;
	}

}
