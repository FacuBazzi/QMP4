package qmp4;

import java.util.*;

public class Usuario {

	GeneradorSugerencias generadorSugerencias;
	ControladorClima controladorClima;
	
	List<Prenda> misPrendas;
	
	List<Sugerencia> pedirSugerencias() {
		return generadorSugerencias.generarSugerencias(misPrendas);
	}
	
	ReporteClima pedirReporteClima() {
		return controladorClima.pedirReporteClima();
	}
	
}
