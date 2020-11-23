package Elements;

public class VampireList {

	private Vampire[] vl;
	

	
	public VampireList(int max) {
		this.vl = new Vampire[max];
		
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de vampiros
	//si existe un objeto con las mismas coordenadas y si existe devuelve true
	public boolean isVampirerHere(int x, int y, boolean columna) {
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < Vampire.getCnt()) {
			if(!columna) {
				isHere = vl[i].equals(x, y);
			}
			else {
				isHere = vl[i].equals2(x, y);
			}
			i++;
		}
		return isHere;
	}
	
	//Metodo que crea un nuevo objeto vampiro y lo añade al array
	//Controla ademas el incremento de
	public void addElement(Vampire v) {
		vl[Vampire.getCnt()-1] = v;
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de vampiros
	//si existe un objeto con las mismas coordenadas, y si existe 
	//devuelve un string con su salud
	public String vampireToString (int x, int y) {
		String vampire;
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < Vampire.getCnt()) {
			isHere = vl[i].equals(x, y);
			i++;
		}
		if (isHere) {
			i--;
			vampire = vl[i].toString();
		}
		else {
			vampire = "";
		}
		
		return vampire;
	}
	
	
	
	

	
	
	
	
	//Metodo que recibe una posicion, y ejecuta el metodo advanceVampire de la clase Vampire 
	//sobre el objeto que contie el array de la posicion recibida
	public void advanceVampire() {
		for(int i = 0; i < Vampire.getCnt(); i++) {
			vl[i].advanceVampire();
		}
	}
	
	//Metodo que recibe un numero de fila donde se encuentra un slayer
	//Recorre el array decrementando la salud del primer vampiro que se encuentren en esa fila
	public void recivedAttack(int x, int y) {
		boolean shotter = false;
		int i = 0;
		while ((i < Vampire.getCnt()) && !shotter) {
			if (vl[i].equals2(x,y)) {
				vl[i].dealDamage();
				shotter = true;
			}
			i++;
		}
	}
	//-----------------------------------------------------------------------------------
	// ESTO DE AQUI ABAJO NO
	//
	//
	//
	/*
	 * //Getter de las coordenadas de un vampiro dada una posicion en el array
	public int giveBitteX(int pos) {
		return vl[pos].getX();
	}
	public int giveBitteY(int pos) {
		return vl[pos].getY();
	}
	 */
	
	
	//-----------------------------------------------------------------------------------
	
	//Metodo que recorre el array de vampiros eliminando los que hayan muerto
	//El primer for recorre el array completo de vampiros
	//El if controla si el vampiro de esa vuelta de bucle está muerto
	//El segundo for elimina del array ese ese slayer
	//Se controla el contador
	public void removeVampire() {
		for(int i=0; i < Vampire.getCnt(); i++) {
			if (vl[i].isDead()) {
				for(int j=i; j < Vampire.getCnt(); j++) {
					vl[j] = vl[j+1];
					
				}
				Vampire.setCnt();
			}
		}
	}
	
	//Metodo que inicializa el contador y el numero de vampiros que han aparecido a 0
	public void iniCnt() {
		Vampire.setCnt(0);
		Vampire.setTotalV(0);
	}
	
	
	//Metodo que controla si quedan mas vampiros por aparecer (posible fin de partida)
	public boolean noMoreVampires(int maxVampires) {
		boolean end = false;
		if((Vampire.getCnt() == 0) && (Vampire.getTotalV() == maxVampires)) {
			end = true;
		}
		return end;
	}
	
	public void attack () {
		for(int i=0; i < Vampire.getCnt(); i++) {
			vl[i].VampireAttack();
		}
	}


}