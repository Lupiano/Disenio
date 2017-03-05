package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import core.Conector;

public class ControladorAgregarConector implements Initializable{
		
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }

	@FXML private AnchorPane panelAgregarConector;
	@FXML private TextField idNombreDelConector;
	@FXML private MenuButton idTipoDeConector;
	@FXML private TextField idComponenteOrigen;
	@FXML private TextField idComponenteDestino;
	@FXML private MenuButton verConectores = new MenuButton();
	@FXML private Label l1 = new Label("");
	ControladorComponentes cC = Modelo.controladorComponentes;
		
	@FXML
	private void guardarConector(){
		//Boton Guardar
		panelAgregarConector.getChildren().remove(l1);
    	l1.setLayoutX(40);
    	l1.setLayoutY(250);
    	
    	boolean existe = false;
    	for(Conector c: Modelo.Conectores){
    		if(c.getNombre().equals((idNombreDelConector).getText()))
    			existe = true;
    	}

    	if(!existe){
			//Si tiene todos los campos completos...
	    	if ((!idNombreDelConector.getText().isEmpty()) && (Modelo.idTipoDeConector!= null) && (!idComponenteOrigen.getText().isEmpty()) && (!idComponenteDestino.getText().isEmpty())){
	    		
	    		Modelo.idNombreDelConector = idNombreDelConector.getText();
	    		Modelo.idConectorOrigen = idComponenteOrigen.getText();
	    		Modelo.idConectorDestino = idComponenteDestino.getText();
	    		
	    		//Cargo el conector a la lista de Conectores que tiene Modelo
	        	Conector aux = new Conector();
	        	aux.setNombre(Modelo.idNombreDelConector);
	        	aux.SetTipo(Modelo.idTipoDeConector);
	        	aux.setComponenteOrigen(Modelo.idConectorOrigen);
	        	aux.setComponenteDestino(Modelo.idConectorDestino);
	        	Modelo.Conectores.add(aux);
	    		
	    		l1.setText("El conector se ha guardado correctamente");		
	    		cC.guardarEnTabla();
	    	}
	        else
	        	l1.setText("Error: Debe Completar todos los campos");		
    	}
    	else
    		l1.setText("Error: El conector ya existe");
    	panelAgregarConector.getChildren().add(l1);
	}	
	
	@FXML
	private void itemProcedureCall(){
		idTipoDeConector.setText("Procedure Call");
		Modelo.idTipoDeConector = "Procedure Call";
	}
	
	@FXML
	private void itemEvent(){
		idTipoDeConector.setText("Event");
		Modelo.idTipoDeConector = "Event";
	}
	
	@FXML
	private void itemAccess(){
		idTipoDeConector.setText("Data Access");
		Modelo.idTipoDeConector = "Data Access";
	}
	
	@FXML
	private void itemLinkage(){
		idTipoDeConector.setText("Linkage");
		Modelo.idTipoDeConector = "Linkage";
	}
	
	@FXML
	private void itemStream(){
		idTipoDeConector.setText("Stream");
		Modelo.idTipoDeConector = "Stream";
	}
	
	@FXML
	private void itemArbitator(){
		idTipoDeConector.setText("Arbitrator");
		Modelo.idTipoDeConector = "Arbitrator";
	}
	
	@FXML
	private void itemAdaptor(){
		idTipoDeConector.setText("Adaptor");
		Modelo.idTipoDeConector = "Adaptor";
	}
	
	@FXML
	private void itemDistributor(){
		idTipoDeConector.setText("Distributor");
		Modelo.idTipoDeConector = "Distributor";
	}
}
