package ui;

import java.util.Optional;
import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class ControladorComponentes {
	
	private boolean salir = false;
	
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
	private void siguienteHaciaAtributos(){
		if (salir == false){
			JOptionPane.showMessageDialog(null, "Error: Debe llenar al menos un componente");
			System.out.println("Entraaa en siguiente");
		}
		else
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Vista Atributos Calidad.fxml"));
				Modelo.primaryStage.setScene(new Scene(root));
				Modelo.primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	@FXML
	private void agregarComponente(){
		salir = true;
	}
	
	@FXML
	private void eliminarComponente(){
	}
}