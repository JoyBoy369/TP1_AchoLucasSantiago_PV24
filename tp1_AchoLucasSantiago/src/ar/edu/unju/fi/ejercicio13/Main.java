package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {
    
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numeros = new int[8];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = getInteger("Ingrese un número: ");
            System.out.printf("Índice: [%d] - Valor: %d%n", i, numeros[i]);
        }
    }

    
    
    
    
    
    public static int getInteger(String mensaje) {
        int valorEntero;

        while (true) {
            System.out.print(mensaje);
            valorEntero = Integer.parseInt(scanner.nextLine());
            return valorEntero;
        }
    }
}
