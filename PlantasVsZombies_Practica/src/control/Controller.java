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

  
    //CONSTRUCTOR
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
	    this.printer = new GamePrinter(game, game.maxY(), game.maxX());
    }
    
    //Método que llama al metodo toString de la clase GamePrinter e imprime por pantalla el string devuelto
    public void  printGame() {
   	 System.out.println(printer);
    }
    
    //Método que recibe el comando introducido por el usuario por consola y controla su flujo
    //Devuelve true en caso de que el usuario haya introducido un comando correcto y se deba avanzar ciclo
    //Devuelve false si el comando introducido es incorrecto o no se debe avanzar turno
    //Además controla la ejecución de la opción deseada llamando a los métodos de la clase game segun sea necesario
    public boolean userCommand(String[]words) {
    	boolean ok = false;
    	if (words[0].equals("add") || (words[0].equals("a"))) {
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
    
    //Método que controla el flujo de una partida
    //El pimer bucle while controla el flujo de una partida
    //El segundo bucle controla que el ciclo no avance hasta que el usuario haya introducido una opcion valida
    //El if final controla que se incremente el numero de ciclos y se evalue un posible fin de partida solo si
    //el usuario no ha seleccionado la opcion exit o reset
    public void run() {
    	boolean comand; 
    	
    	while(!game.getFin()) {
    		game.updateReset(false);
    		game.attack();
    		game.update();
			game.AddVampire();
			
			do {
    			String line = scanner.nextLine();
    	    	String[]words =line.toLowerCase().trim().split("\\s+");	
    	    	comand = userCommand(words);
    		}while (!comand); //bucle que se ejecuta hasta que el comanndo introducido es correcto
			printGame();
			if (!game.getFin() && !game.isReset()) {
				game.setCycles();
				game.gameOver();
			}
			
		} 
    }

}
