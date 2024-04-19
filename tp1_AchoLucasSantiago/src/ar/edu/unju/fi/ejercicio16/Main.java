package ar.edu.unju.fi.ejercicio16;


import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nombres = new String[5];

        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = getString("Ingrese un nombre de persona");
        }

        mostrarLista(nombres);
        System.out.println("Tamaño del arreglo: " + nombres.length);

        borrarNombre(nombres);
        mostrarLista(nombres);
    }

    public static void borrarNombre(String[] array) {
        byte index;
        String temporal;
        index = getByte("Ingrese índice de un elemento");

        if (array.length - 1 == index) {
            array[index] = "";
        } else {
            while (index < array.length-1) {
                temporal = array[index + 1];
                array[index] = temporal;
                array[index + 1] = "";
                index++;
            }
        }
    }

    public static byte getByte(String message) {
        byte byteValue = 0;

        do {
            System.out.print(message + ": ");
            byteValue = Byte.parseByte(scanner.nextLine());
            if (byteValue < 1 || byteValue > 5) {
                System.out.println("ERROR: Índice fuera de rango");
            }
        } while (byteValue < 1 || byteValue > 5);

        return (byte) (byteValue - 1);
    }

    public static void mostrarLista(String[] array) {
        int i = 0;
        System.out.println("Mostrando los nombres de persona almacenados en el arreglo");
        while (i < array.length) {
            System.out.printf("[%d]: %s%n", i + 1, array[i]);
            i++;
        }
    }

    public static String getString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }
}
