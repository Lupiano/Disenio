package core;

import java.util.ArrayList;

public class Atributo {
	
	private String nombre;
	private ArrayList<Atributo> atributosTradeOff = new ArrayList<Atributo>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Atributo> getAtributosTradeOff() {
		return atributosTradeOff;
	}
	public void setAtributosTradeOff(ArrayList<Atributo> atributosTradeOff) {
		this.atributosTradeOff = atributosTradeOff;
	}
		
}

