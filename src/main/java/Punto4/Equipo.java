package Punto4;

public class Equipo implements Comparable<Equipo> {
    private int codigo;

    public Equipo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Equipo o) {

        return Integer.compare(this.codigo, o.getCodigo());
    }


    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
