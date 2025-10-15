package ambiente.dev.com.api_nutri_check.Controllers;

import ambiente.dev.com.api_nutri_check.Dto.Requests.LoginRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.LoginResponseDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.UsuarioResponse;
import ambiente.dev.com.api_nutri_check.Models.Usuario;
import ambiente.dev.com.api_nutri_check.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {


            // Validações
            if (loginRequest.getLogin() == null || loginRequest.getLogin().isEmpty()) {
                return ResponseEntity.badRequest().body("Login é obrigatório");
            }

            if (loginRequest.getSenha() == null || loginRequest.getSenha().isEmpty()) {
                return ResponseEntity.badRequest().body("Senha é obrigatória");
            }

            // Autenticar usuário
            Optional<Usuario> usuarioOpt = authService.autenticar(
                    loginRequest.getLogin(),
                    loginRequest.getSenha()
            );

            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();
                UsuarioResponse usuarioResponse = authService.toResponse(usuario);

                String token = "token-teste-" + usuario.getId();

                LoginResponseDTO response = new LoginResponseDTO(token, usuarioResponse);

                return ResponseEntity.ok(response);

            } else {

                return ResponseEntity.status(401).body("Credenciais inválidas");
            }

        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro interno do servidor: " + e.getMessage());
        }
    }


}