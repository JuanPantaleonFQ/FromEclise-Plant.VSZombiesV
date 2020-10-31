package Elements;



public class Vampire {
	// Attributes

	private int x;
	private int y;
	private int health;
	private int progress;

	// constructor:
	public Vampire(int x, int y) {
		this.x = x;
		this.y = y;
		this.health = 5;
		this.progress = 0;
	}
	
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

	public void setHealth(int health) {
		this.health -= health;
	}
	

	//Sobreescribimos el metodo equals para comparar unicamente las posiciones x e y
	public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
	}
	
	public boolean equals(int x) {
		return (this.x == x);
	}
	
	public boolean isDead() {
		return (this.health <= 0);
	}
	
	public boolean end() {
		return (this.y == 1);
	}
	
	//Metodo que controla el avance de un vampiro cada dos turnos
	public void advanceVampire() {
		this.progress++;
		if(this.progress == 2) {
			this.progress = 0;
			this.y--;
		}
	}
	
	public String toString() {
		return " V [" + this.health + "] ";
	}

}
