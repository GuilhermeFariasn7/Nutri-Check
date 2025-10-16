package ambiente.dev.com.api_nutri_check.Services;

import ambiente.dev.com.api_nutri_check.Dto.Mappers.EmpresaMapper;
import ambiente.dev.com.api_nutri_check.Dto.Requests.EmpresaRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.EmpresaResponseDTO;
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

    public EmpresaResponseDTO criar(EmpresaRequestDTO dto) {
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public List<EmpresaResponseDTO> listar() {
        return mapper.toListResponse(repository.findAll());
    }

    public EmpresaResponseDTO listarPorId(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Empresa não encontrada com id: " + id)
        ));
    }

}
