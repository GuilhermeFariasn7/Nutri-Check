package ambiente.dev.com.api_nutri_check.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresas") // Mudei para "empresas" se for o nome da tabela
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    private String alvara;

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

    @Column(name = "cnpj_cpf")
    private String cnpjCpf;

    private String telefone;
    private String fax;
    private String email;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;

    @Column(name = "ramo_atividade")
    private String ramoAtividade;

    @Column(name = "tipo_empresa")
    private String tipoEmpresa;

    @Column(name = "numero_funcionarios")
    private Integer numeroFuncionarios;

    @Column(name = "numero_turnos")
    private Integer numeroTurnos;

    @Column(name = "responsavel_manipulacao")
    private String responsavelManipulacao;

    @Column(name = "cpf_manipulador")
    private String cpfManipulador;

    @Column(name = "representante_legal")
    private String representanteLegal;

    @Column(name = "cpf_representante")
    private String cpfRepresentante;

    private String login;
    private String senha;

    @Column(name = "motivo_inspecao")
    private String motivoInspecao;
}