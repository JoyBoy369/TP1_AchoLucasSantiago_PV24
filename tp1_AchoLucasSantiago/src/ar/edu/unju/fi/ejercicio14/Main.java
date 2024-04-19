package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numeros = new int[getArrayLength()];
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = getInteger("Ingrese un número");
            suma += numeros[i];
            System.out.printf("Posicion: [%d] - Valor: %d%n", i, numeros[i]);
        }

        System.out.println("La suma de los valores del arreglo es: " + suma);
    }

    public static int getInteger(String mensaje) {
        int valorEntero;

        while (true) {
            System.out.print(mensaje + ": ");
            valorEntero = Integer.parseInt(scanner.nextLine());
            return valorEntero;
        }
    }

    public static int getArrayLength() {
        int length;

        while (true) {
            length = getInteger("Ingrese la longitud del arreglo");

            if (length < 3 || length > 10) {
                System.out.println("El número debe encontrarse en el rango [3,10]");
            } else {
                System.out.println("Longitud del arreglo: " + length);
                return length;
            }
        }
    }
}
