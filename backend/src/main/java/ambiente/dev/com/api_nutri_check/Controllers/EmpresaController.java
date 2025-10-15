package ambiente.dev.com.api_nutri_check.Controllers;

import ambiente.dev.com.api_nutri_check.Dto.Requests.EmpresaRequestDTO;
import ambiente.dev.com.api_nutri_check.Dto.Responses.EmpresaResponseDTO;
import ambiente.dev.com.api_nutri_check.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> criar(@RequestBody EmpresaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}
