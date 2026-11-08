package Punto3;

public class Solicitud {

    private int codigo;
    private String Prioridad;
    private int minutos;

    public Solicitud(int codigo, String Prioridad, int minutos) {
        this.codigo = codigo;
        this.Prioridad = Prioridad;
        this.minutos = minutos;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(String prioridad) {
        Prioridad = prioridad;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}
