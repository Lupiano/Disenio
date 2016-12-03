package core;

import java.util.ArrayList;

public class Problemas {
	
	ArrayList<Problema> problemas = new ArrayList<Problema>();
	FuncionDistancia fD;
	
	public Problemas(ArrayList<Problema> problemas, FuncionDistancia f){
		this.problemas = problemas;
		this.fD = f;
	}
	
	public ArrayList<Problema> masCercanos(Problema p, int k){
		
		//FuncionDistancia esta hardcodeado. ARREGLAR.
		FuncionComparadora fC = new FuncionComparadora(p, fD);
		problemas.sort(fC);
		ArrayList<Problema> aux = new ArrayList<Problema>();
		for(int i=0; i<k; i++){
			aux.add(problemas.get(i));
		}
		return aux;
	}
	
	
	
}
