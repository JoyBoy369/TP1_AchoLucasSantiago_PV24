package ar.edu.unju.fi.ejercicio17.main;



import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {
	
	private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Jugador> jugadores = new ArrayList<>();

	
	public static void main(String[] args) {
		
		int opcion = 0;

        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        altaJugador();
                        break;
                    case 2:
                        mostrarDatosJugador();
                        break;
                    case 3:
                        mostrarJugadoresPorApellido();
                        break;
                    case 4:
                        modificarJugador();
                        break;
                    case 5:
                        eliminarJugador();
                        break;
                    case 6:
                        mostrarCantidadJugadores();
                        break;
                    case 7:
                        mostrarJugadoresPorNacionalidad();
                        break;
                    case 8:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Ingrese un valor entre 1 y 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
            } catch (Exception e) {
                System.out.println("Se ha producido un error: " + e.getMessage());
            } finally {
                scanner.nextLine(); 
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("\n**Menú de opciones**");
        System.out.println("1. Alta de jugador");
        System.out.println("2. Mostrar datos del jugador");
        System.out.println("3. Mostrar todos los jugadores ordenados por apellido");
        System.out.println("4. Modificar los datos de un jugador");
        System.out.println("5. Eliminar un jugador");
        System.out.println("6. Mostrar la cantidad total de jugadores");
        System.out.println("7. Mostrar la cantidad de jugadores por nacionalidad");
        System.out.println("8. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    private static void altaJugador() {
        System.out.println("\n**Alta de jugador**");

        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            String fechaNacimiento;
            do {
                System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                fechaNacimiento = scanner.nextLine();
                if (!validarFormatoFecha(fechaNacimiento)) {
                    System.out.println("Error: Fecha no válida. Debe tener el formato dd/mm/aaaa.");
                }
            } while (!validarFormatoFecha(fechaNacimiento));

            System.out.print("Nacionalidad: ");
            String nacionalidad = scanner.nextLine();

            System.out.print("Estatura (m) ejemplo(1,57): ");
            double estatura = scanner.nextDouble();

            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();

            // Consumir el salto de línea pendiente
            scanner.nextLine();

            System.out.print("Posición (delantero, medio, defensa, arquero): ");
            String posicion = scanner.nextLine();

            Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
            jugadores.add(jugador);

            System.out.println("\nJugador registrado exitosamente!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un valor numérico para estatura o peso.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: No se proporcionó ningún valor.");
        } catch (IllegalStateException e) {
            System.out.println("Error: Scanner cerrado inesperadamente.");
        } catch (Exception e) {
            System.out.println("Se ha producido un error al registrar el jugador: " + e.getMessage());
        }
    }

    private static boolean validarFormatoFecha(String fecha) {
        return fecha.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    private static void mostrarDatosJugador() {
        System.out.println("\n**Mostrar datos del jugador**");

        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            Jugador jugador = buscarJugador(nombre, apellido);

            if (jugador != null) {
                System.out.println("\n**Datos del jugador**");
                System.out.println("Nombre: " + jugador.getNombre());
                System.out.println("Apellido: " + jugador.getApellido());
                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
                System.out.println("Edad: " + jugador.calcularEdad() + " años");
                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
                System.out.println("Estatura: " + jugador.getEstatura() + " m");
                System.out.println("Peso: " + jugador.getPeso() + " kg");
                System.out.println("Posición: " + jugador.getPosicion());
            } else {
                System.out.println("Jugador no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error al mostrar los datos del jugador: " + e.getMessage());
        }
    }
    
    
    
    
    private static void mostrarJugadoresPorApellido() {
        System.out.println("\n**Mostrar jugadores por apellido**");

        Collections.sort(jugadores, (jugador1, jugador2) -> jugador1.getApellido().compareTo(jugador2.getApellido()));

        for (Jugador jugador : jugadores) {
            System.out.println("\n**Datos del jugador**");
            System.out.println("Nombre: " + jugador.getNombre());
            System.out.println("Apellido: " + jugador.getApellido());
            System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
            System.out.println("Nacionalidad: " + jugador.getNacionalidad());
            System.out.println("Estatura: " + jugador.getEstatura() + " m");
            System.out.println("Peso: " + jugador.getPeso() + " kg");
            System.out.println("Posición: " + jugador.getPosicion());
        }
    }
    
    
    
    private static void modificarJugador() {
        System.out.println("\n**Modificar datos del jugador**");

        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            Jugador jugador = buscarJugador(nombre, apellido);

            if (jugador != null) {
                System.out.println("\n**Datos del jugador**");
                System.out.println("Nombre: " + jugador.getNombre());
                System.out.println("Apellido: " + jugador.getApellido());
                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
                System.out.println("Estatura: " + jugador.getEstatura() + " m");
                System.out.println("Peso: " + jugador.getPeso() + " kg");
                System.out.println("Posición: " + jugador.getPosicion());

                System.out.println("\n¿Qué desea modificar?");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido");
                System.out.println("3. Fecha de nacimiento");
                System.out.println("4. Nacionalidad");
                System.out.println("5. Estatura");
                System.out.println("6. Peso");
                System.out.println("7. Posición");
                System.out.print("Ingrese la opción deseada: ");

                int opcionModificar = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcionModificar) {
                    case 1:
                        System.out.print("Nuevo nombre: ");
                        jugador.setNombre(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Nuevo apellido: ");
                        jugador.setApellido(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Nueva fecha de nacimiento (dd/mm/aaaa): ");
                        jugador.setFechaNacimiento(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Nueva nacionalidad: ");
                        jugador.setNacionalidad(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Nueva estatura (m): ");
                        jugador.setEstatura(scanner.nextDouble());
                        break;
                    case 6:
                        System.out.print("Nuevo peso (kg): ");
                        jugador.setPeso(scanner.nextDouble());
                        break;
                    case 7:
                        System.out.print("Nueva posición (delantero, medio, defensa, arquero): ");
                        jugador.setPosicion(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

                System.out.println("\nDatos del jugador modificados exitosamente!");
            } else {
                System.out.println("Jugador no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error al modificar los datos del jugador: " + e.getMessage());
        }
    }

    private static void eliminarJugador() {
        System.out.println("\n**Eliminar jugador**");

        try {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            Jugador jugador = buscarJugador(nombre, apellido);

            if (jugador != null) {
                System.out.println("\n**Datos del jugador**");
                System.out.println("Nombre: " + jugador.getNombre());
                System.out.println("Apellido: " + jugador.getApellido());
                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
                System.out.println("Estatura: " + jugador.getEstatura() + " m");
                System.out.println("Peso: " + jugador.getPeso() + " kg");
                System.out.println("Posición: " + jugador.getPosicion());

                System.out.println("\n¿Está seguro de que desea eliminar este jugador? (s/n)");
                String confirmacion = scanner.nextLine();

                if (confirmacion.equalsIgnoreCase("s")) {
                    jugadores.remove(jugador);
                    System.out.println("\nJugador eliminado exitosamente!");
                } else {
                    System.out.println("\nEliminación cancelada.");
                }
            } else {
                System.out.println("Jugador no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error al eliminar el jugador: " + e.getMessage());
        }
    }

    private static void mostrarCantidadJugadores() {
        System.out.println("\n**Cantidad total de jugadores:** " + jugadores.size());
    }
    
    
    private static void mostrarJugadoresPorNacionalidad() {
        System.out.println("\n**Mostrar jugadores por nacionalidad**");

        System.out.print("Ingrese la nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        int contador = 0;

        for (Jugador jugador : jugadores) {
            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                contador++;

                System.out.println("\n**Datos del jugador**");
                System.out.println("Nombre: " + jugador.getNombre());
                System.out.println("Apellido: " + jugador.getApellido());
                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
                System.out.println("Estatura: " + jugador.getEstatura() + " m");
                System.out.println("Peso: " + jugador.getPeso() + " kg");
                System.out.println("Posición: " + jugador.getPosicion());
            }
        }

        if (contador == 0) {
            System.out.println("No hay jugadores de esa nacionalidad.");
        }
    }

    
    private static Jugador buscarJugador(String nombre, String apellido) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                return jugador;
            }
        }
        return null;
    }

    
    
}

