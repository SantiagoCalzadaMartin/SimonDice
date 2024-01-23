package main;

import java.util.Scanner;

/*
 * Esta es la clase engine de mi programa en la cual se almacena toda la información
 * relacionada con los jugadores
 */

public class jugador {

	private String nombre;
	public int puntuacion;
	
	/**
	 * Este metodo devuelve el nombre del jugador
	 * @return
	 */
	public String getNombre() {
		return "Bienvenido " + this.nombre + ", Buena suerte";
	}
	
	/**
	 * Este metodo registra la puntuación del jugador
	 * @return
	 */
	public int getPuntuacion() {
		this.puntuacion = 0;
		return this.puntuacion;
	}
	
	/**
	 * Este metodo registra el nombre del jugador
	 * @param nombre
	 */
	public jugador(String nombre) {
		this.nombre = nombre;
	}
	
}
