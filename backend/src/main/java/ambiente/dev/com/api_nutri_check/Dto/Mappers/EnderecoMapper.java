package ambiente.dev.com.api_nutri_check.Dto.Mappers;

import ambiente.dev.com.api_nutri_check.Dto.Requests.EnderecoRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.EnderecoResponseDTO;
import ambiente.dev.com.api_nutri_check.Models.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "id", ignore = true)
    Endereco toEntity(EnderecoRequestDTO dto);

    EnderecoResponseDTO toResponse(Endereco endereco);

    List<EnderecoResponseDTO> toListResponse(List<Endereco> list);

    void update(EnderecoRequestDTO dto, @MappingTarget Endereco endereco);
}
