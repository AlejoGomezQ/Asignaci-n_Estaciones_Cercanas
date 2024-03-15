import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void asignarEstacion (List<Persona> personas, List<Estacion> estaciones) {
        for (Persona persona : personas) {
            double distanciaMinima = Double.POSITIVE_INFINITY;
            Estacion estacionCercana = null;

            for (Estacion estacion : estaciones) {
                double distancia = persona.getUbicacion().distancia(estacion.getUbicacion());

                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    estacionCercana = estacion;
                }

                if (estacionCercana != null) {
                    persona.setEstacionBase(estacionCercana);
                }
            }
        }
    }

    public static  void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de personas: ");
        int n = scanner.nextInt();

        System.out.print("Ingrese el número de estaciones: ");
        int m = scanner.nextInt();

        List<Persona> personas = new ArrayList<>();
        List<Estacion> estaciones = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            double posXPersona = random.nextDouble() * 10000;
            double posYPersona = random.nextDouble() * 10000;
            Punto2D localizacionPersona = new Punto2D(posXPersona, posYPersona);
            personas.add(new Persona(localizacionPersona));
        }

        for (int i = 0; i < m; i++) {
            double posXEstacion = random.nextDouble() * 10000;
            double posYEstacion = random.nextDouble() * 10000;
            Punto2D localizacionEstacion = new Punto2D(posXEstacion, posYEstacion);
            estaciones.add(new Estacion(localizacionEstacion));
        }

        asignarEstacion(personas, estaciones);

        for (Persona persona : personas) {
            Estacion estacion = persona.getEstacionBase();
            System.out.println("Persona ubicada en" + persona.getUbicacion() + " y la estación mas cercana es" + (estacion != null ? estacion.getUbicacion() : " "));
        }
    }
}