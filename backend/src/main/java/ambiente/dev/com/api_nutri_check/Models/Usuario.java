package ambiente.dev.com.api_nutri_check.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;  // ← CORRIGIDO: era 'email', agora é 'login'

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "role", nullable = false)
    private String role;   // ← CORRIGIDO: era 'tipo', agora é 'role'

    @Column(name = "empresa_id")
    private Long empresaId;

    // Construtores
    public Usuario() {}

    public Usuario(String login, String senha, String nome, String role) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.role = role;
    }

    // Getters e Setters CORRIGIDOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }    // ← getLogin()
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }      // ← getRole()
    public void setRole(String role) { this.role = role; }

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
}