package controles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCase {
	private String nombre;
	private String objetivo;
	private Date fechaEjecucion;
	private String pathArchivo;
	private String status;
	private List<Step> steps;

	public TestCase(String nombre, String objetivo, Date fechaEjecucion, String status) {
		this.nombre = nombre;
		this.objetivo = objetivo;
		this.fechaEjecucion = fechaEjecucion;
		this.status = status;
		steps = new ArrayList<>();
		this.pathArchivo = "input/" + nombre + ".txt";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getPathArchivo() {
		return pathArchivo;
	}

	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
