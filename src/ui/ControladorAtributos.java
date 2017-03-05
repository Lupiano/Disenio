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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControladorAtributos implements Initializable {
	
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		System.out.println("El conector- a editar es" + Modelo.conectorActual.getNombre());
		Modelo.controladorAtributo = this;
		idTablaPropiedades.setEditable(true);
		idTablaTradeOFF.setEditable(true);
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
	}
	
	
	Stage primaryStage = new Stage();
	@FXML private TableView<Propiedades> idTablaPropiedades = new TableView<Propiedades>();
	@FXML private TableView<Atributo> idTablaTradeOFF = new TableView<Atributo>();
	@FXML private AnchorPane panelAtributosCalidad;
	@FXML private MenuButton idVerAtributos = new MenuButton();
	@FXML private TextField idValorAtributo = new TextField();
	@FXML private MenuButton botonAgregarTradeOff = new MenuButton();
	
	TableColumn dimNameCol = new TableColumn("Dimensión");
	TableColumn subNameCol = new TableColumn("SubDimensión");
	TableColumn valorNameCol = new TableColumn("Valor");
	private ObservableList<Propiedades> data = FXCollections.observableArrayList();
	
	TableColumn atributoNameCol = new TableColumn("Lista");
	private ObservableList<Atributo> dataAtributosTradeOff = FXCollections.observableArrayList();
	
	private void borrarBotonesEscenarios(){
		//Se borran todos los botones de la interfaz.
		Modelo.yLabel -= Modelo.listaBotones.size() * 40;
		Modelo.yBotonBorrar -= Modelo.listaBotones.size() * 40;
		Modelo.yBotonEditar -= Modelo.listaBotones.size() * 40;
		for(ArrayList<Labeled> arr: Modelo.listaBotones){
			panelAtributosCalidad.getChildren().removeAll(arr);
		}
	}
	
	@FXML
	private void cambiarAtributo(String elegido){
    	Modelo.nombreAtributo = elegido;
    	borrarBotonesEscenarios();
    	borrarTablaTradeOff();
    	Modelo.numero = 1;
    	Modelo.listaBotones = Modelo.hashAtributos.get(Modelo.nombreAtributo);
    	if(Modelo.listaBotones != null){
        	generarBotonesEscenarios();
    	}
    	else{
    		Modelo.listaBotones = new ArrayList<ArrayList<Labeled>>();
    	}
    }
	
	@FXML
	private void borrarTablaTradeOff(){
		//Limpio la tabla para generar la correcta para cada atributo de calidad
		idTablaTradeOFF.getItems().clear();
		ArrayList<Atributo> lista = Modelo.atributoActual.getAtributosTradeOff();
		if(!Modelo.atributoActual.getAtributosTradeOff().isEmpty()){
			for(Atributo a: lista){
				idTablaTradeOFF.getItems().add(a);
			}
		}
	}
	
	@FXML
	private void verAtributosDeCalidad(){
		idVerAtributos.getItems().clear();
		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		
		for (String c: Modelo.conectorActual.getAtributosCalidad().keySet()){
			MenuItem item = new MenuItem(c);
			list.addAll(item);
			Atributo nuevo = new Atributo();
	        item.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	nuevo.setNombre(item.getText());
	            	Modelo.atributoActual= nuevo;
	            	cambiarAtributo(c);
	            	Modelo.nombreAtributo = item.getText();
	            	idVerAtributos.setText(item.getText());
	            	idValorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get(item.getText())));
	            }
	        });
		}
		idVerAtributos.getItems().addAll(list);     
	}
	
	@FXML
	private void asignarValorAtributoCalidad(){
		Modelo.conectorActual.getAtributosCalidad().replace(Modelo.nombreAtributo,Float.parseFloat((idValorAtributo.getText())));
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
	
	@FXML
	public void agregarListaEscenario(){
		Label l1 = new Label();
        String nombrefinal = "Escenario" + Modelo.numero;
        l1.setText(nombrefinal);
        l1.setFont(new Font("Arial", 18)); 
        l1.setId(Integer.toString(Modelo.numeroId));
        Modelo.numeroId ++;

    	Button buttonEditar = new Button ("Editar Escenario");
    	Button buttonBorrar = new Button ("Borrar Escenario");
    	    	
    	l1.setLayoutX(Modelo.xLabel);
    	l1.setLayoutY(Modelo.yLabel);
    	
    	buttonEditar.setLayoutX(Modelo.xBotonEditar);
    	buttonEditar.setLayoutY(Modelo.yBotonEditar);
    	
    	buttonBorrar.setLayoutX(Modelo.xBotonBorrar);
    	buttonBorrar.setLayoutY(Modelo.yBotonBorrar);
    	
    	panelAtributosCalidad.getChildren().add(l1);
    	panelAtributosCalidad.getChildren().add(buttonEditar);
    	panelAtributosCalidad.getChildren().add(buttonBorrar);
        
        ArrayList<Labeled> aux = new ArrayList<Labeled>();
        aux.add(l1);
        aux.add(buttonEditar);
        aux.add(buttonBorrar);
        Modelo.listaBotones.add(aux);
        
        Modelo.hashAtributos.remove(Modelo.nombreAtributo);
        Modelo.hashAtributos.put(Modelo.nombreAtributo, Modelo.listaBotones);
        
        Modelo.numero++;
        Modelo.yLabel = Modelo.yLabel + 40;
        Modelo.yBotonBorrar = Modelo.yBotonBorrar +40;
        Modelo.yBotonEditar = Modelo.yBotonEditar +40;
        
    	buttonBorrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ArrayList<Labeled> aBorrar = new ArrayList<Labeled>();
				//Se borran todos los botones de la interfaz.
				Modelo.yLabel -= Modelo.listaBotones.size() * 40;
				Modelo.yBotonBorrar -= Modelo.listaBotones.size() * 40;
				Modelo.yBotonEditar -= Modelo.listaBotones.size() * 40;
				
				for(ArrayList<Labeled> arr: Modelo.listaBotones){
					panelAtributosCalidad.getChildren().removeAll(arr);
					//Se borran los botones a eliminar de la lista de botones.
					if(arr.contains(l1)){
						aBorrar = arr;
					}
				}
				Modelo.listaBotones.remove(aBorrar);
				generarBotonesEscenarios();
			}		
    	});

    	buttonEditar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				//Se obtiene el escenario de calidad que corresponde a este boton.
				EscenarioDeCalidad escenarioAEditar = Modelo.conectorActual.getEscenariosCalidad().get(Modelo.nombreAtributo).get(l1.getId());
				Modelo.escenarioAEditarValores = escenarioAEditar.getValores();
				Modelo.idAuxiliarEscenario = l1.getId();
				editarEscenario();
			}	
			
    	});
	}
	
	@FXML
	private void editarEscenario(){
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
	
	public void generarBotonesEscenarios(){
		Modelo.numero = 1;
		//Se vuelven a generar los botones.
		for(ArrayList<Labeled> arr: Modelo.listaBotones){
			arr.get(0).setText("Escenario" + Modelo.numero);
			
			arr.get(0).setLayoutX(Modelo.xLabel);
			arr.get(0).setLayoutY(Modelo.yLabel);
	    	
			arr.get(1).setLayoutX(Modelo.xBotonEditar);
			arr.get(1).setLayoutY(Modelo.yBotonEditar);
	    	
			arr.get(2).setLayoutX(Modelo.xBotonBorrar);
			arr.get(2).setLayoutY(Modelo.yBotonBorrar);
			
			panelAtributosCalidad.getChildren().add(arr.get(0));
			panelAtributosCalidad.getChildren().add(arr.get(1));
			panelAtributosCalidad.getChildren().add(arr.get(2));

	        Modelo.yLabel = Modelo.yLabel + 40;
	        Modelo.yBotonBorrar = Modelo.yBotonBorrar +40;
	        Modelo.yBotonEditar = Modelo.yBotonEditar +40;
	        
	        Modelo.numero ++;
		}
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
		Modelo.atributoActual.getAtributosTradeOff().remove(a);
	}
	
	@FXML
	private void tablaPerformance(){
		Atributo t = new Atributo();
		t.setNombre("Performance");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaSeguridad(){
		Atributo t = new Atributo();
		t.setNombre("Seguridad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaModificabilidad(){
		Atributo t = new Atributo();
		t.setNombre("Modificabilidad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaDisponibilidad(){
		Atributo t = new Atributo();
		t.setNombre("Disponibilidad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaUsabilidad(){
		Atributo t = new Atributo();
		t.setNombre("Usabilidad");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
	
	@FXML
	private void tablaTestability(){
		Atributo t = new Atributo();
		t.setNombre("Testability");
		dataAtributosTradeOff.add(t);
		idTablaTradeOFF.setItems(dataAtributosTradeOff);
		ArrayList<Atributo> aux = Modelo.atributoActual.getAtributosTradeOff();
		aux.add(t);
	}
}
