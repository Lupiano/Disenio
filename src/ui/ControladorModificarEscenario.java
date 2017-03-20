package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;

public class ControladorModificarEscenario implements Initializable {
		
		@Override
	    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
			idEstimulo.setText(Modelo.escenarioactual.getEstimulo());
	        idRespuesta.setText(Modelo.escenarioactual.getRespuesta());
	        idFuenteEstimulo.setText(Modelo.escenarioactual.getFuenteEstimulo());
	        idMedidaRespuesta.setText(Modelo.escenarioactual.getMedidaRespuesta());
	        idArtefactoAfectado.setText(Modelo.escenarioactual.getArtefactoAfectado());
	        idAmbiente.setText(Modelo.escenarioactual.getAmbiente());
	    }
		
		@FXML private Button botonGuardarEscenario = new Button();
		@FXML private AnchorPane panelModificarEscenario;
		@FXML private MenuButton idEstimulo = new MenuButton();
		@FXML private MenuButton idRespuesta = new MenuButton();
		@FXML private MenuButton idFuenteEstimulo = new MenuButton();
		@FXML private MenuButton idMedidaRespuesta = new MenuButton();
		@FXML private MenuButton idArtefactoAfectado = new MenuButton();
		@FXML private MenuButton idAmbiente = new MenuButton();
		@FXML private Label l2 = new Label("");
		ControladorAtributos cA = Modelo.controladorAtributo;
		
		@FXML
		private void guardarEscenarioCalidad(){
			l2.setLayoutX(40);
	    	l2.setLayoutY(265);
	    	     	
	    	if((!idEstimulo.getText().isEmpty())&&
	    				(!idRespuesta.getText().isEmpty())&&
	    					(!idFuenteEstimulo.getText().isEmpty())&&
	    						(!idMedidaRespuesta.getText().isEmpty())&&
	    								(!idArtefactoAfectado.getText().isEmpty())&&
	    									(!idAmbiente.getText().isEmpty())){
	    										l2.setText("El escenario se ha guardado con exito");				                		
	    										Modelo.escenarioactual.setEstimulo((idEstimulo.getText()));
	    										Modelo.escenarioactual.setRespuesta((idRespuesta.getText()));
	    										Modelo.escenarioactual.setFuenteEstimulo((idFuenteEstimulo.getText()));
	    										Modelo.escenarioactual.setMedidaRespuesta((idMedidaRespuesta.getText()));
	    										Modelo.escenarioactual.setArtefactoAfectado((idArtefactoAfectado.getText()));
	    										Modelo.escenarioactual.setAmbiente((idAmbiente.getText()));
	    										l2.setText("El escenario se ha guardado con exito");
	    									}
	    	else
	    		l2.setText("Debes completar todos los campos");
	    	panelModificarEscenario.getChildren().add(l2);
		}
		
		@FXML
		private void guardarRespuesta1(){
			idRespuesta.setText("Respuesta 1");
		}
		
		@FXML
		private void guardarEstimulo1(){
			idEstimulo.setText("Estimulo 1");
		}
		
		@FXML
		private void guardarArtefacto1(){
			idArtefactoAfectado.setText("Artefacto Afectado 1");
		}
		
		@FXML
		private void guardarAmbiente1(){
			idAmbiente.setText("Ambiente 1");
		}
		
		@FXML
		private void guardarUsuario(){
			idFuenteEstimulo.setText("Usuario");
		}
		
		@FXML
		private void guardarOperador(){
			idFuenteEstimulo.setText("Operador");
		}
		
		@FXML
		private void guardarActor(){
			idFuenteEstimulo.setText("Actor");
		}
		
		@FXML
		private void guardarSistemas(){
			idFuenteEstimulo.setText("Sistemas");
		}
		
		@FXML
		private void guardarPrueba(){
			idFuenteEstimulo.setText("Prueba");
		}
		
		@FXML
		private void guardar1segundos(){
			idMedidaRespuesta.setText("1s");
		}
		
		@FXML
		private void guardar2segundos(){
			idMedidaRespuesta.setText("2s");
		}
		
		@FXML
		private void guardar3segundos(){
			idMedidaRespuesta.setText("3s");
		}
		
		@FXML
		private void guardar4segundos(){
			idMedidaRespuesta.setText("4s");
		}
		
		@FXML
		private void guardar5segundos(){
			idMedidaRespuesta.setText("5s");
		}
}
