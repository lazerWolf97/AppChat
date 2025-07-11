package umu.tds.AppChat.dao.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.ContactoIndividualDAO;
import umu.tds.AppChat.dominio.ContactoIndividual;

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
	
	public List<ContactoIndividual> findByNameAndUser(String name, String userID) {
		return em.createQuery("select c from ContactoIndividual c where c.nombre like :name "
				+ "AND c.usuario = :id")
				.setParameter("id", userID)
				.setParameter("name", name).getResultList();
	}

	@Override
	public void add(ContactoIndividual c) {
		em.persist(c);
	}

	@Override
	public void delete(long ID) {
		em.createQuery("delete from ContactoIndividual c where c.id = :id")
			.setParameter("id", ID).executeUpdate();
	}

	@Override
	public void update(ContactoIndividual c) {
		em.merge(c);
	}

	@Override
	public Optional<ContactoIndividual> findByID(long ID) {
		return em.createQuery("select c from ContactoIndividual c where c.id = :id")
		.setParameter("id", ID).getResultStream().findFirst();
	}
	
	

}
