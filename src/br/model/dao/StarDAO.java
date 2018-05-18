package br.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StarDAO {
	public void createStar(Star star) throws Exception {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(star);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao criar star");
		} finally {
			session.flush();
			session.close();
		}
	}

	public Star getStar(String starId) {

		Star star = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			star = (Star) session.get(Star.class, new Integer(starId));
		} finally {
			session.flush();
			session.close();
		}

		return star;
	}

	public void deleteStar(String starId) throws Exception {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Star star = (Star) session.load(Star.class, new String(starId));
			session.delete(star);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao excluir star");
		} finally {
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Star> listStars() {
		List<Star> stars = new ArrayList<Star>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			stars = session.createQuery("from Star").list();

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return stars;
	}

	public void updateStar(Star star) throws Exception {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(star);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error ao atualizar star");
		} finally {
			session.flush();
			session.close();
		}
	}
}
