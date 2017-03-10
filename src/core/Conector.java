package core;

import java.util.ArrayList;
import java.util.Hashtable;

import ui.Modelo;

public class Conector {
	
	public Conector(){
		Float cero = ((float)0);
		Atributo a1 = new Atributo("Performance");
		Atributo a2 = new Atributo("Seguridad");
		Atributo a3 = new Atributo("Modificabilidad");
		Atributo a4 = new Atributo("Disponibilidad");
		Atributo a5 = new Atributo("Usabilidad");
		Atributo a6 = new Atributo("Testability");
		
		atributosCalidad.put(a1, cero);
		atributosCalidad.put(a2, cero);
		atributosCalidad.put(a3, cero);
		atributosCalidad.put(a4, cero);
		atributosCalidad.put(a5, cero);
		atributosCalidad.put(a6, cero);
	}
	
	private String nombre;
	private String tipo;
	private String componenteOrigen;
	private String componenteDestino;
	private ArrayList<Propiedades> propiedades = new ArrayList<Propiedades>();
	
	//Atributos de calidad.
	private Hashtable<Atributo,Float> atributosCalidad = new Hashtable<Atributo,Float>();
	
	//Escenarios de calidad por cada atributo.
	private Hashtable<String, Hashtable<String, EscenarioDeCalidad>> escenariosCalidad = new Hashtable<String,Hashtable<String, EscenarioDeCalidad>>();
	
	public String getTipo(){
		return tipo;
	}
	
	public void SetTipo(String tipo){
		this.tipo = tipo;
	}
	
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

	public Hashtable<Atributo, Float> getAtributosCalidad() {
		return atributosCalidad;
	}

	public void setAtributosCalidad(Hashtable<Atributo, Float> atributosCalidad) {
		this.atributosCalidad = atributosCalidad;
	}

	public Hashtable<String, Hashtable<String, EscenarioDeCalidad>> getEscenariosCalidad() {
		return escenariosCalidad;
	}

	public void setEscenariosCalidad(
			Hashtable<String, Hashtable<String, EscenarioDeCalidad>> escenariosCalidad) {
		this.escenariosCalidad = escenariosCalidad;
	}
	
	public ArrayList<Propiedades> getPropiedades(){
		return propiedades;
	}
	
	public Atributo getAtributo(String nombre){
		for (Atributo a: Modelo.conectorActual.getAtributosCalidad().keySet()){
    		if(a.getNombre().equals(nombre))
        		return a;
    	}
		return null;
	}
	
}
