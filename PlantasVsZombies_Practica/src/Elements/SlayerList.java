package Elements;

public class SlayerList {
	//attibutes
	Slayer[] sl;
	public static int cnt;
	
	//constructor
	public SlayerList(int max) {
		this.sl = new Slayer[max];
	}

	//metodos:
	
	//metodo que recibe una posicion, busca dentro de la lista de slayers
	//si existe un objeto con las mismas coordenadas y si existe devuelve true
	public boolean isSlayerHere(int x, int y) {
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < SlayerList.cnt) {
			isHere = sl[i].equals(x, y);
			i++;
		}
		return isHere;
	}
	
	//metodo que crea un nuevo objeto slayer y lo añade al array
	public void addElement(int x, int y) {
		sl[cnt] = new Slayer(x, y);
		
	}
	
	//metodo que recibe una posicion, busca dentro de la lista de slayers
	//si existe un objeto con las mismas coordenadas, y si existe 
	//devuelve un string con su salud
	public String slayerToString (int x, int y) {
		String slayer;
		boolean isHere = false;
		int i = 0;
		while (!isHere && i < VampireList.cnt) {
			isHere = sl[i].equals(x, y);
			i++;
		}
		/*Lo que hace este while es: ¿Hay algun slayer en la posicion del array de slayer i, con coordenadas x y?*/
		
		if (isHere) {
			slayer = " S [" + sl[i--].getHealth() + "] ";
		}
		else {
			slayer = "       ";
		}
		
		return slayer;
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