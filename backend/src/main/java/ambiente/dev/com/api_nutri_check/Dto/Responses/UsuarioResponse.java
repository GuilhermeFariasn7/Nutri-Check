package ambiente.dev.com.api_nutri_check.Dto.Responses;

public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String tipo;
    private Long empresa_id;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String nome, String email, String tipo, Long empresa_id) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.empresa_id = empresa_id;
    }

    public Long getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}