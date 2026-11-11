package Punto4;

public class NodoArbol<T> {

    private T elemento;
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;
    private NodoArbol<T> padre;

    public NodoArbol(NodoArbol<T> padre, T elemento)  {
        this.padre= padre;
        this.elemento= elemento;
    }




    public NodoArbol<T> getPadre() {
        return padre;
    }
    public void setPadre(NodoArbol<T> padre) {
        this.padre = padre;

    }
    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol<T> derecho) {
        this.derecho = derecho;
    }
}
