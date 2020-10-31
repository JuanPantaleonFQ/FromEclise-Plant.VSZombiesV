package Elements;

public class Slayer {
	// Attributes
	private int x;
	private int y;
	private int health;

	// constructor:
		public Slayer(int y, int x) {
			this.x = x;
			this.y = y;
			this.health = 3;
			
		}
		
		
		//Sobreescribimos el metodo equals para comparar unicamente las posiciones x e y
		public boolean equals(int x, int y) {
		return (this.x == x && this.y == y);
		}
		
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
		
		public String toString() {
			return " S [" + this.health + "] ";
		}

}