package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Servico;


public class ServicoDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create (Servico s) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.save(s);
			transaction.commit();
		session.close();
	}
	
	public void update (Servico s) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.update(s);
		transaction.commit();
	session.close();
	}
	
	public void delete (Servico s) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
			session.delete(s);
		transaction.commit();
	session.close();
	}
	
	public Servico porId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
			Servico s = (Servico) session.get(Servico.class, id);
			session.close();
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public List <Servico> todosServicos(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Servico order by idServico desc");
			List<Servico> lista = query.list();
			session.close();
		return lista;
	}

}
