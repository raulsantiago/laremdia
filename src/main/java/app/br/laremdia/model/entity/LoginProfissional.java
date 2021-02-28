package app.br.laremdia.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name="login_profissional")
public class LoginProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_profissional")
    private Integer idProfissional;

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

    @Column(nullable = true)
    private String foto;

    @Column(nullable = false)
    private Boolean ativo;

}
