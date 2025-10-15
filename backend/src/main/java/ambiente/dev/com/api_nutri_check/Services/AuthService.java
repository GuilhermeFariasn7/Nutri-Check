package ambiente.dev.com.api_nutri_check.Services;

import ambiente.dev.com.api_nutri_check.Dto.Responses.UsuarioResponse;
import ambiente.dev.com.api_nutri_check.Models.Usuario;
import ambiente.dev.com.api_nutri_check.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Optional<Usuario> autenticar(String login, String senha) {
        System.out.println("Buscando usuário com login: " + login);

        Optional<Usuario> usuarioOpt = usuarioRepository.findByLogin(login);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            System.out.println("Usuário encontrado: " + usuario.getNome());
            System.out.println("Comparando senhas...");

            // Comparação simples de senha
            if (usuario.getSenha().equals(senha)) {
                return Optional.of(usuario);
            } else {
                System.out.println(" Senha incorreta!");
            }
        } else {
            System.out.println("Usuário não encontrado!");
        }

        return Optional.empty();
    }


    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }

    // Método para criar usuário (se precisar)
    public Usuario criarUsuario(String login, String senha, String nome, String role) {
        Usuario usuario = new Usuario(login, senha, nome, role);
        return usuarioRepository.save(usuario);
    }
}