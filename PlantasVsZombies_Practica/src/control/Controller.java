package control;

import java.util.Scanner;

import logic.Game;
import view.GamePrinter;

public class Controller {
	
	//Attributes
	private Game game;
	private Scanner scanner;
	private GamePrinter printer;

	
	public final String prompt = "Command > ";
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

  
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
	    this.printer = new GamePrinter(game, game.maxY(), game.maxX());
    }
    
    public void  printGame() {
   	 System.out.println(printer);
   }
    
    public boolean userCommand(String[]words) {
    	boolean ok = false;
    	if (words[0].equals("add")) {
    		int xpos = Integer.parseInt(words[2]);
    		int ypos = Integer.parseInt(words[1]);
    		ok = game.AddSlayer(xpos,ypos);
			
		}
    	else if(words[0].equals("reset") || (words[0].equals("r"))){
    		game.reset();
			ok = true;
			game.updateReset(true);
		}
    	else if(words[0].equals("") || (words[0].equals("none")) || (words[0].equals("n")) ){
    		ok = true;
		}
    	else if(words[0].equals("exit") || (words[0].equals("e"))){
    		System.out.println("¡Game over!");
    		ok = true;
    		game.setFin(true);
    		System.out.println("GAME OVER");
			
		}
    	else if(words[0].equals("help") || (words[0].equals("h"))){
    		System.out.println(helpMsg);
			
		}
    	else {
    		System.out.println(invalidCommandMsg);
    	}
    	
    	return ok;
    }
    
    public void run() {
    	boolean comand; 
    	
    	while(!game.getFin()) {
    		game.updateReset(false);
    		game.attack();
    		game.update();
			game.AddVampire();
			printGame();
			do {
    			String line = scanner.nextLine();
    	    	String[]words =line.toLowerCase().trim().split("\\s+");	
    	    	comand = userCommand(words);
    		}while (!comand); //bucle que se ejecuta hasta que el comanndo introducido es correcto
			
			if (!game.getFin() && !game.isReset()) {
				game.setCycles();
				game.gameOver();
			}
		} 
    }

}