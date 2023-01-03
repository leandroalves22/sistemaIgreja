package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Endereco;

public class EnderecoDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Endereco e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(e);
			transaction.commit();
		session.close();
	}
	
	public void update (Endereco e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(e);
		transaction.commit();
	session.close();
	}
	
	public void delete (Endereco e) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(e);
		transaction.commit();
	session.close();
	}
	
	public Endereco porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Endereco e = (Endereco) session.get(Endereco.class, id);
			session.close();
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public List <Endereco> todosContatos(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Endereco order by idEndereco desc");
			List<Endereco> lista = query.list();
			session.close();
		return lista;
	}

}
