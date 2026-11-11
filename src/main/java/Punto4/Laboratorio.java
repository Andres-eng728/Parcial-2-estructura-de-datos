package Punto4;

public class Laboratorio {
    private Equipo equipo;
    private ArbolBinario<Equipo> arbolEquipo;


    public Laboratorio(Equipo equipo){
        this.equipo=equipo;
        this.arbolEquipo= new ArbolBinario<>();
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ArbolBinario<Equipo> getArbolEquipo() {
        return arbolEquipo;
    }

    public void setArbolEquipo(ArbolBinario<Equipo> arbolEquipo) {
        this.arbolEquipo = arbolEquipo;
    }

    public int contarEquiposEnRango(int limiteInferior, int limiteSuperior) {

        if (arbolEquipo.estaVacio() || limiteInferior > limiteSuperior) {
            return 0;
        }
        return contarEquiposEnRango(arbolEquipo.getRaiz(), limiteInferior, limiteSuperior);
    }


    public int contarEquiposEnRango(NodoArbol<Equipo> nodo, int min, int max) {
        if (nodo == null) {
            return 0;
        }
        int contador = 0;
        int codigoActual = nodo.getElemento().getCodigo();

        if (codigoActual >= min && codigoActual <= max) {
            contador = 1;
        }

        if (codigoActual > min) {
            contador += contarEquiposEnRango(nodo.getIzquierdo(), min, max);
        }

        if (codigoActual < max) {
            contador += contarEquiposEnRango(nodo.getDerecho(), min, max);
        }

        return contador;
    }
}

