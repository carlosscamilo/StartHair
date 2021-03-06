package br.com.StartHair.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("StartHair");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) {
		return FACTORY.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
