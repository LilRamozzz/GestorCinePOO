
package modelo;

import java.util.ArrayList;

public class Venta {
    private String codigo;
    private Cliente cliene;
    private Empleado empleado;
    private Horario horario;
    private Asiento asiento;
    private String metodoPago;
    private double total;
    private String fechaCompra;
    private ArrayList<DetalleVenta>detalles;
    
    public void agregarDetalle(DetalleVenta detalle){
        detalles.add(detalle);
        total +=detalle.getImporte();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliene() {
        return cliene;
    }

    public void setCliene(Cliente cliene) {
        this.cliene = cliene;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
    
}
