package br.edu.infnet.mitjava.persistencia.jpa;

import javax.persistence.EntityManager;

import br.edu.infnet.mitjava.persistencia.DAO;
import br.edu.infnet.mitjava.persistencia.JpaUtil;

public class JpaDao<T> implements DAO<T> {

	protected EntityManager em;
	private Class clazz;
	
	public JpaDao(@SuppressWarnings("rawtypes") Class clazz) {
		super();
		this.clazz = clazz;
		em = JpaUtil.createEntityManager();
	}

	public void salvar(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void editar(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
			
	}

	@SuppressWarnings("unchecked")
	public T getById(Integer id) {
		return (T) em.find(clazz, id);
	}

	public void deletar(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
		
	}

}