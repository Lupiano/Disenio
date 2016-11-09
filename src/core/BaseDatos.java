package core;

import java.sql.*;
import java.util.*;

public class BaseDatos {
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";  
    static final String DB_URL = "jdbc:postgresql://[::1]:5432/postgres";
 
    //  Database credentials
    private String USER = "postgres";
    private String PASS = "ayelen";
    
    private Connection conn = null;
    private Statement stmt = null;
    
    public BaseDatos (String user, String pass){
    	this.USER = user;
    	this.PASS = pass;
    }
 
 
    public void conectar(){
 
        conn = null;
        stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");
 
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            
            String sql;
 
            sql = "CREATE TABLE IF NOT EXISTS grafos " +
                    "( nombre_grafo VARCHAR(255), " +
                    " PRIMARY KEY ( nombre_grafo ))";
 
            stmt.executeUpdate(sql);
 
           
            sql = "CREATE TABLE IF NOT EXISTS nodos " +
                    "( id_nodo VARCHAR(255) not NULL, " +
                    " nombre_grafo VARCHAR(255) not NULL, " +
                    " PRIMARY KEY ( id_nodo, nombre_grafo )," +
                    " FOREIGN KEY ( nombre_grafo )  REFERENCES grafos(nombre_grafo))";
                       
            stmt.executeUpdate(sql);
 
            sql = "CREATE TABLE IF NOT EXISTS arcos " +
                    "( id_arco VARCHAR(255) not NULL, " +
                    " nombre_grafo VARCHAR(255) not NULL, " +
                    " nodo1 VARCHAR(255) not NULL, " +
                    " nodo2 VARCHAR(255) not NULL," +
                    " PRIMARY KEY ( id_arco, nombre_grafo )," +
                    " FOREIGN KEY ( nombre_grafo )  REFERENCES grafos(nombre_grafo)," +
                    " FOREIGN KEY ( nodo1, nombre_grafo )   REFERENCES nodos (id_nodo, nombre_grafo)," +
                    " FOREIGN KEY ( nodo2, nombre_grafo )   REFERENCES nodos (id_nodo, nombre_grafo))";
 
            stmt.executeUpdate(sql);
           
            sql = "CREATE TABLE IF NOT EXISTS atributosnodos " +
                    "( id_nodo VARCHAR not NULL, " +
                    " nombre_grafo VARCHAR(255) not NULL, " +
                    " nombre_atributo VARCHAR(255) not NULL, " +
                    " valor VARCHAR(255), " +
                    " PRIMARY KEY ( id_nodo, nombre_grafo, nombre_atributo )," +
                    " FOREIGN KEY ( id_nodo, nombre_grafo)  REFERENCES nodos (id_nodo, nombre_grafo))";
           
        stmt.executeUpdate(sql);
           
            sql = "CREATE TABLE IF NOT EXISTS atributosarcos " +
                    "( id_arco VARCHAR not NULL, " +
                    " nombre_grafo VARCHAR(255) not NULL, " +
                    " nombre_atributo VARCHAR(255) not NULL, " +
                    " valor VARCHAR(255), " +
                    " PRIMARY KEY ( id_arco, nombre_grafo, nombre_atributo )," +
                    " FOREIGN KEY ( id_arco, nombre_grafo)  REFERENCES arcos (id_arco, nombre_grafo))";
           
        stmt.executeUpdate(sql);
           
        System.out.println("Created table in given database...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }/* finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        } */
    }
 
 
    public ResultSet consulta(String sql){
    	ResultSet rs = null;
    	try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return rs;
		}
    	return rs;
    }
    
    public void insertar(String sql){
    	try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
