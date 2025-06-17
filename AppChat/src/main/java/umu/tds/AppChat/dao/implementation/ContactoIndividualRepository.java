package umu.tds.AppChat.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.ContactoIndividualDAO;
import umu.tds.dominio.ContactoIndividual;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ContactoIndividualRepository implements ContactoIndividualDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ContactoIndividual> findAll() {
		return em.createQuery("from ContactoIndividual").getResultList();
	}

	@Override
	public List<ContactoIndividual> findByName(String name) {
		return em.createQuery("select c from ContactoIndividual c where c.nombre like :name")
				.setParameter("name", name).getResultList();
	}

	@Override
	public void add(ContactoIndividual c) {
		em.persist(c);
	}

	@Override
	public void delete(String ID) {
		em.createQuery("delete from ContactoIndividual c where c.id = :id")
			.setParameter("id", ID).executeUpdate();
	}

}
