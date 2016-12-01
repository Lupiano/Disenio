package core;

import javafx.fxml.FXML;


public class ControladorEscenario {
	
	@FXML
	private void guardarEscenario(){
		Modelo.escenario.close();
	}
	
}
