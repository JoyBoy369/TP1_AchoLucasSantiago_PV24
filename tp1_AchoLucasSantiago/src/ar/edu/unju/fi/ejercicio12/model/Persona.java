package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;

public class Persona {

	private String nombre;
	private Calendar nacimiento;
	
	
	public Persona() {
		
	}

	
	public int getEdad(){
		Calendar hoy = Calendar.getInstance();
		int edad = hoy.get(Calendar.YEAR)- nacimiento.get(Calendar.YEAR);
		int mes = nacimiento.get(Calendar.MONTH);
		int mesActual = hoy.get(Calendar.MONTH);
		
		if (mes > mesActual){
			edad--;
		}else {
			if(mesActual == mes) {
				
				int dia = nacimiento.get(Calendar.DAY_OF_MONTH);
				int diaActual = hoy.get(Calendar.DAY_OF_MONTH);
				
				if(diaActual > dia) {
					edad--;
				}
				
			}
		}
		
		return edad;
	}
	
	public String getSignoZodiaco() {
		
		final int dia = nacimiento.get(Calendar.DAY_OF_MONTH);
		final int mes = nacimiento.get(Calendar.MONTH);
		
		
		switch (mes) {
			case 1: {if(dia >= 20) 
						return "Acuario";
					else
						return "Capricornio";
			}
			case 2: {if(dia >= 19)
						return "Piscis";
					else
						return "Acuario";
			}
			case 3: {if(dia >= 21)
						return "Aries";
					else
						return "Piscis";
			}
			case 4: {if(dia >= 20)
						return "Tauro";
					else
						return "Aries";
			}
			case 5: {if(dia >= 21)
						return "Geminis";
					else
						return "Tauro";
			}
			case 6: {if(dia >= 21)
						return "Cancer";
					else
						return "Geminis";
			}
			case 7: {if(dia >= 23)
						return "Leo";
					else
						return "Cancer";
			}
			case 8: {if(dia >= 23)
						return "Virgo";
					else
						return "Leo";
			}
			case 9: {if(dia >= 23)
						return "Libra";
					else
						return "Virgo";
			}
			case 10: {if(dia >= 23)
						return "Escorpio";
					else
						return "Libra";
			}
			case 11: {if(dia >= 22)
						return "Sagitario";
					else
						return "Escorpio";
			}
			case 12: {if(dia >= 22)
						return "Capricornio";
					else
						return "Sagitario";
			}
					default:
						return "ERROR";
			}
		
	}
	
	public String getEstacion(){
		final int dia = nacimiento.get(Calendar.DAY_OF_MONTH);
		final int mes = nacimiento.get(Calendar.MONTH);	
		String estacion ="";
		
		 if ((mes == 1) || (mes == 2)) {
	            estacion = "Verano";
	        } else if ((mes == 4) || (mes == 5)) {
	            estacion = "Otoño";
	        } else if ((mes == 7) || (mes == 8)) {
	            estacion = "Invierno";
	        } else if ((mes == 10) || (mes == 11)) {
	            estacion = "Primavera";
	        } else if ((mes == 3) && (dia <= 19)) {
	            estacion = "Verano";
	        } else if (mes == 3) {
	            estacion = "Otoño";
	        } else if ((mes == 6) && (dia <= 20)) {
	            estacion = "Otoño";
	        } else if (mes == 6) {
	            estacion = "Invierno";
	        } else if ((mes == 9) && (dia <= 20)) {
	            estacion = "Invierno";
	        } else if (mes == 9) {
	            estacion = "Primavera";
	        } else if ((mes == 12) && (dia <= 21)) {
	            estacion = "Primavera";
	        } else if (mes == 12) {
	            estacion = "Verano";
	        }
		
		return estacion;
	}
	
	
	
	
	
	
	
	
	
	/*Getters Setters*/

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Calendar getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(Calendar nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	
}
