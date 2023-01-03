package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Membro;

public class MembroDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Membro m) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(m);
			transaction.commit();
		session.close();
	}
	
	public void update (Membro m) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(m);
		transaction.commit();
	session.close();
	}
	
	public void delete (Membro m) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(m);
		transaction.commit();
	session.close();
	}
	
	public Membro porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Membro m = (Membro) session.get(Membro.class, id);
			session.close();
		return m;
	}
	
	@SuppressWarnings("unchecked")
	public List <Membro> todosMembros(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Membro order by idMembro desc");
			List<Membro> lista = query.list();
			session.close();
		return lista;
	}
	
	public Integer contaMembro() {
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Membro m where m.ativo = 'SIM'");
			int total = query.list().size();
		return total;
		
	}
	
	@SuppressWarnings("unchecked")
	public List <Membro> aniversariantes(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Membro m where month(dataNascimento) = month(now()) and m.ativo = 'SIM'");
			List<Membro> lista = query.list();
			session.close();
		return lista;
	}

}
