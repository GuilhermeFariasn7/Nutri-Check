package ambiente.dev.com.api_nutri_check.Dto.Responses;


import ambiente.dev.com.api_nutri_check.Models.AuthResultType;
import ambiente.dev.com.api_nutri_check.Models.Usuario;

public class AuthResult {
    private AuthResultType type;
    private Usuario usuario;

    public AuthResult(AuthResultType type, Usuario usuario) {
        this.type = type;
        this.usuario = usuario;
    }

    public AuthResultType getType() {
        return type;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}