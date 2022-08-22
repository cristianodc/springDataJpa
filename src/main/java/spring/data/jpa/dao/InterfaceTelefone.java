package spring.data.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.data.jpa.model.Telefone;
@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long>{

}
