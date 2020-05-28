package qmp4;

import java.util.*;
import java.util.List; 
import java.util.stream.Collectors; 

public class ControladorClima {   // singleton
	
	ServicioClima servicioClima;
	List<Map<String, Object>> climaProximas12Horas = new ArrayList<>();
	CondicionClimatica condicionClimatica;
	
	// Estaría bueno que cada un par de horas se ejecute este método automáticamente para tener un registro propio de las
	// condiciones climáticas del día entero. Se podría hacer cada 3 horas, teniendo una cobertura del clima de las 24 horas del día
	// de manera medianamente actualizada, sin tener que pasar el límite de 10 consultas diarias a la API para que no nos cobren.
	// Cuando un cliente o algo/alguien necesite usar información del clima, lo tomará de nuestro registro y no de la API: nosotros
	// controlamos cuantas veces se consulta a la API para no pagar de más, y en nuestro sistema se consulta las veces necesarias
	// de nuestro propio registro.
	public void obtenerClimaProximo() {
		climaProximas12Horas = servicioClima.getWeather("Buenos Aires, Argentina");
	}
	
	public Map<String, Object> climaActual() {
		return climaProximas12Horas.get(this.posicionSegunHoraActual());
	}
	
	private int posicionSegunHoraActual() {return 0;} // habría que ver la forma de calcular posicionSegunHoraActual
	
	public List<Prenda> definirPrendasAptas(List<Prenda> prendas) {
		return prendas.stream().
			   filter(prenda->prenda.aptaParaTemperaturaActual(condicionClimatica.temperatura(this.climaActual()))).
			   collect(Collectors.toList());
	}

	public ReporteClima pedirReporteClima() {
		return condicionClimatica.reporteClima(this.climaActual());
	}
	
}
