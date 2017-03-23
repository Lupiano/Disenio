package ui;

import java.util.ArrayList;
import core.Atributo;
import core.Conector;
import core.EscenarioDeCalidad;

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
	public static String atribActual = "";
	public static String nombreAtributo = "";
	public static int numero = 1;	
	public static Atributo atributoActual;
	public static EscenarioDeCalidad escenarioactual;
}