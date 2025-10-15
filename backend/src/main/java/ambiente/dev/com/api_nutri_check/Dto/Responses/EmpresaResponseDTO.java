package ambiente.dev.com.api_nutri_check.Dto.Responses;

import ambiente.dev.com.api_nutri_check.Dto.Requests.EnderecoRequestDTO;

public record EmpresaResponseDTO(

        Long id,
        String razaoSocial,
        String cnpj,
        String inscricaoEstadual,
        String telefone,
        String email,
        String ramoAtividade,
        String tipoEmpresa,
        EnderecoResponseDTO endereco
) {}