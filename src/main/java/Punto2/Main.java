package Punto2;

public class Main {

    public static void main(String[] args) {


                Stack<Sesion> historialAcciones = new Stack<>();


                historialAcciones.push(new Sesion("A1"));
                historialAcciones.push(new Sesion("A2"));
                historialAcciones.push(new Sesion("A3"));
                historialAcciones.push(new Sesion("A4"));
                historialAcciones.push(new Sesion("A5"));
                historialAcciones.push(new Sesion("A6"));


                Sesion sesionInicial = new Sesion("Sesion Base");
                EditorTexto editor = new EditorTexto(sesionInicial);


                Stack<Sesion> resultado = editor.obtenerSegmento(3, 3, historialAcciones);


                System.out.println("--- SEGMENTO OBTENIDO ---");
                while (!resultado.isEmpty()) {
                    System.out.println(resultado.pop().getAccion());
                }


                System.out.println("\n--- PILA ORIGINAL DESPUÉS DEL PROCESO (Desde el tope) ---");
                Stack<Sesion> pilaTemporal = new Stack<>();


                while (!historialAcciones.isEmpty()) {
                    Sesion actual = historialAcciones.pop();
                    System.out.println(actual.getAccion());
                    pilaTemporal.push(actual);
                }


                while (!pilaTemporal.isEmpty()) {
                    historialAcciones.push(pilaTemporal.pop());
                }
            }
}

