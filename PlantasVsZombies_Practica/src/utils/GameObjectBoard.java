package utils;
import Elements.Slayer;
import Elements.SlayerList;
import Elements.Vampire;
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
	    
	   
	
	
	    
	    //metodo para añadir un slayer 
		public void addToS (Slayer sl) {
			s.addElement(sl);
		}
		//metodo para añadir un vampiros 
		public void addToV (Vampire vp) {
			v.addElement(vp);
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
		
	
		
		//metodo que ejecuta el avance de todos los vampiros del tablero
		public void advanceVampire() {
				v.advanceVampire();
		}
		
		//Metodo que ejecuta el ataque de todos los slayers del tablero
		public void slayerAttack(int x, int y) {
			v.recivedAttack(x,y);
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
		
		
		public boolean SlayerHere(int x, int y) {
			return(s.isSlayerHere(x, y));
						
		}
	
		public boolean VampireHere(int x, int y, boolean columna) {
			return(v.isVampirerHere(x, y, columna));					
		}
		
		public boolean positionAvaible (int x, int y) {
			return !(s.isSlayerHere(x, y) || v.isVampirerHere(x, y, false));
		}
		
		public void Attack() {
			v.attack();
			s.attack();

		}
		
		
}