package utils;

import Elements.SlayerList;
import Elements.VampireList;



public class GameObjectBoard {
	
	//Attributes
		
		private SlayerList s;
		private VampireList v;
	   	
	   	//constructores
	    public GameObjectBoard (int maxV, int maxS) {
	        this.v = new VampireList(maxV);
	        this.s = new SlayerList(maxS);
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
	    
	  //metodo para añadir un slayer 
		public void addToS (int x, int y) {
			s.addElement(x, y);
		}
		
		public void addToV (int x, int y) {
			v.addElement(x, y);
		}
		
		
		public boolean moreVampire(int n) {
			boolean more = true;
			if(n == v.getTotalV()) {
				more = false;
			}
			return more;
		}
		
		
		public String posString(int x, int y) {
			String pos;
			pos = v.vampireToString(x, y);
			if (pos.equals("")) {
				pos = s.slayerToString(x, y);
			}
			return pos;
		}
		
		public int numberOfV() {
			return v.getTotalV();
		}
		
		public int vampiresOnBoard() {
			return v.getCnt();
		}
		
		public void advanceVampire() {
			for(int i = 0; i < v.getCnt(); i++) {
				if (positionAvaible(v.getXvampireI(i), v.getYvampireI(i)-1)) {
					v.advanceVampire(i);
				}
			}
		}
		
		public void slayerAttack() {
			for(int i = 0; i < s.getCnt(); i++) {
				v.shotVampire(s.giveShot(i));
			}
		}
		
		public void vampireAttack() {
			for(int i = 0; i < v.getCnt(); i++) {
				s.bitteSlayer(v.giveBitteX(i), v.giveBitteY(i));
			}
		}
		
		public void updateObjects() {
			v.removeVampire();
			s.removeSlayer();
		}
		
		public void resetBoard() {
			v.iniCnt();
			s.iniCnt();
		}
		
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
}
