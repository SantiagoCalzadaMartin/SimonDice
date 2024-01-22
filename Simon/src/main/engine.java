package main;

import java.util.Random;
import java.util.Scanner;

public class engine {

	enum tColores {
		Rojo, Verde, Azul, Naranja
		}

	static int MAX_COLORES_SEC = 12;
	static tColores[] secuenciaColores = new tColores[MAX_COLORES_SEC];

	public tColores charToColor(char _color) {
		tColores seleccion = null;
		char Iniciales = Character.toLowerCase(_color);
		switch (Iniciales) {
		case 'r':
			seleccion = tColores.Rojo;
			break;
		case 'v':
			seleccion = tColores.Verde;
			break;
		case 'a':
			seleccion = tColores.Azul;
			break;
		case 'n':
			seleccion = tColores.Naranja;
			break;
		default:
			System.out.println("Color no reconocido");
		}
		return seleccion;
	}

	private tColores intToColor(int _numero) {
		tColores posicion = null;
		switch (_numero) {
		case 0:
			posicion = tColores.Rojo;
			break;
		case 1:
			posicion = tColores.Verde;
			break;
		case 2:
			posicion = tColores.Azul;
			break;
		case 3:
			posicion = tColores.Naranja;
			break;
		}
		return posicion;
	}

	public void generarSecuencia(int _NumColores) {
		int maximiliano = MAX_COLORES_SEC - 1;
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random aleatorio = new Random();
			int random = aleatorio.nextInt(0, 4);
			secuenciaColores[i] = intToColor(random);
		}
	}

	public boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;
	}

	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	public void end() {
		System.exit(0);
	}
	
	public void menu() {
		System.out.println("Ingrese el número para realizar una de las siguientes opciones:");
		System.out.println();
		System.out.println("1: Dejar de jugar");
		System.out.println();
		System.out.println("2: Empezar a jugar");
		Scanner sc1 = new Scanner(System.in);
		int menu = sc1.nextInt();;

		switch (menu) {
		case 1:
			System.out.println("Adios");
			end();
			break;
		case 2:
			play();
			break;
		}
		if(menu != 1 || menu != 2) {
			System.out.println("Opción no válida");
			System.out.println();
			menu();
		}
	}

	public void start() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("Welcome to Simon dice!");

		System.out.println("Introduzca su nombre");
		String nombre = sc1.next();

		System.out.println("Hello " + nombre + ", good luck :)");
		System.out.println();
		menu();
	}

	public void play() {

		generarSecuencia(12);

		for (int i = 0; i < MAX_COLORES_SEC; i++) {

			System.out.println("Pulse ENTER para combrobar su capacidad de memoria");

			Scanner sc4 = new Scanner(System.in);
			String ENTER2 = sc4.nextLine();

			mostrarSecuencia(3 + i);

			/* Limpia la pantalla */
			if (ENTER2.isEmpty()) {

				new Scanner(System.in).nextLine();

				int limpiar = 50;

				for (int i1 = 0; i1 <= limpiar; i1++) {
					System.out.println();
				}

				System.out.println();

				int quesecuencia = i + 1;

				System.out.println("¿Cuál era la secuencia de colores de la secuencia " + quesecuencia + "?");

				for (int n = 0; n < 3 + i; n++) {
					char secuenciaUsuario = new Scanner(System.in).next().charAt(0);
					tColores colorElejido = charToColor(secuenciaUsuario);

					if (comprobarColor(n, colorElejido)) {
						System.out.println("Acertaste");
					} 
					else {
						System.out.println("Fallaste, fin del juego");
						menu();
					}
				}
				
				while(i == MAX_COLORES_SEC -3) {
					System.out.println("Terminaste el juego");
					menu();
				}
				
			}
		}
	}
}