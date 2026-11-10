package co.edu.uniquindio.poo.Punto_1;



public class Historial {

    private Sesion sesion;
    private Operacion operacion;
    private Stack<Operacion> historialOperaciones;

    public Historial(Sesion sesion, Operacion operacion) {
        this.sesion = sesion;
        this.operacion = operacion;
        historialOperaciones = new Stack<>();
    }





    public  Stack<Operacion> obtenerUltimasConfirmadas(Stack<Operacion> historial, int n) {
        Stack<Operacion> resultadoFinal = new Stack<>();

        if (historial == null || n <= 0) {
            return resultadoFinal;
        }
        buscarYRestaurarRecursivo(historial, n, resultadoFinal);

        return resultadoFinal;
    }

    private  void buscarYRestaurarRecursivo(Stack<Operacion> historial, int nRestantes, Stack<Operacion> resultado) {

        if (historial.isEmpty() || nRestantes == 0) {
            return;
        }

        Operacion actual = historial.pop();
        boolean esConfirmada = actual.isEstado();

        int nuevosRestantes;
        if (esConfirmada) {
            nuevosRestantes = nRestantes - 1;
        } else {
            nuevosRestantes = nRestantes;
        }
        buscarYRestaurarRecursivo(historial, nuevosRestantes, resultado);
        if (esConfirmada) {
            resultado.push(actual);
        }
        historial.push(actual);
    }


}
