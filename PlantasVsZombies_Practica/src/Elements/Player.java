package Elements;

public class Player {
	private int coins;
	
	public Player() {
		this.coins = 50;
	}
	
	

	
	// getpoint lo que hace es comprobar que tiene mas de 50monedas,y si da true
	// deja comprar.
	public boolean areCoins() { 							
		boolean ok = true;
		if (this.coins < 50) {
			ok = false;
		}
		return ok;
	}


	// getter y setters:

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins += coins;
	}
	
	public void resetCoins() {
		this.coins = 50;
	}
	
	
}