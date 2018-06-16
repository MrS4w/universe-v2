package Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Hibernate.HibernateUtility;







public class Dao {
	
	private static Dao instance;
	private Session sessao;
	private Transaction tx;
	
	public Dao(){
		
	}
	
	public static Dao getInstance(){
		if(instance == null)
			instance = new Dao();
		return instance;
	}
	
	public <T> Object buscarPorId(Class<T> clazz, Long id){
		try{
			sessao = HibernateUtility.getSession();
			Object object = sessao.get(clazz, id);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> Object buscarPorChaveUnica(Class<T> clazz, Long codigo, String coluna){
		try{
			sessao = HibernateUtility.getSession();
			Object object = sessao.createCriteria(clazz).add(Restrictions.eq(coluna, codigo)).uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	
	
	public <T> boolean salvarObjeto(T objeto){
		try{
			sessao = HibernateUtility.getSession();
			tx = sessao.beginTransaction();
			sessao.save(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean salvarOuAtualizarObjeto(T objeto){
		try{
			sessao = HibernateUtility.getSession();
			tx = sessao.beginTransaction();
			sessao.saveOrUpdate(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}

	
	
	public <T> boolean deletarObjeto(T objeto){
		try{
			sessao = HibernateUtility.getSession();
			tx = sessao.beginTransaction();
			sessao.delete(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> listarObjetos(Class<?> classe){
		try{
			sessao = HibernateUtility.getSession();
			Criteria criteria = sessao.createCriteria(classe);
			return criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
		
	
	
	
}
