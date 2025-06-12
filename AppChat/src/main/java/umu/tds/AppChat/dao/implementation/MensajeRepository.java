package umu.tds.AppChat.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.MensajeDAO;
import umu.tds.dominio.Mensaje;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class MensajeRepository implements MensajeDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Mensaje> findAll() {
		return em.createQuery("from Mensaje").getResultList();
	}
	
	@Override
	public List<Mensaje> findByUser(String userID) {
		return em.createQuery("select m from Mensaje m where m.emisor like :id")
				.setParameter("id", userID).getResultList();
	}

	@Override
	public void add(Mensaje m) {
		em.persist(m);
	}
	
	@Override
	public void delete(String ID) {
		em.createQuery("delete from Mensaje m where m.id like :id").setParameter("id", ID).executeUpdate();
	}

}
