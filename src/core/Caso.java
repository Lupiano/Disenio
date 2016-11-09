package core;

public class Caso {
	
	private Problema p;
	private String s = null;
	
	public Caso(Problema p, String s){
		this.p = p;
		this.s = s;
	}
	
	public Caso(Problema p){
		this.p = p;
	}
	
	public void setSolucion(String s){
		this.s = new String(s);
	}
	
	public String getSolucion(){
		return s;
	}
	
	public String getId(){
		return p.getId();
	}
}
