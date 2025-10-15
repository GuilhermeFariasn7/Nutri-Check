package ambiente.dev.com.api_nutri_check.Dto.Requests;

public class LoginRequestDTO {
    private String login;
    private String senha;

    // Construtores
    public LoginRequestDTO() {}

    public LoginRequestDTO(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
