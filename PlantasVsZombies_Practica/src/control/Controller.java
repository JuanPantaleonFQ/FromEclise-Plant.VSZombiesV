package control;

import java.util.Scanner;
import logic.Game;
import view.GamePrinter;

public class Controller {
	
	//Attributes
	private Game game; 
	private Scanner scanner;
	

	
	public final String prompt = "Command > ";


  
    //CONSTRUCTOR
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
   
    
    //Método que recibe el comando introducido por el usuario por consola y controla su flujo
    //Devuelve true en caso de que el usuario haya introducido un comando correcto y se deba avanzar ciclo
    //Devuelve false si el comando introducido es incorrecto o no se debe avanzar turno
    //Además controla la ejecución de la opción deseadqwa llamando a los métodos de la clase game segun sea necesario
    
    public void removeDead() {
    	game.removeDeadVampireAndSlayer();
    	
    }
    
    //Método que controla el flujo de una partida
    //El pimer bucle while controla el flujo de una partida
    //El segundo bucle controla que el ciclo no avance hasta que el usuario haya introducido una opcion valida
    //El if final controla que se incremente el numero de ciclos y se evalue un posible fin de partida solo si
    //el usuario no ha seleccionado la opcion exit o reset
    public void run() { 
    	game.reset();
    	while(!game.getFin()) {
    		game.printTable();
			String line = scanner.nextLine();
	    	String[]words =line.toLowerCase().trim().split("\\s+");	
    	    if (game.execCommand(words)) {
    	    	game.update();
    	    	game.Attack();
    	    	game.AddVampire();
    	    	game.removeDeadVampireAndSlayer();
    	    	game.gameOver();
    	    }
			
		} 
    	
    }

}