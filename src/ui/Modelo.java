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
	public static Stage propiedades = new Stage();
	public static Stage primaryStage = new Stage();
	public static Stage secondaryStage = new Stage();
	public static int numero = 1;
	public static int fila = 42;
	public static int columna = 0;
	public static int numeroId = 0;
	public static Scene scene;

	
	public static Conector conectorActual = new Conector();
	
	public static ArrayList<ArrayList<Labeled>> listaBotones = new ArrayList<ArrayList<Labeled>>();
	public static Hashtable<String, ArrayList<ArrayList<Labeled>>> hashAtributos = new Hashtable<String, ArrayList<ArrayList<Labeled>>>();
}
