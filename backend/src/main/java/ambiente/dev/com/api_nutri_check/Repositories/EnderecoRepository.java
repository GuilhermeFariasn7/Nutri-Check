package ambiente.dev.com.api_nutri_check.Repositories;

import ambiente.dev.com.api_nutri_check.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
