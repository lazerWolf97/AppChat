package umu.tds.AppChat.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.ContactoDAO;
import umu.tds.dominio.Contacto;

@Repository
@Transactional
public class ContactoRepository implements ContactoDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacto> findAll() {
		return em.createQuery("from Contacto").getResultList();
	}

	@Override
	public void add(Contacto c) {
		em.persist(c);
	}
	
	
}
