package logic;

import Elements.Player;
import utils.GameObjectBoard;
import java.util.Random;

public class Game {
	private Player player;
	private GameObjectBoard board;
	private Level level;
	private Random r;
	private boolean fin; //controla el fin del juego
	private int cycles;
	private boolean reset; //controla si el juego va a ser reseteado
	
	
	//CONSTRUCTOR
	public Game(Long seed, Level level) {
		this.r = new Random(seed);
		this.level = level;
		this.fin = false;
		this.cycles = 0;
		this.player = new Player();
		this.board = new GameObjectBoard(level.getNumberOfVampires(),(level.getDim_x()*level.getDim_y()));
		this.reset = false;
	}
	
	//Getters & Setters
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
		//Getter & Setter
		public boolean getFin() {
			return fin;
		}
		public void setFin(boolean fin) {
			this.fin = fin;
		}
	
	//------------------------------------------ METODOS -------------------------------------------------//
	
	//Metodo que determina aleatoriamente si se va añadir un vampiro
	//Determina tambien aleatoriamente la posicion donde va a aparecer (siempre en la ultima columna, pero distinta fila)
	//Controla si esta posicion generada aleatoriamente esta vacia
	//Si todas las premisas se cumplen añade el vampiro
	public void AddVampire() {
		int posX = Math.abs(r.nextInt() % (level.getDim_x())) + 1;
		if((board.positionAvaible(posX, level.getDim_y()))&&(board.moreVampire(level.getNumberOfVampires())) && (r.nextDouble() <= level.getVampireFrequency()))  {
			board.addToV(posX, level.getDim_y());
		}
	}
	
	//Metodo que añade un vampiro en la posicion que recibe en los parametros
	//Controlando que el jugador tenga monedas suficientes
	//Controlando si no existe otro elemento en el tablero
	//Controlando si las coordenadas son validas
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
	
	//Metodo que develve un string con la informacion general del juego
		public String infoGeneral () {
			return "Number of cycles: " + cycles + "\n" +
			"Coins: " + player.getCoins() + "\n" +
			"Remaining vampires: " + (level.getNumberOfVampires() - board.numberOfV()) + "\n" +
			"Vampires on the board: " + board.vampiresOnBoard() + "\n\n";
		}
	
	//Metodo que recibe unas coordenadas y llaman a un metodo de GameObjectBoard para devolver 
	//un string con las caracteristicas deseadas
	public String positionToString(int x, int y) {
		return board.posString(x, y);	
	}
	
	//Sobreescritura del metodo string
	public String toString() {
		return infoGeneral();
	}
	
	//Metodo que actualiza el estado del juego
	//Realiza el avance de los vampiros
	//Incrementa aleatoriamente el numero de monedas 
	//Elimina los elementos muertos de la partida
	public void update() {
		board.advanceVampire();
		if(r.nextDouble() <= 0.5 ) {
			if (this.cycles != 0) {
				player.setCoins(10);
			}
		}
				
	}
	
	//Metodo que realiza el ataque de los vampiros y los slayers
	//Consideramos que primero atacan los vampiros
	public void vampireAttack() {
		board.vampireAttack();
		
		
	}
	
	public void slayerAtack() {
		board.slayerAttack();
		
	}
	
	public void removeDeadVampireAndSlayer() {
		board.updateVampire();		
		board.updateSlayer();
		
	}
	
	
	
	
	//Metodo que resetea el juego
	public void reset() {
		board.resetBoard();
		this.cycles = 0;
		player.resetCoins();
		
	}
	
	//Metodo que actualiza el valor del atributo fin, controlando si el juego ha terminando
	public void gameOver() {
		this.fin = board.endGame(level.getNumberOfVampires());
	}
	
	//Getters que devuelven las dimensiones del tablero
	public int maxX() {
		return level.getDim_x();
	}
	public int maxY() {
		return level.getDim_y();
	}

	
}