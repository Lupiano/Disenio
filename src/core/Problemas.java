package core;

import java.awt.List;
import java.util.ArrayList;

public class Problemas {
	
	ArrayList<Problema> problemas = new ArrayList<Problema>();
	//FuncionDistancia f = new FuncionDistancia();
	
	public Problemas(ArrayList<Problema> problemas){
		this.problemas = problemas;
	}
	
	public ArrayList<Problema> masCercanos(Problema p, int k){
		
		//FuncionDistancia esta hardcodeado. ARREGLAR.
		FuncionDistancia f = new FuncionDistancia(p, "Vehiculo");
		problemas.sort(f);
		ArrayList<Problema> aux = new ArrayList<Problema>();
		for(int i=0; i<k; i++){
			aux.add(problemas.get(i));
		}
		return aux;
	}
	
	
	
}
