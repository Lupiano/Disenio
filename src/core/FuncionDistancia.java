package core;

import java.util.Comparator;

public class FuncionDistancia implements Comparator {
	
	Problema p0;
	String clave;
	
	public FuncionDistancia(Problema p0, String clave){
		this.p0 = p0;
		this.clave = clave;
	}

	@Override
	public int compare(Object p1, Object p2) {
		
		String valorP0 = (String)((Problema)p0).valor(clave);
		String valorP1 = (String)((Problema)p1).valor(clave);
		String valorP2 = (String)((Problema)p2).valor(clave);
		
		//Sort ordena ascendente, por eso se devuelven al revés.
		
		if( ( valorP1.equals(valorP0) && valorP2.equals(valorP0) ) || ( !valorP1.equals(valorP0) && !valorP2.equals(valorP0) ) )	
			return 0;
		else
			if( valorP1.equals(valorP0) && !valorP2.equals(valorP0) )
				return -1;
			else
				return 1;
		
			
	}
	
}
