package core;

import java.io.IOException;
import java.util.ArrayList;

public abstract class ImportadorDB implements Importador {
	
	protected BaseDatos bd;

	public ImportadorDB(BaseDatos bd){
		this.bd = bd;
	}
	
	@Override
	public abstract ArrayList<Caso> importarCasos() throws IOException;/*
	*/
}
