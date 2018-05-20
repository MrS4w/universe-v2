package br.model.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ApplicationScoped
public class HibernateUtil {
	private EntityManagerFactory factory;

	public HibernateUtil() {
		this.factory = Persistence.createEntityManagerFactory("crudPU");
	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}

	public void cloceEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}