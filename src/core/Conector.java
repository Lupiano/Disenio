package core;

import java.util.ArrayList;
import java.util.Hashtable;

public class Conector {
	
	private String nombre;

	private String componenteOrigen;
	private String componenteDestino;
	
	//Atributos de calidad.
	private Hashtable<String,Integer> atributosCalidad = new Hashtable<String,Integer>();
	
	//Escenarios de calidad por cada atributo.
	private Hashtable<String,ArrayList<EscenarioDeCalidad>> escenariosCalidad = new Hashtable<String,ArrayList<EscenarioDeCalidad>>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getComponenteOrigen() {
		return componenteOrigen;
	}

	public void setComponenteOrigen(String componenteOrigen) {
		this.componenteOrigen = componenteOrigen;
	}

	public String getComponenteDestino() {
		return componenteDestino;
	}

	public void setComponenteDestino(String componenteDestino) {
		this.componenteDestino = componenteDestino;
	}

	public Hashtable<String, Integer> getAtributosCalidad() {
		return atributosCalidad;
	}

	public void setAtributosCalidad(Hashtable<String, Integer> atributosCalidad) {
		this.atributosCalidad = atributosCalidad;
	}

	public Hashtable<String, ArrayList<EscenarioDeCalidad>> getEscenariosCalidad() {
		return escenariosCalidad;
	}

	public void setEscenariosCalidad(
			Hashtable<String, ArrayList<EscenarioDeCalidad>> escenariosCalidad) {
		this.escenariosCalidad = escenariosCalidad;
	}
	
	
}
