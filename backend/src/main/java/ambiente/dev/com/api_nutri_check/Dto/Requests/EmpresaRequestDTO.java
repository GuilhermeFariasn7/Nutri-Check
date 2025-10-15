package ambiente.dev.com.api_nutri_check.Dto.Requests;

public record EmpresaRequestDTO(

         String razaoSocial,
         String cnpj,
         String inscricaoEstadual,
         String telefone,
         String email,
         String ramoAtividade,
         String tipoEmpresa,
         EnderecoRequestDTO endereco
) {}