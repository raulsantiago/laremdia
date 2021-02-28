package app.br.laremdia.model.repository;

import app.br.laremdia.model.entity.LoginCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginClienteRepository extends JpaRepository< LoginCliente, Integer> {
}
