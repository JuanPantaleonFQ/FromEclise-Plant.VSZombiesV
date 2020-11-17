package Elements;

import logic.Game;



public class Vampire {

	private int x;
	private int y;
	private int health;
	private int progress; // Atributo para controlar el avance cada 2 ciclos
	private Game game;

	// CONSTRUCTOR
	public Vampire(int x, int y) {
		this.x = x;
		this.y = y;
		this.health = 5;
		this.progress = 0;
	}
	//----------------------------------------------------------------------------
	
	//setters and getter:
	public int getX() {
		return x;
		
	}
	public int getY() {
		return y;
		
	}
	
	public int getHealth() {
		return health;
	}
	
	//----------------------------------------------------------------------------
	
	//metodos:
	
	public void setHealth(int health) {
		this.health -= health;
	}
	

	//Sobreescribimos el metodo equals para comparar unicamente las posiciones x e y
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	//Sobreescribimos el metodo equals para comparar unicamente la posiciones x
	public boolean equals(int x) {
		return (this.x == x);
	}
	
	//Metodo que controla si el vampiro está muerto
	public boolean isDead() {
		return (this.health <= 0);
	}
	
	//Metodo que controla si un vampiro ha llegado a la columna 1 del tablero
	public boolean end() {
		return (this.y == 1);
	}
	
	//Metodo que controla el avance de un vampiro cada dos turnos
	//1- No avanza
	//2- Avanza, resetea progrees a 0
	public void advanceVampire() {
		this.progress++;
		if(this.progress == 2) {
			this.progress = 0;
			this.y--;
		}
	}
	
	//Sobreescribimos el metodo toString para devolver la vida del vampiro en el formato deseado
	public String toString() {
		return " V [" + this.health + "] ";
	}
	
	//changes:
	public void VampireAtack() {
		
		
		
	}

}