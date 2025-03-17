package pe.edu.idat.examen3_web.Model;

public class DescuentoModel {
    private Integer tiempoComprando;
    private Double producto;
    private Double totalPagar; // Nuevo atributo

    public Integer getTiempoComprando() {
        return tiempoComprando;
    }

    public void setTiempoComprando(Integer tiempoComprando) {
        this.tiempoComprando = tiempoComprando;
    }

    public Double getProducto() {
        return producto;
    }

    public void setProducto(Double producto) {
        this.producto = producto;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
