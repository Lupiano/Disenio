package core;

import java.util.Comparator;

public class FuncionComparadora implements Comparator {
	
	Problema p0;
	FuncionDistancia fD;
	
	public FuncionComparadora(Problema p0, FuncionDistancia f){
		this.p0 = p0;
		this.fD = f;
	}

	@Override
	public int compare(Object p1, Object p2) {
		//Sort ordena ascendente, por eso se devuelven al revés.
		
		if( ( p0.distancia((Problema)p1,fD) == p0.distancia((Problema)p2,fD) ) )	
			return 0;
		else
			if( p0.distancia((Problema)p1,fD) < p0.distancia((Problema)p2,fD) ) 
				//La distancia de p0 a p1 es menor que la de p0 a p1.
				return -1;
			else
				return 1;
		
			
	}
	
}
