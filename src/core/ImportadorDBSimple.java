package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.mysql.jdbc.ResultSet;

public class ImportadorDBSimple extends ImportadorDB {
	
	public ImportadorDBSimple(BaseDatos bd) {
		super(bd);
	}

	@Override
	public ArrayList<Caso> importarCasos() throws IOException {	
		
		ArrayList<Caso> aux = new ArrayList<Caso>();
		
		/*	
	        try {
	 
	            ResultSet rs = (ResultSet) bd.consulta( "SELECT * FROM prueba");
	    		
	            while ( rs.next() ) {
	            	Hashtable<String,Object> atr = new Hashtable<String,Object>();
	            	String vehiculo = rs.getString("vehiculo");
	            	atr.put("Vehiculo", vehiculo);
	            	String id = rs.getString("id");
	                Problema p = new Problema(id, atr);
	                String sol = rs.getString("valor");
	            	Caso c = new Caso(p, sol);
	            	aux.add(c);
	            }
	           
	        } catch ( Exception e ) {
	        	aux = null;
	            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	            System.exit(0);
	        }
	        */
	        return aux;
	}

}
