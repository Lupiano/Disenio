package core;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Atributo extends Observable implements Observer {
	
	private String nombre;
	private ArrayList<Atributo> atributosTradeOff = new ArrayList<Atributo>();
	private float valor = 0;
	private boolean yaModificado = false;
	private ArrayList<EscenarioDeCalidad> escenarios = new ArrayList<EscenarioDeCalidad>();
	
	public ArrayList<EscenarioDeCalidad> getEscenarios() {
		return escenarios;
	}

	public void setEscenarios(ArrayList<EscenarioDeCalidad> escenarios) {
		this.escenarios = escenarios;
	}

	public Atributo(String nombre){
		this.nombre = nombre;
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(!yaModificado){
			cambiarValor(1 - ((Atributo)arg0).getValor());
		}
	}

	public void cambiarValor(float f) {
		// TODO Auto-generated method stub
		this.valor = f;
		yaModificado = true;
		setChanged();
		notifyObservers();
		yaModificado = false;
	}
		
}
