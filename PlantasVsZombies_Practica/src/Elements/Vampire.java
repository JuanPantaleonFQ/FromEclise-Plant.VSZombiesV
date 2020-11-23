package Elements;

import logic.Game;



public class Vampire {

	private int x;
	private int y;
	private int health;
	private int progress; // Atributo para controlar el avance cada 2 ciclos
	private Game game;
	private static int totalV = 0;
	private static int cnt = 0;
	private static boolean fin = false;

	// CONSTRUCTOR
	public Vampire(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		this.health = 5;
		this.progress = 0;
		Vampire.cnt++;
		Vampire.totalV++;
		this.game = game;
	}
	
	

	//Sobreescribimos el metodo equals para comparar unicamente las posiciones x e y
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	public boolean equals2(int x, int y) {
		return (this.x == x && this.y > y);
	}
	
	//Sobreescribimos el metodo equals para comparar unicamente la posiciones x
	public boolean equals(int x) {
		return (this.x == x);
	}
	
	
	//Metodo que controla el avance de un vampiro cada dos turnos
	//1- No avanza
	//2- Avanza, resetea progrees a 0
	public void advanceVampire() {
		this.progress++;
		if (progress == 2) {
			progress = 0;
			if (!game.isVampireHere(x, y-1, false) && !game.isSlayerHere(x, y-1)) {
				this.y--;
			}
			
			if(progress == 2) {
				progress = 0;
				this.y--;
			}
			if(y == 1) {
				Vampire.fin = true;
			}
		}
	}
	
	//Sobreescribimos el metodo toString para devolver la vida del vampiro en el formato deseado
	public String toString() {
		return " V [" + this.health + "] ";
	}
	
	//changes:
	public void VampireAttack() {
		if(game.isSlayerHere(x, y-1) && health > 0) {
			game.vampireAttack(x,y-1);
		}
	}
	
	
	public static boolean isVampireFin() {
		return Vampire.fin;
	}

	
	public void dealDamage() {
		this.health--;
	}
	
	public boolean isDead() {
		return (health <= 0);
	}


	public static boolean noMoreVampire(int Max) {
		return (Vampire.totalV == Max);
	}
	public static int getTotalV() {
		return totalV;
	}
	public static int getCnt() {
		return cnt;
	}
	
	public static void setTotalV(int totalV) {
		Vampire.totalV = totalV;
	}
	public static void setCnt(int cnt) {
		Vampire.cnt = cnt;
	}
	public static void setCnt() {
		Vampire.cnt--;
	}

}