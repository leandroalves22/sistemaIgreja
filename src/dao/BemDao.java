package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Bem;

public class BemDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Bem b) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(b);
			transaction.commit();
		session.close();
	}
	
	public void update (Bem b) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(b);
		transaction.commit();
	session.close();
	}
	
	public void delete (Bem b) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(b);
		transaction.commit();
	session.close();
	}
	
	public Bem porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Bem b = (Bem) session.get(Bem.class, id);
			session.close();
		return b;
	}
	
	@SuppressWarnings("unchecked")
	public List <Bem> todosBens(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Bem order by idBem desc");
			List<Bem> lista = query.list();
			session.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List <Bem> inventario(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Bem order by local asc");
			List<Bem> lista = query.list();
			session.close();
		return lista;
	}
	
	public Integer contaBens() {
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Bem");
			Integer total = query.list().size();
		return total;
	}
	
	public Bem limparBem() {
		session = HibernateUtil.getSessionFactory().openSession();
			Bem bem = (Bem) session.createQuery("delete from Bem");
			return bem;		
	}

}
