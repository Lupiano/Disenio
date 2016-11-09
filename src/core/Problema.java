package core;

import java.util.ArrayList;
import java.util.Hashtable;

public class Problema {

	String id;
	//
	private Hashtable<String,Object> atributos = new Hashtable<String,Object>();
	
	public Problema(String id){
		this.id = id;
	}
	
	public Problema(){
		id = null;
	}
	
	public Object valor(String clave){
		return atributos.get(clave);
	}
	
	public String getId(){
		return id;
	}
	
	public void setValor(String clave, Object valor){
		atributos.put(clave, valor);
	}
	
}
