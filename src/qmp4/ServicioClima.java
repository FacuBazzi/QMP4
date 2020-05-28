package qmp4;

import java.util.*;

public interface ServicioClima {
	public List<Map<String, Object>> getWeather(String ciudad);
}
