package app.br.laremdia;

import app.br.laremdia.model.entity.LoginCliente;
import app.br.laremdia.model.entity.LoginProfissional;
import app.br.laremdia.model.repository.LoginClienteRepository;
import app.br.laremdia.model.repository.LoginProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LaremdiaApplication {

	@Bean
	public CommandLineRunner commandLineRunner(
			@Autowired LoginProfissionalRepository repository, LoginClienteRepository repositoryCli){
		return args -> {
			LoginProfissional loginProfissional = new LoginProfissional();
			loginProfissional.setNome("Jaq");
			loginProfissional.setEmail("jaq@gmail.com");
			loginProfissional.setSenha("123");
			loginProfissional.setAtivo(true);
			repository.save(loginProfissional);

			LoginCliente loginCliente = new LoginCliente();
			loginCliente.setNome("Marcia");
			loginCliente.setEmail("marcia@gmail.com");
			loginCliente.setSenha("123");
			loginCliente.setEndereco("Rua Rafa Audax");
			loginCliente.setNumero("1005");
			loginCliente.setBairro("Laranjeiras");
			loginCliente.setEstado("RJ");
			loginCliente.setMunicipio("Rio de Janeiro");
			loginCliente.setAtivo(true);
			repositoryCli.save(loginCliente);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LaremdiaApplication.class, args);
	}

}
