
public class Region {
	protected String nombre;
	//TOTAL CASOS,	FALLECIDOS,	TOTAL MUESTRAS,	POSITIVIDAD (%),	LETALIDAD (%)
	protected double[] items = new double[5];
	public Region(String nombre, double positivos, double fallecidos, double muestras, double positividad, double letalidad ) {
		this.nombre = nombre;
		items[0] = positivos;
		items[1] = fallecidos; 
		items[2] = muestras;
		items[3] = positividad; 
		items[4] = letalidad;
	}

	
	
}
