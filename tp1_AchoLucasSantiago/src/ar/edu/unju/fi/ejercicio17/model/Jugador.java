package ar.edu.unju.fi.ejercicio17.model;

import java.util.Calendar;

public class Jugador {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private double estatura;
    private double peso;
    private String posicion;
    
	public Jugador(String nombre, String apellido, String fechaNacimiento, String nacionalidad, double estatura,
			double peso, String posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	
	public int calcularEdad() {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaNacimientoCal = Calendar.getInstance();

        fechaNacimientoCal.set(
            Integer.parseInt(fechaNacimiento.substring(6)), 
            Integer.parseInt(fechaNacimiento.substring(3, 5)) - 1, 
            Integer.parseInt(fechaNacimiento.substring(0, 2))
        );

        int años = fechaActual.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.MONTH) < fechaNacimientoCal.get(Calendar.MONTH)) {
            años--;
        } else if (fechaActual.get(Calendar.MONTH) == fechaNacimientoCal.get(Calendar.MONTH) && 
                   fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCal.get(Calendar.DAY_OF_MONTH)) {
            años--;
        }

        return años;
    }
 }