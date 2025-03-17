package pe.edu.idat.examen3_web.Model;

public class BonificacionModel {
    private Double dias;
    private String pagar; // Cambiado a String para almacenar el mensaje

    public Double getDias() {
        return dias;
    }

    public void setDias(Double dias) {
        this.dias = dias;
    }

    public String getPagar() {
        return pagar;
    }

    public void setPagar(String pagar) {
        this.pagar = pagar;
    }
}
