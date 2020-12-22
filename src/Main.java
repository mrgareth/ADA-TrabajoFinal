import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String[] titulos = {"TOTAL CASOS POSITIVOS	","	FALLECIDOS	","	TOTAL MUESTRAS	","	POSITIVIDAD (%)	","	LETALIDAD (%)	"};
		ArrayList<Region> regiones = new ArrayList<Region>();
		llenarDatos(regiones);		
		mostrarCercanos(regiones, titulos);
		
	}
	public static void mostrarCercanos(ArrayList<Region> r, String[] t) {
		System.out.println("Las regiones mas parecida según: ");
		for (int item = 0; item < r.get(0).items.length; item++) {//por cada item, haremos el mismo proceso
			merge(r, item);	//Le ingresamos el número del item para que sepa con cual esta trabajando
			double aux = r.get(1).items[item] - r.get(0).items[item];
			String r1 = r.get(0).nombre;
			String r2 = r.get(1).nombre;
			for (int region = 1; region < r.size() - 1; region++) {//ya que no comparamos la ultima region con otra
				if (aux > r.get(region+1).items[item]  - r.get(region).items[item]) {
					aux = r.get(region+1).items[item]  - r.get(region).items[item];
					r1 = r.get(region).nombre;
					r2 = r.get(region+1).nombre;
				}	
			}
			System.out.println(t[item]+ ": "+ r1 +" y " + r2 + "\tLa diferencia de sus casos es:" + aux );
		}
	}
	
	public static void merge(ArrayList<Region> list, int n) {
		if (list.size() > 1) {
			int half = list.size()/2;//hallamos la mitad
			ArrayList<Region> left = new ArrayList<Region>();//lista izquierda
			full(list, left, half);// llenamos lista izquierda
			merge(left, n);
			ArrayList<Region> right = new ArrayList<Region>();//lista derecha
			full(list, right);//llenamos lista derecha
			merge(right, n);
			merge(list ,left, right, n);//aqui uniremos en orden las 2 listas
		}
	}
	public static void merge(ArrayList<Region> list, ArrayList<Region> l , ArrayList<Region> r, int n) {
		if (l.isEmpty()) 
			while (!r.isEmpty())
				list.add(r.remove(0));
		else if (r.isEmpty()) 
			while (!l.isEmpty())
				list.add(l.remove(0));
		else {
			if (r.get(0).items[n] < l.get(0).items[n])
				list.add(r.remove(0));
			else
				list.add(l.remove(0));
				merge(list, l, r, n);
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
	
	public static void llenarDatos(ArrayList<Region> regiones) {
		regiones.add(new Region("LIMA METROPOLITANA",	402669	,	14791	,	2306070	,	17.46	,	3.67	));
		regiones.add(new Region("CALLAO",	41530	,	1923	,	174812	,	23.76	,	4.63	));
		regiones.add(new Region("LA LIBERTAD",	36033	,	2400	,	178282	,	20.21	,	6.66	));
		regiones.add(new Region("AREQUIPA",	46799	,	1549	,	292696	,	15.99	,	3.31	));
		regiones.add(new Region("MOQUEGUA",	15507	,	292	,	98778	,	15.70	,	1.88	));
		regiones.add(new Region("CUSCO",	24332	,	508	,	148650	,	16.37	,	2.09	));
		regiones.add(new Region("LAMBAYEQUE",	31562	,	1876	,	138971	,	22.71	,	5.94	));
		regiones.add(new Region("PIURA",	41410	,	2145	,	163742	,	25.29	,	5.18	));
		regiones.add(new Region("AMAZONAS",	18161	,	243	,	82595	,	21.99	,	1.34	));
		regiones.add(new Region("ICA",	31264	,	1736	,	147744	,	21.16	,	5.55	));
		regiones.add(new Region("JUNIN",	26046	,	919	,	153779	,	16.94	,	3.53	));
		regiones.add(new Region("ANCASH",	29218	,	1449	,	159770	,	18.29	,	4.96	));
		regiones.add(new Region("CAJAMARCA",	24260	,	575	,	133800	,	18.13	,	2.37	));
		regiones.add(new Region("HUANUCO",	19429	,	461	,	101595	,	19.12	,	2.37	));
		regiones.add(new Region("APURIMAC",	6781	,	143	,	78155	,	8.68	,	2.11	));
		regiones.add(new Region("PUNO",	18721	,	377	,	101575	,	18.43	,	2.01	));
		regiones.add(new Region("TACNA",	14242	,	255	,	83581	,	17.04	,	1.79	));
		regiones.add(new Region("LORETO",	25131	,	992	,	70331	,	35.73	,	3.95	));
		regiones.add(new Region("SAN MARTIN",	24595	,	783	,	98162	,	25.06	,	3.18	));
		regiones.add(new Region("AYACUCHO",	14751	,	360	,	78074	,	18.89	,	2.44	));
		regiones.add(new Region("HUANCAVELICA",	7742	,	137	,	58444	,	13.25	,	1.77	));
		regiones.add(new Region("PASCO",	6331	,	127	,	46084	,	13.74	,	2.01	));
		regiones.add(new Region("TUMBES",	9235	,	333	,	42850	,	21.55	,	3.61	));
		regiones.add(new Region("UCAYALI",	19626	,	376	,	64053	,	30.64	,	1.92	));
		regiones.add(new Region("MADRE DE DIOS",	9326	,	151	,	43237	,	21.57	,	1.62	));
		regiones.add(new Region("LIMA REGIÓN",	31920	,	1500	,	149669	,	21.33	,	4.7	));
		
	}
}


