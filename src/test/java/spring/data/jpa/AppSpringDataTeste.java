package spring.data.jpa;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.data.jpa.dao.InterfaceSpringRepoUser;
import spring.data.jpa.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private  InterfaceSpringRepoUser interfaceSpringRepoUser;
	
	@Test
	public void testeTabela() {
		System.out.println("Criou o campo");
	}
	@Test
	public void testeInsert() {
		UsuarioSpringData uso = new UsuarioSpringData();
		uso.setEmail("cristianocoffy@gmail.com");
		uso.setLogin("cris");
		uso.setSenha("123");
		uso.setIdade(30);
		uso.setNome("Panqueca");
		
		interfaceSpringRepoUser.save(uso);
	}
	@Test
	public void consulta(){
		Optional<UsuarioSpringData> uso = interfaceSpringRepoUser.findById(3L);
		 System.out.println("Nome :"+uso.get().getNome());
		 System.out.println("Email :"+uso.get().getEmail());
		}
	
	@Test
	public void testeBuscaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringRepoUser.findAll();
		
		  for (UsuarioSpringData uso : lista) {
			  System.out.println("Nome :"+uso.getNome());
			  System.out.println("Email :"+uso.getEmail());
			  System.out.println("Login :"+uso.getLogin());
			  System.out.println("--------------------------------");
		}
	}
	
	@Test
	public void testUpdate() {
		Optional<UsuarioSpringData> uso = interfaceSpringRepoUser.findById(4L);
		UsuarioSpringData data = uso.get();
		data.setLogin("Fulano");
		
		interfaceSpringRepoUser.save(data);
	}
}
