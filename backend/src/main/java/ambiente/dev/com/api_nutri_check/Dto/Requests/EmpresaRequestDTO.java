package ambiente.dev.com.api_nutri_check.Dto.Requests;

import ambiente.dev.com.api_nutri_check.Models.TipoEmpresa;

public record EmpresaRequestDTO(

         String razaoSocial,
         String cnpj,
         String inscricaoEstadual,
         String telefone,
         String email,
         String ramoAtividade,
         TipoEmpresa tipoEmpresa,
         EnderecoRequestDTO endereco
) {}