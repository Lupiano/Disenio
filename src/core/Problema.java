package core;

import java.util.Hashtable;

public class Problema {

	private String id;
	
	//Conectores con sus propiedades.
	private Hashtable<String,Conector> conectores = new Hashtable<String,Conector>();

	public Problema(String id, Hashtable<String,Conector> conectores){
		this.id = id;
		this.conectores = conectores;
	}
	
	public Problema(){
		id = null;
	}
	
	public Object valor(String clave){
		return conectores.get(clave);
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setValor(String clave, Conector valor){
		conectores.put(clave, valor);
	}
	
	public float distancia(Problema p, FuncionDistancia f){
		return f.calcularDistancia(this, p);
	}
	
	public Hashtable<String,Conector> getConectores(){
		return conectores;
	}
	
	public void setConectores(Hashtable<String,Conector> conectores){
		this.conectores = conectores;
	}
	
}
