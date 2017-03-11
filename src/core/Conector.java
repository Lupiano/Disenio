package core;

import java.util.ArrayList;
import java.util.Hashtable;

import ui.Modelo;

public class Conector {
	
	public Conector(){
		Atributo a1 = new Atributo("Performance");
		Atributo a2 = new Atributo("Seguridad");
		Atributo a3 = new Atributo("Modificabilidad");
		Atributo a4 = new Atributo("Disponibilidad");
		Atributo a5 = new Atributo("Usabilidad");
		Atributo a6 = new Atributo("Testability");
		
		atributosCalidad.add(a1);
		atributosCalidad.add(a2);
		atributosCalidad.add(a3);
		atributosCalidad.add(a4);
		atributosCalidad.add(a5);
		atributosCalidad.add(a6);
	}
	
	private String nombre;
	private String tipo;
	private String componenteOrigen;
	private String componenteDestino;
	private ArrayList<Propiedades> propiedades = new ArrayList<Propiedades>();
	
	//Atributos de calidad.
	private ArrayList<Atributo> atributosCalidad = new ArrayList<Atributo>();
	
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

	public ArrayList<Atributo> getAtributosCalidad() {
		return atributosCalidad;
	}

	public void setAtributosCalidad(ArrayList<Atributo> atributosCalidad) {
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
		for (Atributo a: this.atributosCalidad){
    		if(a.getNombre().equals(nombre))
        		return a;
    	}
		return null;
	}
	
}
