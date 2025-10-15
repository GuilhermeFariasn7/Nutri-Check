package ambiente.dev.com.api_nutri_check.Dto.Mappers;

import ambiente.dev.com.api_nutri_check.Dto.Requests.EmpresaRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.EmpresaResponseDTO;
import ambiente.dev.com.api_nutri_check.Models.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface EmpresaMapper {

    @Mapping(target = "id", ignore = true)
    Empresa toEntity(EmpresaRequestDTO dto);

    EmpresaResponseDTO toResponse(Empresa empresa);

    List<EmpresaResponseDTO> toListResponse(List<Empresa> list);

    void update(EmpresaRequestDTO dto, @MappingTarget Empresa empresa);
}
