package utils;

import Elements.SlayerList;
import Elements.VampireList;
import logic.Game;
import view.GamePrinter;


public class GameObjectBoard {
	
	//Attributes
		
		private SlayerList s;
		private VampireList v;
	   	private Game g;
	   	private GamePrinter printer;
	   	
	   	//constructores
	    public GameObjectBoard (int max) {
	        this.v = new VampireList(max);
	        this.s = new SlayerList(max);
	    }
	    
	    //setter y getters

	    public VampireList getV() {
	        return v;
	    }

	    public void setV(VampireList v) {
	        this.v = v;
	    }

	    public SlayerList getS() {
	        return s;
	    }

	    public void setS(SlayerList s) {
	        this.s = s;
	    }
	
	
	//metodos
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
	    
	  //metodo para añadir un slayer e incrementar el contador del array de slayers
		public void addToS (int x, int y) {
			s.addElement(x, y);
			SlayerList.cnt++;
		}
		
		public String posString(int x, int y) {
			String pos= "";
			pos = v.vampireToString(x, y);
			if (pos.equals("")) {
				pos = s.slayerToString(x, y);
			}
			return pos;
		}
		
		//metodo para eliminar un slayer o un vampire si estos han muerto
		//se comprueba en todo el tablero si hay un slayer con vida=0 o un vampire con vida = 0 
		// y se elimina del tablero.
		public void removeDead() {
			
			int numberVampires = v.numberVampires();
			int numberSlayers = s.numberSlayers();
			for (int i = 0; i < numberVampires; i++) {
				if (v.vampireHealth(i) == 0) {
					//remover del tablero
					printer.board[v.getXvampireI(i)][v.getYvampireI(i)] = "";
				
					
				}				
			}
			for (int i = 0; i < numberSlayers; i++) {
				if (v.vampireHealth(i) == 0) {
					//remover del tablero
					printer.board[s.getXsLayerI(i)][s.getYslayerI(i)] = "";
					
					
				}				
			}				
		}
		
		//metodo que comprueba si una fila esta vacia de cualquier objeto con " ".
		
		public boolean isRowempty(int row) {
			boolean empty = true;
			
			for (int i = 0; i < printer.showNumCols() ; i++) {
				if (printer.board[row][i] == "") {
					empty = true;
					
					
				}
				else {
					empty = false;
				}
				
				
			}
			return empty;
			
			
		}

}