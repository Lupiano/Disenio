package ui;

import core.Atributo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControladorAgregarAtributoCalidad {

	@FXML private TextField idNuevoAtributoCalidad = new TextField();
	
	@FXML
	private void guardarNuevoAtributoCalidad(){
		if(!idNuevoAtributoCalidad.getText().isEmpty()){
			idNuevoAtributoCalidad.setDisable(true);
        	String value = idNuevoAtributoCalidad.getText();
        	char primero = value.charAt(0);
            String primString = primero + "";
            value = primString.toUpperCase() + value.substring(1, value.length()).toLowerCase();
            Modelo.conectorActual.getAtributosCalidad().add(new Atributo(value)); 
            Modelo.controladorAtributo.actualizarMenuAtributosYTradeOff();
		}	
	}
}