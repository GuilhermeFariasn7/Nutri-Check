package ambiente.dev.com.api_nutri_check.Models;

public enum TipoEmpresa {
    PUBLICA("Pública"),
    PRIVADA("Privada");

    private String tipoEmpesa;

    TipoEmpresa (String tipoEmpesa) {
        this.tipoEmpesa = tipoEmpesa;
    }

    String getPeriodo() {
        return tipoEmpesa;
    }
}
