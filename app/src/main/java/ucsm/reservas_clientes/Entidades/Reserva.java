package ucsm.reservas_clientes.Entidades;

public class Reserva {
    private String codigo,cod_aula,cod_pabellon,dia,hora,estado,cod_alumno;

    public Reserva(){};
    public Reserva(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCod_aula() {
        return cod_aula;
    }

    public void setCod_aula(String cod_aula) {
        this.cod_aula = cod_aula;
    }

    public String getCod_pabellon() {
        return cod_pabellon;
    }

    public void setCod_pabellon(String cod_pabellon) {
        this.cod_pabellon = cod_pabellon;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(String cod_alumno) {
        this.cod_alumno = cod_alumno;
    }
}
