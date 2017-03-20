package core;

import java.util.ArrayList;

public class EscenarioDeCalidad {
	
	private String escenario;
	private String estimulo;
	private String fuenteEstimulo;
	private String medidaRespuesta;
	private String artefactoAfectado;
	private String ambiente;
	private String respuesta;
			
	public String getEscenario() {
		return escenario;
	}

	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

	public String getEstimulo() {
		return estimulo;
	}

	public void setEstimulo(String estimulo) {
		this.estimulo = estimulo;
	}

	public String getFuenteEstimulo() {
		return fuenteEstimulo;
	}

	public void setFuenteEstimulo(String fuenteEstimulo) {
		this.fuenteEstimulo = fuenteEstimulo;
	}

	public String getMedidaRespuesta() {
		return medidaRespuesta;
	}

	public void setMedidaRespuesta(String medidaRespuesta) {
		this.medidaRespuesta = medidaRespuesta;
	}

	public String getArtefactoAfectado() {
		return artefactoAfectado;
	}

	public void setArtefactoAfectado(String artefactoAfectado) {
		this.artefactoAfectado = artefactoAfectado;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	ArrayList<String> valores = new ArrayList<String>();

	public ArrayList<String> getValores() {
		return valores;
	}

	public void setValores(ArrayList<String> valores) {
		this.valores = valores;
	}
	
}
