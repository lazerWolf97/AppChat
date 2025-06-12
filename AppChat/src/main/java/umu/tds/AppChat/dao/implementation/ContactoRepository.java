package umu.tds.AppChat.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.ContactoDAO;
import umu.tds.dominio.Contacto;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ContactoRepository implements ContactoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Contacto> findAll() {
		return em.createQuery("from Contacto").getResultList();
	}

	@Override
	public List<Contacto> findByName(String name) {
		return em.createQuery("select c from Contacto c where c.nombre like :name")
				.setParameter("name", name).getResultList();
	}
}
