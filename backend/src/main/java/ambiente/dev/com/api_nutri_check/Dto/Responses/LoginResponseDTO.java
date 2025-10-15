package ambiente.dev.com.api_nutri_check.Dto.Responses;

public class LoginResponseDTO {
    private String token;
    private UsuarioResponse user;

    // Construtores
    public LoginResponseDTO() {}

    public LoginResponseDTO(String token, UsuarioResponse user) {
        this.token = token;
        this.user = user;
    }

    // Getters e Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public UsuarioResponse getUser() { return user; }
    public void setUser(UsuarioResponse user) { this.user = user; }
}