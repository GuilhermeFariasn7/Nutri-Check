package ambiente.dev.com.api_nutri_check.Controllers;

import ambiente.dev.com.api_nutri_check.Dto.Requests.LoginRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.LoginResponseDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.UsuarioResponse;
import ambiente.dev.com.api_nutri_check.Models.Usuario;
import ambiente.dev.com.api_nutri_check.Services.AuthService;
import ambiente.dev.com.api_nutri_check.Services.AuthService.AuthResult;
import ambiente.dev.com.api_nutri_check.Services.AuthService.AuthStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {

            if (loginRequest.getLogin() == null || loginRequest.getLogin().isBlank()) {
                return ResponseEntity.badRequest().body("O campo 'login' é obrigatório.");
            }

            if (loginRequest.getSenha() == null || loginRequest.getSenha().isBlank()) {
                return ResponseEntity.badRequest().body("O campo 'senha' é obrigatório.");
            }

            // Autenticação
            AuthResult resultado = authService.autenticar(
                    loginRequest.getLogin(),
                    loginRequest.getSenha()
            );

            // Trata os diferentes resultados
            switch (resultado.getStatus()) {
                case USUARIO_NAO_ENCONTRADO:
                    return ResponseEntity.status(404)
                            .body("Usuário não encontrado. Verifique o login informado.");

                case SENHA_INCORRETA:
                    return ResponseEntity.status(401)
                            .body("Senha incorreta para o usuário informado.");

                case SUCESSO:
                    Usuario usuario = resultado.getUsuario();
                    UsuarioResponse usuarioResponse = authService.toResponse(usuario);
                    String token = "token-teste-" + usuario.getId();

                    LoginResponseDTO response = new LoginResponseDTO(token, usuarioResponse);
                    return ResponseEntity.ok(response);

                default:
                    return ResponseEntity.status(500).body("Erro inesperado na autenticação.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                    .body("Erro interno do servidor: " + e.getMessage());
        }
    }
}
