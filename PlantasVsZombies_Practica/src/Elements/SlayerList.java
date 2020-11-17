package Elements;

public class SlayerList {
	
	private Slayer[] sl;
	private int cnt;
	
	//CONSTRUCTOR
	public SlayerList(int max) {
		this.sl = new Slayer[max];
		this.cnt = 0;
	}


	
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
	
	//metodo que crea un nuevo objeto slayer y lo a�ade al array
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
	
	//Getter
	public int getCnt() {
		return cnt;
	}
	//Setter
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	//--------------------------------------------------------------------------------------
	//ESTO DE AQUI ABAJO TAMPOCO.
	//
	//
	//
	//Metodo que recibe una posicion, y devuelve la fila del slayer que se encuentra en esa posicion
	//del array
	/*
	 * 
 	public int giveShot(int pos) {
		return sl[pos].getX();
	}
	
	//Metodo que recibe una posicion, y devuelve el Health del slayer que contiene esa posicion del array
	public int getHealth(int pos) {
		return sl[pos].getHealth();
	}
	 */
	
		
	//---------------------------------------------------------------------------------------
	
	//Metodo que recibe una coordenadas de un vampiro y si existe un slayer a su derecha
	//actualiza su vida decrementandola
	public void bitteSlayer(int x, int y) {
		for(int i = 0; i < this.cnt; i++) {
			if (sl[i].equals(x, y-1)) {
				sl[i].setHealth(1);
			}
		}
	}
	
	//Metodo que recorre el array de slayers eliminando los que hayan muerto
	//El primer for recorre el array completo de slayers
	//El if controla si el slayer de esa vuelta de bucle est� muerto
	//El segundo for elimina del array ese ese slayer
	//Se controla el contador
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
	
	//Metodo que inicializa el contador de slayers a 0
	public void iniCnt() {
		this.cnt = 0;
	}
	
	

}