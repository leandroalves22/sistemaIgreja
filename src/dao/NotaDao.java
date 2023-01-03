package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Nota;

public class NotaDao {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;

	public void create(Nota n) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(n);
		transaction.commit();
		session.close();
	}

	public void update(Nota n) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(n);
		transaction.commit();
		session.close();
	}

	public void delete(Nota n) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(n);
		transaction.commit();
		session.close();
	}

	public Nota porId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		Nota n = (Nota) session.get(Nota.class, id);
		session.close();
		return n;
	}

	@SuppressWarnings("unchecked")
	public List<Nota> todasNotas() {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Nota");
		List<Nota> notas = query.list();
		session.close();
		return notas;
	}
	
	public Integer contaNota() {
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Nota");
			int total = query.list().size();
		return total;		
	}

}
