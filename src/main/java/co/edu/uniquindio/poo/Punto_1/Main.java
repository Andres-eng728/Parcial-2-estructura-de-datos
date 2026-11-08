package co.edu.uniquindio.poo.Punto_1;


public class Main {
    public static void main(String[] args) {


        Sesion sesion = new Sesion("juan", "1232");

        Operacion o1 = new Operacion(1, false);
        Operacion o2 = new Operacion(2, true);
        Operacion o3 = new Operacion(3, true);
        Operacion o4 = new Operacion(4, false);
        Operacion o5 = new Operacion(5, true);


        Historial historial = new Historial(sesion, o5);
        Stack<Operacion> pilaOperaciones = new Stack<>();


        pilaOperaciones.push(o1);
        pilaOperaciones.push(o2);
        pilaOperaciones.push(o3);
        pilaOperaciones.push(o4);
        pilaOperaciones.push(o5);


        Stack<Operacion> resultado = historial.obtenerUltimasConfirmadas(pilaOperaciones, 2);


        System.out.println("--- RESULTADO: ÚLTIMAS CONFIRMADAS ---");
        while (!resultado.isEmpty()) {
            Operacion op = resultado.pop();
            String estadoStr = op.isEstado() ? "CONFIRMADA" : "ANULADA";
            System.out.println("Operación: O" + op.getCodigo() + " - " + estadoStr);
        }

        System.out.println("\n--- ESTADO DE LA PILA ORIGINAL  ---");
        Stack<Operacion> pilaTemporal = new Stack<>();


        while (!pilaOperaciones.isEmpty()) {
            Operacion op = pilaOperaciones.pop();
            String estadoStr = op.isEstado() ? "CONFIRMADA" : "ANULADA";
            System.out.println("Operación: O" + op.getCodigo() + " - " + estadoStr);

            pilaTemporal.push(op);
        }


        while (!pilaTemporal.isEmpty()) {
            pilaOperaciones.push(pilaTemporal.pop());
        }


        System.out.println("\nTamaño final de la pila original: " + pilaOperaciones.getSize());
    }
}
