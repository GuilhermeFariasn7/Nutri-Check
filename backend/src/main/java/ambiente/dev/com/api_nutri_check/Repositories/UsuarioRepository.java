package ambiente.dev.com.api_nutri_check.Repositories;

import ambiente.dev.com.api_nutri_check.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);  // ← CORRIGIDO: findByEmail → findByLogin
}