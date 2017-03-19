package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import core.Atributo;
import core.EscenarioDeCalidad;
import core.Propiedades;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorAtributos implements Initializable {
	
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		System.out.println("El conector a editar es" + Modelo.conectorActual.getNombre());
		Modelo.controladorAtributo = this;
		idTablaPropiedades.setEditable(true);
		idTablaTradeOFF.setEditable(true);
		idTablaEscenariosCalidad.setEditable(true);
		escenarioNameCol.setMinWidth(130);
		escenarioNameCol.setCellValueFactory(new PropertyValueFactory<EscenarioDeCalidad, String>("escenario"));
		dimNameCol.setMinWidth(100);
        dimNameCol.setCellValueFactory(new PropertyValueFactory<Propiedades, String>("dimension"));
        subNameCol.setMinWidth(100);
        subNameCol.setCellValueFactory(new PropertyValueFactory<Propiedades, String>("subdimension"));
        valorNameCol.setMinWidth(120);
        valorNameCol.setCellValueFactory(new PropertyValueFactory<Propiedades, String>("value"));
        idTablaPropiedades.getColumns().addAll(dimNameCol, subNameCol, valorNameCol);
        atributoNameCol.setMinWidth(100);
        atributoNameCol.setCellValueFactory(new PropertyValueFactory<String, String>("nombre"));
        idTablaTradeOFF.getColumns().addAll(atributoNameCol);
        idTablaEscenariosCalidad.getColumns().addAll(escenarioNameCol);
        //Inicio con el primer atributo de la lista.
        Modelo.atributoActual = Modelo.conectorActual.getAtributosCalidad().get(0);
        cambiarAtributo(Modelo.atributoActual.getNombre());
    	Modelo.nombreAtributo = Modelo.atributoActual.getNombre();
    	menuAtributosCalidad.setText(Modelo.atributoActual.getNombre());
    	idValorAtributo.setText(Float.toString(Modelo.atributoActual.getValor()));
        actualizarMenuAtributosYTradeOff();
        generarListaPropiedades();
	}
	
	Stage primaryStage = new Stage();
	@FXML private MenuButton menuAtributosCalidad = new MenuButton();
	@FXML private TableView<Propiedades> idTablaPropiedades = new TableView<Propiedades>();
	@FXML private TableView<EscenarioDeCalidad> idTablaEscenariosCalidad = new TableView<EscenarioDeCalidad>();
	@FXML private TableView<Atributo> idTablaTradeOFF = new TableView<Atributo>();
	@FXML private AnchorPane panelAtributosCalidad;	
	@FXML private TextField idValorAtributo = new TextField();
	@FXML private MenuButton botonAgregarTradeOff = new MenuButton();
	TableColumn dimNameCol = new TableColumn("Dimensión");
	TableColumn subNameCol = new TableColumn("SubDimensión");
	TableColumn valorNameCol = new TableColumn("Valor");
	private ObservableList<Propiedades> data = FXCollections.observableArrayList();
	TableColumn escenarioNameCol = new TableColumn("Escenario");
	private ObservableList<EscenarioDeCalidad> dataEscenarioCalidad = FXCollections.observableArrayList();
	TableColumn atributoNameCol = new TableColumn("Lista");
	private ObservableList<Atributo> dataAtributosTradeOff = FXCollections.observableArrayList();
	
	public void generarListaPropiedades(){
		ArrayList<Propiedades> listaPropiedades = Modelo.conectorActual.getPropiedades();
		for(Propiedades p: listaPropiedades){
			data.add(p);
			idTablaPropiedades.setItems(data);
		}
	}
	
	public void actualizarMenuAtributosYTradeOff(){
		//Llena el MenuButton atributos y tradeOff con items de los atributos del conector actual.
		menuAtributosCalidad.getItems().clear();
		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		for (Atributo c: Modelo.conectorActual.getAtributosCalidad()){
			MenuItem item = new MenuItem(c.getNombre());
	        item.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	Modelo.atributoActual = Modelo.conectorActual.getAtributo(item.getText());
	            	cambiarAtributo(c.getNombre());
	            	Modelo.nombreAtributo = item.getText();
	            	menuAtributosCalidad.setText(item.getText());
	            	idValorAtributo.setText(Float.toString(Modelo.atributoActual.getValor()));
	            }
	        });
	        
			list.add(item); 
		}
		menuAtributosCalidad.getItems().addAll(list);
	}
	
	private void generarBotonesTradeOff(){	
		ObservableList<MenuItem> listTradeOff = FXCollections.observableArrayList();
		botonAgregarTradeOff.getItems().clear();
		
		for (Atributo c: Modelo.conectorActual.getAtributosCalidad()){
			if(!c.getNombre().equals(Modelo.atributoActual.getNombre())){
				MenuItem itemTradeOff = new MenuItem(c.getNombre());
		        itemTradeOff.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	Atributo t = Modelo.conectorActual.getAtributo(itemTradeOff.getText());
		        		dataAtributosTradeOff.add(new Atributo(t.getNombre()));
		        		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		        		Modelo.atributoActual.getAtributosTradeOff().add(t);
		        		t.getAtributosTradeOff().add(Modelo.atributoActual);
		        		Modelo.atributoActual.addObserver(t);
		        		t.addObserver(Modelo.atributoActual);
		        		t.cambiarValor(1 - Modelo.atributoActual.getValor());
		        		System.out.println("Le agrego a " + Modelo.atributoActual.getNombre());
		            }
		        });
				listTradeOff.add(itemTradeOff);
			}
		}
		
		botonAgregarTradeOff.getItems().addAll(listTradeOff);
	}
	
	private void generarEscenarios(){
		idTablaEscenariosCalidad.getItems().clear();
		ArrayList<EscenarioDeCalidad> escenarios = Modelo.atributoActual.getEscenarios();
		if(!escenarios.isEmpty())
			for(EscenarioDeCalidad e: escenarios){
				idTablaEscenariosCalidad.getItems().add(e);
			}
	}
	
	@FXML
	private void modificarEscenarioDeCalidad(){
		EscenarioDeCalidad e = idTablaEscenariosCalidad.getSelectionModel().getSelectedItem();
		if(e!=null){
			Modelo.escenarioactual=e;
			try {
				primaryStage.setTitle("Modificar Escenario de Calidad");
				primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
				Parent root = FXMLLoader.load(getClass().getResource("Vista Escenario Modificado.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception a) {
				a.printStackTrace();
			}
		}
	}
	
	@FXML
	private void borrarEscenarioDeCalidad(){
		EscenarioDeCalidad e = idTablaEscenariosCalidad.getSelectionModel().getSelectedItem();
		ArrayList<EscenarioDeCalidad> lista = Modelo.atributoActual.getEscenarios();
		lista.remove(e);
		idTablaEscenariosCalidad.getItems().clear();
		if(!lista.isEmpty()){
			int aux = 1;
			for(EscenarioDeCalidad es: lista){
				es.setEscenario("Escenario " + aux);
				idTablaEscenariosCalidad.getItems().add(es);
				aux++;
			}
		}
		Modelo.numero--;
	}
	
	private void borrarTablaTradeOff(){
		//Limpio la tabla para generar la correcta para cada atributo de calidad
		idTablaTradeOFF.getItems().clear();
		ArrayList<Atributo> lista = Modelo.atributoActual.getAtributosTradeOff();
		if(!lista.isEmpty()){
			for(Atributo a: lista){
				idTablaTradeOFF.getItems().add(new Atributo(a.getNombre()));
			}
		}
	}
	
	@FXML
	private void asignarValorAtributoCalidad(){
		Modelo.atributoActual.cambiarValor(Float.parseFloat((idValorAtributo.getText())));
	}
	
	@FXML
	private void agregarAtributoDeCalidad(){
		try {
			primaryStage.setTitle("Agregar Atributo");
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Vista Agregar Atributo Calidad.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
		this.actualizarMenuAtributosYTradeOff();
	}
	
	@FXML
	private void agregarEscenarioCalidad(){
		try {
			primaryStage.setTitle("Escenario de Calidad");
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Vista Escenario de Calidad.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void agregarPropiedades(){
		try {
			primaryStage.setTitle("Tipo conector: " + Modelo.conectorActual.getTipo());
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Vista Propiedades del Conector.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void salir(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Salir del Programa");
		alert.setContentText("¿Está seguro que desea salir? Los cambios no guardados se perderán.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Platform.exit();
		}
	}

	public void agregarListaEscenario(EscenarioDeCalidad escenario){
		dataEscenarioCalidad.add(escenario);
		idTablaEscenariosCalidad.setItems(dataEscenarioCalidad);
	}
	
	@FXML
	private void borrarPropiedad(){
		Propiedades p = idTablaPropiedades.getSelectionModel().getSelectedItem();
		ArrayList<Propiedades> lista = Modelo.conectorActual.getPropiedades();
		lista.remove(p);
		idTablaPropiedades.getItems().remove(p);
	}
	
	public void actualizarListaPropiedades(){
		ArrayList<Propiedades> listaPropiedades = Modelo.conectorActual.getPropiedades();
		data.add(listaPropiedades.get(listaPropiedades.size()-1));
		idTablaPropiedades.setItems(data);
	}
	
	@FXML
	private void borrarAtributoTradeOFF(){
		Atributo a = idTablaTradeOFF.getSelectionModel().getSelectedItem();
		idTablaTradeOFF.getItems().remove(a);
		Atributo aBorrar = Modelo.conectorActual.getAtributo(a.getNombre());
		a = null;
		aBorrar.getAtributosTradeOff().remove(Modelo.atributoActual);
		Modelo.atributoActual.getAtributosTradeOff().remove(aBorrar);
	}
	
	@FXML
	private void tablaPerformance(){
		Atributo t = new Atributo("Performance");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaSeguridad(){
		Atributo t = new Atributo("Seguridad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaModificabilidad(){
		Atributo t = new Atributo("Modificabilidad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaDisponibilidad(){
		Atributo t = new Atributo("Disponibilidad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaUsabilidad(){
		Atributo t = new Atributo("Usabilidad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaTestability(){
		Atributo t = new Atributo("Testability");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void cambiarAtributo(String elegido){
    	Modelo.nombreAtributo = elegido;
    	generarEscenarios();
    	generarBotonesTradeOff();
    	borrarTablaTradeOff();
    }
	

	/*@Override
	public void start(Stage primaryStage) {

		Conector c = new Conector();
		c.setNombre("asd");
		c.setComponenteOrigen("asd");
		c.setComponenteDestino("asd");
		c.SetTipo("Procedure Call");
		
		Modelo.conectorActual = c;
		
		try {
			primaryStage.setTitle("Editar Conector");
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Vista Atributos Calidad.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}¨*/
}
