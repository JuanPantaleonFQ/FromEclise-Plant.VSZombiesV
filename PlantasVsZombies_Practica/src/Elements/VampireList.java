package Elements;

public class VampireList {

	Vampire[] vl;
	public static int cnt;

	public VampireList(int max) {
		this.vl = new Vampire[max];
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de vampiros
	//si existe un objeto con las mismas coordenadas y si existe devuelve true
	public boolean isVlayerHere(int x, int y) {
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < VampireList.cnt) {
			isHere = vl[i].equals(x, y);
			i++;
		}
		return isHere;
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de vampiros
	//si existe un objeto con las mismas coordenadas, y si existe 
	//devuelve un string con su salud
	public String vampireToString (int x, int y) {
		String vampire;
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < VampireList.cnt) {
			isHere = vl[i].equals(x, y);
			i++;
		}
		/*Lo que hace este while es: ¿Hay algun vampire en la posicion del array de slayer i, con coordenadas x y?*/
		// la i devuelve la posicion de donde se pone el vampiro
		
		if (isHere) {
			vampire = " V [" + vl[i--].getHealth() + "] ";
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
	
	

}