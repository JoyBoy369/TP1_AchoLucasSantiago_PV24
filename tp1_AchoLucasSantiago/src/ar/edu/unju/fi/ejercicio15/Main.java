package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nombresPersonas = new String[obtenerLongitudArreglo()];

        for (int i = 0; i < nombresPersonas.length; i++) {
            nombresPersonas[i] = obtenerString("Ingrese un nombre de persona");
            System.out.printf("Posicion [%d] - Valor: %s%n", i, nombresPersonas[i]);
        }

        mostrarContenidoArregloInvertido(nombresPersonas);
    }

    public static void mostrarContenidoArregloInvertido(String[] arreglo) {
        System.out.println("Mostrando arreglo de forma inversa");
        for (int i = arreglo.length; i > 0; i--) {
            System.out.printf(
                    "Índice [%d] - Valor: %s%n",
                    i - 1,
                    arreglo[i - 1]
            );
        }
    }

    public static String obtenerString(final String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public static int obtenerEntero(String mensaje) {
        int valorEntero;

        while (true) {
            System.out.print(mensaje + ": ");
            valorEntero = Integer.parseInt(scanner.nextLine());
            return valorEntero;
        }
    }

    public static int obtenerLongitudArreglo() {
        int longitud;

        while (true) {
            longitud = obtenerEntero("Ingrese la longitud del arreglo");

            if (longitud < 5 || longitud > 10) {
                System.out.println("ERROR: El número debe estar en el rango [5,10]");
            } else {
                System.out.println("Longitud del arreglo: " + longitud);
                return longitud;
            }
        }
    }
}
