package Elements;

public class SlayerList {
	//attibutes
	private Slayer[] sl;
	private int cnt;
	
	//constructor
	public SlayerList(int max) {
		this.sl = new Slayer[max];
		this.cnt = 0;
	}

	//metodos:
	
	//metodo que recibe una posicion, busca dentro de la lista de slayers
	//si existe un objeto con las mismas coordenadas y si existe devuelve true
	public boolean isSlayerHere(int x, int y) {
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < this.cnt) {
			isHere = sl[i].equals(x, y);
			i++;
		}
		return isHere;
	}
	
	//metodo que crea un nuevo objeto slayer y lo añade al array
	public void addElement(int x, int y) {
		sl[this.cnt] = new Slayer(y, x);
		this.cnt++;
		
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de slayers
	//si existe un objeto con las mismas coordenadas, y si existe 
	//devuelve un string con su salud
	public String slayerToString (int x, int y) {
		String slayer;
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < this.cnt) {
			isHere = sl[i].equals(x, y);
			i++;
		}
		if (isHere) {
			i--;
			slayer = sl[i].toString();
		}
		else {
			slayer = "       ";
		}
		
		return slayer;
	}
	
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	public int giveShot(int pos) {
		return sl[pos].getX();
	}
	
	public void bitteSlayer(int x, int y) {
		for(int i = 0; i < this.cnt; i++) {
			if (sl[i].equals(x, y-1)) {
				sl[i].setHealth(1);
			}
		}
	}
	
	public void removeSlayer() {
		for(int i=0; i < this.cnt; i++) {
			if (sl[i].isDead()) {
				for(int j=i; j < (this.cnt-1) ; j++) {
					sl[j] = sl[j+1];
					
				}
				this.cnt--;
			}
		}
	}
	
	
	public void iniCnt() {
		this.cnt = 0;
	}
	
	
	
	
	
	
	
	

	//metodo que devuelve el numero de slayer que hay.
	public int numberSlayers() {
		
		return sl.length;
				
		
	}
	
	//retorna la vida de un vampire en una posicion i:
		public int slayerHealth(int i) {
			return sl[i].getHealth();
		}
		
		public int getXsLayerI(int i) {
			return sl[i].getX();
		}
		public int getYslayerI(int i) {
			return sl[i].getY();
		}
	

}