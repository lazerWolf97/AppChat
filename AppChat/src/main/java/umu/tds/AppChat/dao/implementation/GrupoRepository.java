package umu.tds.AppChat.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.GrupoDAO;
import umu.tds.AppChat.dominio.Grupo;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class GrupoRepository implements GrupoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Grupo> findAll() {
		return em.createQuery("from Grupo").getResultList();
	}
	
	@Override
	public List<Grupo> findByName(String name) {
		return em.createQuery("select g from Grupo g where g.nombre like :name")
		.setParameter("name", name).getResultList();
	}

	@Override
	public void add(Grupo g) {
		em.persist(g);
	}

	@Override
	public void delete(String ID) {
		em.createQuery("delete from Grupo g where g.id = :id").setParameter("id", ID).executeUpdate();
	}

}
