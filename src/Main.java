import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Region> regiones = new ArrayList<Region>();
		regiones.add(new Region("Ica", 50));
		regiones.add(new Region("Lima", 100));
		regiones.add(new Region("Cusco", 200));
		regiones.add(new Region("Arequipa", 201));
		mostrarCercanos(regiones);
		
	}
	public static void mostrarCercanos(ArrayList<Region> r) {
//		//for (int item = 0; item < r.get(0).items.length; item++) {//por cada item, haremos el mismo proceso
		merge(r);	
		int aux = r.get(1).positivos - r.get(0).positivos;
		String r1 = r.get(0).nombre;
		String r2 = r.get(1).nombre;
		for (int region = 1; region < r.size() - 1; region++) {//ya que no comparamos la ultima region con otra
			if (aux > r.get(region+1).positivos  - r.get(region).positivos) {
					aux = r.get(region+1).positivos  - r.get(region).positivos;
					r1 = r.get(region).nombre;
					r2 = r.get(region+1).nombre;
			}		
		}
		System.out.println("Las regiones mas parecidas según sus casos positivos son: \n"+ r1 +" y " + r2 + "\nLa diferencia de sus casos es:" + aux);
	}
	
	public static void merge(ArrayList<Region> list) {
		if (list.size() > 1) {
			int half = list.size()/2;//hallamos la mitad
			ArrayList<Region> left = new ArrayList<Region>();//lista izquierda
			full(list, left, half);// llenamos lista izquierda
			merge(left);
			ArrayList<Region> right = new ArrayList<Region>();//lista derecha
			full(list, right);//llenamos lista derecha
			merge(right);
			merge(list ,left, right);//aqui uniremos en orden las 2 listas
		}
	}
	public static void merge(ArrayList<Region> list, ArrayList<Region> l , ArrayList<Region> r) {
		if (l.isEmpty()) 
			while (!r.isEmpty())
				list.add(r.remove(0));
		else if (r.isEmpty()) 
			while (!l.isEmpty())
				list.add(l.remove(0));
		else {
			if (r.get(0).positivos < l.get(0).positivos)
				list.add(r.remove(0));
			else
				list.add(l.remove(0));
				merge(list, l, r);
		}
	}
	public static void full(ArrayList<Region> a1, ArrayList<Region> a2, int count) {
		while (count > 0) {
			a2.add(a1.remove(0));
			count--;
		}
	}
	public static void full(ArrayList<Region> a1, ArrayList<Region> a2) {
		while (!a1.isEmpty()) 
			a2.add(a1.remove(0));
	}
}


