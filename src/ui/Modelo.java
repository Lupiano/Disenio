package ui;

import java.util.ArrayList;
import java.util.Hashtable;

import core.Atributo;
import core.Conector;
import javafx.scene.control.Labeled;

public class Modelo {
	
	public static ControladorAtributos controladorAtributo;
	public static ControladorComponentes controladorComponentes;
	public static ControladorModificarEscenario cME;
	public static String idNombreDelConector;
	public static String idTipoDeConector;
	public static String idConectorOrigen;
	public static String idConectorDestino;
	
	public static Conector conectorActual = null;
	public static ArrayList<Conector> Conectores = new ArrayList<Conector>();
	
	public static ArrayList<ArrayList<Labeled>> listaBotones = new ArrayList<ArrayList<Labeled>>();
	public static Hashtable<String, ArrayList<ArrayList<Labeled>>> hashAtributos = new Hashtable<String, ArrayList<ArrayList<Labeled>>>();
	
	public static String atribActual = "";
	public static String nombreAtributo = "";

	public static int numero = 1;
	public static int numeroId = 0;
	
	public static int xLabel = 30;
	public static int yLabel =346;
	
	public static int xBotonEditar =237;
	public static int yBotonEditar =346;
	
	public static int xBotonBorrar = 129;
	public static int yBotonBorrar = 346;
	
	public static ArrayList<String> escenarioAEditarValores;
	public static String idAuxiliarEscenario;
	
	public static Atributo atributoActual;
}
