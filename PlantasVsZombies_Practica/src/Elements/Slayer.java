package Elements;
import logic.Game;

public class Slayer {
	// Attributes
	private int x;
	private int y;
	private int health;
	private Game game;

	//CONSTRUCTOR
	public Slayer(int y, int x) {
		this.x = x;
		this.y = y;
		this.health = 3;
		
	}
	
	//METODOS:
	
	//Sobreescribimos el metodo equals para comparar unicamente las posiciones x e y
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	//Método que devuelve true si el slayer ha muerto, false en caso contrario 
	public boolean isDead() {
		return (this.health <= 0);
	}

	// getters & setters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health -= health;
	}
	
	//Sobreescribimos el metodo toString para devolver la vida del slayer con el formato deseado
	//para su salida por pantalla
	public String toString() {
		return " S [" + this.health + "] ";
	}

}