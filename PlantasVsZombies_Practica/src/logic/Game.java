package logic;

import Elements.Player;
import utils.GameObjectBoard;
import java.util.Scanner;

public class Game {

	private Game game;
	private Scanner in;
	private Player player;
	GameObjectBoard board;
	
	//guardado num 23
	
	public void run() {
		String line = in.nextLine();
		String[] words = line.toLowerCase().trim().split("\\s+");
		
	}
	
	
	public void AddVampire(int x, int y) {
		//añade un vampiro si
		if (player.getpoints() && ) {
			
		}
		
	}
	
	public boolean AddSlayer(int x, int y){
		boolean ok = false;
		if (!player.getcoins()) {
			System.out.println("El jugador no tiene monedas suficientes. ");
		}
		else {
			if(!board.positionAvaible(x, y)) {
				System.out.println("Posicion erronea, ya existe un elemento en esa posicion. ");
			}
			else {
				if(y >= level.getDim_y()) {
					System.out.println("No se pueden añadir Slayers en la utlima posicion. ");
				}
				else {
					board.addToS(x, y);
					ok = true;
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
	
	public void reset() {
		
	}
	
	public void none(){
		
		
	}
	
	public boolean gameOver() {
		//Permite salir y muestra el mensaje de error/salida.
		//basicamente, desde la function update, comprobamos todos los ciclos si osOver = true para terminar el juego, llamando
				
		boolean isOver = true;
		return isOver;
		 
	}


	
		


	
}