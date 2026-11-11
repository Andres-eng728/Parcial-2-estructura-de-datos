package Punto4;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario<T extends Comparable<T>> {
    private int peso;
    private NodoArbol<T> raiz;

    public ArbolBinario() {
        peso=0;
        raiz=null;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVacio(){
        return raiz==null;
    }

    public void recorrerInorden(){
        recorrerInorden(raiz);
    }

    private void recorrerInorden(NodoArbol<T> raiz){
        if(raiz==null)return;
        recorrerInorden(raiz.getIzquierdo());
        System.out.print(raiz.getElemento());
        recorrerInorden(raiz.getDerecho());
    }

    public void recorrerPreorden(NodoArbol<T> raiz){
        recorrerPreorden(raiz);
    }

    private void recorrerPreprden(NodoArbol<T> raiz){
        if(raiz==null)return;
        System.out.print(raiz.getElemento());
        recorrerPreorden(raiz.getIzquierdo());
        recorrerPreorden(raiz.getDerecho());
    }
    public void recorrerPostorden(){
        recorrerPostorden(raiz);
    }

    private void recorrerPostorden(NodoArbol<T> raiz){
        if(raiz==null)return;
        recorrerPostorden(raiz.getIzquierdo());
        recorrerPostorden(raiz.getDerecho());
        System.out.print(raiz.getElemento());
    }

    public int obtenerPeso(){
        return obtenerPeso(raiz);
    }
    private int obtenerPeso(NodoArbol<T> raiz){
        if(raiz==null)return 0;
        return 1 + obtenerPeso(raiz.getIzquierdo()) + obtenerPeso(raiz.getDerecho());
    }

    public int obtenerAltura() {
        return obtenerAltura(raiz);
    }
    private int obtenerAltura(NodoArbol<T> raiz) {
        if (raiz == null) {
            return 0;
        }

        int alturaIzquierda = obtenerAltura(raiz.getIzquierdo());
        int alturaDerecha = obtenerAltura(raiz.getDerecho());

        return 1 + (alturaIzquierda > alturaDerecha ? alturaIzquierda : alturaDerecha);
    }


    public boolean buscarPorNiveles(T elemento) {
        if (raiz == null || elemento == null) {
            return false;
        }

        Queue<NodoArbol<T>> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoArbol<T> nodoActual = cola.poll();


            if (nodoActual.getElemento().equals(elemento)) {
                return true;
            }


            if (nodoActual.getIzquierdo() != null) {
                cola.add(nodoActual.getIzquierdo());
            }
            if (nodoActual.getDerecho() != null) {
                cola.add(nodoActual.getDerecho());
            }
        }

        return false;
    }


    public boolean existe(T elemento) {
        return existe(raiz,elemento);
    }

    private boolean existe(NodoArbol<T> raizAux, T elemento) {
        if (raizAux == null) {
            return false;
        }
        int comp = raizAux.getElemento().compareTo(elemento);

        if(comp==0){
            return true;
        }
        if (comp>0){
            return existe(raizAux.getIzquierdo(), elemento);
        }else {
            return existe(raizAux.getDerecho(), elemento);
        }
    }

    public void insertar(T elemento) {
       raiz= insertar(raiz,elemento,null);
    }
    private NodoArbol<T> insertar(NodoArbol<T> raizAux, T elemento,NodoArbol<T> padre) {
        if (raizAux == null) {
            peso++;
                NodoArbol<T> Nuevonodo = new NodoArbol<>(padre,elemento);
            Nuevonodo.setPadre(padre);
            return Nuevonodo;
        }else{
            int comp = raizAux.getElemento().compareTo(elemento);

            if(comp ==0){

                throw new RuntimeException("El elemento ya existe");
            }
            if (comp>0){
                raizAux.setIzquierdo(insertar(raizAux.getIzquierdo(), elemento,raizAux.getIzquierdo()));
            }else{
                 raizAux.setDerecho(insertar(raizAux.getDerecho(), elemento,raizAux));
            }
            return raizAux;
        }
    }

    public void eliminar(T elemento) {
        raiz = eliminar(raiz, elemento);
    }

    private NodoArbol<T> eliminar(NodoArbol<T> raizAux, T elemento) {
        if (raizAux == null) {
            throw new RuntimeException("El elemento no existe en el árbol");
        }

        int comp = raizAux.getElemento().compareTo(elemento);

        if (comp > 0) {

            raizAux.setIzquierdo(eliminar(raizAux.getIzquierdo(), elemento));
        } else if (comp < 0) {

            raizAux.setDerecho(eliminar(raizAux.getDerecho(), elemento));
        } else {
            peso--;

            if (raizAux.getIzquierdo() == null && raizAux.getDerecho() == null) {
                return null;
            }


            if (raizAux.getIzquierdo() == null) {
                return raizAux.getDerecho();
            }
            if (raizAux.getDerecho() == null) {
                return raizAux.getIzquierdo();
            }

            T menorValor = obtenerMinimo(raizAux.getDerecho());

            raizAux.setElemento(menorValor);

            raizAux.setDerecho(eliminar(raizAux.getDerecho(), menorValor));


            peso++;
        }

        return raizAux;
    }


    private T obtenerMinimo(NodoArbol<T> raizAux) {
        while (raizAux.getIzquierdo() != null) {
            raizAux = raizAux.getIzquierdo();
        }
        return raizAux.getElemento();
    }








}
