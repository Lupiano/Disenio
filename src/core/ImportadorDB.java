package core;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

public abstract class ImportadorDB implements Importador {
	
	protected BaseDatos bd;

	public ImportadorDB(BaseDatos bd){
		this.bd = bd;
	}
	
	@Override
	public abstract ArrayList<Caso> importarCasos() throws IOException;/*
	*/
}
