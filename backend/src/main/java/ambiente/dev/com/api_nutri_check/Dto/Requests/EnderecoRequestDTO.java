package ambiente.dev.com.api_nutri_check.Dto.Requests;

public record EnderecoRequestDTO(

         String rua,
         int numero,
         String complemento,
         String bairro,
         String municipio,
         String uf,
         String cep
) {}