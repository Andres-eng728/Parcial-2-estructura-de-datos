package Punto2;

public class EditorTexto {

    private Sesion sesion;
    private Stack<Sesion> PilaAccion;

    public EditorTexto(Sesion sesion) {
        this.sesion = sesion;
        this.PilaAccion = new Stack<>();
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Stack<Sesion> obtenerSegmento(int inicio, int fin, Stack<Sesion> historialAcciones) {

        Stack<Sesion> resultado = new Stack<>();

        if (historialAcciones == null || inicio < 1 || inicio > fin || fin > historialAcciones.size()) {
            return resultado;
        }


        obtenerySegmentar(inicio, fin, 1, historialAcciones, resultado);
        return resultado;
    }

    private void obtenerySegmentar(int inicio, int fin, int posicionActual, Stack<Sesion> historial, Stack<Sesion> resultado) {
        // Si la pila se vacía o si ya superamos la posición 'fin'
        if (historial.isEmpty() || posicionActual > fin) {
            return;
        }

        Sesion actual = historial.pop();


        obtenerySegmentar(inicio, fin, posicionActual + 1, historial, resultado);


        if (posicionActual >= inicio && posicionActual <= fin) {
            resultado.push(actual);
        }


        historial.push(actual);
    }

}
