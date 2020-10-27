package control;

import java.util.Scanner;

import logic.Game;

public class Controller {
	
	//Attributes
	private Game game;
	private Scanner scanner;

	
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
    }
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() {
		
    	do {
    		
    		String line = scanner.nextLine();
        	String[]words =line.toLowerCase().trim().split("\\s+");		//parte el string recibido de scanner para
        	/*
        	 si introducimos add 5 6
        	 el array words[0] = "add" words[1] = 5  y  words[2] = 6, tendria todo en formato string;
        	 */
        	if (words[0].equals("add")) {
        		int xpos = Integer.parseInt(words[1]);
        		int ypos = Integer.parseInt(words[2]);
        		game.AddSlayer(xpos,ypos);
        		
    			
    		}
        	if (words[0].equals("reset") || (words[0].equals("r"))){
        		
    			
    		}
        	if (words[0].equals("none") || (words[0].equals("n"))){
        		
    			
    		}
        	if (words[0].equals("exit") || (words[0].equals("e"))){
        		System.out.println("¡Game over!");
        		game.gameOver();
    			
    		}
        	if (words[0].equals("help") || (words[0].equals("h"))){
        		/*
        		 * Available commands:
    					[a]dd <x> <y>: add a slayer in position x, y
    					[h]elp: show this help
    					[r]eset: reset game
    					[e]xit: exit game
    					[n]one | []: update

        		 */
        		System.out.println("Available commands:");
        		System.out.println("[a]dd <x> <y>: add a slayer in position x, y ");
        		System.out.println("[h]elp: show this help");
        		System.out.println("[r]eset: reset game");
        		System.out.println("[e]xit: exit game");
        		System.out.println("[n]one | []: update");
    			
    		}
        	
			
		} while (!game.gameOver());
    	
    	
    	
    }
    
    

}