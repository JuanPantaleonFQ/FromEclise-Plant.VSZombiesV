package utils;

import Elements.Slayer;
import Elements.SlayerList;
import Elements.VampireList;



public class GameObjectBoard {
	
	//Attributes
		
		private SlayerList s;
		private VampireList v;
	   	
	   	//constructor
	    public GameObjectBoard (int maxV, int maxS) {
	        this.v = new VampireList(maxV);
	        this.s = new SlayerList(maxS);
	    }
	    
	   
	
	
	    //Metodo que recibe unas coordenadas, realiza una busqueda y devuelve si existe o no un objeto
	    //con esas coordenadas
	    public boolean positionAvaible(int x, int y) {
			boolean avaible = true;
			if (avaible) {
				avaible = !v.isVlayerHere(x, y);
			}
			
			if (avaible) {
				avaible =  !s.isSlayerHere(x, y);
			}
			
			return avaible;
		}
	    
	    //metodo para añadir un slayer 
		public void addToS (int x, int y) {
			s.addElement(x, y);
		}
		//metodo para añadir un vampiros 
		public void addToV (int x, int y) {
			v.addElement(x, y);
		}
		
		//Metodo que recibe el numero total de vampiros que aparecen en un nivel
		//lo compara con el numero de vampiros que han aparecido en esta partida
		//y devuelve si quedan o no mas vampiros por aparecer
		public boolean moreVampire(int n) {
			boolean more = true;
			if(n == v.getTotalV()) {
				more = false;
			}
			return more;
		}
		
		//Metodo que recibe unas coordenadas y devuelve un string con el formato deseado
		//Primero llamamos al metodo de la clase VampireList, que nos devolvera un string con el formato del vampiro
		//si existe un vampiro con las coordenadas aportadas o un string vacio si no existe un vampiro en esas coordenadas
		//Si el string recibido es vacio entonces llamara al metodo de SlayerList que nos devolvera un string con 
		//el formato del slayer si existe en esas coordenadas o un string en este formato "      " en caso de no existir
		public String posString(int x, int y) {
			String pos;
			pos = v.vampireToString(x, y);
			if (pos.equals("")) {
				pos = s.slayerToString(x, y);
			}
			return pos;
		}
		
		//metodo que devuelve el numero total de vampiros que han aparecido durante el juego
		public int numberOfV() {
			return v.getTotalV();
		}
		
		//metodo que devuelve el numero total de vampiros que estan sobre el tablero
		public int vampiresOnBoard() {
			return v.getCnt();
		}
		
		//metodo que ejecuta el avance de todos los vampiros del tablero
		public void advanceVampire() {
			for(int i = 0; i < v.getCnt(); i++) {
				if (positionAvaible(v.getXvampireI(i), v.getYvampireI(i)-1)) {
					v.advanceVampire(i);
				}
			}
		}
		
		//Metodo que ejecuta el ataque de todos los slayers del tablero
		public void slayerAttack() {
			v.reciveAtack(x,y);
		}
		
		//Metodo que ejecuta el ataque de todos los vampiros del tablero
		public void vampireAttack(int x,int y) {
			s.reciveAtack(x,y);
		}
		
		//Metodo que elimina todos los elementos sin vida del tablero
		public void updateSlayer() {
			s.removeSlayer();
		}
		
		public void updateVampire() {
			v.removeVampire();
		}
		
		//metodo que resetea los contadores del juego
		public void resetBoard() {
			v.iniCnt();
			s.iniCnt();
		}
		
		
		
		//Metodo que chequea un fin del juego, para ello recibe el numero maximo de vampiros que pueden aparecer
		//Controla el ganador
		public boolean endGame(int maxVampires) {
			boolean end = false;
			if(v.isVampireFinal()) {
				end = true;
				System.out.println("GAME OVER \nVampires win");
			}
			else if (v.noMoreVampires(maxVampires)){
				end = true;
				System.out.println("GAME OVER \nPlayer win");
			}
			return end;
		}
		
		
		public boolean SlayerHere(int x, int y) {
			return(s.isSlayerHere(x, y));
						
			
		}
			
			
			
			
			
}
