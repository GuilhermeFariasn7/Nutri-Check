package ambiente.dev.com.api_nutri_check.Services;

import ambiente.dev.com.api_nutri_check.Dto.Mappers.EmpresaMapper;
import ambiente.dev.com.api_nutri_check.Dto.Requests.EmpresaRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.EmpresaResponseDTO;
import ambiente.dev.com.api_nutri_check.Models.Empresa;
import ambiente.dev.com.api_nutri_check.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EmpresaMapper mapper;
    @Autowired
    private AuthService authService;

    public EmpresaResponseDTO criar(EmpresaRequestDTO dto) {
        // 1. Salva a empresa
        Empresa empresa = mapper.toEntity(dto);
        Empresa empresaSalva = repository.save(empresa);

        // 2. Cria o usuário associado à empresa
        authService.criarUsuario(
                dto.login(),           // login da empresa
                dto.senha(),           // senha da empresa
                empresaSalva.getRazaoSocial(), // nome = razão social
                "empresa",             // role = empresa
                empresaSalva.getEmail(), //Buscar e-mail da empresa
                empresaSalva.getId()   // empresaId
        );
        //3. Retornar empresa salva desta forma pois precisa ser criado o usuário para acesso da entidade.
        return mapper.toResponse(empresaSalva);
    }

    public List<EmpresaResponseDTO> listar() {
        return mapper.toListResponse(repository.findAll());
    }

    public EmpresaResponseDTO listarPorId(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Empresa não encontrada com id: " + id)
        ));
    }
    public EmpresaResponseDTO atualizar(Long id, EmpresaRequestDTO dto) {
        Empresa empresa = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Empresa não encontrada com id: " + id)
        );
        mapper.update(dto, empresa);
        return mapper.toResponse(repository.save(empresa));
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Empresa não encontrada com id: " + id);
        }
        repository.deleteById(id);
    }
}