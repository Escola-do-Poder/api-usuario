package tadashi.demo.model;

public enum TipoUsuario {
    CLIENTE("Cliente"),
    ATENDENTE("Atendente");

    private String tipoUsuario;

    TipoUsuario(String tipousuario) {
        this.tipoUsuario = tipousuario;
    }

    public String getTipousuario() {
        return tipoUsuario;
    }


}
