package Elements;

public class VampireList {

	private Vampire[] vl;
	private int cnt;
	private int totalV;

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
	
	
	
	
	
	//devuelve el numero de vampiros en el array de vampiros
	public int numberVampires() {
		return vl.length;
		
	}
	
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
	
	public void advanceVampire(int i) {
		vl[i].advanceVampire();
	}
	
	public void shotVampire(int fila) {
		for(int i = 0; i < this.cnt; i++) {
			if (vl[i].equals(fila)) {
				vl[i].setHealth(1);
			}
		}
	}
	
	public int giveBitteX(int pos) {
		return vl[pos].getX();
	}
	
	public int giveBitteY(int pos) {
		return vl[pos].getY();
	}
	
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
	
	public void iniCnt() {
		this.cnt = 0;
		this.totalV = 0;
	}
	
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
	
	public boolean noMoreVampires(int maxVampires) {
		boolean end = false;
		if(this.cnt == 0 && this.totalV == maxVampires) {
			end = true;
		}
		return end;
	}

}