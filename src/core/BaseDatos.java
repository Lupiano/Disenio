package core;

import java.sql.*;
import java.util.*;

public class BaseDatos {
	// JDBC driver name and database URL
    static private String JDBC_DRIVER = "org.postgresql.Driver";  
    private String DB_URL = "jdbc:mysql://";
 
    //  Database credentials
    private String USER = "root";
    private String PASS = "";
    
    private Connection conn = null;
    private Statement stmt = null;
    
    public BaseDatos (String user, String pass, String url){
    	this.USER = user;
    	this.PASS = pass;
    	this.DB_URL += url;
    }
 
 
    public void conectar(){
 
        conn = null;
        stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
 
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Error en la conexión a la base de datos.");
        }catch(Exception e){
            //Handle errors for Class.forName
        	System.out.println("Error en la conexión a la base de datos.");
        }
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
