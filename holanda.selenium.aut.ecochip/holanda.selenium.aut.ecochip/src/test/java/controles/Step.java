package controles;

public class Step {
	private String accion;
	private String elemento;
	private String resultadoEsperado;
	private String resultadoLogrado;
	private String status;
	private String evidence;

	public Step(String accion, String elemento, String resultadoEsperado, String resultadoLogrado, String status,
			String evidence) {
		this.accion = accion;
		this.elemento = elemento;
		this.resultadoEsperado = resultadoEsperado;
		this.resultadoLogrado = resultadoLogrado;
		this.status = status;
		this.evidence = evidence;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getResultadoEsperado() {
		return resultadoEsperado;
	}

	public void setResultadoEsperado(String resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}

	public String getResultadoLogrado() {
		return resultadoLogrado;
	}

	public void setResultadoLogrado(String resultadoLogrado) {
		this.resultadoLogrado = resultadoLogrado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String generateFileLineforStepLog() {
		return this.accion + ";" + this.elemento + ";" + this.resultadoEsperado + ";" + this.resultadoLogrado + ";"
				+ this.status + ";" + this.evidence;
	}

}

