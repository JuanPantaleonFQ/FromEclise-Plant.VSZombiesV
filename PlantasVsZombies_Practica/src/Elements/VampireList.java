package Elements;

public class VampireList {

	private Vampire[] vl;
	private int cnt; //Contador del array(controla los vampiros que hay en el board)
	private int totalV; //Contador total de vampiros(controla todos los vampiros que han aparecido en la partida)

	
	public VampireList(int max) {
		this.vl = new Vampire[max];
		this.cnt = 0;
		this.totalV = 0;
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de vampiros
	//si existe un objeto con las mismas coordenadas y si existe devuelve true
	public boolean isVlayerHere(int x, int y) {
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < this.cnt) {
			isHere = vl[i].equals(x, y);
			i++;
		}
		return isHere;
	}
	
	//Metodo que crea un nuevo objeto vampiro y lo añade al array
	//Controla ademas el incremento de
	public void addElement(int x, int y) {
		vl[cnt] = new Vampire(x, y);
		this.cnt++;
		this.totalV++;
		
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de vampiros
	//si existe un objeto con las mismas coordenadas, y si existe 
	//devuelve un string con su salud
	public String vampireToString (int x, int y) {
		String vampire;
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < this.cnt) {
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
	
	
	
	

	//GETTERS & SETTERS
	//retorna la vida de un vampire en una posicion i:
	public int vampireHealth(int i) {
		return vl[i].getHealth();
	}
	//dos metodos que devuelven la pos X e Y de un vampiro de la lista:
	public int getXvampireI(int i) {
		return vl[i].getX();
	}
	public int getYvampireI(int i) {
		return vl[i].getY();
		
	}
	public int getTotalV() {
		return totalV;
	}

	public void setTotalV(int totalV) {
		this.totalV = totalV;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	//Metodo que recibe una posicion, y ejecuta el metodo advanceVampire de la clase Vampire 
	//sobre el objeto que contie el array de la posicion recibida
	public void advanceVampire(int i) {
		vl[i].advanceVampire();
	}
	
	//Metodo que recibe un numero de fila donde se encuentra un slayer
	//Recorre el array decrementando la salud del primer vampiro que se encuentren en esa fila
	public void shotVampire(int fila) {
		boolean shotter = false;
		int i = 0;
		while ((i < this.cnt) && !shotter) {
			if (vl[i].equals(fila)) {
				vl[i].setHealth(1);
				shotter = true;
			}
			i++;
		}
	}
	
	
	//Getter de las coordenadas de un vampiro dada una posicion en el array
	public int giveBitteX(int pos) {
		return vl[pos].getX();
	}
	public int giveBitteY(int pos) {
		return vl[pos].getY();
	}
	
	
	//Metodo que recorre el array de vampiros eliminando los que hayan muerto
	//El primer for recorre el array completo de vampiros
	//El if controla si el vampiro de esa vuelta de bucle está muerto
	//El segundo for elimina del array ese ese slayer
	//Se controla el contador
	public void removeVampire() {
		for(int i=0; i < cnt; i++) {
			if (vl[i].isDead()) {
				for(int j=i; j < cnt; j++) {
					vl[j] = vl[j+1];
					
				}
				this.cnt--;
			}
		}
	}
	
	//Metodo que inicializa el contador y el numero de vampiros que han aparecido a 0
	public void iniCnt() {
		this.cnt = 0;
		this.totalV = 0;
	}
	
	//Metodo que controla si algun objeto del array se encuentra en la columna 1 (posible fin de partida)
	public boolean isVampireFinal() {
		boolean end = false;
		int i = 0;
		while(!end && i < this.cnt) {
			if(vl[i].end()) {
				end = true;
			}
			i++;
		}
		return end;
	}
	
	//Metodo que controla si quedan mas vampiros por aparecer (posible fin de partida)
	public boolean noMoreVampires(int maxVampires) {
		boolean end = false;
		if(this.cnt == 0 && this.totalV == maxVampires) {
			end = true;
		}
		return end;
	}
	
	//Metodo que recibe una posicion, y devuelve el Health del vampire que contiene esa posicion del array
		public int getHealth(int pos) {
			return vl[pos].getHealth();
		}

}