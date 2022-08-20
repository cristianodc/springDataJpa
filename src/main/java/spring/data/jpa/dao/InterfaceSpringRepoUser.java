package spring.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.data.jpa.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringRepoUser extends CrudRepository<UsuarioSpringData, Long> {

}
