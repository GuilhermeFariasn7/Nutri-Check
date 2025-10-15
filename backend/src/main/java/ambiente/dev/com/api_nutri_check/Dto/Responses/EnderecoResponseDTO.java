package ambiente.dev.com.api_nutri_check.Dto.Responses;

public record EnderecoResponseDTO(

        String rua,
        int numero,
        String complemento,
        String bairro,
        String municipio,
        String uf,
        String cep
) {}