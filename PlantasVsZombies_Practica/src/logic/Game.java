package logic;

import Elements.Player;
import Elements.Slayer;
import Elements.Vampire;
import utils.GameObjectBoard;
import view.GamePrinter;

import java.util.Random;

public class Game {
	private Player player;
	private GameObjectBoard board;
	private Level level;
	private Random r;
	private boolean fin; 
	private int cycles;
	private GamePrinter printer;   
	
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

	
	
	//CONSTRUCTOR
	public Game(Long seed, Level level) {
		this.r = new Random(seed);
		this.level = level;
		this.fin = false;
		this.cycles = 0;
		this.player = new Player();
		this.board = new GameObjectBoard(level.getNumberOfVampires(),(level.getDim_x()*level.getDim_y()));
		this.printer = new GamePrinter(this, level.getDim_y(), level.getDim_x());
	}
	
	
	//------------------------------------------ METODOS -------------------------------------------------//
	
	public boolean getFin() {
		return fin;
	}


	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	public int maxX () {
		return level.getDim_x();
	}
	public int maxY () {
		return level.getDim_y();
	}

	public void printTable() {
		
	  System.out.println(infoGeneral() + printer);
	}
	
	//Metodo que determina aleatoriamente si se va añadir un vampiro
	//Determina tambien aleatoriamente la posicion donde va a aparecer (siempre en la ultima columna, pero distinta fila)
	//Controla si esta posicion generada aleatoriamente esta vacia
	//Si todas las premisas se cumplen añade el vampiro
	public void AddVampire() {
		int posX = Math.abs(r.nextInt() % (level.getDim_x())) + 1; 
		if((board.positionAvaible(posX, level.getDim_y()))&&(!Vampire.noMoreVampire(level.getNumberOfVampires())) && (r.nextDouble() <= level.getVampireFrequency()))  {
			board.addToV(new Vampire(posX, level.getDim_y(), this));
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
					board.addToS(new Slayer(x, y, this));
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
		"Remaining vampires: " + (level.getNumberOfVampires() - Vampire.getTotalV()) + "\n" +
		"Vampires on the board: " + Vampire.getCnt() + "\n\n";
	}
	
	
	//Metodo que recibe unas coordenadas y llaman a un metodo de GameObjectBoard para devolver 
	//un string con las caracteristicas deseadas
	public String positionToString(int x, int y) {
		return board.posString(x, y);	
	}
	
	//Sobreescritura del metodo string
	
	
	//Metodo que actualiza el estado del juego
	//Realiza el avance de los vampiros
	//Incrementa aleatoriamente el numero de monedas 
	//Elimina los elementos muertos de la partida
	public void update() {
		this.cycles++;
		board.advanceVampire();
		if(r.nextFloat() <= 0.5 ) { //float
			if (this.cycles != 0) {
				player.setCoins(10);
			}
		}
				
	}
	
	//Metodo que realiza el ataque de los vampiros y los slayers
	//Consideramos que primero atacan los vampiros
	public void vampireAttack(int x,int y) {
		board.vampireAttack(x,y);
		
	}
	
	public void slayerAttack(int x, int y) {
		board.slayerAttack(x,y);
	}
	
	public void removeDeadVampireAndSlayer() {
		board.updateVampire();		
		board.updateSlayer();
		
	}
	public void Attack() {
		board.Attack();
	}
	
	//Metodo que actualiza el valor del atributo fin, controlando si el juego ha terminando
	public void gameOver() {
		if (Vampire.noMoreVampire(level.getNumberOfVampires()) && Vampire.getCnt() == 0) {
			this.fin = true;
			System.out.println("GAME OVER. Player win");
		}
		else if (Vampire.isVampireFin()) {
			this.fin = true;
			System.out.println("GAME OVER. Vampires win");
		}
	}
	
	public void reset() {
		Vampire.setCnt(0);
		Vampire.setTotalV(0);
		Slayer.setCnt(0);
		this.cycles = 0;
		player.resetCoins();
	}
	
	
	
	public boolean isSlayerHere(int x , int y) {
		return (board.SlayerHere(x,y));
	}
	
	public boolean isVampireHere(int x , int y, boolean columna) {
		return (board.VampireHere(x,y, columna));
		
	}
	
	public boolean execCommand (String[]words) {
		boolean ok = false;
		if (words[0].equals("add") || (words[0].equals("a"))) {
    		int xpos = Integer.parseInt(words[2])+1;
    		int ypos = Integer.parseInt(words[1])+1;
    		ok = AddSlayer(xpos,ypos);
			
		}
    	else if(words[0].equals("reset") || (words[0].equals("r"))){
    		reset();
    		ok = true;
		
		}
    	else if(words[0].equals("") || (words[0].equals("none")) || (words[0].equals("n")) ){
    		ok = true;
		}
    	else if(words[0].equals("exit") || (words[0].equals("e"))){
    		ok = true;
    		this.fin = true;
    		System.out.println("GAME OVER");
			
		}
    	else if(words[0].equals("help") || (words[0].equals("h"))){
    		System.out.println(helpMsg);
			
		}
    	else {
    		System.out.println(invalidCommandMsg);
    	}
		
		if (ok) {
			
		}
		return ok;
	}

	
}