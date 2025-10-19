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

    /**
     * Retorna o usuário autenticado, ou uma mensagem específica em caso de erro.
     * @param login Login informado pelo usuário
     * @param senha Senha informada pelo usuário
     * @return Resultado contendo o tipo de falha ou o usuário autenticado
     */
    public AuthResult autenticar(String login, String senha) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findByLogin(login);

        if (usuarioOpt.isEmpty()) {
            return new AuthResult(AuthStatus.USUARIO_NAO_ENCONTRADO, null);
        }

        Usuario usuario = usuarioOpt.get();

        // Comparação de senha simples (sem criptografia)
        if (!usuario.getSenha().equals(senha)) {
            return new AuthResult(AuthStatus.SENHA_INCORRETA, null);
        }

        return new AuthResult(AuthStatus.SUCESSO, usuario);
    }

    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole(),
                usuario.getEmpresaId()
        );
    }

    public Usuario criarUsuario(String login, String senha, String nome, String role,String email, Long empresaId) {
        Usuario usuario = new Usuario(login, senha, nome, email, role,empresaId);
        usuario.setEmpresaId(empresaId);
        return usuarioRepository.save(usuario);
    }

    // Enum interno para representar resultado da autenticação
    public enum AuthStatus {
        SUCESSO,
        USUARIO_NAO_ENCONTRADO,
        SENHA_INCORRETA
    }

    // Classe auxiliar de retorno
    public static class AuthResult {
        private final AuthStatus status;
        private final Usuario usuario;

        public AuthResult(AuthStatus status, Usuario usuario) {
            this.status = status;
            this.usuario = usuario;
        }

        public AuthStatus getStatus() {
            return status;
        }

        public Usuario getUsuario() {
            return usuario;
        }
    }
}
