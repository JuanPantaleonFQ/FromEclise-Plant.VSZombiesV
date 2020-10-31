package logic;

import Elements.Player;
import utils.GameObjectBoard;


import java.util.Random;

public class Game {
	private Player player;
	private GameObjectBoard board;
	private Level level;
	private Random r;
	private boolean fin;
	private int cycles;
	private boolean reset;
	
	
	
	public Game(Long seed, Level level) {
		this.r = new Random(seed);
		this.level = level;
		this.fin = false;
		this.cycles = 0;
		this.player = new Player();
		this.board = new GameObjectBoard(level.getNumberOfVampires(),(level.getDim_x()*level.getDim_y()));
		this.reset = false;
	}
	
	public String infoGeneral () {
		return "Number of cycles: " + cycles + "\n" +
		"Coins: " + player.getCoins() + "\n" +
		"Remaining vampires: " + (level.getNumberOfVampires() - board.numberOfV()) + "\n" +
		"Vampires on the board: " + board.vampiresOnBoard() + "\n\n";
  }
	
	public void AddVampire() {
		int posX = Math.abs(r.nextInt() % (level.getDim_x())) + 1;
		if((board.positionAvaible(posX, level.getDim_y()))&&(board.moreVampire(level.getNumberOfVampires())) && (r.nextDouble() <= level.getVampireFrequency()))  {
			board.addToV(posX, level.getDim_y());
		}
	}
	
	public boolean AddSlayer(int x, int y){
		boolean ok = false;
		if (!player.areCoins()) {
			System.out.println("El jugador no tiene monedas suficientes. ");
		}
		else {
			if(!board.positionAvaible(x, y)) {
				System.out.println("Posicion erronea, ya existe un elemento en esa posicion. ");
			}
			else {
				if(x > level.getDim_x() || y >= level.getDim_y()) {
					System.out.println("No se pueden añadir Slayers en la utlima posicion o posicion incorrecta ");
				}
				else {
					board.addToS(x, y);
					System.out.println("Slayer añadido correctamente. \n\n");
					ok = true;
					player.setCoins(-50);
				}
				
			}
		}
		
		return ok;
	}
	
	
	public String positionToString(int x, int y) {
		String pos;
		pos = board.posString(x, y);
		return pos;
	}
	
	public String toString() {
		return infoGeneral();
	}
	
	public void update() {
		board.advanceVampire();
		if(r.nextDouble() <= 0.5 ) {
			if (this.cycles != 0) {
				player.setCoins(10);
			}
		}
		board.updateObjects();
		
	}
	
	public void attack() {
		board.slayerAttack();
		board.vampireAttack();
	}
	
	public boolean getFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	public void reset() {
		board.resetBoard();
		this.cycles = 0;
		player.resetCoins();
		
	}
	
	public void gameOver() {
		this.fin = board.endGame(level.getNumberOfVampires());
	}
	
	public int maxX() {
		return level.getDim_x();
	}
	
	public int maxY() {
		return level.getDim_y();
	}

	public int getCycles() {
		return cycles;
	}

	public void setCycles() {
		this.cycles++;
	}
	
	public void updateReset(boolean bool) {
		this.reset = bool;
	}

	public boolean isReset() {
		return this.reset;
	}
}
