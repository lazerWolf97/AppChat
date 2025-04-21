package umu.tds.AppChat.dao.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dao.UsuarioDAO;
import umu.tds.dominio.Usuario;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UsuarioRepository implements UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Usuario> findAll() {
		return em.createQuery("from Usuario").getResultList();
	}

	@Override
	public List<Usuario> findByName(String name) {
		return em.createQuery("select u from Usuario u where u.nombre like :nombre").setParameter("nombre", name).getResultList();
	}

	@Override
	public Optional<Usuario> findByID(String ID) {
		return em.createQuery("select u from Usuario u where u.numTLF like :id").setParameter("id", ID).getResultStream().findFirst();
	}

	@Override
	public void add(Usuario u) {
		em.persist(u);
	}
	
	@Override
	public void update(Usuario u) {
		em.merge(u);
	}
	
	@Override
	public void delete(String ID) {
		em.createQuery("delete from Usuario u where u.numTLF like :id").setParameter("id", ID).executeUpdate();
	}
	
	
}
