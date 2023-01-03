package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Contato;

public class ContatoDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Contato c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(c);
			transaction.commit();
		session.close();
	}
	
	public void update (Contato c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(c);
		transaction.commit();
	session.close();
	}
	
	public void delete (Contato c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(c);
		transaction.commit();
	session.close();
	}
	
	public Contato porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Contato c = (Contato) session.get(Contato.class, id);
			session.close();
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List <Contato> todosContatos(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Contato order by idContato desc");
			List<Contato> lista = query.list();
			session.close();
		return lista;
	}

}
