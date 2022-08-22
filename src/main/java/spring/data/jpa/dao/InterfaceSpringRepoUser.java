package spring.data.jpa.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringRepoUser extends CrudRepository<UsuarioSpringData, Long> {
	
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPorNome(String nome);
	
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
	public UsuarioSpringData buscaPorParametro(@Param("paramnome") String paramnome);
	
	@Modifying
	@Transactional
	@Query(value ="delete from UsuarioSpringData u where u.nome = ?1" )
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional
	@Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2 ")
	public void updateEmail(String email, String nome);
	
}
