package core;

import java.util.ArrayList;
import java.util.Hashtable;

public class Conector {
	
	private String nombre;

	private String componenteOrigen;
	private String componenteDestino;
	
	//Atributos de calidad.
	private Hashtable<String,Float> atributosCalidad = new Hashtable<String,Float>();
	
	//Escenarios de calidad por cada atributo.
	private Hashtable<String, Hashtable<String, EscenarioDeCalidad>> escenariosCalidad = new Hashtable<String,Hashtable<String, EscenarioDeCalidad>>();
	
	
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

	public Hashtable<String, Float> getAtributosCalidad() {
		return atributosCalidad;
	}

	public void setAtributosCalidad(Hashtable<String, Float> atributosCalidad) {
		this.atributosCalidad = atributosCalidad;
	}

	public Hashtable<String, Hashtable<String, EscenarioDeCalidad>> getEscenariosCalidad() {
		return escenariosCalidad;
	}

	public void setEscenariosCalidad(
			Hashtable<String, Hashtable<String, EscenarioDeCalidad>> escenariosCalidad) {
		this.escenariosCalidad = escenariosCalidad;
	}
	
	
}
