package Punto4;

public class Main {
    public static void main(String[] args) {
        // Inicializamos el laboratorio
        Laboratorio laboratorio = new Laboratorio(new Equipo(0));
        ArbolBinario<Equipo> arbol = laboratorio.getArbolEquipo();


        int[] codigos = {50, 30, 70, 20, 40, 60, 80, 55, 65};
        for (int codigo : codigos) {
            arbol.insertar(new Equipo(codigo));
        }


        int limiteInferior = 20;
        int limiteSuperior = 30;


        int cantidadEnRango = laboratorio.contarEquiposEnRango(arbol.getRaiz(), limiteInferior, limiteSuperior);

        System.out.println("Cantidad de equipos con código entre [" + limiteInferior + " y " + limiteSuperior + "]: " + cantidadEnRango);
    }
}
