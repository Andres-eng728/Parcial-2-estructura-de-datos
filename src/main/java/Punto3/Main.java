package Punto3;

public class Main {
    public static void main(String[] args) {


        CentroSoporte centroSoporte = new CentroSoporte();


        Cola<Solicitud> colaPendientes = new Cola<>();


        colaPendientes.encolar(new Solicitud(1, "NORMAL", 10)); // S1
        colaPendientes.encolar(new Solicitud(2, "ALTA", 30));   // S2
        colaPendientes.encolar(new Solicitud(3, "ALTA", 15));   // S3
        colaPendientes.encolar(new Solicitud(4, "NORMAL", 5));  // S4

        System.out.println("Iniciando selección con los minutos disponibles...\n" );


        Cola<Solicitud> seleccionadas = centroSoporte.seleccionarSolicitud(colaPendientes, 60);


        System.out.println("--- SOLICITUDES SELECCIONADAS ---");
        System.out.print("Resultado: ");
        if (seleccionadas.isEmpty()) {
            System.out.println("Ninguna");
        }
        while (!seleccionadas.isEmpty()) {
            Solicitud s = seleccionadas.desencolar();
            System.out.print("S" + s.getCodigo() + " (" + s.getPrioridad() + ", " + s.getMinutos() + "m) -> ");
        }
        System.out.println("FIN\n");


        System.out.println("--- SOLICITUDES PENDIENTES  ---");

        System.out.print("Resultado: ");
        if (colaPendientes.isEmpty()) {
            System.out.println("Ninguna");
        }
        while (!colaPendientes.isEmpty()) {
            Solicitud s = colaPendientes.desencolar();
            System.out.print("S" + s.getCodigo() + " (" + s.getPrioridad() + ", " + s.getMinutos() + "m) -> ");
        }
        System.out.println("FIN");
    }
}
