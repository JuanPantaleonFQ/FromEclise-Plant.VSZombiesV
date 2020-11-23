package Elements;
import logic.Game;

public class Slayer {
	// Attributes
	private int x;
	private int y;
	private int health;
	private Game game;
	private static int cnt = 0;
	

	//CONSTRUCTOR
	public Slayer(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		this.health = 3;
		Slayer.cnt++;
		this.game = game;
	}
	
	//METODOS:
	
	//Sobreescribimos el metodo equals para comparar unicamente las posiciones x e y
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}


	
	//Sobreescribimos el metodo toString para devolver la vida del slayer con el formato deseado
	//para su salida por pantalla
	public String toString() {
		return " S [" + this.health + "] ";
	}
	
	public void dealDamage() {
		this.health--;
	}
	
	//changes:
	public void SlayerAttack() {		
		if(game.isVampireHere(x, y, true) && health > 0) {
			game.slayerAttack(x,y);
		}
	}
	
	public boolean isDead() {
		return (health <= 0);
	}

	public static int getCnt() {
		return cnt;
	}
	public static void setCnt(int cnt) {
		Slayer.cnt = cnt;
	}
	public static void setCnt() {
		Slayer.cnt--;	
	}
	
	
}