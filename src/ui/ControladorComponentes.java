package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import core.Conector;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControladorComponentes implements Initializable{	
	
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		Modelo.controladorComponentes = this;
		idTablaConectores.setEditable(true);
		nombreCol.setMinWidth(100);
		nombreCol.setCellValueFactory(new PropertyValueFactory<Conector, String>("nombre"));
        tipoCol.setMinWidth(100);
        tipoCol.setCellValueFactory(new PropertyValueFactory<Conector, String>("tipo"));
        origenCol.setMinWidth(120);
        origenCol.setCellValueFactory(new PropertyValueFactory<Conector, String>("componenteOrigen"));
        destinoCol.setMinWidth(120);
        destinoCol.setCellValueFactory(new PropertyValueFactory<Conector, String>("componenteDestino"));
		idTablaConectores.getColumns().addAll(nombreCol,tipoCol,origenCol,destinoCol);
	}
	
	Stage primaryStage = new Stage();
	@FXML private SplitMenuButton verConectores = new SplitMenuButton();
	@FXML private TableView<Conector> idTablaConectores = new TableView<Conector>();
	TableColumn nombreCol = new TableColumn("Conector");
	TableColumn tipoCol = new TableColumn("Tipo");
	TableColumn origenCol = new TableColumn("Origen");
	TableColumn destinoCol = new TableColumn("Destino");
	private ObservableList<Conector> data = FXCollections.observableArrayList();
	
	public void guardarEnTabla(){
		Conector c = new Conector();
		c.setNombre(Modelo.idNombreDelConector);
		c.setComponenteOrigen(Modelo.idConectorOrigen);
		c.setComponenteDestino(Modelo.idConectorDestino);
		c.SetTipo(Modelo.idTipoDeConector);
		data.add(c);
		idTablaConectores.setItems(data);
	}
	
	@FXML
	private void borrarConector(){
		Conector c = idTablaConectores.getSelectionModel().getSelectedItem();
		//ACORDARSE DE QUE ESTO NO BORRA NO SE PORQUE
		Modelo.conectores.remove(c);
		idTablaConectores.getItems().remove(c);	
		if(Modelo.conectores.isEmpty())
			System.out.println("Vaciaaaaa");
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
	private void editarConector(){
		Conector c = idTablaConectores.getSelectionModel().getSelectedItem();
		if (c!=null){
			Modelo.conectorActual = c;
			try {
				primaryStage.setTitle("Editar Conector: " + Modelo.conectorActual.getNombre());
				primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
				Parent root = FXMLLoader.load(getClass().getResource("Vista Atributos Calidad.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Error: Debe elegir un Conector");
	}
	
	@FXML
	private void agregarConector(){
		try {
			primaryStage.setTitle("Agregar Conector");
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Vista Agregar Conector.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}