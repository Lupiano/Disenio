package ui;

import java.net.URL;
import java.util.ResourceBundle;

import core.Propiedades;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ControladorPropiedadesDelConector implements Initializable{
	

	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }

	ControladorAtributos cA = Modelo.controladorAtributo;
	@FXML private AnchorPane panelPropiedadesConector;
	@FXML private MenuButton idValorDimension = new MenuButton();
	@FXML private MenuButton idValorSubDimension = new MenuButton();
	@FXML private MenuButton idValorValor = new MenuButton();
	@FXML private Text l1 = new Text("");
	
	@FXML
	private void guardarPropiedadesDelConector(){
		panelPropiedadesConector.getChildren().remove(l1);
		
		l1.setLayoutX(50);
		l1.setLayoutY(130);
			
		if((!idValorDimension.getText().equals("Opciones")) &&
				(!idValorSubDimension.getText().equals("Opciones")) &&
					(!idValorValor.getText().equals("Opciones"))){
						l1.setText("Las propiedades se han guardado con exíto");						
						Propiedades nueva = new Propiedades();
						nueva.setDimension(idValorDimension.getText());
						nueva.setSubdimension(idValorSubDimension.getText());
						nueva.setValue(idValorValor.getText());
						Modelo.conectorActual.getPropiedades().add(nueva);
						cA.actualizarListaPropiedades();					
		}
		else
			l1.setText("Debes completar todos los campos");
		panelPropiedadesConector.getChildren().add(l1);
	}
	
	//Tipo
	private void cargarProcedureCall(){
		ObservableList<MenuItem> listaProcedureCall = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Parameters");
		MenuItem item2 = new MenuItem("Entry Point");
		MenuItem item3 = new MenuItem("Invocation");
		MenuItem item4 = new MenuItem("Synchronicity PC");
		MenuItem item5 = new MenuItem("Cardinality PC");
		MenuItem item6 = new MenuItem("Accessibility");
		listaProcedureCall.addAll(item1,item2,item3,item4,item5,item6);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setDisable(false);
            	idValorSubDimension.setText("Opciones");
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {           	
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaProcedureCall);	
	}
	private void cargarEvent(){
		ObservableList<MenuItem> listaEvent = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Cardinality E");
		MenuItem item2 = new MenuItem("Delivery");
		MenuItem item3 = new MenuItem("Priority");
		MenuItem item4 = new MenuItem("Synchronicity E");
		MenuItem item5 = new MenuItem("Notification");
		MenuItem item6 = new MenuItem("Causality");
		MenuItem item7 = new MenuItem("Mode");
		listaEvent.addAll(item1,item2,item3,item4,item5,item6,item7);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setDisable(false);
            	idValorSubDimension.setText("Opciones");
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {           	
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {           	
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item7.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaEvent);	
	}
	private void cargarDataAccess(){
		ObservableList<MenuItem> listaDataAccess = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Locality");
		MenuItem item2 = new MenuItem("Access");
		MenuItem item3 = new MenuItem("Availability");
		MenuItem item4 = new MenuItem("Accessibility DA");
		MenuItem item5 = new MenuItem("Lifecycle");
		MenuItem item6 = new MenuItem("Cardinality DA");
		listaDataAccess.addAll(item1,item2,item3,item4,item5,item6);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {           	
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaDataAccess);	
	}
	private void cargarLinkage(){
		ObservableList<MenuItem> listaLinkage = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Reference");
		MenuItem item2 = new MenuItem("Granularity");
		MenuItem item3 = new MenuItem("Cardinality Linkage");
		MenuItem item4 = new MenuItem("Binding");;
		listaLinkage.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaLinkage);
	}
	private void cargarStream(){
		ObservableList<MenuItem> listaStream = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Delivery Stream");
		MenuItem item2 = new MenuItem("Bounds");
		MenuItem item3 = new MenuItem("Buffering");
		MenuItem item4 = new MenuItem("Throughput");;
		MenuItem item5 = new MenuItem("State");
		MenuItem item6 = new MenuItem("Identity");
		MenuItem item7 = new MenuItem("Locality Stream");
		MenuItem item8 = new MenuItem("Synchronicity Stream");;
		MenuItem item9 = new MenuItem("Format");
		MenuItem item10 = new MenuItem("Cardinality Stream");
		listaStream.addAll(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item7.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item8.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item9.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item10.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaStream);
	}
	private void cargarArbitrator(){
		ObservableList<MenuItem> listaArbitrator= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Fault Handling");
		MenuItem item2 = new MenuItem("Concurrency");
		MenuItem item3 = new MenuItem("Transactions");
		MenuItem item4 = new MenuItem("Security");
		MenuItem item5 = new MenuItem("Scheduling");;
		listaArbitrator.addAll(item1,item2,item3,item4,item5);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaArbitrator);
	}
	private void cargarAdaptor(){
		ObservableList<MenuItem> listaAdaptor= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Invocation conversion");
		MenuItem item2 = new MenuItem("Packaging conversion");
		MenuItem item3 = new MenuItem("Protocol conversion");
		MenuItem item4 = new MenuItem("Presentation conversion");
		listaAdaptor.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("NULL");
            	idValorValor.setDisable(true);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("NULL");
            	idValorSubDimension.setDisable(true);
            	idValorValor.setText("NULL");
            	idValorValor.setDisable(true);
            	idValorDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	idValorDimension.getItems().addAll(listaAdaptor);
	}
	private void cargarDistributor(){
		ObservableList<MenuItem> listaDistributor= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Naming");
		MenuItem item2 = new MenuItem("Delivery Distributor");
		MenuItem item3 = new MenuItem("Routing");
		listaDistributor.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText("Opciones");
            	idValorSubDimension.setDisable(false);
            	idValorValor.setText("Opciones");
            	idValorValor.setDisable(false);
            	idValorDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);;
            }
        });
	idValorDimension.getItems().addAll(listaDistributor);
	}
	
	
	//Dimension
	//-----ProcedureCall----//
	private void cargarParameters(){
		ObservableList<MenuItem> listaParameters = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Data Transfer");
		MenuItem item2 = new MenuItem("Semantics");
		MenuItem item3 = new MenuItem("Return Values");
		MenuItem item4 = new MenuItem("Invocation Record");
		listaParameters.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorSubDimension.setText(item3.getText());
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorValor.setDisable(true);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item4.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaParameters);	
	}
	private void cargarEntryPoint(){
		ObservableList<MenuItem> listaEntryPoint = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Multiple");
		MenuItem item2 = new MenuItem("Single");
		listaEntryPoint.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaEntryPoint);
	}	
	private void cargarInvocation(){
		ObservableList<MenuItem> listaInvocation = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Explicit");
		MenuItem item2 = new MenuItem("Implicit");
		listaInvocation.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaInvocation);
	}
	private void cargarCardinalityPC(){
		ObservableList<MenuItem> listaCardinality = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Fan out");
		MenuItem item2 = new MenuItem("Fan in");
		listaCardinality.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaCardinality);
	}
	
	//-----Event-----//
	private void cargarCardinalityE(){
		ObservableList<MenuItem> listaCardinalityE = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Producers");
		MenuItem item2 = new MenuItem("Observers");
		MenuItem item3 = new MenuItem("Event patterns");
		listaCardinalityE.addAll(item1,item2,item3);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item3.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaCardinalityE);
	}
	private void cargarPriority(){
		ObservableList<MenuItem> listaPriority = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Outgoing");
		MenuItem item2 = new MenuItem("Incoming");
		listaPriority.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaPriority);
	}
	private void cargarMode(){
		ObservableList<MenuItem> listaPriority = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Hardware");
		MenuItem item2 = new MenuItem("Software");
		listaPriority.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaPriority);
	}
	
	private void cargarConcurrency(){
		ObservableList<MenuItem> listaConcurrency = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Mechanism");
		MenuItem item2 = new MenuItem("Weight");
		listaConcurrency.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaConcurrency);
	}
	private void cargarTransactions(){
		ObservableList<MenuItem> listaTransactions = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Nesting");
		MenuItem item2 = new MenuItem("Awareness");
		MenuItem item3 = new MenuItem("Isolation");
		listaTransactions.addAll(item1,item2,item3);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaTransactions);
	}
	private void cargarSecurity(){
		ObservableList<MenuItem> listaSecurity = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Authentication");
		MenuItem item2 = new MenuItem("Authorization");
		MenuItem item3 = new MenuItem("Privacy");
		MenuItem item4 = new MenuItem("Integrity");
		MenuItem item5 = new MenuItem("Durability");
		listaSecurity.addAll(item1,item2,item3,item4,item5);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item3.getText());
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item4.getText());
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item5.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaSecurity);
	}
	
	private void cargarAvailability(){
		ObservableList<MenuItem> listaAvailability = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Transient");
		MenuItem item2 = new MenuItem("Persistent");
		listaAvailability.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaAvailability);
	}
	private void cargarCardinalityDA(){
		ObservableList<MenuItem> listaCardinalityDA = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Defines");
		MenuItem item2 = new MenuItem("Uses");
		listaCardinalityDA.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaCardinalityDA);
	}
	
	private void cargarScheduling(){
		ObservableList<MenuItem> listaScheduling = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Time");
		MenuItem item2 = new MenuItem("Weight");
		listaScheduling.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaScheduling);
	}
	
	private void cargarInvocationConversion(){
		ObservableList<MenuItem> listanvocationConversion = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Address mapping");
		MenuItem item2 = new MenuItem("Marshalling");
		MenuItem item3 = new MenuItem("Translation");
		listanvocationConversion.addAll(item1,item2,item3);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item3.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listanvocationConversion);
	}
	
	private void cargarNaming(){
		ObservableList<MenuItem> listaNaming = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Structure based");
		MenuItem item2 = new MenuItem("Attribute based");
		listaNaming.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaNaming);
	}
	private void cargarDeliveryDistributor(){
		ObservableList<MenuItem> listaDeliveryDistributor = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Semantics Distributor");
		MenuItem item2 = new MenuItem("Mechanism Distributor");
		listaDeliveryDistributor.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaDeliveryDistributor);
	}
	private void cargarRouting(){
		ObservableList<MenuItem> listaRouting = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Membership");
		MenuItem item2 = new MenuItem("Path");
		listaRouting.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaRouting);
	}
	
	private void cargarGranularity(){
		ObservableList<MenuItem> listaGranularity= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Unit");
		MenuItem item2 = new MenuItem("Syntactic");
		MenuItem item3 = new MenuItem("Semantic");
		listaGranularity.addAll(item1,item2,item3);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item3.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaGranularity);
	}
	private void cargarCardinalityLinkage(){
		ObservableList<MenuItem> listaCardinalityLinkage= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Defines");
		MenuItem item2 = new MenuItem("Uses");
		MenuItem item3 = new MenuItem("Provides");
		MenuItem item4 = new MenuItem("Requires");
		listaCardinalityLinkage.addAll(item1,item2,item3,item4);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item3.getText());
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item4.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaCardinalityLinkage);
	}
	
	private void cargarCardinalityStream(){
		ObservableList<MenuItem> listaCardinalityStream= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Binary");
		MenuItem item2 = new MenuItem("N-ary");
		listaCardinalityStream.addAll(item1,item2);
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(false);
            	idValorValor.setText("Opciones");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item2.getText());
            }
        });
		idValorSubDimension.getItems().addAll(listaCardinalityStream);
	}
	
	//Subdimension
	//-----Parameters----//
	private void cargarDataTransfer(){
		ObservableList<MenuItem> listaDataTransfer = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Reference");
		MenuItem item2 = new MenuItem("Value");
		MenuItem item3 = new MenuItem("Name");
		listaDataTransfer.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaDataTransfer);	
	}
	private void cargarSemantics(){
		ObservableList<MenuItem> listaSemantics = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Default Values");
		MenuItem item2 = new MenuItem("Keyword Parameters");
		MenuItem item3 = new MenuItem("Inline Parameters");
		listaSemantics.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaSemantics);	
	}
	private void cargarInvocationRecord(){
		ObservableList<MenuItem> listaInvocationRecord = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Push From L To R");
		MenuItem item2 = new MenuItem("Push From R To L");
		MenuItem item3 = new MenuItem("Hash Table");
		listaInvocationRecord.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaInvocationRecord);	
	}
	
	//-----Invocation----//
	private void cargarExplicit(){
		ObservableList<MenuItem> listaExplicit = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Method call");
		MenuItem item2 = new MenuItem("Macro call");
		MenuItem item3 = new MenuItem("Inline");
		MenuItem item4 = new MenuItem("System call");
		listaExplicit.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaExplicit);
	}
	private void cargarImplicit(){
		ObservableList<MenuItem> listaImplicit = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Exceptions");
		MenuItem item2 = new MenuItem("Callbacks");
		MenuItem item3 = new MenuItem("Delegation");
		listaImplicit.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaImplicit);	
	}
	
	//-----Synchronicity----//
	private void cargarSynchronicityPC(){
		ObservableList<MenuItem> listaSynchronicity = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Asynchronous");
		MenuItem item2 = new MenuItem("Synchronous");
		listaSynchronicity.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaSynchronicity);	
	}

	//-----Accessibility----//
	private void cargarAccessibility(){
		ObservableList<MenuItem> listaAccesibility = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Private");
		MenuItem item2 = new MenuItem("Protected");
		MenuItem item3 = new MenuItem("Public");
		listaAccesibility.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaAccesibility);
	}
	
	//-----Delivery-----//
	private void cargarDelivery(){
		ObservableList<MenuItem> listaDelivery = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Best effort");
		MenuItem item2 = new MenuItem("Exactly once");
		MenuItem item3 = new MenuItem("At most once");
		MenuItem item4 = new MenuItem("At least once");
		listaDelivery.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaDelivery);
	}
	private void cargarSynchronicityE(){
		ObservableList<MenuItem> listaSynchronicityE = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Synchronous");
		MenuItem item2 = new MenuItem("Asynchronous");
		MenuItem item3 = new MenuItem("Time out synchronous");
		listaSynchronicityE.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setDisable(true);
            	idValorValor.setText("NULL");
            	panelPropiedadesConector.getChildren().remove(l1);
            	idValorSubDimension.setText(item1.getText());
            }
        });
		idValorValor.getItems().addAll(listaSynchronicityE);
	}
	private void cargarNotification(){
		ObservableList<MenuItem> listaNotification = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Polled");
		MenuItem item2 = new MenuItem("Publish/subscribe");
		MenuItem item3 = new MenuItem("Central update");
		MenuItem item4 = new MenuItem("Queued dispatch");
		listaNotification.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaNotification);
	}
	private void cargarCausality(){
		ObservableList<MenuItem> listaCausality = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Absolute");
		MenuItem item2 = new MenuItem("Relative");
		listaCausality.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaCausality);
	}
		
	private void cargarHardware(){
		ObservableList<MenuItem> listaHardware = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Page faults");
		MenuItem item2 = new MenuItem("Interrupts");
		MenuItem item3 = new MenuItem("Traps");
		listaHardware.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaHardware);
	}
	private void cargarSoftware(){
		ObservableList<MenuItem> listaSoftware = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Signals");
		MenuItem item2 = new MenuItem("GUI input/output");
		MenuItem item3 = new MenuItem("Triggers");
		listaSoftware.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaSoftware);
	}
	
	private void cargarLocality(){
		ObservableList<MenuItem> listaLocalty = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Thread specific");
		MenuItem item2 = new MenuItem("Process specific");
		MenuItem item3 = new MenuItem("Global");
		listaLocalty.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaLocalty);
	}
	private void cargarAccess(){
		ObservableList<MenuItem> listaAccess = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Accessor");
		MenuItem item2 = new MenuItem("Mutator");
		listaAccess.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaAccess);
	}
	private void cargarAccessibilityDA(){
		ObservableList<MenuItem> listaAccessibilityDA = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Private");
		MenuItem item2 = new MenuItem("Protected");
		MenuItem item3 = new MenuItem("Public");
		listaAccessibilityDA.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaAccessibilityDA);
	}
	private void cargarLifecycle(){
		ObservableList<MenuItem> listaLifecycle = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Initialization");
		MenuItem item2 = new MenuItem("Termination");
		listaLifecycle.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaLifecycle);
	}
	
	private void cargarTransient(){
		ObservableList<MenuItem> listaTransient = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Register");
		MenuItem item2 = new MenuItem("Cache");
		MenuItem item3 = new MenuItem("DMA");
		MenuItem item4 = new MenuItem("Heap");
		MenuItem item5 = new MenuItem("Stack");
		listaTransient.addAll(item1,item2,item3,item4,item5);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaTransient);
	}
	private void cargarPersistent(){
		ObservableList<MenuItem> listaPersistent = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Repository access");
		MenuItem item2 = new MenuItem("File I/O");
		MenuItem item3 = new MenuItem("Dynamic data exchange");
		MenuItem item4 = new MenuItem("Database Access");
		listaPersistent.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaPersistent);
	}
	
	private void cargarReference(){
		ObservableList<MenuItem> listaReference = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Implicit");
		MenuItem item2 = new MenuItem("Explicit");
		listaReference.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaReference);
	}
	private void cargarBinding(){
		ObservableList<MenuItem> listaBinding = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Compile-time");
		MenuItem item2 = new MenuItem("Run-time");
		MenuItem item3 = new MenuItem("Pre-compile-time");
		listaBinding.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaBinding);
	}
	
	private void cargarSyntactic(){
		ObservableList<MenuItem> listaSyntactic = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Variable");
		MenuItem item2 = new MenuItem("Procedure");
		MenuItem item3 = new MenuItem("Function");
		MenuItem item4 = new MenuItem("Constant");
		MenuItem item5 = new MenuItem("Type");
		listaSyntactic.addAll(item1,item2,item3,item4,item5);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		idValorValor.getItems().addAll(listaSyntactic);
	}
	
	private void cargarDeliveryStream(){
		ObservableList<MenuItem> listaDeliveryStream= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Best effort");
		MenuItem item2 = new MenuItem("Exactly once");
		MenuItem item3 = new MenuItem("At most once");
		MenuItem item4 = new MenuItem("At least once");
		listaDeliveryStream.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaDeliveryStream);
	}
	private void cargarBounds(){
		ObservableList<MenuItem> listaBounds = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Bounded");
		MenuItem item2 = new MenuItem("Unbounded");
		listaBounds.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaBounds);
	}
	private void cargarBuffering(){
		ObservableList<MenuItem> listaBuffering = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Buffered");
		MenuItem item2 = new MenuItem("Unbuffered");
		listaBuffering.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaBuffering);
	}
	private void cargarThroughput(){
		ObservableList<MenuItem> listaThroughput = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Atomic units");
		MenuItem item2 = new MenuItem("Higher-order units");
		listaThroughput.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaThroughput);
	}
	private void cargarState(){
		ObservableList<MenuItem> listaState = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Stateless");
		MenuItem item2 = new MenuItem("Stateful");
		listaState.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaState);
	}
	private void cargarIdentity(){
		ObservableList<MenuItem> listaIdentity = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Named");
		MenuItem item2 = new MenuItem("Unnamed");
		listaIdentity.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaIdentity);
	}
	private void cargarLocalityStream(){
		ObservableList<MenuItem> listaLocalityStream = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Local");
		MenuItem item2 = new MenuItem("Remote");
		listaLocalityStream.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaLocalityStream);
	}
	private void cargarSynchronicityStream(){
		ObservableList<MenuItem> listaSynchronicityStream = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Synchronous");
		MenuItem item2 = new MenuItem("Asynchronous");
		MenuItem item3 = new MenuItem("Time out synchronous");
		listaSynchronicityStream.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaSynchronicityStream);
	}
	private void cargarFormat(){
		ObservableList<MenuItem> listaFormat = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Raw");
		MenuItem item2 = new MenuItem("Structured");
		listaFormat.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaFormat);
	}
	private void cargarNary(){
		ObservableList<MenuItem> listaNary = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Multi sender");
		MenuItem item2 = new MenuItem("Multi receiver");
		MenuItem item3 = new MenuItem("Multi sender/receiver");
		listaNary.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaNary);
	}
	private void cargarAuthorization(){
		ObservableList<MenuItem> listaAuthorization = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Capabilities");
		MenuItem item2 = new MenuItem("Access control lists");
		listaAuthorization.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaAuthorization);
	}
	private void cargarPrivacy(){
		ObservableList<MenuItem> listaPrivacy = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Encryption");
		MenuItem item2 = new MenuItem("Information padding");
		MenuItem item3 = new MenuItem("Screening");
		listaPrivacy.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaPrivacy);
	}
	private void cargarIntegrity(){
		ObservableList<MenuItem> listaIntegrity = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Redundancy check");
		MenuItem item2 = new MenuItem("Certificates");
		listaIntegrity.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaIntegrity);
	}
	private void cargarDurability(){
		ObservableList<MenuItem> listaDurability= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Single session");
		MenuItem item2 = new MenuItem("Multi session");
		listaDurability.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaDurability);
	}
	private void cargarNesting(){
		ObservableList<MenuItem> listaNesting= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Single");
		MenuItem item2 = new MenuItem("Multiple");
		listaNesting.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaNesting);
	}
	private void cargarAwareness(){
		ObservableList<MenuItem> listaAwareness= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("None");
		MenuItem item2 = new MenuItem("Supported");
		MenuItem item3 = new MenuItem("Required");
		MenuItem item4 = new MenuItem("New");
		listaAwareness.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaAwareness);
	}
	private void cargarIsolation(){
		ObservableList<MenuItem> listaIsolation= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Read");
		MenuItem item2 = new MenuItem("Write");
		MenuItem item3 = new MenuItem("Read/Write");
		listaIsolation.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaIsolation);
	}
	private void cargarMechanism(){
		ObservableList<MenuItem> listaMechanism= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Semaphore");
		MenuItem item2 = new MenuItem("Rendezvous");
		MenuItem item3 = new MenuItem("Monitor");
		MenuItem item4 = new MenuItem("Lock");
		listaMechanism.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaMechanism);
	}
	private void cargarWeight(){
		ObservableList<MenuItem> listaWeight = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Light");
		MenuItem item2 = new MenuItem("Heavy");
		listaWeight.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaWeight);
	}
	private void cargarPackagingConversion(){
		ObservableList<MenuItem> listaPackagingConversion = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Wrappers");
		MenuItem item2 = new MenuItem("Packagers");
		listaPackagingConversion.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaPackagingConversion);
	}
	private void cargarFaultHandling(){
		ObservableList<MenuItem> listaFaultHandling = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Authoritative");
		MenuItem item2 = new MenuItem("Voting");
		listaFaultHandling.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });		
		idValorValor.getItems().addAll(listaFaultHandling);
	}

	private void cargarStructureBased(){
		ObservableList<MenuItem> listaStructureBased = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Hierarchical");
		MenuItem item2 = new MenuItem("Flat");
		listaStructureBased.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaStructureBased);
	}
	private void cargarSemanticsDistributor(){
		ObservableList<MenuItem> listaSemanticsDistributor = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Best effort");
		MenuItem item2 = new MenuItem("Exactly once");
		MenuItem item3 = new MenuItem("At most once");
		MenuItem item4 = new MenuItem("At least once");
		listaSemanticsDistributor.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaSemanticsDistributor);
	}
	private void cargarMechanismDistributor(){
		ObservableList<MenuItem> listaMechanismDistributor = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Unicast");
		MenuItem item2 = new MenuItem("Multicast");
		MenuItem item3 = new MenuItem("Broadcast");
		listaMechanismDistributor.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaMechanismDistributor);
	}
	private void cargarMembership(){
		ObservableList<MenuItem> listaMembership = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Bounded");
		MenuItem item2 = new MenuItem("Ad-hoc");
		listaMembership.addAll(item1,item2);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		idValorValor.getItems().addAll(listaMembership);
	}
	private void cargarPath(){
		ObservableList<MenuItem> listaPath = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Static");
		MenuItem item2 = new MenuItem("Cached");
		MenuItem item3 = new MenuItem("Dynamic");
		listaPath.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });	
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	idValorValor.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		idValorValor.getItems().addAll(listaPath);
	}
	
	@FXML
	private void verDimension(){		
		idValorDimension.getItems().clear();
		switch (Modelo.conectorActual.getTipo()){
				case "Procedure Call": cargarProcedureCall(); break;
				case "Event": cargarEvent(); break;
				case "Data Access": cargarDataAccess(); break;
				case "Linkage": cargarLinkage(); break;
				case "Stream": cargarStream(); break;
				case "Arbitrator": cargarArbitrator(); break;
				case "Adaptor": cargarAdaptor(); break;
				case "Distributor": cargarDistributor(); break;
		}
	}
	
	@FXML
	private void verSubDimension(){
		idValorValor.setDisable(false);
		idValorSubDimension.getItems().clear();
		switch (idValorDimension.getText()) {
			case "Parameters": cargarParameters(); break;
			case "Entry Point": cargarEntryPoint(); break;
			case "Invocation": cargarInvocation(); break;
			case "Cardinality PC": cargarCardinalityPC(); break;
			case "Cardinality E": cargarCardinalityE(); break;
			case "Priority": cargarPriority(); break;
			case "Mode": cargarMode(); break;
	        case "Availability": cargarAvailability(); break;
	        case "Cardinality DA": cargarCardinalityDA(); break;
	        case "Granularity": cargarGranularity(); break;
	        case "Cardinality Linkage": cargarCardinalityLinkage(); break;
	        case "Cardinality Stream": cargarCardinalityStream(); break;
	        case "Concurrency": cargarConcurrency(); break;
	        case "Transactions": cargarTransactions(); break;
	        case "Security": cargarSecurity(); break;
	        case "Scheduling": cargarScheduling(); break;
	        case "Invocation conversion": cargarInvocationConversion(); break;
	        case "Naming": cargarNaming(); break;
	        case "Delivery Distributor": cargarDeliveryDistributor(); break;
	        case "Routing": cargarRouting(); break;
		}
	}
	
	@FXML
	private void verValor(){
		idValorValor.getItems().clear();
		
		if (idValorDimension.getText() == "Synchronicity PC")
			cargarSynchronicityPC();
		
		if (idValorDimension.getText() == "Accessibility")
			cargarAccessibility();
		
		if (idValorDimension.getText() == "Delivery")
			cargarDelivery();
		
		if (idValorDimension.getText() == "Synchronicity E")
			cargarSynchronicityE();
		
		if (idValorDimension.getText() == "Notification")
			cargarNotification();
		
		if (idValorDimension.getText() == "Causality")
			cargarCausality();
		
		if (idValorDimension.getText() == "Locality")
			cargarLocality();
		
		if (idValorDimension.getText() == "Access")
			cargarAccess();
		
		if (idValorDimension.getText() == "Accessibility DA")
			cargarAccessibilityDA();
		
		if (idValorDimension.getText() == "Lifecycle")
			cargarLifecycle();
		
		if (idValorDimension.getText() == "Reference")
			cargarReference();
		
		if (idValorDimension.getText() == "Binding")
			cargarBinding();
		
		if (idValorDimension.getText() == "Fault Handling")
			cargarFaultHandling();
		
		if (idValorDimension.getText() == "Delivery Stream")
			cargarDeliveryStream();
		if (idValorDimension.getText() == "Bounds")
			cargarBounds();
		if (idValorDimension.getText() == "Buffering")
			cargarBuffering();
		if (idValorDimension.getText() == "Throughput")
			cargarThroughput();
		if (idValorDimension.getText() == "State")
			cargarState();
		if (idValorDimension.getText() == "Identity")
			cargarIdentity();
		if (idValorDimension.getText() == "Locality Stream")
			cargarLocalityStream();
		if (idValorDimension.getText() == "Synchronicity Stream")
			cargarSynchronicityStream();
		if (idValorDimension.getText() == "Format")
			cargarFormat();
		
		if (idValorDimension.getText() == "Packaging conversion")
			cargarPackagingConversion();

		switch (idValorSubDimension.getText()) {
	        case "Data Transfer": cargarDataTransfer(); break;
	        case "Semantics": cargarSemantics(); break;
	        case "Invocation Record": cargarInvocationRecord(); break;
	        case "Explicit": cargarExplicit(); break;
	        case "Implicit": cargarImplicit(); break;
	        case "Hardware": cargarHardware(); break;
	        case "Software": cargarSoftware(); break;
	        case "Transient": cargarTransient(); break;
	        case "Persistent": cargarPersistent(); break;
	        case "Syntactic": cargarSyntactic(); break;
	        case "N-ary": cargarNary(); break;
	        case "Authorization": cargarAuthorization(); break;
	        case "Privacy": cargarPrivacy(); break;
	        case "Integrity": cargarIntegrity(); break;
	        case "Durability": cargarDurability(); break;
	        case "Nesting": cargarNesting(); break;
	        case "Awareness": cargarAwareness(); break;
	        case "Isolation": cargarIsolation(); break;
	        case "Mechanism": cargarMechanism(); break;
	        case "Weight": cargarWeight(); break;
	        case "Structure based": cargarStructureBased(); break;
	        case "Semantics Distributor": cargarSemanticsDistributor(); break;
	        case "Mechanism Distributor": cargarMechanismDistributor(); break;
	        case "Membership": cargarMembership(); break;
	        case "Path": cargarPath(); break;
		}
	}
}
