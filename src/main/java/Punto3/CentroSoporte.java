package Punto3;

public class CentroSoporte {

    private Solicitud solicitud;
    private Cola<Solicitud> colaPendientes;

    public CentroSoporte() {
        this.solicitud = null;
        this.colaPendientes = new Cola<>();
    }

    public Cola<Solicitud> seleccionarSolicitud(Cola<Solicitud> cola, int minutos) {
        Cola<Solicitud> colaFinal = new Cola<>();

        // Validaciones iniciales
        if (cola == null || minutos <= 0) {
            return colaFinal;
        }

        AtenderSolicitudes(minutos, cola, colaFinal);
        return colaFinal;
    }

    private void AtenderSolicitudes(int minutos, Cola<Solicitud> cola, Cola<Solicitud> colaFinal) {

        int minutosRestantes = procesarPrioridad(minutos, cola, new Cola<>(), colaFinal, "ALTA");

        procesarPrioridad(minutosRestantes, cola, new Cola<>(), colaFinal, "NORMAL");
    }


    private int procesarPrioridad(int minutos, Cola<Solicitud> original, Cola<Solicitud> auxiliar, Cola<Solicitud> colaFinal, String prioridadBuscada) {


        if (original.isEmpty()) {
            restaurarColaRecursivo(auxiliar, original);
            return minutos;
        }


        Solicitud actual = original.desencolar();


        if (actual.getPrioridad().equalsIgnoreCase(prioridadBuscada) && actual.getMinutos() <= minutos) {
            colaFinal.encolar(actual);
            minutos -= actual.getMinutos();
        } else {

            auxiliar.encolar(actual);
        }


        return procesarPrioridad(minutos, original, auxiliar, colaFinal, prioridadBuscada);
    }


    private void restaurarColaRecursivo(Cola<Solicitud> origen, Cola<Solicitud> destino) {

        if (origen.isEmpty()) {
            return;
        }

        destino.encolar(origen.desencolar());
        restaurarColaRecursivo(origen, destino);
    }
}