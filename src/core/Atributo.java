package core;

import java.util.ArrayList;

public class Atributo {
	
	private String nombre;
	private ArrayList<Atributo> atributosTradeOff = new ArrayList<Atributo>();
	
	public Atributo(String nombre){
		this.nombre = nombre;
	}
	
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
	
	public void addAtributoTradeOff(Atributo at){
		this.atributosTradeOff.add(at);
	}
	
	public void removeAtributoTradeOff(String nomAtributo){
		for(Atributo a: this.atributosTradeOff){
			if(a.getNombre().equals(nomAtributo)){
				this.atributosTradeOff.remove(a);
			}
		}
	}
		
}
