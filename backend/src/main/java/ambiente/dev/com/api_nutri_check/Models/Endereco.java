package ambiente.dev.com.api_nutri_check.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_enderecos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private Empresa empresa;
}
