package app.br.laremdia.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name="login_cliente")
public class LoginCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer idCliente;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 70)
    private String email;

    @Column(nullable = true, length = 11)
    private String celular;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, length = 70)
    private String endereco;

    @Column(nullable = false, length = 15)
    private String numero;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = true, length = 30)
    private String complemento;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 30)
    private String municipio;

    @Column(nullable = true)
    private String referencia;

    @Column(nullable = true)
    private String foto;

    @Column(nullable = false)
    private Boolean ativo;

}
