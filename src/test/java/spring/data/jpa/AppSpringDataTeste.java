package spring.data.jpa;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.data.jpa.dao.InterfaceSpringRepoUser;
import spring.data.jpa.dao.InterfaceTelefone;
import spring.data.jpa.model.Telefone;
import spring.data.jpa.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private  InterfaceSpringRepoUser interfaceSpringRepoUser;
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void testeTabela() {
		System.out.println("Criou o campo");
	}
	@Test
	public void testeInsert() {
		UsuarioSpringData uso = new UsuarioSpringData();
		uso.setEmail("panqueca@gmail.com");
		uso.setLogin("panqueca");
		uso.setSenha("123");
		uso.setIdade(25);
		uso.setNome("ciclano_Ciclano");
		
		interfaceSpringRepoUser.save(uso);
	}
	@Test
	public void consulta(){
		Optional<UsuarioSpringData> uso = interfaceSpringRepoUser.findById(10L);
		 System.out.println("Nome :"+uso.get().getNome());
		 System.out.println("Email :"+uso.get().getEmail());
		 List<Telefone> lista = uso.get().getTelefones();
		 
		 for (Telefone telefone : uso.get().getTelefones()) {
			System.out.println("Numero " + telefone.getNumero());
		}
			 
		 	
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
	
	@Test
	public void testeDelete() {
		
		interfaceSpringRepoUser.deleteById(5L);
	}
	@Test
	public void testeDelete02() {
		Optional<UsuarioSpringData> uso = interfaceSpringRepoUser.findById(3L);
		interfaceSpringRepoUser.delete(uso.get());
	}
	
	@Test
	public void testConsultaNome() {
		List<UsuarioSpringData> lista  = interfaceSpringRepoUser.buscaPorNome("ci");
		
		 for (UsuarioSpringData uso : lista) {
			  System.out.println("Nome :"+uso.getNome());
			  System.out.println("Email :"+uso.getEmail());
			  System.out.println("Login :"+uso.getLogin());
			  System.out.println("--------------------------------");
		}
	}
	@Test
	public void testBuscarPorNome() {
		
		 UsuarioSpringData uso =  interfaceSpringRepoUser.buscaPorParametro("Beltrano");
		 System.out.println("Nome :"+uso.getNome());
		  System.out.println("Email :"+uso.getEmail());
		  System.out.println("Login :"+uso.getLogin());
		  System.out.println("--------------------------------");
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringRepoUser.deletePorNome("ciclano");
	}
	
	@Test
	public void testUpdateEmail() {
		String email = "cristianocoffy@bol.com.br";
		String nome = "Coffy";
		interfaceSpringRepoUser.updateEmail(email, nome);
	}
	@Test
	public void testTelefone() {
		Optional<UsuarioSpringData> uso = interfaceSpringRepoUser.findById(10L);
		Telefone fone = new Telefone();
		fone.setTipo("Celular");
		fone.setNumero("51 7998798");
		fone.setUsuarioSpringData(uso.get());
		interfaceTelefone.save(fone);
	}
}
