package core;

public class FuncionDistanciaIgual implements FuncionDistancia {

	private String clave;
	
	public FuncionDistanciaIgual(String clave){
		this.clave = clave;
	}
	
	public float calcularDistancia(Problema p1, Problema p2){
		if(p1.valor(clave).equals(p2.valor(clave))){
			//0 es si son iguales.
			return 0;
		}
		else 
			return 1;
	}
}
