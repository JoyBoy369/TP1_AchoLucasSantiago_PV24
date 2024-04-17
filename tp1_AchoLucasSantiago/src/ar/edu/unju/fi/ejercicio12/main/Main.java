package ar.edu.unju.fi.ejercicio12.main;

import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {
	
	static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Persona persona = new Persona();
		
		System.out.print("Ingresar nombre: ");
		String nombre = scanner.nextLine();
		persona.setNombre(nombre);
		
		System.out.print("Ingresar fecha de nacimiento en formato (YYYY-MM-DD): ");
        String fechaString = scanner.nextLine();
        Calendar fechaCal = Calendar.getInstance();      
        fechaCal.set(getAnio(fechaString),getMes(fechaString),getDia(fechaString));             
        persona.setNacimiento(fechaCal);
       
      
        
        System.out.println("*************************************");
		System.out.println("Nombre: "+persona.getNombre());
		System.out.println("Fecha de nacimiento: "+fechaString);
		System.out.println("Edad: "+persona.getEdad()+" años");
		System.out.println("Signo del zodiaco: "+persona.getSignoZodiaco());
		System.out.println("Estación: "+persona.getEstacion());
		System.out.println("*************************************");
		
	
		
		
	}
	
	public static int getAnio(String fecha) {
		String anioString = fecha.substring(0,4);
		int anio = Integer.parseInt(anioString);
		
		return anio;
	}
	
	public static int getMes(String fecha) {
		String mesString = fecha.substring(5,7);
		int mes = Integer.parseInt(mesString);
		
		return mes;
	}
	
	public static int getDia(String fecha) {
		String diaString = fecha.substring(8,10);
		int dia = Integer.parseInt(diaString);
		
		return dia;
	}

}
