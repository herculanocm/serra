package br.com.cunha.serra.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.cunha.serra.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("UsuarioDAO - UserDetails -> loadUserByUsername() - Buscando Usuario ");
		String jpql = "select u from Usuario u where u.login = :login";
		List<Usuario> users = em.createQuery(jpql,Usuario.class).setParameter("login", username).getResultList();
		if(users.isEmpty()){
			System.out.println("UsuarioDAO - UserDetails -> loadUserByUsername() - Usuario não existe ");
			throw new UsernameNotFoundException("O usuario "+username+" não existe");
		}
		System.out.println("Usuario buscado DAO : "+users.get(0).toString());
		return users.get(0);
	}
	
}
