package qmp4;

import java.util.*;

public class GeneradorSugerencias {  // singleton
	
	ControladorClima controladorClima;
	
	public List<Sugerencia> generarSugerencias(List<Prenda> prendas) {
		return this.armarConjuntos(this.filtrarPrendas(prendas));
	}
	
	private List<Sugerencia> armarConjuntos(List<Prenda> prendasAptas) {
		// bla bla bla
		return null;
	}
	
	private List<Prenda> filtrarPrendas(List<Prenda> prendas) {
		return controladorClima.definirPrendasAptas(prendas);
	}
	
}
