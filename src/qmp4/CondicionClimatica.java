package qmp4;

import java.util.Map;

public class CondicionClimatica {  // es un "traductor"  // singleton

	public boolean esDeDia(Map<String, Object> clima) {
		return (boolean) clima.get("IsDayLight");
	}
	
	public float probabilidadPrecipitaciones(Map<String, Object> clima) {
		return (float) clima.get("PrecipitationProbability");
	}
	
	@SuppressWarnings("unchecked")
	public int temperatura(Map<String, Object> clima) {
		return (int) ((Map<String, Object>) clima.get("Temperature")).get("Value");
	}
	
	// etc
	
	public ReporteClima reporteClima(Map<String, Object> clima) {
		ReporteClima reporte = new ReporteClima();
		reporte.temperatura = this.temperatura(clima);
		reporte.esDeDia = this.esDeDia(clima);
		reporte.probabilidadDePrecipitaciones = this.probabilidadPrecipitaciones(clima);
		// etc
		return reporte;
	}
	
}