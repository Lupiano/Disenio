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
	
	public static int xLabel = 32;
	public static int yLabel = 460;
	
	public static int xBotonEditar = 134;
	public static int yBotonEditar = 460;
	
	public static int xBotonBorrar = 190;
	public static int yBotonBorrar = 460;
	
	public static ArrayList<String> escenarioAEditarValores;
	public static String idAuxiliarEscenario;
	
	public static Atributo atributoActual;
}
