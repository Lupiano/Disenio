package ui;

import java.util.ArrayList;
import java.util.Hashtable;

import core.Conector;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

public class Modelo {
	public static String atribActual = "";
	public static String nombreAtributo = "";
	public static Stage escenario = new Stage();
	public static Stage conector = new Stage();
	public static Stage agregarPropiedades = new Stage();
	public static Stage editarPropiedades = new Stage();
	public static Stage primaryStage = new Stage();
	public static Stage secondaryStage = new Stage();
	public static int numero = 1;
	public static int numeroPropiedad = 1;
	public static int fila = 62;
	public static int filaPropiedad = 20;
	public static int columna = 0;
	public static int numeroId = 0;
	public static int numeroIdPropiedad = 0;
	public static Scene scene;
	public static boolean hayNombreConector = false;
	public static boolean hayNombreOrigen= false;
	public static boolean hayNombreDestino = false;

	
	public static Conector conectorActual = new Conector();
	
	public static ArrayList<ArrayList<Labeled>> listaBotones = new ArrayList<ArrayList<Labeled>>();
	public static Hashtable<String, ArrayList<ArrayList<Labeled>>> hashAtributos = new Hashtable<String, ArrayList<ArrayList<Labeled>>>();
}
