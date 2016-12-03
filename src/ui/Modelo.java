package ui;

import java.util.ArrayList;
import java.util.Hashtable;

import core.*;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

public class Modelo {
	public static String atribActual = "";
	public static String nombreAtributo = "";
	public static Stage escenario = new Stage();
	public static Stage primaryStage = new Stage();
	public static int numero = 1;
	public static int fila = 24;
	public static int columna = 0;
	public static ArrayList<EscenarioDeCalidad> escenarios = new ArrayList<EscenarioDeCalidad>();
	public static Hashtable<String,ArrayList<Labeled>> hashBotones = new Hashtable<String,ArrayList<Labeled>>();
	public static ArrayList<ArrayList<Labeled>> listaBotones = new ArrayList<ArrayList<Labeled>>();
	public static Hashtable<String,EscenarioDeCalidad> hashEscenarios = new Hashtable<String,EscenarioDeCalidad>();
}
