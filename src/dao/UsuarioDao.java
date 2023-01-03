package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Usuario;

public class UsuarioDao {
	
	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	
	public void create(Usuario u) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();	
			transaction = session.beginTransaction();
				session.save(u);
			transaction.commit();
		session.close();			
	}		
	
	public void update(Usuario u) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();			
			transaction = session.beginTransaction();
				session.update(u);
			transaction.commit();
		session.close();
	}
	
	public void delete(Usuario u) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
				session.delete(u);
			transaction.commit();
		session.close();
	}
	
	public Usuario porId(Integer id){
		session = HibernateUtil.getSessionFactory().openSession();
			Usuario s = (Usuario) session.get(Usuario.class, id);
			session.close();
		return s;		
	}
	
	@SuppressWarnings("unchecked")
	public List <Usuario> listaTodos(){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Usuario order by idUsuario desc");			
			List<Usuario> lista = query.list();
			session.close();
		return lista;
	}
	
	public Usuario logar(Usuario u){
		session = HibernateUtil.getSessionFactory().openSession();			
				query = session.createQuery("from Usuario where login=:param1 and senha=:param2");
				query.setString("param1", u.getLogin());
				query.setString("param2", u.getSenha());
			Usuario user = (Usuario) query.uniqueResult();
		session.close();
		return user;
	}	
	
	public Integer contaUsuario() {
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Usuario");
			int total = query.list().size();
		return total;
		
	}
	
}
