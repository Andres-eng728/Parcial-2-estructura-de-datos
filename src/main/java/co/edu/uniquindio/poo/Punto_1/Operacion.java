package co.edu.uniquindio.poo.Punto_1;

public class Operacion {

    private int codigo;
    private boolean estado;


    public Operacion(int codigo, boolean estado) {
        this.codigo = codigo;
        this.estado = estado;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
