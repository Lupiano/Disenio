package ui;

import java.net.URL;
import java.util.ResourceBundle;
import core.EscenarioDeCalidad;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;

public class ControladorEscenario implements Initializable {
	
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

    }
	
	@FXML private Button botonGuardarEscenario = new Button();
	@FXML private AnchorPane panelAgregarEscenario;
	@FXML private MenuButton idEstimulo = new MenuButton();
	@FXML private MenuButton idRespuesta = new MenuButton();
	@FXML private MenuButton idFuenteEstimulo = new MenuButton();
	@FXML private MenuButton idMedidaRespuesta = new MenuButton();
	@FXML private MenuButton idArtefactoAfectado = new MenuButton();
	@FXML private MenuButton idAmbiente = new MenuButton();
	@FXML private Label l1 = new Label("");
	ControladorAtributos cA = Modelo.controladorAtributo;
	
	@FXML
	private void guardarEscenarioCalidad(){
		panelAgregarEscenario.getChildren().remove(l1);
    	l1.setLayoutX(40);
    	l1.setLayoutY(265);
    	     	
    	if((!idEstimulo.getText().isEmpty())&&
    				(!idRespuesta.getText().isEmpty())&&
    					(!idFuenteEstimulo.getText().isEmpty())&&
    						(!idMedidaRespuesta.getText().isEmpty())&&
    								(!idArtefactoAfectado.getText().isEmpty())&&
    									(!idAmbiente.getText().isEmpty())){
    										
    		l1.setText("El escenario se ha guardado con exito");    										
    		//Se guardan los valores en el objecto EscenarioDeCalidad
			if(Modelo.atributoActual.getEscenarios().isEmpty())
				Modelo.numero=1;
			EscenarioDeCalidad aGuardar = new EscenarioDeCalidad();
			String nombrefinal = "Escenario " + Modelo.numero;
			aGuardar.setEscenario(nombrefinal);
    		aGuardar.setEstimulo((idEstimulo.getText()));
    		aGuardar.setRespuesta(idRespuesta.getText());
    		aGuardar.setFuenteEstimulo(idFuenteEstimulo.getText());
    		aGuardar.setMedidaRespuesta(idMedidaRespuesta.getText());
    		aGuardar.setArtefactoAfectado(idArtefactoAfectado.getText());
    		aGuardar.setAmbiente(idAmbiente.getText());
    		Modelo.atributoActual.getEscenarios().add(aGuardar);
    		Modelo.numero++;
    		cA.agregarListaEscenario(aGuardar);
    				                		
    									}
    	else
    		l1.setText("Debes completar todos los campos");
    	panelAgregarEscenario.getChildren().add(l1);
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
