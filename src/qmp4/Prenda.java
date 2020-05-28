package qmp4;

public class Prenda {
	
	// info de la prenda de las anteriores iteraciones
	int tempMaxima;
	int tempMinima;
	
	boolean aptaParaTemperaturaActual(int temperatura) {
		return (temperatura>=tempMinima && temperatura<=tempMaxima);
	}
	
}
