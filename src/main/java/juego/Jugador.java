package juego;

import java.util.Random;

public class Jugador {

	private String nombre;
	private int vida=100;
	private int minPower;
	private int maxPower;
	private int lastHit; //Agrego este atributo para tener registro del ultimo golpe dado por un jugador
	
	
	public Jugador(String nombre, int minPower, int maxPower) {
		this.nombre=nombre;
		this.minPower=minPower;
		this.maxPower=maxPower;
	}
	
	//Metodo encargado de calcular el golpe del jugador
	private int hitCalculator(int min, int max) {
		return new Random().nextInt(max-min+1)+min;
	}
	
	private int getHit() {
		this.lastHit=this.hitCalculator(this.minPower, this.maxPower);
		return lastHit;
	}
	
	//Descuenta la vida del Jugador cuando es atacado
	public void descontarVida(int golpe) {
		this.vida=Math.max(vida-golpe, 0);
	}
	
	//Ataca a otro jugador
	public void atacarJugador(Jugador jugador) {
		jugador.descontarVida(this.getHit());
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getLastHit() {
		return this.lastHit;
	}
	
}
