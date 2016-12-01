package core;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Caso {
	
	private Problema p;
	private String solucion = "";
	
	public Caso(Problema p, String s){
		this.p = p;
		this.solucion = s;
	}
	
	public Caso(Problema p){
		this.p = p;
	}
	
	public void setSolucion(String s){
		this.solucion = new String(s);
	}
	
	public String getSolucion(){
		return solucion;
	}
	
	public String getId(){
		return p.getId();
	}

	public Problema getProblema(){
		return p;
	}
	
	public void setProblema(Problema p){
		this.p = p;
	}

}
