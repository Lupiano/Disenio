package ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class ControladorComponentes {
	
	private boolean salir = false;
	private final ComboBox<String> atributosCalidad = new ComboBox<String>();
	private String address = "";
	private final TextField valorAtributo = new TextField("");
	private final TextField nombreAtributo = new TextField("");
	private final Button buttonAgregar = new Button ("Agregar Escenario");
	private final static Button buttonEditar = new Button ("Editar Escenario");
	private final static Button buttonBorrar = new Button ("Borrar Escenario");
	private final static Button idAgregarComponente = new Button();
	private final static Button botonSiguienteSolucion = new Button ("Siguiente");


	Scene scene = new Scene(new Group(), 850, 650);
	static GridPane grid = new GridPane();
    
	
	
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
	private String getAddress(){
		return address;
	}
	
	@FXML
	private void siguienteHaciaAtributos(){
		if (salir == false){
			JOptionPane.showMessageDialog(null, "Error: Debe llenar al menos un componente");
			System.out.println("Entraaa en siguiente");
		}
		else
			try {
				/*Parent root = FXMLLoader.load(getClass().getResource("Vista Atributos Calidad.fxml"));
				Modelo.primaryStage.setScene(new Scene(root));*/
				Modelo.primaryStage.setTitle("Trabajo Diseño Final");
				Modelo.primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
				
				grid.setVgap(4);
			    grid.setHgap(10);
			    Group root = (Group)scene.getRoot();
			    root.getChildren().add(grid);
			    Modelo.primaryStage.setScene(scene);
			    grid.setPadding(new Insets(6, 6, 6, 6));
				
		       
		        Label l1 = new Label();
		        l1.setText("Atributos de Calidad");
		        l1.setFont(new Font("Arial", 24));
		        grid.add(l1, 0, 5);
		        
		        atributosCalidad.setPromptText("Atributos de Calidad:");
		        atributosCalidad.setEditable(true);        
		        atributosCalidad.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
		        
		      //ComboBox AtributosCalidad
		        atributosCalidad.getItems().addAll(
		            "Performance",
		            "Seguridad",
		            "Modificabilidad",
		            "Testability",
		            "Disponibilidad",
		            "Usabilidad"
		        );
		        
		        grid.add(atributosCalidad, 0, 9);
		        
		        Label l2 = new Label();
		        l2.setText("Valor");
		        l2.setFont(new Font("Arial", 24));
		        grid.add(l2, 1, 5);
		        
		        valorAtributo.setPrefWidth(10);
		        grid.add (valorAtributo, 1,9);
		        nombreAtributo.setPrefWidth(250);
		        nombreAtributo.setFont(new Font("Arial", 24));
		        nombreAtributo.setDisable(true);
		        grid.add(nombreAtributo, 5, 5);
		        
		        atributosCalidad.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	nombreAtributo.setText(atributosCalidad.getValue());
		            	}
		            }
		        );
		        
		        valorAtributo.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	if ((atributosCalidad.getValue() != null && !atributosCalidad.getValue().toString().isEmpty())){
		            		System.out.println(atributosCalidad.getValue());
		            		System.out.println(valorAtributo.getText());

		            		nombreAtributo.setText(atributosCalidad.getValue() + ": " + valorAtributo.getText());
		            		valorAtributo.clear();
		            	}
		            }
		        });
		        
		        Label l3 = new Label();
		        l3.setText("(entre 0 y 1)");
		        l3.setFont(new Font("Arial", 16));
		        grid.add(l3, 2, 9);
		        
		        Label l4 = new Label();
		        l4.setText("Escenarios de Calidad");
		        l4.setFont(new Font("Arial", 24));
		        grid.add(l4, 0, 20);
		        
		        grid.add(buttonAgregar, 1,20);
		        
		        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	ControladorAtributos.agregarEscenario();
		            }
		        });
		        
		        grid.add(botonSiguienteSolucion, 6, 120);
		        
		        botonSiguienteSolucion.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	Modelo.primaryStage.setTitle("Trabajo Diseño Final");
						Modelo.primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
						
						grid.setVgap(4);
					    grid.setHgap(10);
					    Group root = (Group)scene.getRoot();
					    root.getChildren().add(grid);
					    Modelo.primaryStage.setScene(scene);
					    grid.setPadding(new Insets(6, 6, 6, 6));
		            }
		        });
		        
		        
		        Modelo.primaryStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void agregarListaEscenario(){
		
        Label l1 = new Label();
        String nombrefinal = "Escenario" + Modelo.numero;
        l1.setText(nombrefinal);
        l1.setFont(new Font("Arial", 18)); 

    	Button buttonEditar = new Button ("Editar Escenario");
    	
    	Button buttonBorrar = new Button ("Borrar Escenario");
    	buttonBorrar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				ArrayList<Labeled> aBorrar = new ArrayList<Labeled>();
				int indexBorrar;
				
				//Se borran todos los botones de la interfaz.
				Modelo.fila -= Modelo.listaBotones.size() * 4;
				for(ArrayList<Labeled> arr: Modelo.listaBotones){
					grid.getChildren().removeAll(arr);
					//Se borran los botones a eliminar de la lista de botones.
					if(arr.contains(l1)){
						aBorrar = arr;
					}
				}

				Modelo.listaBotones.remove(aBorrar);
				
				//Se vuelven a generar los botones.
				for(ArrayList<Labeled> arr: Modelo.listaBotones){
					grid.add(arr.get(0), Modelo.columna, Modelo.fila);
					grid.add(arr.get(1), 1, Modelo.fila);
					grid.add(arr.get(2), 2, Modelo.fila);
			        Modelo.fila+= 4;
				}
			}	
			
    	});
    	
        grid.add(l1, Modelo.columna, Modelo.fila);
        grid.add(buttonEditar, 1, Modelo.fila);
        grid.add(buttonBorrar, 2, Modelo.fila);
        
        ArrayList<Labeled> aux = new ArrayList<Labeled>();
        aux.add(l1);
        aux.add(buttonEditar);
        aux.add(buttonBorrar);
        Modelo.listaBotones.add(aux);
        
        Modelo.numero++;
        Modelo.fila+= 4;
        
	}
	
   
	
	@FXML
	private void agregarComponente(){
		salir = true;
	}
	
	@FXML
	private void eliminarComponente(){
	}
}